package ru.netology.springboot2.repository;

import ru.netology.springboot2.service.Authorities;

import java.util.List;

public class UserInfo {
    String name;
    String password;
    List<Authorities> accessRights;

    public UserInfo() {

    }

    public UserInfo(String name, String password, List<Authorities> accessRights) {
        this.name = name;
        this.password = password;
        this.accessRights = accessRights;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Authorities> getAccessRights() {
        return accessRights;
    }

    public void setAccessRights(List<Authorities> accessRights) {
        this.accessRights = accessRights;
    }
}
