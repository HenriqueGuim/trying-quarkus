package com.flutter;


import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GreetingsService {

        public String greet(String name) {
            return "Hello " + name;
        }
}
