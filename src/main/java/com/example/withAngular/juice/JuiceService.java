package com.example.withAngular.juice;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JuiceService {
    private JuiceRepository repository ;

    public JuiceService(JuiceRepository repository) {
        this.repository = repository;
    }

    public void handle(JuiceRequest juiceRequest) {
        System.out.println("=======Handle this=======");
        Juice juice = new Juice(juiceRequest.getId(), juiceRequest.getName());
        System.out.println(juice);
        repository.save(juice);
        repository.flush();
        System.out.println("=======Handled this=======");

    }

    @Override
    public String toString() {
        return "JuiceService{}";
    }
}
