package com.siazon.tree;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TreeBack {
    ServerSocket socket;
    HashMap<String, DataOutputStream> Clients = new HashMap<>();

    public TreeBack() throws IOException {
        socket = new ServerSocket(4000);
    }

    public void Start() throws IOException {
        while (true) {
            Socket s = socket.accept();

            Thread threadA = new Thread(new Runnable() {
                @Override
                public void run() {
                    try (DataInputStream dis = new DataInputStream(s.getInputStream())) {
                        DataOutputStream dOut = new DataOutputStream(s.getOutputStream());

                        int count;
                        byte[] buffer = new byte[8192]; // or 4096, or more
                        while ((count = dis.read(buffer)) > 0) {
                            // out.write(buffer, 0, count);
                            byte[] data = new byte[count];
                            for (int i = 0; i < count; i++)
                                data[i] = buffer[i];
                            Clients.put(DataUtil.bytesToHex(data), dOut);
                            System.out.println("message= " + DataUtil.bytesToHex(data));
                        }
                    } catch (Exception e) {

                    }
                }
            });
            threadA.start();
        }
    }

    public void Stop() throws IOException {
        List<String> test = new LinkedList<>();
        socket.close();
    }

    public int SendMsg(String endPoint, byte[] buff) throws IOException {
        int i = 0;
        Clients.get(endPoint).write(buff);

        return i;
    }

    static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) throws IOException {

        TreeBack back = new TreeBack();

//        Thread threadA = new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//                try {
//                    System.out.println("Start");
//                    back.Start();
//                    System.out.println("Start end");
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        threadA.start();
//        String txt = scanner.next();
//        while (!"q".equalsIgnoreCase(txt)) {
//            byte[] data = txt.getBytes(Charset.forName("UTF-8"));
//            back.SendMsg("09", data);
//            System.out.println("输入以发送");
//            txt = scanner.next();
//        }
    }
}
