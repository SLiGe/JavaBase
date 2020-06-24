package com.java.string;

import org.junit.Test;

import java.util.StringTokenizer;

/**
 * @author Gary
 * @since 2019/11/22 10:42
 */
public class StringSplit {

    @Test
    public void testSplit() {
        String orgStr = generateString();
        /*使用split进行测试,共花费 543ms */
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            orgStr.split(";");
        }
        System.out.printf("花费时间: %s", System.currentTimeMillis() - start);
    }

    @Test
    public void testStringToken() {
        String orgStr = generateString();
        /*使用StringTokenizer进行测试,花费时间: 492ms*/
        long start = System.currentTimeMillis();
        StringTokenizer st = new StringTokenizer(orgStr, ";");
        for (int i = 0; i < 10000; i++) {
            while (st.hasMoreTokens())
                st.nextToken();
            st = new StringTokenizer(orgStr, ";");
        }
        System.out.printf("花费时间: %s", System.currentTimeMillis() - start);
    }

    @Test
    public void testSubAndIndex() {
        String orgStr = generateString();
        /*使用indexOf和subString进行测试,花费时间: 9247ms*/
        long start = System.currentTimeMillis();
        String tmp = orgStr;
        for (int i = 0; i < 10000; i++) {
            while (true) {
                String splitStr = null;
                int j = tmp.indexOf(';'); //寻找分隔符
                if (j < 0) break;   //没有分隔符
                splitStr = tmp.substring(0, j); // 找到分隔符，截取子字符串
                tmp = tmp.substring(j + 1); //剩下需要处理的字符串
            }
            tmp = orgStr;
        }
        System.out.printf("花费时间: %s", System.currentTimeMillis() - start);
    }

    @Test
    public void testCharAt() {
        String orgStr = generateString();
        int len = orgStr.length();
        //判断是否以abc开头
        if (orgStr.charAt(0) == 'a' && orgStr.charAt(0) == 'b' && orgStr.charAt(0) == 'c')
            System.out.println("以abc开头");
        //判断是否以abc结尾
        if (orgStr.charAt(len - 1) == 'a' && orgStr.charAt(len - 2) == 'b' && orgStr.charAt(len - 3) == 'c')
            System.out.println("以abc结尾");
        //String的原生方法
        boolean startsWithAbc = orgStr.startsWith("abc");
        boolean endsWithAbc = orgStr.endsWith("abd");
        System.out.println(startsWithAbc + "" + endsWithAbc);
    }

    /**
     * String a = "a" + "b" +"c";
     * 以上代码，会编译成String a = "abc"; 编译器会作优化
     */
    @Test
    public void testConcat() {
        //使用+拼接字符串 花费时间:536ms
        long startForPlus = System.currentTimeMillis();
        String str = "";
        for (int i = 0; i < 10000; i++) {
            /*
             * StringBuilder默认容量为16字节
             * 编译结果: str = (new StringBuilder(String.valueOf(str))).append(i).toString();
             * */
            str = str + i;
        }
        System.out.printf("plus -> 花费时间: %s ms \n", System.currentTimeMillis() - startForPlus);
        //使用concat方法 花费时间: 105 ms
        long startForConcat = System.currentTimeMillis();
        String result = "";
        for (int i = 0; i < 10000; i++) {
            result = result.concat(String.valueOf(i));
        }
        System.out.printf("concat -> 花费时间: %s ms \n", System.currentTimeMillis() - startForConcat);
        //使用StringBuilder 花费时间: 1 ms
        long startForStringBuilder = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            sb.append(i);
        }
        System.out.printf("StringBuilder -> 花费时间: %s ms", System.currentTimeMillis() - startForStringBuilder);
    }

    private String generateString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            sb.append(i);
            sb.append(";");
        }
        return sb.toString();
    }
}
