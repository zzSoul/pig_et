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
 * @since 2019-02-21
 */
@TableName("atc_user_info")
public class AtcUserInfo extends Model<AtcUserInfo> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 电话
     */
    private String tel;
    /**
     * 密码
     */
    private String pwd;
    /**
     * 编号
     */
    private String num;
    /**
     * 该用户累计充值金额
     */
    @TableField("rmb_money")
    private Integer rmbMoney;
    /**
     * 该用户token币余额
     */
    @TableField("token_money")
    private Integer tokenMoney;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 头像
     */
    private String pic;
    /**
     * 状态：认证 0未认证 1个人认证 2机构认证
     */
    private Integer status;
    @TableField("create_time")
    private Date createTime;
    @TableField("update_time")
    private Date updateTime;
    /**
     * 微信小程序openid
     */
    private String openid;
    /**
     * 微信登录unionid
     */
    private String unionid;
    /**
     * 用户token
     */
    private String token;
    /**
     * 公钥 
     */
    @TableField("public_key")
    private String publicKey;
    /**
     * 私钥
     */
    @TableField("private_key")
    private String privateKey;
    /**
     * 驳回原因
     */
    private String dismissal;
    /**
     * 以太坊版本 默认1
     */
    @TableField("etherenum_ban")
    private String etherenumBan;
    /**
     * 删除标识
     */
    @TableField("del_flag")
    private String delFlag;
    /**
     * 备用字段
     */
    @TableField("alternate_field1")
    private String alternateField1;
    /**
     * 备用字段
     */
    @TableField("alternate_field2")
    private String alternateField2;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public Integer getRmbMoney() {
        return rmbMoney;
    }

    public void setRmbMoney(Integer rmbMoney) {
        this.rmbMoney = rmbMoney;
    }

    public Integer getTokenMoney() {
        return tokenMoney;
    }

    public void setTokenMoney(Integer tokenMoney) {
        this.tokenMoney = tokenMoney;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getDismissal() {
        return dismissal;
    }

    public void setDismissal(String dismissal) {
        this.dismissal = dismissal;
    }

    public String getEtherenumBan() {
        return etherenumBan;
    }

    public void setEtherenumBan(String etherenumBan) {
        this.etherenumBan = etherenumBan;
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
        return "AtcUserInfo{" +
        ", id=" + id +
        ", tel=" + tel +
        ", pwd=" + pwd +
        ", num=" + num +
        ", rmbMoney=" + rmbMoney +
        ", tokenMoney=" + tokenMoney +
        ", email=" + email +
        ", pic=" + pic +
        ", status=" + status +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        ", openid=" + openid +
        ", unionid=" + unionid +
        ", token=" + token +
        ", publicKey=" + publicKey +
        ", privateKey=" + privateKey +
        ", dismissal=" + dismissal +
        ", etherenumBan=" + etherenumBan +
        ", delFlag=" + delFlag +
        ", alternateField1=" + alternateField1 +
        ", alternateField2=" + alternateField2 +
        "}";
    }
}
