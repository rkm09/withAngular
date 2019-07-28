package com.example.withAngular.juice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.stream.Stream;

@Component
public class JuiceCommandLineRunner implements CommandLineRunner {
    private final JuiceRepository repository;

    public JuiceCommandLineRunner(JuiceRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... strings) throws Exception{
        Stream.of("Lemon", "Mango", "Papaya", "Orange", "Apple")
                .forEach(name -> repository.save(new Juice(name)));
        repository.findAll().forEach(System.out::println);
    }

}
