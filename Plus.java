public class Plus extends Binop {
    @Override
    protected double eval(double left, double right) {
        return left + right;
    }

    @Override
    public String toString(Node lChild, Node rChild) {
        return "(" + lChild.toString() + " + " + rChild.toString() + ")";
    }
}
