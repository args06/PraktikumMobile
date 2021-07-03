package com.example.coronajabar.service;

public interface CovidListener<T> {
    void onSuccess(T items);
    void onFailed(String msg);
}
