package com.org.easysolution.innerclass;

import java.util.logging.Level;
import java.util.logging.Logger;

public class VariableScope {
    public static void main(String[] args) {
        OuterAccess.InnerAccess obj = new OuterAccess().new InnerAccess();
        obj.innerMethodScope();
    }
}

class OuterAccess {
    public static final Logger LOG = Logger.getLogger("OuterMemberAccess");
    int x = 10;

    class InnerAccess {
        int x = 100;

        public void innerMethodScope() {
            int x = 1000;
            LOG.log(Level.INFO, "Local variable access : " + x);
            LOG.log(Level.INFO, "Inner variable access : " + this.x);
            LOG.log(Level.INFO, "Inner variable access : " + InnerAccess.this.x);
            LOG.log(Level.INFO, "Outer variable access : " + OuterAccess.this.x);

        }
    }
}