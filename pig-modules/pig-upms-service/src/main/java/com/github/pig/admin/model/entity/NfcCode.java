package com.github.pig.admin.model.entity;

import java.util.Date;
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
 * @since 2018-12-25
 */
@TableName("atc_nfc_code")
public class NfcCode extends Model<NfcCode> {

    private static final long serialVersionUID = 1L;

    private Integer id;
    /**
     * 加密编码
     */
    @TableField("encrypted_coding")
    private String encryptedCoding;
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
     * 编码状态
     */
    @TableField("code_status")
    private String codeStatus;
    /**
     * 创建时间
     */
    @TableField("creation_time")
    private Date creationTime;
    /**
     * 创建人
     */
    private String creater;
    /**
     * 修改时间
     */
    @TableField("update_time")
    private Date updateTime;
    /**
     * 修改人
     */
    private String modifier;
    /**
     * 删除标识
     */
    @TableField("del_flag")
    private String delFlag;
    @TableField("alternate_field1")
    private String alternateField1;
    @TableField("alternate_field2")
    private String alternateField2;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEncryptedCoding() {
        return encryptedCoding;
    }

    public void setEncryptedCoding(String encryptedCoding) {
        this.encryptedCoding = encryptedCoding;
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

    public String getCodeStatus() {
        return codeStatus;
    }

    public void setCodeStatus(String codeStatus) {
        this.codeStatus = codeStatus;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getAlternateField1() {
        return alternateField1;
    }

    public void setAlternateField1(String alternateField1) {
        this.alternateField1 = alternateField1;
    }

    public String getAlternateField2() {
        return alternateField2;
    }

    public void setAlternateField2(String alternateField2) {
        this.alternateField2 = alternateField2;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "NfcCode{" +
        ", id=" + id +
        ", encryptedCoding=" + encryptedCoding +
        ", versionNumber=" + versionNumber +
        ", superChain=" + superChain +
        ", codeStatus=" + codeStatus +
        ", creationTime=" + creationTime +
        ", creater=" + creater +
        ", updateTime=" + updateTime +
        ", modifier=" + modifier +
        ", delFlag=" + delFlag +
        ", alternateField1=" + alternateField1 +
        ", alternateField2=" + alternateField2 +
        "}";
    }
}
