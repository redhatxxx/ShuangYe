package org.fun.shuangye.base.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 用户持久化类
 * 用户详细信息
 * 映射用户表SYS_SY_USER
 * 
 * author by redhat;
 * date 2016.12.12
 * 
 * */
@Entity
@Table(name="SYS_SY_USER")
public class UserBaseBean{

	@Column(name="sculptrue_path")
	public String getSculptrue_path() {
		return sculptrue_path;
	}

	public void setSculptrue_path(String sculptrue_path) {
		this.sculptrue_path = sculptrue_path;
	}

	@Column(name="user_name")
	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	
	@Column(name="user_password")
	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	@Column(name="user_sex")
	public int getUser_sex() {
		return user_sex;
	}

	public void setUser_sex(int user_sex) {
		this.user_sex = user_sex;
	}

	@Column(name="user_email")
	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	@Column(name="user_regist_time")
	@Temporal(TemporalType.TIMESTAMP)
	public java.util.Date getUser_regist_time() {
		return user_regist_time;
	}

	public void setUser_regist_time(java.util.Date  user_regist_time) {
		this.user_regist_time = user_regist_time;
	}

	@Column(name="user_last_login_time",length=50)
	@Temporal(TemporalType.TIMESTAMP)
	public java.util.Date getUser_last_login_time() {
		return user_last_login_time;
	}

	public void setUser_last_login_time(java.util.Date user_last_login_time) {
		this.user_last_login_time = user_last_login_time;
	}

	@Id
	@Column(name="user_id")
	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	@Column(name="user_nickname")
	public String getUser_nickname() {
		return user_nickname;
	}

	public void setUser_nickname(String user_nickname) {
		this.user_nickname = user_nickname;
	}

	@Column(name="user_phone")
	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	@Column(name="user_qq_number")
	public String getUser_qq_number() {
		return user_qq_number;
	}

	public void setUser_qq_number(String user_qq_number) {
		this.user_qq_number = user_qq_number;
	}

	@Column(name="user_weixin_account")
	public String getUser_weixin_account() {
		return user_weixin_account;
	}

	public void setUser_weixin_account(String user_weixin_account) {
		this.user_weixin_account = user_weixin_account;
	}

	@Column(name="user_real_name")
	public String getUser_real_name() {
		return user_real_name;
	}

	public void setUser_real_name(String user_real_name) {
		this.user_real_name = user_real_name;
	}

	@Column(name="user_identity_number")
	public String getUser_identity_number() {
		return user_identity_number;
	}

	public void setUser_identity_number(String user_identity_number) {
		this.user_identity_number = user_identity_number;
	}

	@Column(name="user_login_count")
	public int getUser_login_count() {
		return user_login_count;
	}

	public void setUser_login_count(int user_login_count) {
		this.user_login_count = user_login_count;
	}

	@Column(name="user_status")
	public int getUser_status() {
		return user_status;
	}

	public void setUser_status(int user_status) {
		this.user_status = user_status;
	}

	@Column(name="user_hold1")
	public String getUser_hold1() {
		return user_hold1;
	}

	public void setUser_hold1(String user_hold1) {
		this.user_hold1 = user_hold1;
	}

	@Column(name="user_hold2")
	public String getUser_hold2() {
		return user_hold2;
	}

	public void setUser_hold2(String user_hold2) {
		this.user_hold2 = user_hold2;
	}

	private String user_id;
	
	private String user_name;
	
	private String user_password;

	private int user_sex;
	
	private String user_email;
	
	private Date user_regist_time;
	
	private Date user_last_login_time;
	
	private String sculptrue_path;

	private String user_nickname;

	private String user_phone;

	private String user_qq_number;
	
	private String user_weixin_account;
	
	private String user_real_name;
	
	private String user_identity_number;
	
	private int user_login_count;
	
	private int user_status;
	
	private String user_hold1;
	
	private String user_hold2;
	
}
