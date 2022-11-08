package JavaIO;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class testOutputstream {
    public static void main(String[] args) throws IOException {
        File file = new File("D:"+File.separator+ "hello" + File.separator + "reverse.txt");
        if (!file.getParentFile().exists()) {
            // 文件不存在
            file. getParentFile().mkdirs();
            //创建父目录
            }
            OutputStream output = new FileOutputStream(file,true) ; // 2、 通过子类实例化
            String str = "www.mldn.cn" ; //要输出的文件内容
            output.write(str.getBytes()); // 3、 将字符串变为字节数组并输出
            output.close(); //4、关闭字节输出流
    }
}