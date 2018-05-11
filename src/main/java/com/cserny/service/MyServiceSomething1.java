package com.cserny.service;

import com.cserny.model.Something1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@Service
public class MyServiceSomething1 implements MyService<Something1> {

    @Autowired
    MainService mainService;

    @PostConstruct
    public void init() {
        mainService.register(Something1.class, this);
    }

    @Override
    public List<Something1> search() {
        return Arrays.asList(
                new Something1("name1"),
                new Something1("name2"),
                new Something1("name3"),
                new Something1("name4")
        );
    }
}
