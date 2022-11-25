package edu.umb.cs680.hw07;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) throws Exception {
        LocalDateTime date = LocalDateTime.now();

        Directory directort1 = new Directory(null, "Root", 12, date);
        Directory directort2 = new Directory(directort1, "Home", 8, date);

        File file1 = new File(directort2, "Main.java", 5, date);
        File file2 = new File(directort1, "Main2.java", 5, date);

        System.out.println(file1.getName());
        System.out.println(directort2.getTotalSize());
        System.out.println(file1.getParent().getParent().countChildren());

    }
}