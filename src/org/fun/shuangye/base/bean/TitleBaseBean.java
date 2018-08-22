package org.fun.shuangye.base.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 记录持久化类
 * 记录详细信息
 * 映射用户表SYS_SY_NOTETITLE
 * 
 * author by redhat;
 * date 2018.8.22
 * 
 * */
@Entity
@Table(name="SYS_SY_NOTETITLE")
public class TitleBaseBean {
	
	private NoteBaseBean note_parent;
	
	private String title_id;
	
	private String title_name;
	
	private Date create_date;
	
	private Date last_edit_date;
	
	private List<RecordBaseBean> recordlist = new ArrayList<RecordBaseBean>();

	@ManyToOne
	@JoinColumn(name="note_id")
	public NoteBaseBean getNote_parent() {
		return note_parent;
	}

	public void setNote_parent(NoteBaseBean note_parent) {
		this.note_parent = note_parent;
	}

	@Id
	@Column(name="title_id")
	public String getTitle_id() {
		return title_id;
	}

	public void setTitle_id(String title_id) {
		this.title_id = title_id;
	}

	@Column(name="title_name")
	public String getTitle_name() {
		return title_name;
	}

	public void setTitle_name(String title_name) {
		this.title_name = title_name;
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

	@OneToMany(mappedBy="title_parent")
	public List<RecordBaseBean> getRecordlist() {
		return recordlist;
	}

	public void setRecordlist(List<RecordBaseBean> recordlist) {
		this.recordlist = recordlist;
	}

}
