package edu.umb.cs680.hw08;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) throws Exception {
        LocalDateTime date = LocalDateTime.now();

        Directory dr1 = new Directory(null, "Root", 0, date);
        Directory dr2 = new Directory(dr1, "Home", 0, date);
        Directory dr3 = new Directory(dr2, "SubDir", 0, date);

        File f1 = new File(dr2, "Main.java", 5, date);

        Link link1 = new Link(dr2, "Test.link", 3, date, f1);
        Link link2 = new Link(dr3, "Test2.link", 4, date, dr3);

        System.out.println("link1 is the link of :" + link1.getTarget().getName());
        System.out.println("link2 is the link of :" + link2.getTarget().getName());

        System.out.println("f1 full name: " + f1.getName());
        System.out.println("File size of dir1: " + dr1.getTotalSize());
        System.out.println("File size of dir2: " + dr2.getTotalSize());
        System.out.println("File size of dir3: " + dr3.getTotalSize());
        
        System.out.println(f1.getParent().getParent().countChildren());

    }
}