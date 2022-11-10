package com.siazon.tree;


public class NormalClass {
    public static void main(String[] args) {
        MessageBoard board = new MessageBoard();
        Student bob = new Student("bob");
        Student joe = new Student("joe");
        board.addObserver(bob);
        board.addObserver(joe);
        Teacher te = new Teacher();
        board.addObserver(te);
        board.changeMessage("More Homework!");

    }
}
