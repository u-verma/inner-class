package com.org.easysolution.innerclass;

import java.util.logging.Level;
import java.util.logging.Logger;

public class OuterClass {
    public static final Logger LOG = Logger.getLogger(OuterClass.class.getName());
    private int instanceMember = 10;
    static int staticMember = 100;

    public static void main(String[] args) {
        Nested nested = new Nested();
        nested.nestedMethod();
    }

    static class Nested {
        public static void main(String[] args) {
            LOG.log(Level.INFO, "Inside Nested inner class");
            new Nested().nestedMethod();
        }

        public void nestedMethod() {
            LOG.log(Level.INFO, "Inside Nested inner class");
            LOG.log(Level.INFO, "static member of outer class: " + staticMember);
            // Compile time error at below line Non static can't be refereed from static area
            //LOG.log(Level.INFO, "instance member of outer class: " + instanceMember);
        }
    }
}

class NestedDemo {
    public static void main(String[] args) {
        OuterClass.Nested nested = new OuterClass.Nested();
    }
}
