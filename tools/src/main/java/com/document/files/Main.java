package com.document.files;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;

/**
 * @author: zl
 * @Date: 2019-12-14 17:02
 */
public class Main {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("M:\\text\\test.xml");

//        Path file1 = Files.createFile(path);

        File file = new File("M:\\text");
        Path path1 = file.toPath();

//        Files.createDirectory(path1);


        Path path2 = Paths.get("..");
//        System.out.println(path2.toRealPath(LinkOption.NOFOLLOW_LINKS));
        System.out.println(path2.toAbsolutePath().normalize());
        System.out.println(Files.exists(path2));

//        Files.walkFileTree(path1, new SimpleFileVisitor<>());

    }

}
