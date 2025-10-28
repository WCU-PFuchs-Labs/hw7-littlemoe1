import java.util.*;

public class GPTree implements Collector {
    private Node root;
    private ArrayList<Node> crossNodes;

    /**
     * @param node The node to be collected.
     * Adds node to crossNodes if it is not a leaf node.
     */
    public void collect(Node node) {
        if (!node.isLeaf()) {
            crossNodes.add(node);
        }
    }

    /**
     * This initializes the crossNodes field and
     * calls the root Node's traverse method on this
     * so that this can collect the Binop Nodes.
     */
    public void traverse() {
        crossNodes = new ArrayList<Node>();
        root.traverse(this);
    }

    /**
     * This returns a String with all of the binop Strings
     * separated by semicolons.
     */
    public String getCrossNodes() {
        StringBuilder string = new StringBuilder();
        int lastIndex = crossNodes.size() - 1;
        for (int i = 0; i < lastIndex; ++i) {
            Node node = crossNodes.get(i);
            string.append(node.toString());
            string.append(";");
        }
        string.append(crossNodes.get(lastIndex));
        return string.toString();
    }

    /**
     * this implements left child to left child
     * and right child to right child crossover.
     */
    public void crossover(GPTree tree, Random rand) {
        // find the points for crossover
        this.traverse();
        tree.traverse();
        int thisPoint = rand.nextInt(this.crossNodes.size());
        int treePoint = rand.nextInt(tree.crossNodes.size());
        boolean left = rand.nextBoolean();

        // get the connection points
        Node thisTrunk = crossNodes.get(thisPoint);
        Node treeTrunk = tree.crossNodes.get(treePoint);

        if (left) {
            thisTrunk.swapLeft(treeTrunk);
        } else {
            thisTrunk.swapRight(treeTrunk);
        }
    }

    GPTree() {
        root = null;
    }

    public GPTree(NodeFactory n, int maxDepth, Random rand) {
        root = n.getOperator(rand);
        root.addRandomKids(n, maxDepth, rand);
    }

    public String toString() {
        return root.toString();
    }

    public double eval(double[] data) {
        return root.eval(data);
    }
}
