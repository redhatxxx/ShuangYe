package org.fun.shuangye.base.dao;

import java.util.Date;
import java.util.List;

import org.fun.shuangye.base.bean.TitleBaseBean;
import org.fun.shuangye.base.bean.UserBaseBean;
import org.fun.shuangye.common.AbstractCommonFunction;
import org.fun.shuangye.common.AbstractUuidGenerate;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

public class TitleBaseDao implements ITitleBaseDao {

	private SessionFactory sessionfactory;
	
	public void setSessionfactory(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}
	
	@Override
	public TitleBaseBean getTitleById(String titleId) {
		// TODO Auto-generated method stub
		String gethql = "from TitleBaseBean t where t.title_id = ?";
		Query query = this.sessionfactory.getCurrentSession().createQuery(gethql);
		query.setString(0, titleId);
		return (TitleBaseBean)query.uniqueResult();
	}

	@Override
	public TitleBaseBean addNewTitle(TitleBaseBean title) {
		// TODO Auto-generated method stub
		String uuid = AbstractUuidGenerate.getUUID();
		Date nowtime = AbstractCommonFunction.getNowTimeDate();
		title.setTitle_id(uuid);
		title.setCreate_date(nowtime);
		title.setLast_edit_date(nowtime);
		sessionfactory.getCurrentSession().save(title);
		return title;
	}

	@Override
	public boolean delTitleById(String titleId) {
		// TODO Auto-generated method stub
		String hql = "delete TitleBaseBean t where t.title_id = ? ";
		Query query = this.sessionfactory.getCurrentSession().createQuery(hql);
		query.setString(0, titleId);
		return (query.executeUpdate()>0);
	}

	@Override
	public List<TitleBaseBean> getTitleList(List conditions) {
		// TODO Auto-generated method stub
		String hql = " from TitleBaseBean t where 1=1 ";
		Query query = null;
		if(conditions!=null){
			StringBuffer extrasql = new StringBuffer();
			String[] params = new String[conditions.size()];
			int i = 0;
			for(String condition : (List<String>)conditions) {
				String[] strs = condition.split(":");
				if(strs!=null&&strs.length==2) {
					extrasql.append(" and ");
					extrasql.append("t.note_parent");
					extrasql.append("= ? ");
					params[i++] = strs[1];
				}
			}
			query= this.sessionfactory.getCurrentSession().createQuery(hql+extrasql.toString());
			for(int n = 0;n<i;n++)
				query.setString(n, params[n]);
		}else {
			query= this.sessionfactory.getCurrentSession().createQuery(hql);
		}
		
		return query.list();
	}

	@Override
	public boolean updateUser(TitleBaseBean title) {
		// TODO Auto-generated method stub
		String updatehql = "update TitleBaseBean t set t.title_name = ? , t.create_date = ? , t.last_edit_date = ? "
				+ " where t.title_id = ? ";
		Query query = this.sessionfactory.getCurrentSession().createQuery(updatehql);
		query.setString(0, title.getTitle_name());
		query.setTimestamp(1, title.getCreate_date());
		query.setTimestamp(2, title.getLast_edit_date());
		query.setString(3, title.getTitle_id());
		
		return (query.executeUpdate()>0);
	}

	@Override
	public boolean checkTitleName(String title_name,String note_id) {
		// TODO Auto-generated method stub
		String gethql = "from TitleBaseBean t where t.title_name = ? and t.note_id = ? ";
		Query query = this.sessionfactory.getCurrentSession().createQuery(gethql);
		query.setString(0, title_name);
		query.setString(1, note_id);
		List<UserBaseBean> res = query.list();
		if(res==null||res.size()==0)
			return false;
		else
			return true;
	}

}
