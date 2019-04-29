package com.lhm.star.entity.model;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

@Data
@EqualsAndHashCode
@SuppressWarnings("serial")
@ApiModel(value = "会员表")
public class Member implements Serializable {
    private Integer id;

    private String member_uuid;

    private String member_name;

    private String member_nickname;

    private String login_name;

    private String login_password;

    private String register_phone;

    private Date create_time;

    private Date update_time;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMember_uuid() {
        return member_uuid;
    }

    public void setMember_uuid(String member_uuid) {
        this.member_uuid = member_uuid == null ? null : member_uuid.trim();
    }

    public String getMember_name() {
        return member_name;
    }

    public void setMember_name(String member_name) {
        this.member_name = member_name == null ? null : member_name.trim();
    }

    public String getMember_nickname() {
        return member_nickname;
    }

    public void setMember_nickname(String member_nickname) {
        this.member_nickname = member_nickname == null ? null : member_nickname.trim();
    }

    public String getLogin_name() {
        return login_name;
    }

    public void setLogin_name(String login_name) {
        this.login_name = login_name == null ? null : login_name.trim();
    }

    public String getLogin_password() {
        return login_password;
    }

    public void setLogin_password(String login_password) {
        this.login_password = login_password == null ? null : login_password.trim();
    }

    public String getRegister_phone() {
        return register_phone;
    }

    public void setRegister_phone(String register_phone) {
        this.register_phone = register_phone == null ? null : register_phone.trim();
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Member other = (Member) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getMember_uuid() == null ? other.getMember_uuid() == null : this.getMember_uuid().equals(other.getMember_uuid()))
            && (this.getMember_name() == null ? other.getMember_name() == null : this.getMember_name().equals(other.getMember_name()))
            && (this.getMember_nickname() == null ? other.getMember_nickname() == null : this.getMember_nickname().equals(other.getMember_nickname()))
            && (this.getLogin_name() == null ? other.getLogin_name() == null : this.getLogin_name().equals(other.getLogin_name()))
            && (this.getLogin_password() == null ? other.getLogin_password() == null : this.getLogin_password().equals(other.getLogin_password()))
            && (this.getRegister_phone() == null ? other.getRegister_phone() == null : this.getRegister_phone().equals(other.getRegister_phone()))
            && (this.getCreate_time() == null ? other.getCreate_time() == null : this.getCreate_time().equals(other.getCreate_time()))
            && (this.getUpdate_time() == null ? other.getUpdate_time() == null : this.getUpdate_time().equals(other.getUpdate_time()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getMember_uuid() == null) ? 0 : getMember_uuid().hashCode());
        result = prime * result + ((getMember_name() == null) ? 0 : getMember_name().hashCode());
        result = prime * result + ((getMember_nickname() == null) ? 0 : getMember_nickname().hashCode());
        result = prime * result + ((getLogin_name() == null) ? 0 : getLogin_name().hashCode());
        result = prime * result + ((getLogin_password() == null) ? 0 : getLogin_password().hashCode());
        result = prime * result + ((getRegister_phone() == null) ? 0 : getRegister_phone().hashCode());
        result = prime * result + ((getCreate_time() == null) ? 0 : getCreate_time().hashCode());
        result = prime * result + ((getUpdate_time() == null) ? 0 : getUpdate_time().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", member_uuid=").append(member_uuid);
        sb.append(", member_name=").append(member_name);
        sb.append(", member_nickname=").append(member_nickname);
        sb.append(", login_name=").append(login_name);
        sb.append(", login_password=").append(login_password);
        sb.append(", register_phone=").append(register_phone);
        sb.append(", create_time=").append(create_time);
        sb.append(", update_time=").append(update_time);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}