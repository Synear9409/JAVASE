package JavaIO.FileDir;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyFileAndDir {
    private File srcFile ; //源文件路径
    private File desFile ; //目标文件路径

    public CopyFileAndDir(File srcFile,File desFile) {
        this.srcFile = srcFile ;
        this.desFile = desFile ;
    }

    public CopyFileAndDir(){}

    public void CopyDir(File file){
        if(file.isDirectory()){
            File[] res = file.listFiles();
            if(res != null){
                for(File f : res){
                    CopyDir(f);
                }
            }
        }else{
            String newPath = file.getPath().replace(this.srcFile.getParent() + File.separator, "");
            File newFile = new File(this.desFile,newPath);
            this.CopyFile(file,newFile);
        }
    }



    public void CopyFile(File srcFile,File desFile){
        if(!desFile.getParentFile().exists()){   ///getParentFile()返回上层目录
            desFile.getParentFile().mkdirs();  ///创建父目录
        }
        InputStream input = null;
        OutputStream output = null;
        byte[] data = new byte[1024];
        int len = 0;
        try{
            input = new BufferedInputStream(new FileInputStream(srcFile));   ///加入缓冲流 提高性能
            output = new BufferedOutputStream(new FileOutputStream(desFile));
            while((len = input.read(data)) != -1){
                output.write(data,0,len);
            }
        }catch(Exception e){
            e.printStackTrace();;
        }finally{

            if(output != null){
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(input != null){
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(final String[] args) {
        long start = System. currentTimeMillis() ;
        File srcFile = new File("D:" + File.separator + "hello/p3.mp4");
        File desFile = new File("D:" + File.separator + "hi/p.mp4");
        CopyFileAndDir fu = new CopyFileAndDir(srcFile,desFile);
        fu.CopyFile(srcFile,desFile);
        long end = System.currentTimeMillis() ;
        System.out.println("拷贝完成的时间:"+ (end - start));  
    }
}