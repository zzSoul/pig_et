package com.github.pig.admin.service;

import com.baomidou.mybatisplus.service.IService;
import com.github.pig.admin.model.entity.NfcCode;
import com.github.pig.admin.model.vo.NfcCodeVO;
import com.github.pig.common.util.Query;
import com.baomidou.mybatisplus.plugins.Page;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zzz
 * @since 2018-12-25
 */
public interface NfcCodeService extends IService<NfcCode> {
    Page pageSelect(Query query, NfcCodeVO nfcCode);
}
