package me.kupchenko.preview;

import java.util.Arrays;

public class SwitchPattern {

    public static void main(String[] args) {
        assert "String str".equals(formatterPatternSwitch("str"));
        assert "String str".equals(notFormattedSwitch("str"));
    }

    /**
     * In Java 16, JEP 394 extended the instanceof operator to take a type pattern and perform pattern matching.
     * More details: https://openjdk.java.net/jeps/406
     */
    static String formatterPatternSwitch(Object o) {
        return switch (o) {
            case Integer i && (i > 100) -> String.format("int %d", i);
            case Integer i -> String.format("int %d", i);
            case Long l -> String.format("long %d", l);
            case Double d -> String.format("double %f", d);
            case String s -> String.format("String %s", s);
            case int[] ia -> String.format("Array %s", Arrays.toString(ia));
            case null -> null;
            default -> o.toString();
        };
    }

    static String notFormattedSwitch(Object o) {
        String formatted = "unknown";
        if (o instanceof Integer i) {
            formatted = String.format("int %d", i);
        } else if (o instanceof Long l) {
            formatted = String.format("long %d", l);
        } else if (o instanceof Double d) {
            formatted = String.format("double %f", d);
        } else if (o instanceof String s) {
            formatted = String.format("String %s", s);
        }
        return formatted;
    }
}

