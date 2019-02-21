package com.github.pig.admin.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.github.pig.admin.mapper.NfcCodeMapper;
import com.github.pig.admin.model.entity.NfcCode;
import com.github.pig.admin.model.vo.NfcCodeVO;
import com.github.pig.admin.service.NfcCodeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.pig.common.util.Query;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zzz
 * @since 2018-12-25
 */
@Slf4j
@Service
@AllArgsConstructor
public class NfcCodeServiceImpl extends ServiceImpl<NfcCodeMapper, NfcCode> implements NfcCodeService {

    private final NfcCodeMapper nfcCodeMapper;

    @Override
    public Page pageSelect(Query query, NfcCodeVO nfcCode){
//        NfcCode nfcCode = new NfcCode();
//        String encryptedCoding = (String) query.getCondition().get("encryptedCoding");
//        nfcCode.setEncryptedCoding(encryptedCoding);
//        Object encrypted_coding = query.getCondition().get("encrypted_coding");
        query.setRecords(nfcCodeMapper.pageSelect(query,nfcCode));
        return query;
    }
   /* public Page pageSelect(Query query, NfcCode nfcCode){
//        NfcCode nfcCode = new NfcCode();
//        String encryptedCoding = (String) query.getCondition().get("encryptedCoding");
//        nfcCode.setEncryptedCoding(encryptedCoding);
        //query.getCondition().get("username");
        query.setRecords(nfcCodeMapper.pageSelect(query,nfcCode));
        return query;
    }*/
}
