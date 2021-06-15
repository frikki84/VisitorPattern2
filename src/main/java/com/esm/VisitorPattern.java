package com.esm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.TreeMap;

enum Color {
    RED, GREEN
}

abstract class Tree {

    //значение, расположенное в узле
    private int value;
    //цвет узла
    private Color color;
    //глубина - это количство ребер между узлом и корнем дерева (глубина корня = 0, глубина каждого потомка узла
    // равна глубина узла + 1
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

    @Override
    public String toString() {
        return "Tree{" + "value=" + value + ", color=" + color + ", depth=" + depth + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Tree tree = (Tree) o;
        return value == tree.value && depth == tree.depth && color == tree.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, color, depth);
    }
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

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof TreeNode))
            return false;
        if (!super.equals(o))
            return false;
        TreeNode treeNode = (TreeNode) o;
        return children.equals(treeNode.children);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), children);
    }

    @Override
    public String toString() {
        return "TreeNode{" + super.toString() + " children=" + children + '}';
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

    //Реализуйте логику, отвечающую за посещение нелистовых узлов дерева,
    // чтобы метод getResult возвращал правильный результат для посетителя реализующего класса.
    public abstract void visitNode(TreeNode node);

    //Реализуйте логику, отвечающую за посещение листовых узлов дерева,
    // так чтобы метод getResult возвращал правильный результат для посетителя реализующего класса.
    public abstract void visitLeaf(TreeLeaf leaf);

}

class SumInLeavesVisitor extends TreeVis {

    //вернуть сумму, находящуюся на листьях
    public int getResult() {
        //implement this
        return 0;
    }

    public void visitNode(TreeNode node) {
        //implement this
    }

    public void visitLeaf(TreeLeaf leaf) {
        //implement this
    }
}

class ProductOfRedNodesVisitor extends TreeVis {

    //произведение значений, хранящихся во всех красных узлах, включая листья, вычисленное по модулю 10^9 +7.
    // Обратите внимание, что произведение нулевых значений равно 1.
    public int getResult() {
        //implement this
        return 1;
    }

    public void visitNode(TreeNode node) {
        //implement this
    }

    public void visitLeaf(TreeLeaf leaf) {
        //implement this
    }
}

class FancyVisitor extends TreeVis {

    //должна возвращать абсолютную разницу между суммой значений, хранящихся в нелистовых узлах дерева на одинаковой глубине,
    // и суммой значений, хранящихся в зеленых листовых узлах дерева. Напомним, что ноль - четное число.
    public int getResult() {
        //implement this
        return 0;
    }

    public void visitNode(TreeNode node) {
        //implement this
    }

    public void visitLeaf(TreeLeaf leaf) {
        //implement this
    }
}

public class VisitorPattern {

    public static Tree solve() {
        List<Integer> inputValues = createValuesArray();
        int nodeNumber = findNodeNumber(inputValues);
        List<Integer> values = findValues(inputValues);
        List<Color> colors = findColorList(inputValues);
        LinkedHashMap<Integer, List<Integer>> edges = findEdgesMap(inputValues);

        return null;
    }

