package com.cserny.service;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MainService {

    private Map<Class<?>, MyService> services = new HashMap<>();

    public void register(Class<?> type, MyService service) {
        services.put(type, service);
    }

    public <T> List<T> search(Class<T> type) {
        MyService<T> myService = services.get(type);
        if (myService != null) {
            return myService.search();
        }
        return Collections.emptyList();
    }
}
