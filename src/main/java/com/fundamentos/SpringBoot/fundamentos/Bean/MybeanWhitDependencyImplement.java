package com.fundamentos.SpringBoot.fundamentos.Bean;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

public class MybeanWhitDependencyImplement implements MyBeanWhitDependency{

    Log LOGGER = LogFactory.getLog(MybeanWhitDependencyImplement.class);
    private MyOperation myOperation;

    public MybeanWhitDependencyImplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWhitDependency() {
        LOGGER.info("Hola Pais desde el printwhitdependency");
        int numero =1;
        LOGGER.debug("El numero enviado como parametro a la dependencia operation es " + numero);
        System.out.println(myOperation.sum(numero));
        System.out.println("Hola gonorreas que tal estan amigos ... bean con dependencia");
    }
}
