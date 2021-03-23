package hackerrank.PracticeJava.JavaVisitorPattern;

import java.util.*;

enum Color {
    RED, GREEN
}

abstract class Tree {

    private int value;
    private Color color;
    private int depth;

    public Tree(int value, Color color, int depth) {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public int getDepth() {
        return depth;
    }

    public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {

    private ArrayList<Tree> children = new ArrayList<>();

    public TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitNode(this);

        for (Tree child : children) {
            child.accept(visitor);
        }
    }

    public void addChild(Tree child) {
        children.add(child);
    }
}

class TreeLeaf extends Tree {

    public TreeLeaf(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitLeaf(this);
    }
}

abstract class TreeVis {
    public abstract int getResult();

    public abstract void visitNode(TreeNode node);

    public abstract void visitLeaf(TreeLeaf leaf);

}

class SumInLeavesVisitor extends TreeVis {
    private int sumInLeaves = 0;

    public int getResult() {
        return sumInLeaves;
    }

    public void visitNode(TreeNode node) {
        //implement this
    }

    public void visitLeaf(TreeLeaf leaf) {
        sumInLeaves += leaf.getValue();
    }
}

class ProductOfRedNodesVisitor extends TreeVis {
    long productOfRedNodes = 1L;

    public int getResult() {
        return (int) (productOfRedNodes);
    }

    public void visitNode(TreeNode node) {
        if (node.getColor() == Color.RED)
            productOfRedNodes = (productOfRedNodes * node.getValue()) % (1000000007);
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor() == Color.RED)
            productOfRedNodes = (productOfRedNodes * leaf.getValue()) % (1000000007);
    }
}

class FancyVisitor extends TreeVis {
    int sumOfValuesNonLeafAtEvenDepth = 0;
    int sumOfValuesGreenLeaf = 0;

    public int getResult() {
        return Math.abs(sumOfValuesGreenLeaf - sumOfValuesNonLeafAtEvenDepth);
    }

    public void visitNode(TreeNode node) {
        if (node.getDepth() % 2 != 0) return;
        sumOfValuesNonLeafAtEvenDepth += node.getValue();
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor() != Color.GREEN) return;
        sumOfValuesGreenLeaf += leaf.getValue();
    }
}

public class Solution {
    private static Map<Integer, Set<Integer>> nodesMap = new HashMap<>();
    private static int[] x;
    private static Color[] c;

    public static Tree solve() {
        Tree tree;
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        x = new int[n];
        c = new Color[n];

        for (int i = 0; i < n; i++) {
            x[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            c[i] = (scanner.nextInt() == 0) ? Color.RED : Color.GREEN;
        }


        if (n == 1) {
            tree = new TreeLeaf(x[0], c[0], 0);
        } else {
            for (int index = 0; index < (n - 1); index++) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                Set<Integer> uEdges = nodesMap.get(u);
                if (uEdges == null) {
                    uEdges = new HashSet<>();
                }
                uEdges.add(v);
                nodesMap.put(u, uEdges);
                Set<Integer> vEdges = nodesMap.get(v);
                if (vEdges == null) {
                    vEdges = new HashSet<>();
                }
                vEdges.add(u);
                nodesMap.put(v, vEdges);
            }

            tree = new TreeNode(x[0], c[0], 0);
            Set<Integer> rootEdges = nodesMap.get(1);
            Iterator<Integer> rootIterator = rootEdges.iterator();
            while (rootIterator.hasNext()) {
                Integer nodeIdentifier = rootIterator.next();
                nodesMap.get(nodeIdentifier).remove(1);
                createEdge(tree, nodeIdentifier);
            }
        }

        return tree;
    }

    private static void createEdge(Tree tree, Integer nodeIdentifier) {
        Set<Integer> nodeEdges = nodesMap.get(nodeIdentifier);
        boolean hasChild = false;
        if (nodeEdges != null && !nodeEdges.isEmpty())
            hasChild = true;

        if (hasChild) {
            TreeNode node = new TreeNode(x[nodeIdentifier - 1], c[nodeIdentifier - 1], tree.getDepth() + 1);
            ((TreeNode) tree).addChild(node);
            Iterator<Integer> nodeIterator = nodeEdges.iterator();
            while (nodeIterator.hasNext()) {
                Integer neighborNodeIdentifier = nodeIterator.next();
                nodesMap.get(neighborNodeIdentifier).remove(nodeIdentifier);
                createEdge(node, neighborNodeIdentifier);
            }
        } else {
            TreeLeaf leaf = new TreeLeaf(x[nodeIdentifier - 1], c[nodeIdentifier - 1], tree.getDepth() + 1);
            ((TreeNode) tree).addChild(leaf);
        }
    }


    public static void main(String[] args) {
        Tree root = solve();
        SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
        ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
        FancyVisitor vis3 = new FancyVisitor();

        root.accept(vis1);
        root.accept(vis2);
        root.accept(vis3);

        int res1 = vis1.getResult();
        int res2 = vis2.getResult();
        int res3 = vis3.getResult();

        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }
}
