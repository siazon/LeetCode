package com.siazon.io;

import java.io.File;
import java.io.IOException;


@Report
public class FileDemo {
    public static void main(String[] args) throws IOException {
        File f = new File("..\\notepad.exe");
        System.out.println(f.getPath());
        System.out.println(f.getAbsolutePath());
        System.out.println(f.getCanonicalPath());
    }

    @Report
    public void test() {

    }
}
