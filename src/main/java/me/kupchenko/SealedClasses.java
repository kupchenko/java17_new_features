package me.kupchenko;

public class SealedClasses {
    /**
     * Goals:
     * <p>
     * Allow the author of a class or interface to control which code is responsible for implementing it.
     * <p>
     * Provide a more declarative way than access modifiers to restrict the use of a superclass.
     * <p>
     * Support future directions in pattern matching by providing a foundation for the exhaustive analysis of patterns.
     * <p>
     * More details: https://openjdk.java.net/jeps/409
     */
    public static void main(String[] args) {
        S a = new A();
        S b = new B();
        S c = new C(1);
    }
}

sealed interface S permits A, B, C {
}

final class A implements S {
}

final class B implements S {
}

record C(int i) implements S {
}

//NOT TODO:
//D is not allowed in the sealed hierarchy
/*
final class D implements S {
}
 */
