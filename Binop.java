public abstract class Binop extends Op {
    @Override
    public double eval(Node lChild, Node rChild, double[] values) {
        double lval = lChild.eval(values);
        double rval = rChild.eval(values);
        return this.eval(lval, rval);
    }

    protected abstract double eval(double left, double right);
    public abstract String toString(Node lChild, Node rChild);
}
