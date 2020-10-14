package com.nm.travel.service;

public interface SecurityService {
    boolean isAuthenticated();
    void autoLogin(String username, String password);
}
