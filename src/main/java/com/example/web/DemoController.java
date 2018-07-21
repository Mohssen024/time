package com.example.web;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequestMapping
public class DemoController{
    @RequestMapping
    public LocalDateTime sayTheTime(){
        return LocalDateTime.now();
    }

    @RequestMapping(path = "many")
    public String sayTheTimeMany(@RequestParam() String name, @RequestParam(defaultValue = "10") int repetitions) {
        return IntStream.rangeClosed(1, repetitions).mapToObj(i->i+ " .Hello "+ name +" !Now It Is "+ LocalDateTime.now())
                .collect(Collectors.joining(System.lineSeparator()));

    }
    @RequestMapping(path = "manyParams")
    public String sayTheTimeManyParams(Params params) {
        return IntStream.rangeClosed(1, params.repetitions).mapToObj(i -> i + " .Hello " + params.name + " !Now It Is " + LocalDateTime.now())
                .collect(Collectors.joining(System.lineSeparator()));
    }

    @RequestMapping(path = "many/{name}/{repetitions}")
    public String sayTheTimeManyParamsPath(Params params) {
        return IntStream.rangeClosed(1, params.repetitions).mapToObj(i -> i + " .Hello " + params.name + " !Now It Is " + LocalDateTime.now())
                .collect(Collectors.joining(System.lineSeparator()));
    }


    static class Params{
        String name;
        int repetitions;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getRepetitions() {
            return repetitions;
        }

        public void setRepetitions(int repetitions) {
            this.repetitions = repetitions;
        }

    }



}