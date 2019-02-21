package com.github.pig.admin.controller;
import java.util.Map;
import java.util.Date;

import com.github.pig.admin.model.entity.AtcUserInfo;
import com.github.pig.admin.service.IAtcUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.github.pig.common.constant.CommonConstant;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.github.pig.common.util.Query;
import com.github.pig.common.util.R;
import com.github.pig.common.web.BaseController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zzz
 * @since 2019-02-21
 */
@RestController
@RequestMapping("/atcUserInfo")
public class AtcUserInfoController extends BaseController {
    @Autowired private IAtcUserInfoService atcUserInfoService;

    /**
    * 通过ID查询
    *
    * @param id ID
    * @return AtcUserInfo
    */
    @GetMapping("/{id}")
    public R<AtcUserInfo> get(@PathVariable Integer id) {
        return new R<>(atcUserInfoService.selectById(id));
    }


    /**
    * 分页查询信息
    *
    * @param params 分页对象
    * @return 分页对象
    */
    @RequestMapping("/page")
    public Page page(@RequestParam Map<String, Object> params) {
        params.put(CommonConstant.DEL_FLAG, CommonConstant.STATUS_NORMAL);
        return atcUserInfoService.selectPage(new Query<>(params), new EntityWrapper<>());
    }

    /**
     * 添加
     * @param  atcUserInfo  实体
     * @return success/false
     */
    @PostMapping
    public R<Boolean> add(@RequestBody AtcUserInfo atcUserInfo) {
        return new R<>(atcUserInfoService.insert(atcUserInfo));
    }

    /**
     * 删除
     * @param id ID
     * @return success/false
     */
    @DeleteMapping("/{id}")
    public R<Boolean> delete(@PathVariable Integer id) {
        AtcUserInfo atcUserInfo = new AtcUserInfo();
        atcUserInfo.setId(id);
        atcUserInfo.setUpdateTime(new Date());
        atcUserInfo.setDelFlag(CommonConstant.STATUS_DEL);
        return new R<>(atcUserInfoService.updateById(atcUserInfo));
    }

    /**
     * 编辑
     * @param  atcUserInfo  实体
     * @return success/false
     */
    @PutMapping
    public R<Boolean> edit(@RequestBody AtcUserInfo atcUserInfo) {
        atcUserInfo.setUpdateTime(new Date());
        return new R<>(atcUserInfoService.updateById(atcUserInfo));
    }
}
