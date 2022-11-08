package JavaIO.CommonsIO;


import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * 拷贝文件
 * @author Synear
 */
public class commonsIoTest05 {
    public static void main(String[] args) throws IOException {
        //复制文件
        /*FileUtils.copyFile(
                new File("E:/Users/Shinelon/IdeaProjects/JavaSE/src/JavaIO/aaa.txt"),
                new File("E:/Users/Shinelon/IdeaProjects/JavaSE/src/JavaIO/bbb.txt"));*/
        //复制文件到目录
        /*FileUtils.copyFileToDirectory(
                new File("E:/Users/Shinelon/IdeaProjects/JavaSE/src/JavaIO/aaa.txt"),
                new File("E:/Users/Shinelon/IdeaProjects/JavaSE/src/JavaIO/CommonsIO"));*/
        //复制目录到目录
        /*FileUtils.copyDirectoryToDirectory(
                new File("E:/Users/Shinelon/IdeaProjects/JavaSE/src/JavaIO/lib"),
                new File("E:/Users/Shinelon/IdeaProjects/JavaSE/src/JavaIO/lib2"));*/
        //复制目录
        /*FileUtils.copyDirectory(new File("E:/Users/Shinelon/IdeaProjects/JavaSE/src/JavaIO/lib"),
                new File("E:/Users/Shinelon/IdeaProjects/JavaSE/src/JavaIO/lib2"));*/
        //拷贝URL内容
        /*FileUtils.copyURLToFile(
                new URL("http://www.baidu.com"),
                new File("E:/Users/Shinelon/IdeaProjects/JavaSE/src/JavaIO/baidu.html"));*/

        ///直接输出URL中获取的内容
        /*String data = IOUtils.toString(new URL("http://www.baidu.com"),"utf-8");
        System.out.println(data);*/
    }
}
