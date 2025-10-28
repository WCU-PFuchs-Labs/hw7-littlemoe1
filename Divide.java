public class Divide extends Binop {

    public Divide() { super(); }

    public Divide(Node l, Node r) {
        super(l, r);
    }

    public double eval(double[] data) {
        double denom = rChild.eval(data);
        if (Math.abs(denom) < 0.0001)
            return 1.0; // prevent Infinity
        return lChild.eval(data) / denom;
    }

    public String toString() {
        return "(" + lChild.toString() + " / " + rChild.toString() + ")";
    }
}
