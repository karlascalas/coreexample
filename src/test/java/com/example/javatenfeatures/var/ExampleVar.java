package com.example.javatenfeatures.var;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ExampleVar {

    public String vaString(){
        var message ="Hello, World!";
        
        return message;
    }

    public Map<String, List<Integer>> mapExample(){
        var map= new HashMap<String,List<Integer>>();
        return map;
    }

    public void varLoop(){
        List<String> names = List.of("Alice","Bob","Charlie");
        for(var name: names){
            System.out.println("Value of name"+name);
        }
    }

    public void varforStreams(){
        List<String> names =  List.of("Alice","Bob","Charlie");
        names.stream().map((String name)-> name.toUpperCase()).forEach(System.out::println);
        names.stream().map((var name) -> name.toUpperCase()).forEach(System.out::println);
    }

    public void varForOptiona(){
        var optional = Optional.of("Hello");
        
    }

}
