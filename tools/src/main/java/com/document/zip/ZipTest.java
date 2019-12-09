package com.document.zip;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: zl
 * @Date: 2019-12-9 10:33
 */
public class ZipTest {

    public static void main(String[] args) {
        // 解压
//        String srcFilePath = "C:\\Users\\zhangliang\\Desktop\\zip\\shell.zip";
//        File srcFile = new File(srcFilePath);
//        ZipUtil.unZip(srcFile,srcFile.getParent());
//        AntZipUtil.unZip(srcFile,srcFile.getParent());

        // 压缩
//        String srcDirPath = "C:\\Users\\zhangliang\\Desktop\\shell";
//        ZipUtil.toZip(srcDirPath,"C:\\Users\\zhangliang\\Desktop\\zip\\shell.zip",false);
//        AntZipUtil.toZip(srcDirPath,"C:\\Users\\zhangliang\\Desktop\\zip\\shell.zip",false);


        List<File> fileList = new ArrayList<>();
        fileList.add(new File("C:\\Users\\zhangliang\\Desktop\\shell\\scxx-sass.sh"));
        fileList.add(new File("C:\\Users\\zhangliang\\Desktop\\shell\\temp.sh"));
        fileList.add(new File("C:\\Users\\zhangliang\\Desktop\\shell\\test.sh"));
        AntZipUtil.toZip(fileList,"C:\\Users\\zhangliang\\Desktop\\zip\\shell.zip");



    }

}
