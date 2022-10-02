package com.siazon.tree;

import static org.junit.jupiter.api.Assertions.*;

class BuildTreeTest {
    BuildTree test;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        test = new BuildTree();
    }

    @org.junit.jupiter.api.Test
    void buildTreeTest() {
        test.buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
    }

    @org.junit.jupiter.api.Test
    void constructMaximumBinaryTreeTest() {
        test.constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5});
    }
}