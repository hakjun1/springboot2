package com.springboot.api.paser;

public interface Parser<T> {
    T parse(String str);
}

