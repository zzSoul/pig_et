package com.github.pig.admin.model.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author zzz
 * @since 2019-01-21
 */
@TableName("atc_work_code")
public class AtcWorkCode extends Model<AtcWorkCode> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 作品编码
     */
    @TableField("work_code")
    private String workCode;
    /**
     * sha256加密后编码
     */
    @TableField("encrypted_coding")
    private String encryptedCoding;
    /**
     * 编码状态
     */
    @TableField("code_status")
    private String codeStatus;
    /**
     * 版本号
     */
    @TableField("version_number")
    private String versionNumber;
    /**
     * 超链
     */
    @TableField("super_chain")
    private String superChain;
    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;
    /**
     * 创建人
     */
    private String creater;
    /**
     * 备注
     */
    private String remarks;
    /**
     * 修改时间
     */
    @TableField("update_time")
    private Date updateTime;
    /**
     * 删除标识
     */
    @TableField("del_flag")
    private String delFlag;
    /**
     * 修改人
     */
    private String modifier;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWorkCode() {
        return workCode;
    }

    public void setWorkCode(String workCode) {
        this.workCode = workCode;
    }

    public String getEncryptedCoding() {
        return encryptedCoding;
    }

    public void setEncryptedCoding(String encryptedCoding) {
        this.encryptedCoding = encryptedCoding;
    }

    public String getCodeStatus() {
        return codeStatus;
    }

    public void setCodeStatus(String codeStatus) {
        this.codeStatus = codeStatus;
    }

    public String getVersionNumber() {
        return versionNumber;
    }

    public void setVersionNumber(String versionNumber) {
        this.versionNumber = versionNumber;
    }

    public String getSuperChain() {
        return superChain;
    }

    public void setSuperChain(String superChain) {
        this.superChain = superChain;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "AtcWorkCode{" +
        ", id=" + id +
        ", workCode=" + workCode +
        ", encryptedCoding=" + encryptedCoding +
        ", codeStatus=" + codeStatus +
        ", versionNumber=" + versionNumber +
        ", superChain=" + superChain +
        ", createTime=" + createTime +
        ", creater=" + creater +
        ", remarks=" + remarks +
        ", updateTime=" + updateTime +
        ", delFlag=" + delFlag +
        ", modifier=" + modifier +
        "}";
    }
}
