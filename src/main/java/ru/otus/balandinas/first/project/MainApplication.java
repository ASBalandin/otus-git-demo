package ru.otus.balandinas.first.project;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MainApplication {
    public static void main(String[] args) {
        var file = new File("src");
        System.out.println("txt files : " +
                Arrays.stream(
                        file.listFiles((dir, name) -> name.toLowerCase().endsWith(".txt"))
                ).map(it -> it.getName()).collect(Collectors.toList()));
        System.out.println("Введите имя файла");
        Scanner sc = new Scanner(System.in);
        String fname = sc.next();

        try (FileInputStream in1  = new FileInputStream("src/" + fname)) {
            BufferedInputStream inB = new BufferedInputStream (in1);
            InputStreamReader in = new InputStreamReader(inB);

            int n = in.read();
            while (n != -1) {
                System.out.print((char) n);
                n = in.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println("введите строку для записи :");
        String buf = sc.next();
        try(BufferedOutputStream out  = new BufferedOutputStream(new FileOutputStream("src/" +fname,true))){
            byte[] buffer = buf.getBytes(StandardCharsets.UTF_8);
            for (int i = 0; i < buffer.length; i++) {
                out.write(buffer[i]);
            }
        }  catch (IOException e){
            e.printStackTrace();
        }

    }

}
