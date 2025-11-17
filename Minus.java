public class Minus extends Binop {
    protected double eval(double left, double right) {
        return left - right;
    }
    public String toString(Node lChild, Node rChild) {
        return "(" + lChild.toString() + " - " + rChild.toString() + ")";
    }
}
