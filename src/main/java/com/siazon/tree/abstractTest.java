package com.siazon.tree;

public abstract class abstractTest implements InterfaceTest {
    @Override
    public void run() {
        System.out.println("abstractTest");
    }

    int a = 0;
    final int b = 9;
}
