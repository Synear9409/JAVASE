package JavaIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;


public class TestCopyFile2 {
    public static void main(String[] args) throws Exception {
        long start = System. currentTimeMillis() ;
        File srcFile = new File("D:" + File.separator + "hello");
        File desFile = new File("D:" + File.separator + "hi");
        FileUtil2 fu = new FileUtil2(srcFile,desFile);
        if(srcFile.isFile()){
            System.out.println(fu.copy() ? "文件拷贝成功! ":"文件拷贝失败! ");
        }else{
            System.out.println(fu.copyDir() ? "目录拷贝成功! ":"目录拷贝失败! ");
        }
        long end = System.currentTimeMillis() ;
        System.out.println("拷贝完成的时间:"+ (end - start));  
    }
}

class FileUtil2{
    private File srcFile ; //源文件路径
    private File desFile ; //目标文件路径
    public FileUtil2(File srcFile,File desFile) {
        this.srcFile = srcFile ;
        this.desFile = desFile ;
    }

    ////拷贝文件
    public boolean copy() throws Exception{
        if(!this.srcFile.exists()){
            System.out.println("拷贝的源文件不存在");
            return false;
        }
        return this.copyFileImpl(this.srcFile, this.desFile);
    }

    ////拷贝目录及其内部的文件
    public boolean copyDir() throws Exception {
        try{
            this.copyImpl(this.srcFile);
            return true ;
        }catch(Exception e){
            return false;
        }
    }


    private void copyImpl(File file) throws Exception{
        if(file.isDirectory()){   ///是目录
            File results[] = file.listFiles();  ///列出该层目录下的所有文件
            if(results != null){
                for(File f : results){
                    copyImpl(f);   ///递归遍历
                }
            } 
        }else{              ////是文件
            ////把D:\hello\copy.txt 的“D:\hello\” 替换为""
            String newFilePath = file.getPath().replace(this.srcFile.getPath() + File.separator, ""); ///格式化遍历出文件的路径
            File newFile = new File(this.desFile, newFilePath);    //拷贝的目标路径   拼接新路径 "D:\hi\copy.txt"
            this.copyFileImpl(file, newFile);
        }
    }

    /**
     * 常规文件拷贝
     * @param srcFile
     * @param desFile
     * @return
     * @throws Exception
     */
    private boolean copyFileImpl(File srcFile,File desFile) throws Exception {
        if(!desFile.getParentFile().exists()){   ///getParentFile()返回上层目录
            desFile.getParentFile().mkdirs();  ///创建父目录
        }
        InputStream input = null;
        OutputStream output = null;
        byte[] data = new byte[1024];
        int len = 0;
        try{
            input = new FileInputStream(srcFile);
            output = new FileOutputStream(desFile);
            while((len = input.read(data)) != -1){
                output.write(data,0,len);
            }
            /* input.transferTo(output);   ///转存的方式 */
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
