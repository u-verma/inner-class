# Inner-classes

# Bullet points
  - A class defined inside another class. Below example the OuterClass defines the InnerClass. 
    
    ```
        public class Outer {
            class Inner {
            }
        }
    ```
  - There are two types of inner classes non-static and static inner classes.The static inner classes are known as static-nested classes.
       - Non-static nested class (inner class)
            - Member inner class or Regular/Normal Inner class
            - Local inner class or Method Local Inner class
            - Anonymous inner class
       - Static nested class
  - The Inner class always represents the HAS-A relationship with Outer class. 
  - The Inner class object can't be created without creating the Outer class object. Hence, 
  it is always about the instance behaviour associated with outer class.

# Note
  - Interface can also be defined in nested way. 
   
    ```
        interface IOuter{
            void outerMethod();
            interface IInner{
                void innerMethod();
            }
        }
    ```
    
  - Since nested interface cannot be accessed directly, the main purpose of using them is to resolve the namespace by grouping related interfaces (or related interface and class) together.  
  - In order to implement only the Inner nested Interface use outer class or outer interface name followed by dot( . ) , followed by the inner interface name.
    
    ```
        public class InnerInterfaceImplementation implements IOuter.IInner{
        
            public static void main(String args[]){
                IOuter.IInner obj = new InnerInterfaceImplementation();
                obj.innerMethod();
            }
        
            @Override
            public void innerMethod(){
                System.out.println("Inner Nested interface method");
            }
        }
    ```
  - A class implements an outer Interface only implements outer Interface method.
    
    ```
        public class OuterInterfaceImplementation implements IOuter{
        
            public static void main(String args[]){
                IOuter obj = new OuterInterfaceImplementation();
                obj.outerMethod();
            }
        
            @Override
            public void outerMethod() {
                System.out.println("Outer Nested interface method");
            }
        }
    ```  
  - Nested interfaces are static by default. Don't need to mark them static explicitly as it would be redundant.
  - The nested interfaces declared inside interface is public implicitly.
  - Nested interfaces declared inside class can take any access modifier like private and protected. 
   
    ```
        public class OuterClass {
             protected interface IInner{
                 void innerMethod();
             }
         }
         
         class NestedInterfaceInsideClass implements OuterClass.IInner{
         
             public static void main(String args[]){
                 OuterClass.IInner obj= new NestedInterfaceInsideClass();
                 obj.innerMethod();
             }
         
             @Override
             public void innerMethod(){
                 System.out.println("Nested interface method");
             }
         }  
    ```
# Member or Normal/Regular Inner classes
    
# Instance creation of Normal Inner class
  - Inner class can be declared as private as associated with instance behaviour.
  - From static area of Outer class or from outside of outer class, Inner class object is created using the Outer class object @see the below example **main** method.
    ```
        Inner innerObject = new OuterClass().new Inner();
    ```
  - The Inner class object can be created directly from instance area of outer class,
  as to access any instance method of outer class object must present. @see **createInnerClassInstance** in below example
  
    ```
        Inner fromInstanceMethod =  new Inner();
    ```
  
    ```
        public class Outer {
            public static final Logger LOG = Logger.getLogger("Outer");
        
            public static void main(String[] args) {
                Inner innerObject = new OuterClass().new Inner();
                innerObject.innerMethod();
            }
            
            public void createInnerClassInstance(){
                Inner fromInstanceMethod =  new Inner();
                fromInstanceMethod.innerMethod();
            }
        
            class Inner {
                public void innerMethod() {
                    LOG.log(Level.INFO, "InnerMethod");
                }
            }
        }
    ```
