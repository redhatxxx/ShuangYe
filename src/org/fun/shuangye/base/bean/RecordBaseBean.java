package org.fun.shuangye.base.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 记录持久化类
 * 记录详细信息
 * 映射用户表SYS_SY_NOTERECORD
 * 
 * author by redhat;
 * date 2018.8.22
 * 
 * */
@Entity
@Table(name="SYS_SY_NOTERECORD")
public class RecordBaseBean {

	private TitleBaseBean title_parent;
	
	private String record_id;
	
	private String record_name;
	
	private Date create_date;
	
	private Date last_edit_date;
	
	private String record_data;

	@ManyToOne
	@JoinColumn(name="title_id")
	public TitleBaseBean getTitle_parent() {
		return title_parent;
	}

	public void setTitle_parent(TitleBaseBean title_parent) {
		this.title_parent = title_parent;
	}

	@Id
	@Column(name="record_id")
	public String getRecord_id() {
		return record_id;
	}

	public void setRecord_id(String record_id) {
		this.record_id = record_id;
	}

	@Column(name="record_name")
	public String getRecord_name() {
		return record_name;
	}

	public void setRecord_name(String record_name) {
		this.record_name = record_name;
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

	@Column(name="record_data")
	public String getRecord_data() {
		return record_data;
	}

	public void setRecord_data(String record_data) {
		this.record_data = record_data;
	}
}
