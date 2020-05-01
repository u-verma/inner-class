package com.org.easysolution.innerclass;

import java.util.logging.Level;
import java.util.logging.Logger;

public class NestedInterfaceInsideClass implements OuterClass.IInner {
    public static final Logger LOG = Logger.getLogger("NestedInterfaceInsideClass");

    public static void main(String args[]) {
        OuterClass.IInner obj = new NestedInterfaceInsideClass();
        obj.innerMethod();
    }

    @Override
    public void innerMethod() {
        LOG.log(Level.INFO, "Nested interface method");
    }

}

class OuterClass {
    protected interface IInner {
        void innerMethod();
    }
}
