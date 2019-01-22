package com.example.demo.foundation.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author: Ryan
 * @since: 2018/11/8 14:46
 * @description:
 * @modifyTime:
 * @modifier:
 */
@Data
@Table(name = "sys_user")
public class User implements Serializable{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String phone;

    @Column(name = "card_id")
    private String cardId;

    @Column(name = "birthday")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    @Column(name = "gender")
    private Byte gender;

    @Column(name = "avatar_url")
    private String avatarUrl;

    @Column(name = "password_change_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date passwordChangeTime;

    @Column(name = "wx_name")
    private String wxName;

    @Column(name = "wx_openid")
    private String wxOpenid;

    @Column(name = "wx_unionid")
    private String wxUnionid;

    @Column(name = "last_login_ip")
    private String lastLoginIp;

    @Column(name = "last_login_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastLoginTime;

    @Column(name = "status")
    private Byte status;

    @Column(name = "gmt_create")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date gmtCreate;

    @Column(name = "creator")
    private Integer creator;

    @Column(name = "gmt_modified")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date gmtModified;

    @Column(name = "modifier")
    private Integer modifier;

    @Column(name = "version")
    private String version;

    @Column(name = "is_deleted")
    private Byte deleted;

}
