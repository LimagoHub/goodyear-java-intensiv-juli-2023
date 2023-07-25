package main;
public class Main {
    public static void main(String[] args) { // (KAI) A B C "foo von B" D  B C "foo von B" D
        new B();   new B();
    }
}
class A {
     static {
        System.out.println("A");
    }
    {
        System.out.println("B");
    }
    public A() {
        System.out.println("C");
        foo();
    }
     public void foo() {
        System.out.println("Foo von A");
    }
}
class B extends A {
    public B() {
        System.out.println("D");
   }
   @Override
    public void foo() {
        System.out.println("Foo von B");
    }
}