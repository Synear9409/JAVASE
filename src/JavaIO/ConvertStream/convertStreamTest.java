package JavaIO.ConvertStream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;


/**
 * 转换流 InputStreamReader、OutputStreamWriter
 * 1、以字符流的形式操作字节流（纯文本）
 * 2、指定字符集
 */
public class convertStreamTest {
    public static void main(String[] args) {
        // convertStrean();
        test1();
    }

    public static void convertStrean(){
        try(BufferedReader br =
                new BufferedReader(
                    new InputStreamReader(    ///防止乱码
                        new URL("http://www.baidu.com").openStream(),"UTF-8"));
            BufferedWriter bw =
                new BufferedWriter(
                    new OutputStreamWriter(
                        new FileOutputStream("D:/baidu.html"),"UTF-8"))){
            String msg = null;
            while((msg = br.readLine()) != null){
                bw.write(msg);   ///若这里出现乱码则是字符集不统一
                bw.newLine();
            }
            bw.flush();
            }catch(IOException e){
                System.out.println("操作异常");
            }
    }

    ///乱码例子
    public static void test1(){
        ////网络流
        try(InputStream is = new URL("http://www.baidu.com").openStream()){
            ///操作
//            byte[] res = new byte[1024*10];  ///这样的缺点是可能会浪费内存空间
            int len;
            while((len = is.read()) != -1){
                System.out.print((char)len); //字节数不够,出现乱码 可以用InputStreamReader转换流解决  也可以使用上面缓冲区处理解决
            }
        }catch(IOException e){

        }
    }
}
