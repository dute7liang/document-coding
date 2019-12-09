package com.document.zip;

import lombok.extern.slf4j.Slf4j;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;
import org.apache.tools.zip.ZipOutputStream;

import java.io.*;
import java.util.Enumeration;
import java.util.List;

/**
 * 利用Apache Ant的jar包来解压缩zip工具类。
 * 相对于java原生的技术，可以支持中文
 * @author: zl
 * @Date: 2019/12/8 16:29
 */
@Slf4j
public class AntZipUtil {

    /**
     * 缓冲大小
     */
    private static int BUFFER_SIZE = 2 << 10;

    public static void toZip(String srcDir, String zipPath, boolean isDelSrcFile) {
        long start = System.currentTimeMillis();
        ZipOutputStream zos = null;
        File sourceFile = new File(srcDir);
        File zipFile = new File(zipPath);
        if(!sourceFile.exists()){
            throw new RuntimeException("需压缩文件或者文件夹不存在");
        }
        try {
            zos = new ZipOutputStream(zipFile);
            compress(sourceFile, zos, sourceFile.getName());
            if(isDelSrcFile){
                sourceFile.delete();
            }
            log.info("原文件:{}. 压缩到:{}完成. 是否删除原文件:{}. 耗时:{}ms. ",srcDir,zipPath,isDelSrcFile, System.currentTimeMillis()-start);
        } catch (IOException e) {
            log.error("zip error from AntZipUtil: {}. ",e.getMessage());
            throw new RuntimeException(e);
        } finally {
            try {
                if (zos != null) {zos.finish();zos.close();}
            } catch (Exception e) {}
        }
    }


    /**
     * 递归压缩方法
     * @param sourceFile 源文件
     * @param zos zip输出流
     * @param name 压缩后的名称
     */
    private static void compress(File sourceFile, ZipOutputStream zos, String name) throws IOException {
        if (sourceFile.isFile()) {
            byte[] buf = new byte[BUFFER_SIZE];
            zos.putNextEntry(new ZipEntry(sourceFile,name));
            int len;
            FileInputStream in = new FileInputStream(sourceFile);
            while ((len = in.read(buf)) != -1) {
                zos.write(buf, 0, len);
            }
            zos.closeEntry();
            in.close();
        } else {
            File[] listFiles = sourceFile.listFiles();
            if (listFiles == null || listFiles.length == 0) {
                zos.putNextEntry(new ZipEntry(sourceFile,name + "/"));
                zos.closeEntry();
            } else {
                for (File file : listFiles) {
                    compress(file, zos, name + "/" + file.getName());
                }
            }
        }
    }


    /**
     * 将多个文件压缩成zip，文件放在zip根目录，注意文件名相同会覆盖
     * @param srcFiles 需要压缩的文件列表
     * @param zipPath  zip文件路径
     * @throws RuntimeException 压缩失败会抛出运行时异常
     */
    public static void toZip(List<File> srcFiles , String zipPath) {
        long start = System.currentTimeMillis();
        File zipFile = new File(zipPath);
        File parentFile = zipFile.getParentFile();
        if(!parentFile.exists()) parentFile.mkdirs();
        FileOutputStream fos = null;
        ZipOutputStream zos = null;
        try {
            fos = new FileOutputStream(zipPath);
            zos = new ZipOutputStream(new BufferedOutputStream(fos));
            for (File srcFile : srcFiles) {
                byte[] buf = new byte[BUFFER_SIZE];
                zos.putNextEntry(new ZipEntry(srcFile.getName()));
                int len;
                FileInputStream in = new FileInputStream(srcFile);
                while ((len = in.read(buf)) != -1){
                    zos.write(buf, 0, len);
                }
                in.close();
                zos.closeEntry();
            }
            long end = System.currentTimeMillis();
            log.info("压缩完成，耗时：" + (end - start) +" ms");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally{
            try {
                if(zos != null){
                    zos.finish();
                    zos.close();
                }
                if(fos != null) fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



    /**
     * 把zip文件解压到指定的文件夹
     * @param sourceFile zip文件, 如 "D:/test/aa.zip"
     * @param saveFileDir 解压后的文件存放路径, 如"D:/test/" ()
     */
    public static void unZip(File sourceFile, String saveFileDir) {
        long start = System.currentTimeMillis();
        // 判断源文件是否存在
        if (!sourceFile.exists())
            throw new RuntimeException("zip源文件不存在！");
        File dir = new File(saveFileDir);
        if(!dir.exists()){
            dir.mkdirs();
        }
        File entryFile;
        ZipFile zipFile = null;
        InputStream inputStream = null;
        try {
            zipFile = new ZipFile(sourceFile);
            for(Enumeration<ZipEntry> entries = zipFile.getEntries();
                entries.hasMoreElements();){
                ZipEntry zipEntry = entries.nextElement();
                entryFile = new File(saveFileDir + "/" + zipEntry.getName());
                if(zipEntry.isDirectory()){
                    entryFile.mkdirs();
                } else {
                    File parent = entryFile.getParentFile();
                    if(parent!=null && !parent.exists()){
                        parent.mkdirs();
                    }
                    OutputStream os = new BufferedOutputStream(new FileOutputStream(
                            entryFile));
                    byte[] buffer = new byte[BUFFER_SIZE];
                    int len;
                    inputStream = zipFile.getInputStream(zipEntry);
                    while((len = inputStream.read(buffer)) != -1) {
                        os.write(buffer, 0, len);
                    }
                    inputStream.close();
                    os.close();
                }
            }
            long end = System.currentTimeMillis();
            log.info("解压完成，耗时：{} ms",end - start);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(inputStream != null) inputStream.close();
                if(zipFile != null) zipFile.close();
            } catch (IOException e) {
                // nothing
            }
        }
    }

}
