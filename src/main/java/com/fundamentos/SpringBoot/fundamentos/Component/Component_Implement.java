package com.fundamentos.SpringBoot.fundamentos.Component;

import org.springframework.stereotype.Component;

@Component
public class Component_Implement implements ComponentDependency {
    @Override
    public void saludar() {
        System.out.println("hola pais desde mi componente");
    }
}
