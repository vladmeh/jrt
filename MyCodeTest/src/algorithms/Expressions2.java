package algorithms;

/**
 * @autor mvl on 04.09.2017.
 */
public class Expressions2 {
    public static void main(String[] args) {
        String results = "";

        // Sine(45)^2
        ExpressonNode root = new ExpressonNode(Operators.Squared);
        root.leftOperand = new ExpressonNode(Operators.Sine);
        root.leftOperand.leftOperand = new ExpressonNode("45");

        results += "Sine(45)^2 = " + root.Evaulate() + "\n";

        float check = (float) Math.pow(Math.sin(45 * Math.PI / 180), 2);
        results += "Check: " + String.valueOf(check);


        System.out.println(results);
    }
}