# The static keyword in context to Normal/Regular Inner classes 
  - Normal Inner class depict the instance behaviour, so the static variable and static 
  method including **main method** can't be declare inside the inner class.
  - Compile time error ***(Inner classes can't have static declaration)*** thrown when declare the 
  static member inside normal inner class.
  - Normal Inner class can't declare the *static* member but still can access the static member of outer class.
  - Normal Inner class can access both static and non static member of outer class directly. 
  - Normal Inner can also be declared private, protected in addition to all other modifier(public, default, final, abstract, strictfp) applicable for normal class. 
  - Once the normal Inner class, declared as static, it becomes special case of static inner class. Explained in details later in the other section. 

    ```
        public class OuterMemberAccess {
               public static final Logger LOG = Logger.getLogger("OuterClass");
           
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

    ```
# Variable scope 
  - In side the normal inner class **this** keyword always refer to inner class object  
  - In case of namespace conflict, the nearest member takes the precedence. 
  - Below is the way how to access members in case of namespace conflict.
  
    ```
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
                    // this always refer to inner class object
                    LOG.log(Level.INFO, "Inner variable access : " + this.x); 
                    // this is fancy way.
                    LOG.log(Level.INFO, "Inner variable access : " + InnerAccess.this.x);
    
                    LOG.log(Level.INFO, "Outer variable access : " + OuterAccess.this.x);
        
                }
            }
        }
    
    ``` 
# Local or Method Local Inner class
  - Local classes can be defined inside any block. For example, you can define a local class in a method body, a for loop, or an if clause.
  - Local classes are similar to inner classes because they cannot define or declare any static members.
  - Local inner classes can't be declared public, protected, private and static similar to a method local variable, in addition it can be declared abstract.
  - The scope of the inner class limited to the block where it is defined. Example if declared in **if** block it will be accessible in if block.
  - If the Local Inner classes created inside method body the scope limited to method. The object of the class can be created in the method only.
  - if Local classes defined in instance method then it can access both static and non-static member of Outer class directly. 
    
    ```
        import java.util.logging.Level;
        import java.util.logging.Logger;
        
        public class LocalInnerClass {
            public static final Logger LOG = Logger.getLogger("LocalInnerClass");
            private String outerInstanceVariable = "OuterInstanceVariable";
            private int outerIntVariable = 100;
            private static String outerStaticMember = "OuterStaticMember";
        
            public static void main(String[] args) {
                new LocalInnerClass().withBlockInnerClass();
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
    
    ```
  - Local Inner classes can access the local member (of block or method) only if they are declared final. 
  - As local variable created in the stack and will be available till the method execution and then will be 
  removed in contras Objects reside on the heap and removed by **GC**. That is the reason why normal variable can't be used inside the local Inner class.
  - As the Final variable gets replaced by the constant value at the compile time it can be used accessed by Local Inner classes. 
  
    ```
        import java.util.logging.Level;
        import java.util.logging.Logger;
        
        public class LocalInnerClass {
            public static final Logger LOG = Logger.getLogger("LocalInnerClass");
        
            public static void main(String[] args) {
                new LocalInnerClass().withInnerMember("Method Parameter");
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
        }
    
    ```
  - if Local classes defined in static method then it can only access both static member of Outer class directly. 
    ```
        public class LocalInnerClass {
            public static final Logger LOG = Logger.getLogger("LocalInnerClass");
            private String outerInstanceVariable = "OuterInstanceVariable";
            private int outerIntVariable = 100;
            private static String outerStaticMember = "OuterStaticMember";
        
            public static void main(String[] args) {
               LocalInnerClass.withInnerClass();
            }
        
            public static void withInnerClass() {
                class BlockInnerClass {
                    public void executeInnerMethod() {
                        LOG.log(Level.INFO, "Inside blockInnerMethod");
                        //Compile Time error at below line
                        LOG.log(Level.INFO, "Access Outer Instance Variable: " + outerInstanceVariable);
                        //Compile Time error at below line
                        LOG.log(Level.INFO, "Access Outer primitive Variable: " + outerIntVariable);
                        LOG.log(Level.INFO, "Access Outer static Variable: " + outerStaticMember);
                    }
                }
                BlockInnerClass innerClass = new BlockInnerClass();
                innerClass.executeInnerMethod();
            }
        }
        
    ```
