/**
 * Copyright (C), 2016-2019, XXX有限公司
 * FileName: NfcCodeVO
 * Author:   soul
 * Date:     2019/1/10 18:29
 * Description: 搜索实体
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.github.pig.admin.model.vo;

import com.baomidou.mybatisplus.annotations.TableField;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 〈一句话功能简述〉<br> 
 * 〈搜索实体〉
 *
 * @author soul
 * @create 2019/1/10
 * @since 1.0.0
 */

@Data
public class NfcCodeVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    /**
     * 加密编码
     */
    private String encryptedCoding;
    /**
     * 版本号
     */
    private String versionNumber;
    /**
     * 超链
     */
    private String superChain;
    /**
     * 编码状态
     */
    private String codeStatus;
    /**
     * 创建时间
     */
    private Date creationTime;
    /**
     * 创建人
     */
    private String creater;
    /**
     * 修改时间
     */
    private Date updateTime;
    /**
     * 修改人
     */
    private String modifier;
    /**
     * 删除标识
     */
    private String delFlag;
}
