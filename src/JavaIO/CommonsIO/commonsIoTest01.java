package JavaIO.CommonsIO;

import org.apache.commons.io.FileUtils;

import java.io.File;

public class commonsIoTest01 {
    public static void main(String[] args) {
        //文件大小
        long len = FileUtils.sizeOf(new File("E:/Users/Shinelon/IdeaProjects/JavaSE/src/JavaIO/ConvertStream/convertStreamTest.java"));
        System.out.println(len);
        ///目录大小
        long len2 = FileUtils.sizeOf(new File("E:/Users/Shinelon/IdeaProjects/JavaSE/src/JavaIO"));
        System.out.println(len2);
    }
}
