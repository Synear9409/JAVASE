package JavaIO.FileDir;

import java.io.File;

public class FileShowAll {

    public static void pringName(File src,int deep){
        for(int i = 0 ;i < deep;i++){
            System.out.print("-");
        }
        System.out.println(src.getName());
        if(null == src || !src.exists()){
            return;
        }else if(src.isDirectory()){
            for(File f : src.listFiles()){
                pringName(f, deep+1);
            }
        }
    }


    public static void main(String[] args) {
        File file = new File("E:/Users/Shinelon/IdeaProjects/Catch");
        pringName(file, 0);
    }
}