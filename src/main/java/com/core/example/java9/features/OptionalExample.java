package com.core.example.java9.features;

import java.util.Optional;

public class OptionalExample {

    public void optionalExample_01(){
        Optional<String> optional =  Optional.of("Hello");
        optional.ifPresentOrElse(value -> System.out.println("Value is present: "+value), () -> System.out.println("Value is not present"));
    }

    public void optional_Empty(){
        Optional<String> optional = Optional.empty();
        Optional<String> result = optional.or(()-> Optional.of("Default value"));
        System.out.println(result.get());
    }

    public void optional_stream(){
        Optional<String> optional =  Optional.of("Hello");
        optional.stream().forEach(System.out::println);
    }

    public void optional_orElseThrow(){
        Optional<String> optional = Optional.empty();
        String value = optional.orElseThrow(() -> new IllegalArgumentException("Value is not present")); 
    }

}
