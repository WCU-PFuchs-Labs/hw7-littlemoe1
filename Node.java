public abstract class Node {


    private Node lChild, rChild;
    private Op op;

    // Constructor for binary operation
    public Node(Binop op, Node lChild, Node rChild) {
        this.op = op;
        this.lChild = lChild;
        this.rChild = rChild;
    }

    // Constructor for unary operation (Const or Variable)
    public Node(Unop op) {
        this.op = op;
        this.lChild = null;
        this.rChild = null;
    }

    public double eval(double[] values) {
        return op.eval(lChild, rChild, values);
    }

    public String toString() {
        if (op instanceof Binop) {
            return op.toString(lChild, rChild);
        } else if (op instanceof Unop) {
            return op.toString();
        } else {
            return "";
        }
    }
    public abstract double eval(double[] data);
    public abstract String toString();

    /**
     * collect using preorder traversal.
     */
    public void traverse(Collector c) {
        // collect this node
        c.collect(this);
        // traverse left subtree
        if (lChild != null) {
            lChild.traverse(c);
        }
        // traverse right subtree
        if (rChild != null) {
            rChild.traverse(c);
        }
    }

    /**
     * swap this left child node with trunk left child node
     */
    public void swapLeft(Node trunk) {
        Node temp = this.lChild;
        this.lChild = trunk.lChild;
        trunk.lChild = temp;
    }

    /**
     * swap this right child node with trunk right child node
     */
    public void swapRight(Node trunk) {
        Node temp = this.rChild;
        this.rChild = trunk.rChild;
        trunk.rChild = temp;
    }

    /**
     * return true if operation is a Unop (leaf)
     */
    public boolean isLeaf() {
        return (lChild == null && rChild == null);
    }
}
