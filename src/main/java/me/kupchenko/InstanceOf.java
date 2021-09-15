package me.kupchenko;

public class InstanceOf {
    /**
     * Goal:
     * <p>
     * To replace this boilerplate:
     * <p>
     * if (obj instanceof String) {
     * String s = (String) obj;    // grr...
     * ...
     * }
     * <p>
     * <p>
     * More details: https://openjdk.java.net/jeps/394
     */
    public void main(String[] args) {
        Object obj = "some str";
        if (obj instanceof String s) {
            String s1 = "prefix " + s;
            System.out.println(s1);
        }
    }
}
