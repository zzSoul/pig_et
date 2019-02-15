/**
 * Copyright (C), 2016-2019, XXX有限公司
 * FileName: WorkCodeDTO
 * Author:   soul
 * Date:     2019/1/23 17:35
 * Description: 作品码前端实体类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.github.pig.admin.model.dto;

import com.github.pig.admin.model.entity.AtcWorkCode;
import lombok.Data;

/**
 * 〈一句话功能简述〉<br> 
 * 〈作品码前端实体类〉
 *
 * @author soul
 * @create 2019/1/23
 * @since 1.0.0
 */
@Data
public class WorkCodeDTO extends AtcWorkCode {
    /**
     * 批量生成数量
     */
    private Integer number;
}
