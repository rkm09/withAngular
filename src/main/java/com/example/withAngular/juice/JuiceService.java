package com.example.withAngular.juice;

import org.springframework.stereotype.Service;
import java.util.Optional;


@Service
public class JuiceService {
    private JuiceRepository repository ;

    public JuiceService(JuiceRepository repository) {
        this.repository = repository;
    }

    public void handlePost(JuiceRequest juiceRequest) {
        Juice juice = new Juice(juiceRequest.getId(), juiceRequest.getName());
        repository.save(juice);
    }

    public void handleUpdate(JuiceRequest juiceRequest) {
        Optional optionalJuice = repository.findById(juiceRequest.getId());
        if(optionalJuice.isPresent()){
            Juice juice = (Juice)optionalJuice.get();
            juice.setName(juiceRequest.getName());
            repository.save(juice);
            repository.flush();
        } else {
            throw new juiceException("id not found");
        }
    }

    public void handleDelete(JuiceRequest juiceRequest) {
        Optional optionalJuice = repository.findById(juiceRequest.getId());
        if(optionalJuice.isPresent()) {
            Juice juice = (Juice) optionalJuice.get();
            repository.delete(juice);
        } else {
            throw new juiceException("id not found");
        }
    }

    @Override
    public String toString() {
        return "JuiceService{}";
    }

}
