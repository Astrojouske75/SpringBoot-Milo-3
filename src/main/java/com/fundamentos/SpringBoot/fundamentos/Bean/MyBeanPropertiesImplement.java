package com.fundamentos.SpringBoot.fundamentos.Bean;

public class MyBeanPropertiesImplement implements MyBeanWhitProperties{
    private String nombre;
    private String apellido;
    public MyBeanPropertiesImplement(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    @Override
    public String function() {
        return nombre + "-" + apellido;
    }
}
