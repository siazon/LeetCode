package com.siazon.tree;

public class inTest extends NormalClass implements InterfaceTest {
    public inTest() {
        run();
        runa();
    }


    public void run() {
        System.out.println("inTest run");
    }


    @Override
    public void runa() {
        System.out.println("inTest runa");
    }

    public static void main(String[] args) {
        new inTest();
    }
}
