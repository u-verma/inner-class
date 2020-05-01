package com.org.easysolution.innerclass;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Outer {
    public static final Logger LOG = Logger.getLogger("OuterClass");

    public static void main(String[] args) {
        Inner innerObject = new Outer().new Inner();
        innerObject.innerMethod();
        new Outer().createInnerInstance();
    }

    public void createInnerInstance() {
        Inner fromInstanceMethod = new Inner();
        fromInstanceMethod.innerMethod();
    }

    class Inner {
        public void innerMethod() {
            LOG.log(Level.INFO, "InnerMethod");
        }
    }
}
