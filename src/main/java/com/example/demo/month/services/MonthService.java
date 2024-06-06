package com.example.demo.month.services;

import com.example.demo.month.models.Month;
import com.example.demo.month.repositories.MonthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonthService {
    @Autowired
    private MonthRepository repository;

    public List<Month> readAll() {
        return repository.findAll();
    }
}
