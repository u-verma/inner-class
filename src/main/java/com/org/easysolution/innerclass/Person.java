package com.org.easysolution.innerclass;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Person {
    public static final Logger LOG = Logger.getLogger(Person.class.getName());

    public void displayName() {
        LOG.log(Level.INFO, "Name is Person");
    }

    public void displayAge() {
        LOG.log(Level.INFO, "Age from the super class");
    }

    public static void main(String[] args) {
        Person anonymousObject = new Person() {
            public void displayName() {
                LOG.log(Level.INFO, "Name from Anonymous class");
            }
        };
        anonymousObject.displayName();
        anonymousObject.displayAge();
        LOG.log(Level.INFO, anonymousObject.getClass().getName());
    }
}
