package com.org.easysolution.innerclass;

public class OuterClass {
    protected interface IInner {
        void innerMethod();
    }
}

class NestedInterfaceInsideClass implements OuterClass.IInner {

    public static void main(String args[]) {
        OuterClass.IInner obj = new NestedInterfaceInsideClass();
        obj.innerMethod();
    }

    @Override
    public void innerMethod() {
        System.out.println("Nested interface method");
    }
}