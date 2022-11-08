package JavaIO;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;

public class TestReader {
    public static void main(String[] args) throws Exception {
        File file = new File("D:" + File.separator + "hello" + File. separator + "reverse.txt");
        if (file.exists()) { // 文件存在则进行读取
            Reader in = new FileReader(file) ;
            char data[] = new char[1024] ;
            int len = in.read(data) ;
            System.out.println("读取内容:"+ new String(data,0,len));
            in.close();   ///关闭流
        }
    }
}