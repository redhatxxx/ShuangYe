package org.fun.shuangye.base.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.fun.shuangye.base.bean.UserBaseBean;
import org.fun.shuangye.common.AbstractCommonFunction;
import org.fun.shuangye.common.AbstractUuidGenerate;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

public class UserBaseDao implements IUserBaseDao{

	private SessionFactory sessionfactory;
	
	@Override
	public UserBaseBean getUser(String userId) {
		// TODO Auto-generated method stub
		String gethql = "from UserBaseBean u where u.user_id = ?";
		Query query = this.sessionfactory.getCurrentSession().createQuery(gethql);
		query.setString(0, userId);
		return (UserBaseBean)query.uniqueResult();
	}

	@Override
	public UserBaseBean addUser(UserBaseBean user) {
		// TODO Auto-generated method stub
		String uuid = AbstractUuidGenerate.getUUID();
		user.setUser_id(uuid);
		user.setUser_regist_time(AbstractCommonFunction.getNowTimeDate());
		sessionfactory.getCurrentSession().save(user);
		return user;
	}

	@Override
	public boolean delUser(String userId) {
		// TODO Auto-generated method stub
		String hql = "delete UserBaseBean u where u.user_id=? ";
		Query query = this.sessionfactory.getCurrentSession().createQuery(hql);
		query.setString(0, userId);
		return (query.executeUpdate()>0);
	}
	
	public void setSessionfactory(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}

	@Override
	public List<UserBaseBean> getUserList(List conditions) {
		// TODO Auto-generated method stub
		String hql = " from UserBaseBean ";
		if(conditions!=null){
			
		}
		Query query = this.sessionfactory.getCurrentSession().createQuery(hql);
		
		return query.list();
	}

	@Override
	public boolean updateUser(UserBaseBean user) {
		// TODO Auto-generated method stub
		String updatehql = "update UserBaseBean u set u.user_nickname =? , u.user_sex=?,u.user_qq_number=?"
				+ " ,u.user_weixin_account=? where u.user_id = ?";
		Query query = this.sessionfactory.getCurrentSession().createQuery(updatehql);
		query.setString(0, user.getUser_nickname());
		query.setInteger(1, user.getUser_sex());
		query.setString(2, user.getUser_qq_number());
		query.setString(3, user.getUser_weixin_account());
		query.setString(4, user.getUser_id());
		
		return (query.executeUpdate()>0);
	}

	@Override
	public Map findUserWithResult(String username, String password) {
		// TODO Auto-generated method stub
		String gethql = "from UserBaseBean u where u.user_name = ? and u.user_password = ? ";
		Query query = this.sessionfactory.getCurrentSession().createQuery(gethql);
		query.setString(0, username);
		query.setString(1, password);
		List<UserBaseBean> res = query.list();
		Map returndata = new HashMap();
		if(res.size()<=0){
			returndata.put("errormsg", "用户名或密码错误！");
		}else{
			UserBaseBean loginuser = (UserBaseBean)res.get(0);
			String nickname = loginuser.getUser_nickname();
			String user_id = loginuser.getUser_id();
			int logincount = loginuser.getUser_login_count();
			if(nickname!=null&&!(nickname.equals("")||nickname.equals("null")))
				returndata.put("nickname", nickname);
			else
				returndata.put("nickname", username);
			returndata.put("user_id", user_id);
			loginuser.setUser_login_count(logincount+1);
			loginuser.setUser_last_login_time(AbstractCommonFunction.getNowTimeDate());
			updatUserLoginInfo(loginuser);
		}
		return returndata;
	}

	/**
	 * 用户登录更新用户信息
	 * */
	private boolean updatUserLoginInfo(UserBaseBean loginuser) {
		// TODO Auto-generated method stub
		String updatehql = "update UserBaseBean u set u.user_login_count =? , u.user_last_login_time=? where u.user_id = ?";
		Query query = this.sessionfactory.getCurrentSession().createQuery(updatehql);
		query.setString(0, String.valueOf(loginuser.getUser_login_count()));
		query.setTimestamp(1, loginuser.getUser_last_login_time());
		query.setString(2, loginuser.getUser_id());
		return (query.executeUpdate()>0);
	}

	@Override
	public boolean checkUserName(String user_name) {
		// TODO Auto-generated method stub
		String gethql = "from UserBaseBean u where u.user_name = ?";
		Query query = this.sessionfactory.getCurrentSession().createQuery(gethql);
		query.setString(0, user_name);
		List<UserBaseBean> res = query.list();
		if(res==null||res.size()==0)
			return false;
		else
			return true;
	}

	@Override
	public boolean updateUsersculpture(String user_id, String sculpturepath) {
		// TODO Auto-generated method stub
		String updatehql = "update UserBaseBean u set  u.sculptrue_path=? where u.user_id = ?";
		Query query = this.sessionfactory.getCurrentSession().createQuery(updatehql);
		query.setString(0, sculpturepath);
		query.setString(1, user_id);
		return (query.executeUpdate()>0);
	}
}
