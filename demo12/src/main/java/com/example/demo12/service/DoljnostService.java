package com.example.demo12.service;

import com.example.demo12.dtos.Doljnost;
import com.example.demo12.repo.DoljnostRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class DoljnostService  {

    DoljnostRepository repository;

    public DoljnostService(DoljnostRepository repository) {
        this.repository = repository;
    }

    public Doljnost save(Doljnost doljnost) {
        return repository.save(doljnost);
    }

    public Doljnost findById(String id) {
        return repository.findByFilial_id(id);
    }

}
