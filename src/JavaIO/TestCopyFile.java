package JavaIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class TestCopyFile {
    public static void main(String[] args) throws Exception {
            long start = System. currentTimeMillis() ;
            File srcFile = new File("D:" + File.separator + "hello" + File. separator + "reverse.txt");
            File desFile = new File("D:" + File.separator + "hello" + File. separator + "copy.txt");
            FileUtil fu = new FileUtil(srcFile,desFile) ;
            System. out. println(fu.copy() ? "文件拷贝成功! ":"文件拷贝失败! ");
            long end = System. currentTimeMillis() ;
            System.out.println("拷贝完成的时间:"+ (end - start));
    }
}

class FileUtil{
    private File srcFile ; //源文件路径
    private File desFile ; //目标文件路径
    public FileUtil(File srcFile,File desFile) {
        this.srcFile = srcFile ;
        this.desFile = desFile ;
    }
    public boolean copy() throws Exception{
        if(!this.srcFile.exists()){
            System.out.println("拷贝的源文件不存在");
            return false;
        }
        if(!this.desFile.getParentFile().exists()){   ///getParentFile()返回上层目录
            this.desFile.getParentFile().mkdirs();  ///创建父目录
        }
        byte data[] = new byte[1024];
        InputStream input = null;
        OutputStream output = null;
        try{
            input = new FileInputStream(this.srcFile);
            output = new FileOutputStream(this.desFile);
            int len = 0;
            while((len = input.read(data)) != -1){
                output.write(data, 0, len);
            }
            return true;
        }catch(Exception e){
            throw e;
        }finally{
            if(input != null){
                input.close();
            }
            if(output != null){
                output.close();
            }
        }
    }
}