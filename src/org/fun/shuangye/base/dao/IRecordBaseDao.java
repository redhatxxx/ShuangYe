package org.fun.shuangye.base.dao;

import java.util.List;

import org.fun.shuangye.base.bean.RecordBaseBean;

public interface IRecordBaseDao {
	/**
	 * 根据ID获取记录对象
	 * */
	RecordBaseBean getRecordById(String recordId);
	
	/**
	 * 新添加一个记录对象
	 * */
	RecordBaseBean addNewRecord(RecordBaseBean record);
	
	/**
	 * 删除记录对象
	 * */
	boolean delRecordById(String recordId);
	
	/**
	 * 获取记录list
	 * */
	List<RecordBaseBean> getRecordList(List conditions);
	
	/**
	 * 更新记录基础信息
	 * */
	boolean updateRecordBaseInfo(RecordBaseBean record);
	
	/**
	 * 更新记录内容信息
	 * */
	boolean updateRecordData(String record_id,String record_data);

	/**
	 * 	检查记录名是否存在
	 * */
	boolean checkRecordName(String record_name,String title_id);
}
