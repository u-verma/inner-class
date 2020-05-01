package com.org.easysolution.innerclass;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LocalInnerClass {
    public static final Logger LOG = Logger.getLogger(LocalInnerClass.class.getName());

    private String outerInstanceVariable = "OuterInstanceVariable";
    private int outerIntVariable = 100;
    private static String outerStaticMember = "OuterStaticMember";

    public static void main(String[] args) {
        LocalInnerClass localInnerClass = new LocalInnerClass();
        localInnerClass.withInnerMember("Method Parameter");
        localInnerClass.withBlockInnerClass();
        LocalInnerClass.withInnerClass();
    }

    public static void withInnerClass() {
        class BlockInnerClass {
            public void executeInnerMethod() {
                LOG.log(Level.INFO, "Inside blockInnerMethod");
                // Compile Time Error at below lines.
                // LOG.log(Level.INFO, "Access Outer Instance Variable: " + outerInstanceVariable);
                // LOG.log(Level.INFO, "Access Outer primitive Variable: " + outerIntVariable);
                LOG.log(Level.INFO, "Access Outer static Variable: " + outerStaticMember);
            }
        }
        BlockInnerClass innerClass = new BlockInnerClass();
        innerClass.executeInnerMethod();
    }

    public void withInnerMember(String methodParameter) {
        final String localMember = "Local Member";
        class BlockInnerClass {
            public void executeInnerMethod() {
                LOG.log(Level.INFO, "Inside blockInnerMethod");
                LOG.log(Level.INFO, "Access local Member: " + localMember);
                LOG.log(Level.INFO, "Access method parameter: " + methodParameter);
            }
        }
        BlockInnerClass innerClass = new BlockInnerClass();
        innerClass.executeInnerMethod();
    }

    public void withBlockInnerClass() {
        boolean createBlockInnerClass = true;
        if (createBlockInnerClass) {
            class BlockInnerClass {
                public void executeInnerMethod() {
                    outerInstanceVariable = "";
                    outerIntVariable = 20;
                    LOG.log(Level.INFO, "Inside blockInnerMethod");
                    LOG.log(Level.INFO, "Access Outer Instance Variable: " + outerInstanceVariable);
                    LOG.log(Level.INFO, "Access Outer primitive Variable: " + outerIntVariable);
                    LOG.log(Level.INFO, "Access Outer static Variable: " + outerStaticMember);
                }
            }
            BlockInnerClass innerClass = new BlockInnerClass();
            innerClass.executeInnerMethod();
        }
    }
}
