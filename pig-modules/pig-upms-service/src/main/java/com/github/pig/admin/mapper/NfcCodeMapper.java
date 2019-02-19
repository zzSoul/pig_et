package com.github.pig.admin.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.github.pig.admin.model.entity.NfcCode;
import com.github.pig.common.util.Query;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zzz
 * @since 2018-12-25
 */
public interface NfcCodeMapper extends BaseMapper<NfcCode> {
    List pageSelect(Query query, @Param("nfcCode") NfcCode nfcCode);
}
