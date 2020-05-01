package com.org.easysolution.innerclass;

import java.util.logging.Level;
import java.util.logging.Logger;

public class OuterMemberAccess {
    public static final Logger LOG = Logger.getLogger(OuterMemberAccess.class.getName());

    private int instanceMember = 10;
    static int staticMember = 100;

    public static void main(String[] args) {
        Inner innerObject = new OuterMemberAccess().new Inner();
        innerObject.innerMethod();
    }

    class Inner {
        public void innerMethod() {
            LOG.log(Level.INFO, "Instance member access : " + instanceMember);
            LOG.log(Level.INFO, "static variable access : " + staticMember);
        }
    }
}
