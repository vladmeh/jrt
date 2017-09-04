package algorithms;

/**
 * @autor mvl on 04.09.2017.
 */
public class Expressions {
    public static void main(String[] args) {
        String results = "";

        ExpressonNode root, leftOper, rightOper;

        //(15 / 3) + (24 / 6)
        root = new ExpressonNode(Operators.Plus);

        leftOper = new ExpressonNode(Operators.Divide);
        leftOper.leftOperand = new ExpressonNode("15");
        leftOper.rightOperand = new ExpressonNode("3");

        rightOper = new ExpressonNode(Operators.Divide);
        rightOper.leftOperand = new ExpressonNode("24");
        rightOper.rightOperand = new ExpressonNode("6");

        root.leftOperand = leftOper;
        root.rightOperand = rightOper;

        results += "(15 / 3) + (24 / 6) = " + root.Evaulate() + "\n";
        float check = (15f / 3) + (24f / 6);
        results += "Check: " + String.valueOf(check) + "\n";

        System.out.println(results);
    }
}

class ExpressonNode{
    public Operators operator;
    public ExpressonNode leftOperand, rightOperand;
    public String literaltext;

    public ExpressonNode(Operators operator) {
        this.operator = operator;
    }

    public ExpressonNode(String literaltext) {
        this.operator = Operators.Literal;
        this.literaltext = literaltext;
    }

    public float Evaulate(){
        switch (operator){
            case Literal:
                return Float.parseFloat(literaltext);
            case Plus:
                return leftOperand.Evaulate() + rightOperand.Evaulate();
            case Minus:
                return leftOperand.Evaulate() - rightOperand.Evaulate();
            case Times:
                return leftOperand.Evaulate() * rightOperand.Evaulate();
            case Divide:
                return leftOperand.Evaulate() / rightOperand.Evaulate();
            case Negate:
                return -leftOperand.Evaulate();
            case SquareRoot:
                return (float)Math.sqrt(leftOperand.Evaulate());
            case Factorial:
                return factorial(leftOperand.Evaulate());
            case Sine:
                return (float)Math.sin(Math.PI / 180.0 * leftOperand.Evaulate());
            case Squared:
                float left = leftOperand.Evaulate();
                return left * left;
        }

        throw new ArithmeticException("Unknow operator " + operator.toString());
    }

    public static float factorial(float n){
        float result = 1;
        for (int i = 2; i < n; i++) {
            result *= i;
        }
        return result;
    }
}

enum Operators{
    Literal,
    Plus,
    Minus,
    Times,
    Divide,
    Negate,
    SquareRoot,
    Factorial,
    Sine,
    Squared,
}
