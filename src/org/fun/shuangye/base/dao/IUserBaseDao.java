package org.fun.shuangye.base.dao;

import java.util.List;
import java.util.Map;

import org.fun.shuangye.base.bean.UserBaseBean;


public interface IUserBaseDao {
	/**
	 * 根据ID获取用户对象
	 * */
	UserBaseBean getUser(String userId);
	
	/**
	 * 新添加一个用户对象
	 * */
	UserBaseBean addUser(UserBaseBean user);
	
	/**
	 * 删除用户对象
	 * */
	boolean delUser(String userId);
	
	/**
	 * 获取用户list
	 * */
	List<UserBaseBean> getUserList(List conditions);
	
	/**
	 * 更新用户信息
	 * */
	boolean updateUser(UserBaseBean user);

	/**
	 * 	根据用户名密码登录
	 * */
	Map findUserWithResult(String username, String password);

	/**
	 * 	检查用户名是否存在
	 * */
	boolean checkUserName(String user_name);

	/**
	 * 	根据用户ID更新头像
	 * */
	boolean updateUsersculpture(String user_id, String sculpturepath);
}
