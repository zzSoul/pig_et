/**
 * Copyright (C), 2016-2019, XXX有限公司
 * FileName: NfcCodeDTO
 * Author:   soul
 * Date:     2019/1/8 10:52
 * Description: nfc编码
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.github.pig.admin.model.dto;

import com.github.pig.admin.model.entity.NfcCode;

/**
 * 〈一句话功能简述〉<br> 
 * 〈nfc编码〉
 *
 * @author soul
 * @create 2019/1/8
 * @since 1.0.0
 */
public class NfcCodeDTO extends NfcCode {
    /**
     * 批量生成数量
     */
    private Integer number;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
