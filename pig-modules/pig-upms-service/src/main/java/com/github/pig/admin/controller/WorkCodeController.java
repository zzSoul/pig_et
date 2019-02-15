package com.github.pig.admin.controller;
import java.util.*;

import com.github.pig.admin.common.util.CodeUtil;
import com.github.pig.admin.common.util.EncryptionUtil;
import com.github.pig.admin.model.dto.WorkCodeDTO;
import com.github.pig.admin.model.entity.AtcWorkCode;
import com.github.pig.common.util.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.github.pig.common.constant.CommonConstant;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.github.pig.common.util.Query;
import com.github.pig.common.util.R;
import com.github.pig.admin.service.AtcWorkCodeService;
import com.github.pig.common.web.BaseController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zzz
 * @since 2019-01-21
 */
@RestController
@RequestMapping("/workCode")
public class WorkCodeController extends BaseController {
    @Autowired private AtcWorkCodeService atcWorkCodeService;

    /**
    * 通过ID查询
    *
    * @param id ID
    * @return AtcWorkCode
    */
    @GetMapping("/{id}")
    public R<AtcWorkCode> get(@PathVariable Integer id) {
        return new R<>(atcWorkCodeService.selectById(id));
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
        return atcWorkCodeService.selectPage(new Query<>(params), new EntityWrapper<>());
    }

    /**
     * 添加
     * @param  atcWorkCode  实体
     * @return success/false
     */
    @PostMapping
    public R<Boolean> add(@RequestBody AtcWorkCode atcWorkCode) {
        return new R<>(atcWorkCodeService.insert(atcWorkCode));
    }

    /**
     * 删除
     * @param id ID
     * @return success/false
     */
    @DeleteMapping("/{id}")
    public R<Boolean> delete(@PathVariable Integer id) {
        AtcWorkCode atcWorkCode = new AtcWorkCode();
        atcWorkCode.setId(id);
        atcWorkCode.setUpdateTime(new Date());
        atcWorkCode.setDelFlag(CommonConstant.STATUS_DEL);
        return new R<>(atcWorkCodeService.updateById(atcWorkCode));
    }

    /**
     * 编辑
     * @param  atcWorkCode  实体
     * @return success/false
     */
    @PutMapping
    public R<Boolean> edit(@RequestBody AtcWorkCode atcWorkCode) {
        atcWorkCode.setUpdateTime(new Date());
        return new R<>(atcWorkCodeService.updateById(atcWorkCode));
    }


    @RequestMapping("/batchAddition")
    public R<Boolean> batchAddition(@RequestBody WorkCodeDTO workCode ){
//        获取操作人
        EncryptionUtil encryptionUtil = new EncryptionUtil();
        String user = UserUtils.getUser();
//        生成编码头
        String atcWorkCode = CodeUtil.generate();
        AtcWorkCode generateCode = new AtcWorkCode();
        generateCode.setVersionNumber(atcWorkCode);
        EntityWrapper<AtcWorkCode> entityWrapper = new EntityWrapper<>();
        entityWrapper.setEntity(generateCode);
//        校验是否重复
        int count = atcWorkCodeService.selectCount(entityWrapper);
        if (count != 0){
            return new R<>(false);
        }else{
            List<AtcWorkCode> workCodes = new ArrayList<>();
//            生成不重复6位随机数
            int[] randomArray = CodeUtil.randomArray(100000, 999999, workCode.getNumber());
            for (int i = 0; i < workCode.getNumber(); i++) {

                Date date = new Date();
                //拼接作品编码
                String oneWorkCode = atcWorkCode + randomArray[i];

                AtcWorkCode oneCode = new AtcWorkCode();
                oneCode.setWorkCode(oneWorkCode);

                String code = encryptionUtil.SHA256(oneWorkCode);
                oneCode.setEncryptedCoding(code);
                String newCode="t=2&c="+code+"&l="+(new Random().nextInt(90)+10)+"&z="+(new Random().nextInt(90)+10)+"&x="+(new Random().nextInt(90)+10)+"&w="+(new Random().nextInt(90)+10)+"&q="+(new Random().nextInt(90)+10) ;
                oneCode.setSuperChain(newCode);
                oneCode.setCodeStatus("0");
                oneCode.setCreater(user);
                oneCode.setDelFlag("0");
                oneCode.setCreateTime(date);
                oneCode.setVersionNumber(atcWorkCode);
                oneCode.setRemarks(workCode.getRemarks());

                workCodes.add(oneCode);
            }
            return new R<>(atcWorkCodeService.insertBatch(workCodes, workCode.getNumber()));
        }

    }

}