    public static Tree createRootTree(int nodeNumber, List<Integer> values, List<Color> colors,
            HashMap<Integer, List<Integer>> edges) {
//        TreeNode tree = null;
//        //        for (int i = 1; i <= 1; i ++) {
//        //
//        //            if(edges.containsKey(i)) {
//        int depth = 0;
//        tree = new TreeNode(values.get(0), colors.get(0), depth);
//        depth++;
//
//
//
//        //                for (int j = 0; j < edges.get(0).size(); j ++) {
//        //                    Tree nodeTree = null;
//        //                    int k = edges.get(0).get(j) -1;
//        //                    if (edges.containsKey(edges.get(j))) {
//        //                        nodeTree = new TreeNode(values.get(k), colors.get(k), depth);
//        //
//        //                    } else {
//        //                        nodeTree = new TreeLeaf(values.get(k), colors.get(k), depth);
//        //                    }
//        //                    tree.addChild(nodeTree);
//        //                }
//        //            }
//        for (int j = 0; j < edges.get(0).size(); j++) {
//            int k = edges.get(0).get(j) - 1;
//            TreeNode treeNode = new TreeNode(values.get(k), colors.get(k), depth);
//             while (edges.containsKey(edges.get(0).get(j))) {
//                int ko = edges.get(0).get(j) - 1;
//
//
//             }
//
        //            tree.addChild(treeNode);
        //        }
        //        edges.remove(edges.get(1));
        //
        //        System.out.println(tree);
//
//        List<TreeNode> middleList = new ArrayList<>();
//        int depth = 0;
//        for (Integer key : edges.keySet()) {
//            middleList.add(createTree(key, values, colors, depth));
//        }
//        System.out.println("middleList " + middleList);

        LinkedList<Integer> checkList = new LinkedList<>();
        for (int i = 1; i <= nodeNumber; i ++) {
            checkList.add(i);
        }
        int depth = 0;
        TreeNode mainNode = createTree(1, values, colors, depth);
        checkList.removeFirstOccurrence(1);

        for(int i = 1; i<= nodeNumber; i ++) {
            if (edges.containsKey(i)) {
                for (int j = 0; j < edges.get(i).size(); j++) {
                    depth++;
                    int number = edges.get(i).get(j);
                    if (checkList.contains(number)) {
                        TreeNode treeNode = createTree(number, values, colors, depth);
                        mainNode.addChild(treeNode);
                        checkList.removeFirstOccurrence(number);
                    }
                    depth++;
                }
            }
        }
        System.out.println("mainNode " + mainNode);
        System.out.println("checkList "+ checkList);



        return null;
}

public static TreeNode createTree(int number, List<Integer> values, List<Color> colors, int depth) {
        int arrayNumber = number -1;
        return new TreeNode(values.get(arrayNumber), colors.get(arrayNumber), depth);
}

    public static List<Integer> createValuesArray() {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while (scanner.hasNext()) {
            list.add(scanner.nextInt());
        }
        return list;

    }

    public static Integer findNodeNumber(List<Integer> list) {
        return list.get(0);
    }

    public static List<Integer> findValues(List<Integer> list) {
        Integer nodeNumber = findNodeNumber(list);
        List<Integer> values = new ArrayList<>();
        for (int i = 1; i <= nodeNumber; i++) {
            values.add(list.get(i));
        }
        return values;
    }

    public static List<Color> findColorList(List<Integer> list) {
        Integer nodeNumber = findNodeNumber(list);
        List<Integer> colorNumbers = new ArrayList<>();
        for (int i = nodeNumber + 1; i <= nodeNumber * 2; i++) {
            colorNumbers.add(list.get(i));
        }
        List<Color> colors = new ArrayList<>();

        for (Integer color : colorNumbers) {
            if (color == 1) {
                colors.add(Color.GREEN);
            } else {
                colors.add(Color.RED);
            }
        }

        return colors;
    }

    public static LinkedHashMap<Integer, List<Integer>> findEdgesMap(List<Integer> list) {
        Integer nodeNumber = findNodeNumber(list);
        List<Integer> edgeIntegerList = new ArrayList<>();
        for (int i = nodeNumber * 2 + 1; i < list.size(); i++) {
            edgeIntegerList.add(list.get(i));
        }
        LinkedHashMap<Integer, List<Integer>> map = new LinkedHashMap<>();
        List<Integer> value = new ArrayList<>();
        value.add(edgeIntegerList.get(1));
        map.put(edgeIntegerList.get(0), value);

        for (int i = 2; i < edgeIntegerList.size(); i += 2) {
            if (map.containsKey(edgeIntegerList.get(i))) {
                map.get(edgeIntegerList.get(i)).add(edgeIntegerList.get(i + 1));
            } else {
                List<Integer> val = new ArrayList<>();
                val.add(edgeIntegerList.get(i + 1));
                map.put(edgeIntegerList.get(i), val);
            }
        }
        return map;
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

