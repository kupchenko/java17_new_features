package me.kupchenko;

public class Records {
    /**
     * Goals
     * Devise an object-oriented construct that expresses a simple aggregation of values.
     * <p>
     * Help developers to focus on modeling immutable data rather than extensible behavior.
     * <p>
     * Automatically implement data-driven methods such as equals and accessors.
     * <p>
     * Preserve long-standing Java principles such as nominal typing and migration compatibility.
     * <p>
     * More details: https://openjdk.java.net/jeps/395
     */
    public static void main(String[] args) {
        Point point = new Point(10, 10);
        // NOT TODO: Fails, 'x' is final
        // point.x = 20;
        int i1 = point.x + point.y;
        int i = point.x() + point.y();
        String s = point.toString();
        System.out.println(s); // Output: Point[x=10, y=10]
        System.out.println(point.equals(new Point(10, 10))); // Output: true
    }

    record Point(int x, int y) {
    }
}
