package JavaIO.CommonsIO;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 写出内容
 * @author Synear
 */
public class commonsIoTest04 {
    public static void main(String[] args) throws IOException {
        ///写出文件
        FileUtils.write(
                new File("E:/Users/Shinelon/IdeaProjects/JavaSE/src/JavaIO/aaa.txt"),"学习使人快乐1\r\n","UTF-8",true);
        FileUtils.writeStringToFile(
                new File("E:/Users/Shinelon/IdeaProjects/JavaSE/src/JavaIO/aaa.txt"),"学习使人快乐2\r\n","UTF-8",true);
        FileUtils.writeByteArrayToFile(
                new File("E:/Users/Shinelon/IdeaProjects/JavaSE/src/JavaIO/aaa.txt"),"学习使人快乐3\r\n".getBytes(),true);


        List<String> person = new ArrayList<>();
        person.add("马云");
        person.add("马化腾");
        person.add("弼马温");

        FileUtils.writeLines(
                new File("E:/Users/Shinelon/IdeaProjects/JavaSE/src/JavaIO/aaa.txt"),person,",",true);
    }
}
