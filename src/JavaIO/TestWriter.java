package JavaIO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class TestWriter {
    public static void main(String[] args) throws IOException {
        File file = new File("D:" + File.separator + "hello" + File. separator + "reverse.txt");
        if (!file. getParentFile().exists()) {
        file. getParentFile(). mkdirs(); // 父目录必须存在
        }
        Writer out = new FileWriter(file) ;
        String str = "www.mldn.cn\r\n";
        out.write(str);
        out.append("中国人民万岁。") ; // 追加输出内容
        out.close();

    }
}