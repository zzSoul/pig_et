/**
 * Copyright (C), 2016-2018, XXX有限公司
 * FileName: EncryptionUtil
 * Author:   soul
 * Date:     2018/12/26 11:46
 * Description: sha256加密
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.github.pig.admin.common.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 〈一句话功能简述〉<br> 
 * 〈sha256加密〉
 *
 * @author soul
 * @create 2018/12/26
 * @since 1.0.0
 */
public class EncryptionUtil {



        /**
         * 传入文本内容，返回 SHA-256 串
         *
         * @param strText
         * @return
         */
        public String SHA256(final String strText)
        {
            return SHA(strText, "SHA-256");
        }

        /**
         * 传入文本内容，返回 SHA-512 串
         *
         * @param strText
         * @return
         */
        public  String SHA512(final String strText)
        {
            return SHA(strText, "SHA-512");
        }

        /**
         * 字符串 SHA 加密
         *
         * @param strText
         * @return
         */
        private String SHA(final String strText, final String strType)
        {
            // 返回值
            String strResult = null;

            // 是否是有效字符串
            if (strText != null && strText.length() > 0)
            {
                try
                {
                    // SHA 加密开始
                    // 创建加密对象 并傳入加密類型
                    MessageDigest messageDigest = MessageDigest.getInstance(strType);
                    // 传入要加密的字符串
                    messageDigest.update(strText.getBytes());
                    // 得到 byte 類型结果
                    byte byteBuffer[] = messageDigest.digest();

                    // 將 byte 轉換爲 string
                    StringBuffer strHexString = new StringBuffer();
                    // 遍歷 byte buffer
                    for (int i = 0; i < byteBuffer.length; i++)
                    {
                        String hex = Integer.toHexString(0xff & byteBuffer[i]);
                        if (hex.length() == 1)
                        {
                            strHexString.append('0');
                        }
                        strHexString.append(hex);
                    }
                    // 得到返回結果
                    strResult = strHexString.toString();
                }
                catch (NoSuchAlgorithmException e)
                {
                    e.printStackTrace();
                }
            }

            return strResult;
        }
    }
