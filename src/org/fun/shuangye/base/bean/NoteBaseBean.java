package org.fun.shuangye.base.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 笔记持久化类
 * 笔记详细信息
 * 映射用户表SYS_SY_NOTE
 * 
 * author by redhat;
 * date 2018.8.22
 * 
 * */
@Entity
@Table(name="SYS_SY_NOTE")
public class NoteBaseBean {

	private String note_id;
	
	private String note_name;
	
	private Date create_date;
	
	private Date last_edit_date;
	
	private String user_id;

	private List<TitleBaseBean> titlelist = new ArrayList<TitleBaseBean>();
	
	@OneToMany(mappedBy="note_parent")
	public List<TitleBaseBean> getTitlelist() {
		return titlelist;
	}

	public void setTitlelist(List<TitleBaseBean> titlelist) {
		this.titlelist = titlelist;
	}

	@Id
	@Column(name="note_id")
	public String getNote_id() {
		return note_id;
	}

	public void setNote_id(String note_id) {
		this.note_id = note_id;
	}

	@Column(name="note_name")
	public String getNote_name() {
		return note_name;
	}

	public void setNote_name(String note_name) {
		this.note_name = note_name;
	}

	@Column(name="create_date")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	@Column(name="last_edit_date")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getLast_edit_date() {
		return last_edit_date;
	}

	public void setLast_edit_date(Date last_edit_date) {
		this.last_edit_date = last_edit_date;
	}

	@Column(name="user_id")
	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
}
