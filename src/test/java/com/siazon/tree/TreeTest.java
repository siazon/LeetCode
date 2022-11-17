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
        int[] A = new int[]{1, 2, 1, 2, 1, 2};
        int res = solution("aabbcc", A);
        System.out.println(res);
    }

    //1578
    public int solution(String s, int[] A) {
        if (s.length() == 0) return 0;
        char currChar = s.charAt(0);
        int maxCost = A[0];
        int result = 0;
        for (int i = 1; i < s.length(); i++) {
            if (currChar == s.charAt(i)) {
                result += Math.min(A[i - 1], A[i]);
                if (A[i - 1] > A[i])
                    A[i] = A[i - 1];
            }
            currChar = s.charAt(i);
        }
        return result;
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

    @Test
    void getminResearchTest() {
        TreeNode treeNode19 = new TreeNode(12);
        TreeNode treeNode1 = new TreeNode(49);
        TreeNode treeNode2 = new TreeNode(48, treeNode19, treeNode1);
        TreeNode treeNode4 = new TreeNode(0);
        TreeNode treeNode7 = new TreeNode(1, treeNode4, treeNode2);
        int val = test.getminResearch(treeNode7);
        System.out.println(val);
    }
}