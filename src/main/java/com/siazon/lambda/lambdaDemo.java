package com.siazon.lambda;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class lambdaDemo {
    public static void main(String[] args) throws IOException {
        List<User> list = new ArrayList<>();
        list.add(new User(1, "Chris", 20));
        list.add(new User(2, "Linda", 10));
        list.add(new User(3, "Jack", 30));
        list.sort((a1, a2) -> a2.getAge() - a1.getAge());
//        list.forEach((a) -> System.out.println(a));
        list.stream().map(a -> a.getAge() * a.getAge()).forEach(System.out::println);

        runDemo demo = (a) -> System.out.println("Hello: " + a);
        demo.run("siazon");

        URL url = new URL("http://example.com");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
    }
}
