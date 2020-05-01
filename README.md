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
            - Anonymous inner class
            - Local inner class
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
