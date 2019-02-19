package com.github.pig.admin.controller;
import java.util.*;

import com.github.pig.admin.common.util.EncryptionUtil;
import com.github.pig.admin.model.dto.NfcCodeDTO;
import com.github.pig.admin.model.entity.NfcCode;
import com.github.pig.admin.service.NfcCodeService;
import com.github.pig.common.util.UserUtils;
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
 * @since 2018-12-25
 */
@RestController
@RequestMapping("/nfcCode")
public class NfcCodeController extends BaseController {
    @Autowired private NfcCodeService nfcCodeService;

    /**
    * 通过ID查询
    *
    * @param id ID
    * @return nfcCode
    */
    @GetMapping("/{id}")
    public R<NfcCode> get(@PathVariable Integer id) {
        return new R<>(nfcCodeService.selectById(id));
    }


    /**
    * 分页查询信息
    *
    * @param params 分页对象
    * @return 分页对象
    */
    /*@RequestMapping("/page")
    public Page page(@RequestParam Map<String, Object> params) {
        params.put(CommonConstant.DEL_FLAG, CommonConstant.STATUS_NORMAL);
//        return nfcCodeService.selectPage(new Query<>(params), new EntityWrapper<>());
        String encryptedCoding = (String) params.get("encryptedCoding");
        if ("".equals(encryptedCoding)){
            params.put("encrypted_coding",encryptedCoding);
            params.remove("encryptedCoding");
        }
        return nfcCodeService.selectPage(new Query<>(params), new EntityWrapper<NfcCode>());
    }*/

    @RequestMapping("/page")
    public Page page(@RequestParam Map<String, Object> params,NfcCode nfcCode) {
        params.put(CommonConstant.DEL_FLAG, CommonConstant.STATUS_NORMAL);
        return nfcCodeService.pageSelect(new Query<>(params), nfcCode);
    }

    /**
     * 添加
     * @param  nfcCode  实体
     * @return success/false
     */
    @PostMapping
    public R<Boolean> add(@RequestBody NfcCode nfcCode) {
        nfcCode.setDelFlag(CommonConstant.STATUS_NORMAL);
        nfcCode.setCreationTime(new Date());
        String user = UserUtils.getUser();
        nfcCode.setCreater(user);
        return new R<>(nfcCodeService.insert(nfcCode));
    }

    /**
     * 删除
     * @param id ID
     * @return success/false
     */
    @DeleteMapping("/{id}")
    public R<Boolean> delete(@PathVariable Integer id) {
        NfcCode nfcCode = new NfcCode();
        nfcCode.setId(id);
        nfcCode.setUpdateTime(new Date());
        nfcCode.setDelFlag(CommonConstant.STATUS_DEL);
        return new R<>(nfcCodeService.updateById(nfcCode));
    }

    /**
     * 编辑
     * @param  nfcCode  实体
     * @return success/false
     */
    @PutMapping
    public R<Boolean> edit(@RequestBody NfcCode nfcCode) {
        String user = UserUtils.getUser();
        nfcCode.setModifier(user);
        nfcCode.setUpdateTime(new Date());
        return new R<>(nfcCodeService.updateById(nfcCode));
    }

    public List<NfcCode> conditionalQuery(@RequestBody NfcCode query) {
        EntityWrapper<NfcCode> wrapper = new EntityWrapper<>();
        wrapper.setEntity(query);
        return nfcCodeService.selectList(wrapper);
    }

    @RequestMapping("/queryPage")
    public Page pageQuery(@RequestParam Map<String, Object> params,@RequestBody NfcCode nfcCode){
        params.put(CommonConstant.DEL_FLAG, CommonConstant.STATUS_NORMAL);
        EntityWrapper<NfcCode> query = new EntityWrapper<>();
        query.setEntity(nfcCode);
        return nfcCodeService.selectPage(new Query<>(params),query );
    }
    /**
     * 批量生成nfc码
     * @param nfcCode
     * @return success/false
     */
    @RequestMapping("/batchAddition")
    public R<Boolean> batchAddition(@RequestBody NfcCodeDTO nfcCode ){
        EncryptionUtil encryptionUtil = new EncryptionUtil();
        String user = UserUtils.getUser();
        List<NfcCode> nfcCodes = new ArrayList<>();
        for (int i = 0; i < nfcCode.getNumber(); i++) {

            UUID uuid = UUID.randomUUID();
            Date date = new Date();
            Long time = date.getTime();
            String originalCode =time.toString()+uuid.toString();
            String code = encryptionUtil.SHA256(originalCode);
            NfcCode oneCode = new NfcCode();
            oneCode.setEncryptedCoding(code);
            String newCode="t=2&c="+code+"&l="+(new Random().nextInt(90)+10)+"&z="+(new Random().nextInt(90)+10)+"&x="+(new Random().nextInt(90)+10)+"&w="+(new Random().nextInt(90)+10)+"&q="+(new Random().nextInt(90)+10) ;
            oneCode.setSuperChain(newCode);
            oneCode.setCodeStatus("0");
            oneCode.setCreater(user);
            oneCode.setDelFlag("0");
            oneCode.setCreationTime(date);
            oneCode.setVersionNumber(nfcCode.getVersionNumber());
            oneCode.setRemarks(nfcCode.getRemarks());

            nfcCodes.add(oneCode);
        }

        return new R<>(nfcCodeService.insertBatch(nfcCodes, nfcCode.getNumber()));
    }
}
