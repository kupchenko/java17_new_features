package me.kupchenko;

/**
 * Goals
 * <p>
 * Simplify the task of writing Java programs by making it easy to express strings that span several lines
 * of source code, while avoiding escape sequences in common cases.
 * <p>
 * Enhance the readability of strings in Java programs that denote code written in non-Java languages.
 * <p>
 * Support migration from string literals by stipulating that any new construct can express the same set
 * of strings as a string literal, interpret the same escape sequences,
 * and be manipulated in the same ways as a string literal.
 * <p>
 * Add escape sequences for managing explicit white space and newline control.
 * <p>
 * More details: https://openjdk.java.net/jeps/378
 */
public class TextBlocks {
    String old_ugly_query = "SELECT \"EMP_ID\", \"LAST_NAME\" FROM \"EMPLOYEE_TB\"\n" +
            "WHERE \"CITY\" = 'INDIANAPOLIS'\n" +
            "ORDER BY \"EMP_ID\", \"LAST_NAME\";\n";

    String query = """
            SELECT "EMP_ID", "LAST_NAME" FROM "EMPLOYEE_TB"
            WHERE "CITY" = 'INDIANAPOLIS'
            ORDER BY "EMP_ID", "LAST_NAME";
            """;

    String old_ugly_html = "<html>\n" +
            "    <body>\n" +
            "        <p>Hello, world</p>\n" +
            "    </body>\n" +
            "</html>\n";

    String html = """
            <html>
                <body>
                    <p>Hello, world</p>
                </body>
            </html>
            """;

    public static void main(String[] args) {
        String multilineText = """
                1234
                1234
                """;
        long count = multilineText.chars().filter(value -> value != '\n').count();
        assert count == 8; // Without new line Characters
        assert multilineText.length() == 10; // With new line Characters
    }
}
