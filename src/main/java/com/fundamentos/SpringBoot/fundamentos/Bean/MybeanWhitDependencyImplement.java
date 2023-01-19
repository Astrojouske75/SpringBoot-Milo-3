package com.fundamentos.SpringBoot.fundamentos.Bean;

public class MybeanWhitDependencyImplement implements MyBeanWhitDependency{
    private MyOperation myOperation;

    public MybeanWhitDependencyImplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWhitDependency() {
        int numero =1;
        System.out.println(myOperation.sum(numero));
        System.out.println("Hola gonorreas que tal estan amigos ... bean con dependencia");
    }
}
