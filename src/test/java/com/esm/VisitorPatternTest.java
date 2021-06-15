package com.esm;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.TreeMap;

import org.junit.jupiter.api.Test;

class VisitorPatternTest {
    List<Integer> list = Arrays.asList(5, 4, 7, 2, 5, 12, 0, 1, 0, 0, 1, 1, 2, 1, 3, 3, 4, 3, 5);


    @Test
    void solve() {
    }

    @Test
    void createValuesArray() {
    }

    @Test
    void findNodeNumber() {
        assertEquals(5, VisitorPattern.findNodeNumber(list));
    }

    @Test
    void findValues() {
        List<Integer> expected = Arrays.asList(4, 7, 2, 5, 12);
        assertEquals(expected, VisitorPattern.findValues(list));
    }

    @Test
    void findColorList() {
        List<Color> expected = Arrays.asList(Color.RED, Color.GREEN, Color.RED, Color.RED, Color.GREEN);
        assertEquals(expected, VisitorPattern.findColorList(list));
    }

    @Test
    void findColorListFaild() {
        List<Color> expected = Arrays.asList(Color.GREEN, Color.RED, Color.RED, Color.GREEN, Color.RED);
        assertNotEquals(expected, VisitorPattern.findColorList(list));
    }

    @Test
    void findEdgesMap(){
        HashMap<Integer, List<Integer>> expectedMap = new HashMap<>();
        expectedMap.put(1, Arrays.asList(2, 3));
        expectedMap.put(3, Arrays.asList(4, 5));
        System.out.println(VisitorPattern.findEdgesMap(list));
        assertEquals(expectedMap, VisitorPattern.findEdgesMap(list));
    }

    @Test
    void createRootTree() {
        TreeNode expected = new TreeNode(4, Color.RED, 0);
        Tree tree1 = new TreeLeaf(7, Color.GREEN, 1);
        TreeNode tree2 = new TreeNode(2, Color.RED, 1);
        expected.addChild(tree1);
        expected.addChild(tree2);
        Tree tree3=new TreeLeaf(5, Color.RED, 2);
        Tree tree4 = new TreeLeaf(12, Color.GREEN, 2);
        tree2.addChild(tree3);
        tree2.addChild(tree4);
        System.out.println("expected tree " + expected);
        int nodeNumber = VisitorPattern.findNodeNumber(list);
        List<Integer> values = VisitorPattern.findValues(list);
        List<Color>colors = VisitorPattern.findColorList(list);
        LinkedHashMap<Integer, List<Integer>> edges = VisitorPattern.findEdgesMap(list);
        Tree created = VisitorPattern.createRootTree(nodeNumber, values, colors, edges);
        assertEquals(expected, created);

    }

}