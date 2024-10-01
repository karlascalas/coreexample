package com.core.example.java9.features;

import java.util.Optional;

public class OptionalExample {

    public void optionalExample_01(){
        Optional<String> optional =  Optional.of("Hello");
        optional.ifPresentOrElse(value -> System.out.println("Value is present: "+value), () -> System.out.println("Value is not present"));
    }

}
