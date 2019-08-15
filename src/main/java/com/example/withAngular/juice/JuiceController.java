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
    private JuiceResponse response;

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
    public JuiceResponse goodJuiceService(@RequestBody JuiceRequest juiceRequest) {
        service.handlePost(juiceRequest);
        response = new JuiceResponse("ok","200");
        return response;
    }

    @PutMapping
    public JuiceResponse goodJuicePut(@RequestBody JuiceRequest juiceRequest) {
        service.handleUpdate(juiceRequest);
        response = new JuiceResponse("ok","200");
        return response;
    }

    @DeleteMapping
    public JuiceResponse goodJuiceDelete(@RequestBody JuiceRequest juiceRequest) {
        service.handleDelete(juiceRequest);
        response = new JuiceResponse("ok","200");
        return response;
    }

    private boolean isGreat(Juice juice) {
        return !juice.getName().equals("strawberry") &&
                !juice.getName().equals("pineapple") &&
                !juice.getName().equals("cherry");
    }

}
