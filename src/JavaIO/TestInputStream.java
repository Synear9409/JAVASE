package JavaIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class TestInputStream {
    public static void main(String[] args) throws Exception {
        File file = new File("D:" + File.separator + "hello" + File.separator + "reverse.txt");
        InputStream input = new FileInputStream(file) ;
        byte data [] = new byte[1024];   ///开辟一个缓冲区
        int len = input.read(data);   ///读取数据，数据全部保存在字节数组中
        System.out.println("[" + new String(data,0,len) +"]");
        input.close();
    }
}
