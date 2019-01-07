/**
 * Copyright (C), 2016-2018, XXX有限公司
 * FileName: CodeController
 * Author:   soul
 * Date:     2018/12/24 10:46
 * Description: 二维码生成
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.github.atc.backstage.controller;

import com.github.pig.common.vo.UserVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈一句话功能简述〉<br> 
 * 〈二维码生成〉
 *
 * @author soul
 * @create 2018/12/24
 * @since 1.0.0
 */
@RestController
public class CodeController {

    @GetMapping("/user")
    public UserVO demo(UserVO userVO){
        System.out.print("1");

        return userVO;
    }

}
