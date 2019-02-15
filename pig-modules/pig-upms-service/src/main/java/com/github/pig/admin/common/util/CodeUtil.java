/**
 * Copyright (C), 2016-2018, XXX有限公司
 * FileName: CodeUtil
 * Author:   soul
 * Date:     2018/12/26 11:36
 * Description: 作品编码头生成
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.github.pig.admin.common.util;

import java.util.Random;
import java.util.regex.Pattern;

/**
 * 〈一句话功能简述〉<br> 
 * 〈作品编码头生成〉
 *
 * @author soul
 * @create 2018/12/26
 * @since 1.0.0
 */
public class CodeUtil {
    public static String generate() {
        char[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
                'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
                'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        char[] lettersNoNum = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
                'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
                'W', 'X', 'Y', 'Z'};
        char[] lettersNum = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

        char[] chs = new char[3];
        int num = 0;
        int ch = 0;
        for (int i = 0; i < chs.length; i++) {
            if (ch == 1) {
                int indexNum;
                indexNum = (int) (Math.random() * (lettersNum.length));
                chs[i] = lettersNum[indexNum];
            } else if (num == 2 && ch == 0) {
                int indexNoNum;
                indexNoNum = (int) (Math.random() * (lettersNoNum.length));
                chs[i] = lettersNoNum[indexNoNum];
            } else {

                int index;
                index = (int) (Math.random() * (letters.length));
                chs[i] = letters[index];
                String isNum = String.valueOf(chs[i]);
//	        判断获取字符是不是数字
                if (isInteger(isNum)) {
                    num++;
                } else {
                    ch++;
                }
            }
        }
//	    获取首字母
        int indexOne = (int) (Math.random() * (lettersNoNum.length));
        String a = String.valueOf(lettersNoNum[indexOne]);
        char b = chs[0];
        char c = chs[1];
        char d = chs[2];
        String finalString = a + b + c + d;
        return finalString;
    }

    private static final Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");

    public static boolean isInteger(String str) {
//        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }
    /**
     * 随机指定范围内N个不重复的数
     * 在初始化的无重复待选数组中随机产生一个数放入结果中，
     * 将待选数组被随机到的数，用待选数组(len-1)下标对应的数替换
     * 然后从len-2里随机产生下一个随机数，如此类推
     * @param max  指定范围最大值
     * @param min  指定范围最小值
     * @param n  随机数个数
     * @return int[] 随机数结果集
     */
    public static int[] randomArray(int min,int max,int n){
        int len = max-min+1;

        if(max < min || n > len){
            return null;
        }

        //初始化给定范围的待选数组
        int[] source = new int[len];
        for (int i = min; i < min+len; i++){
            source[i-min] = i;
        }

        int[] result = new int[n];
        Random rd = new Random();
        int index = 0;
        for (int i = 0; i < result.length; i++) {
            //待选数组0到(len-2)随机一个下标
            index = Math.abs(rd.nextInt() % len--);
            //将随机到的数放入结果集
            result[i] = source[index];
            //将待选数组中被随机到的数，用待选数组(len-1)下标对应的数替换
            source[index] = source[len];
        }
        return result;
    }
//    public  String getWorkCode(int type) {
//        String artist = "ART";//  0
//        String collector = "COL";// 1
//        String mechanism = "MEC";// 2
//
//        return "";
//    }

}