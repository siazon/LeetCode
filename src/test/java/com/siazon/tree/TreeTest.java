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
}