package com.siazon.tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

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

        Dictionary<Integer, Integer> dic = new Hashtable<>();

        TreeMap<Integer, String> map = new TreeMap<>();

        map.put(3, "map");
        map.put(2, "map");
        map.put(4, "map");


        TreeSet<Integer> set = new TreeSet<>();
        set.add(2);
        set.add(1);
        set.add(5);
        List<Integer> list = new ArrayList<>();
        Iterator<Map.Entry<Integer, String>> integers = map.entrySet().iterator();
        while (integers.hasNext()) {
            int i = integers.next().getKey();
            if (i == 2)
                integers.remove();
            //System.out.println(integers.next().getKey());
        }
        for (int i : map.keySet())
            System.out.println(i);

        Deque<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);


//        System.out.println(queue.poll());
//        System.out.println(queue.peek());
//        System.out.println(queue.pop());
        Integer[] a = new Integer[]{1, 2, 3};
        String[] b = new String[]{"a", "b"};
        Integer a1 = printArray(a);
        String b1 = printArray(b);
    }

    public <E> E printArray(E[] a) {
        return a[0];
    }

    class Box<T> {
        private T t;

        public void add(T t) {
            this.t = t;
        }

        public T get() {
            return t;
        }
    }

    @Test
    void commonTraversal() {
        Box<String> box = new Box<>();
        box.add("23");
        System.out.println(box.get());
    }

    @Test
    void midorderTraversal() {
        List<Integer> list = new ArrayList<>();
        preOrder(test.tree, list);
    }

    public void preOrder(TreeNode root, List<Integer> res) {
        if (root == null) return;
        res.add(root.val);
        if (root.left != null) preOrder(root.left, res);
        if (root.right != null) preOrder(root.right, res);
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