package Nowcoder.tencent;

import java.util.Scanner;

/**
 * 压缩算法
 * 小Q想要给他的朋友发送一个神秘字符串，但是他发现字符串的过于长了，
 * 于是小Q发明了一种压缩算法对字符串中重复的部分进行了压缩，
 * 对于字符串中连续的m个相同字符串S将会压缩为[m|S](m为一个整数且1<=m<=100)，
 * 例如字符串ABCABCABC将会被压缩为[3|ABC]，现在小Q的同学收到了小Q发送过来的字符串，你能帮助他进行解压缩么？
 *
 * 例子：
 * 输入第一行包含一个字符串s，代表压缩后的字符串。
 * S的长度<=1000;
 * S仅包含大写字母、[、]、|;
 * 解压后的字符串长度不超过100000;
 * 压缩递归层数不超过10层;
 *
 * 输出一个字符串，代表解压后的字符串。
 *
 * 输入
 * HG[3|B[2|CA]]F
 *
 * 输出（解压缩）
 * HGBCACABCACABCACAF
 *
 * 例子说明：
 * HG[3|B[2|CA]]F−>HG[3|BCACA]F−>HGBCACABCACABCACAF
 */
public class practice1 {
    private static Scanner scanner = new Scanner(System.in);

    ///思路：寻找最中间的那对“[]”,从那开始处理，借助contains() 匹配 "]"
    public static String decode(String words) {
        while (words.contains("]")) {
            int right = words.indexOf("]");
            int left = words.lastIndexOf("[");
            String repeatStr = words.substring(left + 1, right);  //2|CA
            String[] split = repeatStr.split("\\|");
            StringBuffer buffer = new StringBuffer();
            for(int i = 0 ;i < Integer.parseInt(split[0]);i++ ){
                buffer.append(split[1]);
            }
//            words = words.replace("[" + repeatStr + "]",
//                    String.join("", Collections.nCopies(Integer.parseInt(split[0]), split[1])));
            words = words.replace("["+repeatStr+"]",buffer);
        }
        return words;
    }
    public static void main(String[] args) {
        String words = scanner.nextLine();
        System.out.println(decode(words));
    }
}
