# Inner-class

Inner class: 
  1. A class defined inside another class. Below example the OuterClass defines the InnerClass. 
  2. The Inner class always represents the HAS-A relationship with Outer class. 
  3. The Inner class object can't be created without creating the Outer class object. Hence, 
  it is always about the instance behaviour associated with outer class.
  4. As Inner class depict the instance behaviour the static variable and static 
  method including **main method** can't be declare inside the inner class.
  5. Compile time error ***(Inner classes can't have static declaration)*** thrown when declare the 
  static member inside inner class.
  6. Inner class can be declared as private as associated with instance behaviour.
  7. Inner class object is created using the Outer class object @see the below example **main** method.
  8. The Inner class object can be created directly from any instance method of outer class,
  as to access any instance method the outer object has already been created. @see **createInnerClassInstance** in below example
  
```
public class OuterClass {
    public static final Logger LOG = Logger.getLogger("OuterClass");

    public static void main(String[] args) {
        InnerClass innerObject = new OuterClass().new InnerClass();
        innerObject.innerMethod();
    }
    
    public void createInnerClassInstance(){
        InnerClass fromInstanceMethod =  new InnerClass();
        fromInstanceMethod.innerMethod();
    }

    class InnerClass {
        public void innerMethod() {
            LOG.log(Level.INFO, "InnerMethod");
        }
    }
}
```
