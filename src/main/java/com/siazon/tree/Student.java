package com.siazon.tree;

import java.util.Observable;
import java.util.Observer;

public class Student implements Observer {
    private String name;

    public Student() {

    }

    public Student(String _name) {
        name = _name;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Message board changed: " + name + " " + arg);
    }
}
