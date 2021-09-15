package me.kupchenko;

public class Switch {
    private static final String TYPE_A = "";
    private static final String TYPE_B = "1";
    private static final String TYPE_C = "2";
    private static final String TYPE_D = "3";

    /**
     * Goals:
     * <p>
     * Switch as a statement: Integer int = switch(...) {...}
     * <p>
     * We propose to introduce a new form of switch label, "case L ->",
     * to signify that only the code to the right of the label is to be executed if the label is matched.
     * We also propose to allow multiple constants per case, separated by commas.
     * <p>
     * Note: It's recommended that you use "arrow case" labels.
     * It's easy to forget to insert break or yield statements when using "colon case" labels;
     * if you do, you might introduce unintentional fall through in your code.
     * <p>
     * More details: https://openjdk.java.net/jeps/361
     */
    public static void main(String[] args) {
        assert switch_syntax_option1("");
        assert !switch_syntax_option2("1");
    }

    private static boolean switch_syntax_option1(String type) {
        return switch (type) {
            case TYPE_A -> true;
            case TYPE_B, TYPE_D -> false;
            case TYPE_C -> throw new IllegalStateException();
            default -> throw new IllegalArgumentException("Seriously?!");
        };
    }

    private static boolean switch_syntax_option2(String type) {
        return switch (type) {
            case TYPE_A: {
                System.out.println(TYPE_A);
                yield true;
            }
            //NOT TODO: This does not work, one style == one switch
            //case TYPE_B -> false;
            case TYPE_B, TYPE_D:
                yield false;
            case TYPE_C:
                throw new IllegalStateException();
            default:
                throw new IllegalArgumentException("Seriously?!!?");
        };
    }
}
