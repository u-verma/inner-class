package com.org.easysolution.innerclass;

import java.util.logging.Level;
import java.util.logging.Logger;

public class OuterClass {
    public static final Logger LOG = Logger.getLogger("OuterClass");

    public static void main(String[] args) {
        InnerClass innerObject = new OuterClass().new InnerClass();
        innerObject.innerMethod();
    }

    public void createInnerClassInstance(){
        InnerClass fromInstanceMethod =  new InnerClass();
        fromInstanceMethod.innerMethod();
    }

    class InnerClass {
        public void innerMethod() {
            LOG.log(Level.INFO, "InnerMethod");
        }
    }
}
