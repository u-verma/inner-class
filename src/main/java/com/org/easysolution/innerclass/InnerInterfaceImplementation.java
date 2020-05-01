package com.org.easysolution.innerclass;

import java.util.logging.Level;
import java.util.logging.Logger;

public class InnerInterfaceImplementation implements IOuter.IInner {

    public static final Logger LOG = Logger.getLogger(InnerInterfaceImplementation.class.getName());

    public static void main(String args[]) {
        IOuter.IInner obj = new InnerInterfaceImplementation();
        obj.innerMethod();
    }

    @Override
    public void innerMethod() {
        LOG.log(Level.INFO, "Inner Nested interface method");
    }
}

class OuterInterfaceImplementation implements IOuter {

    public static void main(String args[]) {
        IOuter obj = new OuterInterfaceImplementation();
        obj.outerMethod();
    }

    @Override
    public void outerMethod() {
        System.out.println("Outer Nested interface method");
    }
}


interface IOuter {
    void outerMethod();

    interface IInner {
        void innerMethod();
    }
}