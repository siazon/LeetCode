package com.siazon.tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class TreeTest {
    Tree test;

    @BeforeEach
    void setUp() {
        test = new Tree();
        test.tree = test.createTree();
    }

    @Test
    void minLength() {
    }

    @Test
    void createTree() {
    }

    @Test
    void maxlength() {
    }

    @Test
    void checkFun() {
    }

    @Test
    void layerTraversal() {
    }

    @Test
    void commonTraversal() {
    }

    @Test
    void midorderTraversal() {
    }

    @Test
    void preorderTraversal() {
    }

    @Test
    void inorderTraversal() {
    }

    @Test
    void levelTraversalText() {
        test.levelTraversal(test.tree);
        for (List<Integer> list : test.result) {
            System.out.println();
            for (Integer i : list) {
                System.out.print(i);
            }
        }

    }

    @Test
    void reverseTreeTest() {
        test.reverseTree(test.tree);
        for (List<Integer> list : test.result) {
            System.out.println();
            for (Integer i : list) {
                System.out.print(i);
            }
        }
    }

    @Test
    void invertTreeTest() {
        test.invertTree(test.tree);
        test.levelTraversal(test.tree);
        for (List<Integer> list : test.result) {
            System.out.println();
            for (Integer i : list) {
                System.out.print(i);
            }
        }

    }

    @Test
    void maxDepthRecursionTest() {
        int length = test.maxDepthRecursion(test.tree);
        System.out.println(length);
    }

    @Test
    void minDepthRecursionTest() {
        int length = test.minDepthRecursion(test.tree);
        System.out.println(length);
    }

    @Test
    void minDepthTest() {
        int length = test.minDepthRecursion(test.tree);
        System.out.println(length);
    }

    @Test
    void getNodeNumberTest() {
        int length = test.getNodeNumbers(test.tree);
        System.out.println(length);
    }

    @Test
    void isBalanceTreeTest() {
        boolean length = test.isBalanceTree(test.tree);
        System.out.println(length);
    }

    @Test
    void getLeftSumTest() {
        int length = test.leftSum(test.tree);
        System.out.println(length);
    }

    @Test
    void getMaxLeft() {
        int left = test.getMaxLeft(test.tree);
        System.out.println(left);

    }
}