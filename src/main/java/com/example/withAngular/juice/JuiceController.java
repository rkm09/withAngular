package com.example.withAngular.juice;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.stream.Collectors;

@RequestMapping("/good-juices")
@RestController
public class JuiceController {
    private JuiceRepository repository;
    private JuiceService service;

    public JuiceController(JuiceRepository repository, JuiceService service) {
        this.repository = repository;
        this.service = service;
    }

    @GetMapping
    @CrossOrigin(origins = "http://localhost:3000")
    public Collection<Juice> goodJuices() {
        return repository.findAll().stream()
                .filter(this::isGreat)
                .collect(Collectors.toList());
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @CrossOrigin(origins = "http://localhost:3000")
    public String goodJuiceService(@RequestBody JuiceRequest juiceRequest) {
        String name = juiceRequest.getName();
        Long id = juiceRequest.getId();
        System.out.println("Request ***************");
        System.out.println(id+", "+name);
        service.handle(juiceRequest);
        return "done";
    }

    private boolean isGreat(Juice juice) {
        return !juice.getName().equals("strawberry") &&
                !juice.getName().equals("pineapple") &&
                !juice.getName().equals("cherry");
    }

}
