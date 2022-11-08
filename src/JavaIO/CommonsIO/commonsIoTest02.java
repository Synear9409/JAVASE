package JavaIO.CommonsIO;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.EmptyFileFilter;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.SuffixFileFilter;

import java.io.File;
import java.util.Collection;

/**
 * 遍历列出子孙级
 */
public class commonsIoTest02 {
    public static void main(String[] args) {
       Collection<File> lists =  FileUtils.listFiles(new File("E:/Users/Shinelon/IdeaProjects/JavaSE/src/JavaIO"),
               EmptyFileFilter.NOT_EMPTY,null);   ///EmptyFileFilter.NOT_EMPTY --- 内容不为空的文件
       for(File f : lists){
           System.out.println(f.getAbsolutePath());
       }
        System.out.println("-----------------------------");
        lists =  FileUtils.listFiles(new File("E:/Users/Shinelon/IdeaProjects/JavaSE/src/JavaIO"),
                EmptyFileFilter.NOT_EMPTY, DirectoryFileFilter.INSTANCE);   ///DirectoryFileFilter.INSTANCE ---递归目录子孙级
        for(File f : lists){
            System.out.println(f.getAbsolutePath());
        }
        System.out.println("-----------------------------");
        lists =  FileUtils.listFiles(new File("E:/Users/Shinelon/IdeaProjects/JavaSE/src/JavaIO"),
                new SuffixFileFilter("java"), DirectoryFileFilter.INSTANCE);   /// new SuffixFileFilter("java")---后缀名为Java的
        for(File f : lists){
            System.out.println(f.getAbsolutePath());
        }

        ////多重过滤的简化方式
        System.out.println("-----------------------------");
        lists =  FileUtils.listFiles(new File("E:/Users/Shinelon/IdeaProjects/JavaSE/src/JavaIO")
                ,FileFilterUtils.and(new SuffixFileFilter("java"),EmptyFileFilter.NOT_EMPTY),DirectoryFileFilter.INSTANCE);   /// new SuffixFileFilter("java")---后缀名为Java的
        for(File f : lists){
            System.out.println(f.getAbsolutePath());
        }
    }
}
