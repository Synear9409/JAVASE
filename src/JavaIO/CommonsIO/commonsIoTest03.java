package JavaIO.CommonsIO;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * 读取文件内容
 */
public class commonsIoTest03 {
    public static void main(String[] args) throws IOException {
        ///读取文件
        String msg = FileUtils.readFileToString(
                new File("E:/Users/Shinelon/IdeaProjects/JavaSE/src/JavaIO/aaa.txt"),"UTF-8");
        System.out.println(msg);
        byte[] data = FileUtils.readFileToByteArray(
                new File("E:/Users/Shinelon/IdeaProjects/JavaSE/src/JavaIO/aaa.txt"));
        System.out.println(data.length);
        System.out.println("------------------------");

        ///逐行读取
        List<String> list =  FileUtils.readLines(
                new File("E:/Users/Shinelon/IdeaProjects/JavaSE/src/JavaIO/aaa.txt"),"UTF-8");
        for(String s : list){
            System.out.println(s);
        }
        System.out.println("------------------------");

        LineIterator it =  FileUtils.lineIterator(
                new File("E:/Users/Shinelon/IdeaProjects/JavaSE/src/JavaIO/aaa.txt"),"UTF-8");
        while (it.hasNext()){
            System.out.println(it.nextLine());
        }
    }
}
