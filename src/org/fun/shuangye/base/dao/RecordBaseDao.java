package org.fun.shuangye.base.dao;

import java.util.Date;
import java.util.List;

import org.fun.shuangye.base.bean.RecordBaseBean;
import org.fun.shuangye.base.bean.TitleBaseBean;
import org.fun.shuangye.base.bean.UserBaseBean;
import org.fun.shuangye.common.AbstractCommonFunction;
import org.fun.shuangye.common.AbstractUuidGenerate;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

public class RecordBaseDao implements IRecordBaseDao {

	private SessionFactory sessionfactory;
	
	public void setSessionfactory(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}
	
	@Override
	public RecordBaseBean getRecordById(String recordId) {
		// TODO Auto-generated method stub
		String gethql = "from RecordBaseBean r where r.record_id = ?";
		Query query = this.sessionfactory.getCurrentSession().createQuery(gethql);
		query.setString(0, recordId);
		return (RecordBaseBean)query.uniqueResult();
	}

	@Override
	public RecordBaseBean addNewRecord(RecordBaseBean record) {
		// TODO Auto-generated method stub
		String uuid = AbstractUuidGenerate.getUUID();
		Date nowtime = AbstractCommonFunction.getNowTimeDate();
		record.setRecord_id(uuid);
		record.setCreate_date(nowtime);
		record.setLast_edit_date(nowtime);
		sessionfactory.getCurrentSession().save(record);
		return record;
	}

	@Override
	public boolean delRecordById(String recordId) {
		// TODO Auto-generated method stub
		String hql = "delete RecordBaseBean r where r.record_id = ? ";
		Query query = this.sessionfactory.getCurrentSession().createQuery(hql);
		query.setString(0, recordId);
		return (query.executeUpdate()>0);
	}

	@Override
	public List<RecordBaseBean> getRecordList(List conditions) {
		// TODO Auto-generated method stub
		String hql = " from RecordBaseBean r where 1=1 ";
		Query query = null;
		if(conditions!=null){
			StringBuffer extrasql = new StringBuffer();
			String[] params = new String[conditions.size()];
			int i = 0;
			for(String condition : (List<String>)conditions) {
				String[] strs = condition.split(":");
				if(strs!=null&&strs.length==2) {
					extrasql.append(" and ");
					extrasql.append("r.title_parent");
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
	public boolean updateRecordBaseInfo(RecordBaseBean record) {
		// TODO Auto-generated method stub
		String updatehql = "update RecordBaseBean r set r.record_name = ? , r.create_date = ? , r.last_edit_date = ? "
				+ " where r.record_id = ? ";
		Query query = this.sessionfactory.getCurrentSession().createQuery(updatehql);
		query.setString(0, record.getRecord_name());
		query.setTimestamp(1, record.getCreate_date());
		query.setTimestamp(2, record.getLast_edit_date());
		query.setString(3, record.getRecord_id());
		
		return (query.executeUpdate()>0);
	}

	@Override
	public boolean checkRecordName(String record_name,String title_id) {
		// TODO Auto-generated method stub
		String gethql = "from RecordBaseBean r where r.record_name = ? and r.title_id = ? ";
		Query query = this.sessionfactory.getCurrentSession().createQuery(gethql);
		query.setString(0, record_name);
		query.setString(1, title_id);
		List<UserBaseBean> res = query.list();
		if(res==null||res.size()==0)
			return false;
		else
			return true;
	}

	@Override
	public boolean updateRecordData(String record_id,String record_data) {
		// TODO Auto-generated method stub
		String updatehql = "update RecordBaseBean r set r.record_data = ?  where r.record_id = ? ";
		Query query = this.sessionfactory.getCurrentSession().createQuery(updatehql);
		query.setString(0, record_data);
		query.setString(1, record_id);
		return (query.executeUpdate()>0);
	}

}
