package JavaIO.SplitStream;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

/**
 * 面向对象思想 io流分割文件
 */
public class splitTest {

    /// 源文件
    private File src;
    /// 目的地(文件夹)
    private String destDir;
    /// 所分割的文件存储地址
    private List<String> destPaths;
    // 每一块大小
    private int blockSize;
    /// 分成多少块
    private int size;

    public splitTest(String srcPath, String destDir, int blockSize) {
        this.src = new File(srcPath);
        this.destDir = destDir;
        this.blockSize = blockSize;

        /// 初始化
        init();
    }

    /// 初始化
    private void init() {
        // 总长度
        long len = this.src.length();
        /// 多少块
        this.size = (int) Math.ceil(len / blockSize);
        /// 每一块的路径
        this.destPaths = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            this.destPaths.add(this.destDir + "/" + i + this.src.getName());
        }
    }

    /**
     * 分割 1、计算每一块的起始位置及大小 2、分割
     *
     * @throws IOException
     */
    public void split() throws IOException {
        long len = src.length();
        // 其实位置及实际大小
        int beginIndex = 0;
        /// 即 每次切多少
        int actualSize = blockSize > len ? (int) len : blockSize;
        for (int i = 0; i < size; i++) {
            beginIndex = i * blockSize;
            if (i == size - 1) {
                actualSize = (int) len;
            } else {
                actualSize = blockSize;
                len -= actualSize; /// 剩余量
            }
            System.out.println(i + "---->" + beginIndex + "--->" + actualSize);
            splitDetail(i,beginIndex,actualSize);
        }
    }

    /**
     * 具体io分割实现
     *
     * @throws IOException
     */
    private void splitDetail(int i, int beginIndex, int actualSize) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(this.src,"r");
        RandomAccessFile raf2 = new RandomAccessFile(this.destPaths.get(i), "rw");

        ///随机读取
        raf.seek(beginIndex);
        //操作
        byte[] flush = new byte[1024];  ///缓冲区
        int len;
        while((len = raf.read(flush)) != -1){
            if(actualSize > len){
                raf2.write(flush, 0, len);
                actualSize -= len;
            }else{
                raf2.write(flush, 0, actualSize);
                break;
            }
        }
        raf2.close();
        raf.close();
    }

    public static void main(String[] args) throws IOException {
        splitTest st = new splitTest("D:/splitTest.java","D:/dest",1024);
        st.split();
    }
}
