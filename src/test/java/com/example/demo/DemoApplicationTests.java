package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.stream.Stream;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
        List<String> list = new ArrayList<>();
        list.add("123");
        list.add("321");
        list.add("abc");
        Stream<String> stringStream = list.stream().filter(s -> s.equals("321"));
        System.out.println(stringStream);
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("123");
        list.add("321");
        list.add("abc");
        Stream<String> stringStream = list.stream().filter(s -> s.equals("321"));
        System.out.println(stringStream);
    }
}
