package algorithms;

/**
 * @autor mvl on 28.07.2017.
 */
public class ParenthesisMatching {
    public static void main(String[] args) {
        System.out.println(isWellFormed("((2+2.2)*(4+5))^3"));
    }

    private static boolean isWellFormed(String expression){
        int count = 0;
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == '(') count++;
            else if (ch == ')') count--;

            if (count < 0) return false;
        }
        return count == 0;
    }
}
