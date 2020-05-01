package com.org.easysolution.innerclass;

import java.util.logging.Level;
import java.util.logging.Logger;

public class NestedInterfaceInsideClass implements OuterClassWithInterfaceDeclaration.IInner {
    public static final Logger LOG = Logger.getLogger(NestedInterfaceInsideClass.class.getName());

    public static void main(String args[]) {
        OuterClassWithInterfaceDeclaration.IInner obj = new NestedInterfaceInsideClass();
        obj.innerMethod();
    }

    @Override
    public void innerMethod() {
        LOG.log(Level.INFO, "Nested interface method");
    }

}

class OuterClassWithInterfaceDeclaration {
    protected interface IInner {
        void innerMethod();
    }
}
