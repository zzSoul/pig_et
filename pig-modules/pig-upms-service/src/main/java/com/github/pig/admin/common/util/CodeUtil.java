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

        char[] letters = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
                'K', 'L', 'M', 'N', 'O', 'P','Q', 'R', 'S', 'T', 'U', 'V',
                'W', 'X', 'Y', 'Z','0','1','2','3','4','5','6','7','8','9'};
        char[] lettersNoNum = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
                'K', 'L', 'M', 'N', 'O', 'P','Q', 'R', 'S', 'T', 'U', 'V',
                'W', 'X', 'Y', 'Z'};
        boolean[] flags = new boolean[letters.length];
        char[] chs = new char[3];
        int isNum=0;
        int isChar=0;
        for (int i = 0; i < chs.length; i++) {
            int index;
            int indexNoNum;
            do {
                index = (int) (Math.random() * (letters.length));
                indexNoNum = (int) (Math.random() * (lettersNoNum.length));
                // 判断生成的字符是否重复
            } while (flags[index]);
            chs[i] = letters[index];
//	        flags[index] = true;
        }
        int indexOne = (int) (Math.random() * (lettersNoNum.length));
//	    获取首字母
        String a =String.valueOf(lettersNoNum[indexOne]);
        char b = chs[0];
        char c = chs[1];
        char d = chs[2];
        String finalString=a+b+c+d;
        return finalString;
    }
/**
 * 是否为数字
 */
//    public static boolean isInteger(String str) {
//        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
//        return pattern.matcher(str).matches();
//    }
}
