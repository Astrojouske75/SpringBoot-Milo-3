package com.fundamentos.SpringBoot.fundamentos.Component;

import org.springframework.stereotype.Component;

@Component
public class ComponentTwoImplement implements ComponentDependency {
    @Override
    public void saludar() {
        System.out.println("Hola pais desde mi otro componente jaja que chimba el springboot :3");
    }
}
