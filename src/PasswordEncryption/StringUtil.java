package PasswordEncryption;

import java.util.Base64;

class StringUtil {
    private static final String SALT = "mldnjava" ; //公共的盐值
    private static final int REPEAT = 5 ; //加密次数
    /**
    *加密处理
    * @param str 要加密的字符串，需要与盐值整合
    * @param repeat 加密的重复次数
    * @return 加密后的数据
    */
    public static String encode(String str) { // 加密处理
        String temp = str + "{" + SALT + "}"; //盐值对外不公布
        byte data [] = temp. getBytes() ; //将字符串变为字节数组
        for(int x = 0;x < REPEAT; x++){
            data = Base64. getEncoder().encode(data) ; //重复加密
        }
        return new String(data) ;
    }
    /**
    *进行解密处理
    * @param str要解密的内容
    * @return 解密后的原始数据
    */
    public static String decode(String str) {
        byte data[] = str.getBytes();
        for(int x = 0; x < REPEAT; x++){
            data = Base64.getDecoder().decode(data);
        }
        return new String(data) ;
    }
    public static void main(String[ ] args) throws Exception {
        String str = StringUtil.encode("www. mldn.cn") ;
        String str1 = StringUtil.decode(str);
        System.out.println(str1);
    }
}