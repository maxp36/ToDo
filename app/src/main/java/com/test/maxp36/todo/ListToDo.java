package com.test.maxp36.todo;


import java.util.Date;

public class ListToDo {

    public String name;
    public String date;

    public ListToDo(String name) {
        this.name = name;
        date = String.format("F" + new Date());
    }

}
