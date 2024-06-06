package com.example.demo.month.controllers;

import com.example.demo.month.models.Month;
import com.example.demo.month.services.MonthService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/months")
public class MonthController {
    @Autowired
    private MonthService service;

    @GetMapping
    public Month findMonth(HttpServletRequest request){
        return (Month) request.getAttribute("MonthInterceptor-month");
    }
}
