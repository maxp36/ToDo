package com.test.maxp36.todo;


import java.text.SimpleDateFormat;
import java.util.Date;

public class ListToDo {

    public String name;
    public String date;

    public ListToDo(String name) {
        this.name = name;
        date = new SimpleDateFormat("dd.MM.yyyy").format(new Date());
    }

}
