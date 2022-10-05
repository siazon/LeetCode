package com.siazon.linknode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LinkCrossTest {
    LinkCross test;

    @BeforeEach
    void setUp() {
        test = new LinkCross();
    }

    @Test
    void getIntersectionNode() {
        System.out.println(test.getIntersectionNode(test.a, test.b).val);
    }
}