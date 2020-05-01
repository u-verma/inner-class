# Inner-classes

# Bullet points
  - A class defined inside another class. Below example the `Outer` defines the InnerClass. 
    
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
  - Nested interfaces are static by default. Don't need to mark them static explicitly as it would be redundant.
  - The nested interfaces declared inside interface is public implicitly.
   
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
  - Nested interfaces declared inside class can take any access modifier like private and protected. 
   
    ```
        public class OuterClassWithInterfaceDeclaration {
             protected interface IInner{
                 void innerMethod();
             }
         }
         
         class NestedInterfaceInsideClass implements OuterClassWithInterfaceDeclaration.IInner{
         
             public static void main(String args[]){
                 OuterClassWithInterfaceDeclaration.IInner obj= new NestedInterfaceInsideClass();
                 obj.innerMethod();
             }
         
             @Override
             public void innerMethod(){
                 System.out.println("Nested interface method");
             }
         }  
    ```
  - A class declared inside the interface is always public and static.
    
    ```
          interface IOuter{
              void outerMethod();
              class InnerClass{
                  void innerMethod();
              }
          }
    ```
  
# Member or Normal/Regular Inner classes
    
# Instance creation of Normal Inner class
  - Inner class can be declared as private as associated with instance behaviour.
  - From static area of Outer class or from outside of outer class, Inner class object is created using the Outer class object @see the below example `main` method.
    ```
        Inner innerObject = new OuterClassWithInterfaceDeclaration().new Inner();
    ```
  - The Inner class object can be created directly from instance area of outer class,
  as to access any instance method of outer class object must present. @see `createInnerClassInstance` in below example
  
    ```
        Inner fromInstanceMethod =  new Inner();
    ```
  
    ```
        public class Outer {
            public static final Logger LOG = Logger.getLogger("Outer");
        
            public static void main(String[] args) {
                Inner innerObject = new OuterClassWithInterfaceDeclaration().new Inner();
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
  method including `main method` can't be declare inside the inner class.
  - Compile time error `*(Inner classes can't have static declaration)`* thrown when declare the 
  static member inside normal inner class.
  - Normal Inner class can't declare the *static* member but still can access the static member of outer class.
  - Normal Inner class can access both static and non static member of outer class directly. 
  - Normal Inner can also be declared private, protected in addition to all other modifier(public, default, final, abstract, strictfp) applicable for normal class. 
  - Once the normal Inner class, declared as static, it becomes special case of static inner class. Explained in details later in the other section. 

    ```
        public class OuterMemberAccess {
               public static final Logger LOG = Logger.getLogger("OuterClassWithInterfaceDeclaration");
           
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
  - In side the normal inner class `this` keyword always refer to inner class object  
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
  - The scope of the inner class limited to the block where it is defined. Example if declared in `if` block it will be accessible in if block.
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
  removed in contras Objects reside on the heap and removed by `GC`. That is the reason why normal variable can't be used inside the local Inner class.
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
# Anonymous Inner Class

  - It is an inner class without a name and for which only a single object is created.
  - Based on declaration and behavior Anonymous inner class can be classified into three types.
     - Anonymous inner class extends a class
     - Anonymous inner class implements an interface.
     - Anonymous inner class defined inside arguments
# 
  - Anonymous Class extends a class. Below, is the anonymous object created by extending Person class.
  - As this is defined in Person It will be the outer class and compiler will create the inner class with the name `Person$1.class`.
  - Below is the typical example of Overriding. Here the anonymous class has overridden the `displayName()` method of Person.
  - As the anonymous class is the child of Person class the `displayAge` method can be access though by its object. 
      
    ```
        import java.util.logging.Level;
        import java.util.logging.Logger;
        
        public class Person {
            public static final Logger LOG = Logger.getLogger("OuterMemberAccess");
        
            public void displayName() {
                LOG.log(Level.INFO, "Name is Person");
            }
        
            public void displayAge() {
                LOG.log(Level.INFO, "Age from the super class");
            }
        
            public static void main(String[] args) {
                Person anonymousObject = new Person() {
                    public void displayName() {
                        LOG.log(Level.INFO, "Name from Anonymous class");
                    }
                };
                anonymousObject.displayName();
                anonymousObject.displayAge();
                LOG.log(Level.INFO, anonymousObject.getClass().getName());
            }
        }
    
    ```
# 
  - Anonymous Class Implements a interface. Below, is the anonymous object created by implementing Runnable.
  - In the below example `runnable` is the object of anonymous class which implements Runnable.
    
    ```
        import java.util.logging.Level;
        import java.util.logging.Logger;
        
        public class RunnableDemo {
            public static final Logger LOG = Logger.getLogger("Person");
        
            public static void main(String[] args) {
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        int i = 0;
                        while (i < 10) {
                            LOG.log(Level.INFO, "Running the run job: " + i);
                            i++;
                        }
                    }
                };
        
                Thread thread = new Thread(runnable);
                thread.start();
            }
        }
    
    ```
# Comparision between Normal java class and Anonymous Class

| Normal Java class | Anonymous Java Class |
| --- | --- |
| Normal Class can extends a class and also can implement the Interface | Anonymous class can either exetnds a class or implement a Interface |
| Any number of constructor can be defined | Can't define a constructor, as to define the constructor class name is required. But it doesn't have any name |

# Static nested class

 - If a Inner class defined with static then it becomes static nested class. 
 - A static nested class, not strongly associated with outer class.
 - Unlike Normal inner class the Static Inner class can exist without Outer class object.
 - Outer class object is not required to create the object of inner class.
 
   ```
        import java.util.logging.Level;
        import java.util.logging.Logger;
        
        public class OuterClass {
            public static final Logger LOG = Logger.getLogger(OuterClass.class.getName());
            public static void main(String[] args) {
                Nested nested = new Nested();
                nested.nestedMethod();
            }
            static class Nested{
                public void nestedMethod(){
                    LOG.log(Level.INFO, "Inside Nested inner class");
                }
            }
        }

   ```
 - The object of nested class can be created from outside of the outer class, as below.
   
   ```
       OuterClass.Nested nested = new OuterClass.Nested();
   ```
 - As the static inner class is not associated with the instance of outer class, 
 unlike normal inner class static member can be defined including `main()` method.
 - It can be executed from command line `java OuterClass$Nested`
   
   ```
        import java.util.logging.Level;
        import java.util.logging.Logger;
        
        public class OuterClass {
            public static final Logger LOG = Logger.getLogger(OuterClass.class.getName());
            static class Nested {
                public static void main(String[] args) {
                    LOG.log(Level.INFO, "Inside Nested inner class");
                    new Nested().nestedMethod()
                }
        
                public void nestedMethod() {
                    LOG.log(Level.INFO, "Inside Nested inner class");
                }
            }
        }

   ```
 - As the static behavior doesn't associate with an instance `this` can't be used inside the static Nested class. 
 - Unlike normal inner class the non-static member can't be accessed from the Nested class.