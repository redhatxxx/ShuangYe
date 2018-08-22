package org.fun.shuangye.base.server;

import java.util.List;

import org.fun.shuangye.base.bean.TitleBaseBean;

public interface ITitleBeanManager {
	/**
	 * 根据ID获取主题对象
	 * */
	TitleBaseBean getTitleById(String titleId);
	
	/**
	 * 新添加一个主题对象
	 * */
	TitleBaseBean addNewTitle(TitleBaseBean title);
	
	/**
	 * 删除主题对象
	 * */
	boolean delTitleById(String TitleId);
	
	/**
	 * 获取主题list
	 * */
	List<TitleBaseBean> getTitleList(List conditions);
	
	/**
	 * 更新主题信息
	 * */
	boolean updateUser(TitleBaseBean title);

	/**
	 * 	检查主题名是否存在
	 * */
	boolean checkTitleName(String title_name,String note_id);

}
