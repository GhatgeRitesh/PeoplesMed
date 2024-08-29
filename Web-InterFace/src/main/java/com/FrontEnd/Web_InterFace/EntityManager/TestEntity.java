package com.FrontEnd.Web_InterFace.EntityManager;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("testEntity1")
@Scope("prototype")
public class TestEntity {
    private int id;
    private String name;
    private String role;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


}
