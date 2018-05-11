package com.cserny.service;

import java.util.List;

public interface MyService<T> {
    List<T> search();
}
