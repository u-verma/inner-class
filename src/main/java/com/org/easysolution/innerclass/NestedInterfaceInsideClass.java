package com.org.easysolution.innerclass;

public class NestedInterfaceInsideClass implements OuterClass.IInner {

    public static void main(String args[]) {
        OuterClass.IInner obj = new NestedInterfaceInsideClass();
        obj.innerMethod();
    }

    @Override
    public void innerMethod() {
        System.out.println("Nested interface method");
    }

}

class OuterClass {
    protected interface IInner {
        void innerMethod();
    }
}
