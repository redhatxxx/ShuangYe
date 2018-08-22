package org.fun.shuangye.base.dao;

import java.util.Date;
import java.util.List;

import org.fun.shuangye.base.bean.NoteBaseBean;
import org.fun.shuangye.base.bean.UserBaseBean;
import org.fun.shuangye.common.AbstractCommonFunction;
import org.fun.shuangye.common.AbstractUuidGenerate;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

public class NoteBaseDao implements INoteBaseDao {

	private SessionFactory sessionfactory;
	
	public void setSessionfactory(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}

	@Override
	public NoteBaseBean getNoteById(String noteId) {
		// TODO Auto-generated method stub
		String hql = "from NoteBaseBean n where n.note_id = ?";
		Query query = this.sessionfactory.getCurrentSession().createQuery(hql);
		query.setString(0, noteId);
		
		return ((NoteBaseBean)query.uniqueResult());
	}

	@Override
	public NoteBaseBean addNewNote(NoteBaseBean note) {
		// TODO Auto-generated method stub
		String uuid = AbstractUuidGenerate.getUUID();
		Date nowtime = AbstractCommonFunction.getNowTimeDate();
		note.setNote_id(uuid);
		note.setCreate_date(nowtime);
		note.setLast_edit_date(nowtime);

		sessionfactory.getCurrentSession().save(note);
		return note;
	}

	@Override
	public boolean delNoteById(String noteId) {
		// TODO Auto-generated method stub
		String hql = "delete NoteBaseBean n where n.note_id = ? ";
		Query query = this.sessionfactory.getCurrentSession().createQuery(hql);
		query.setString(0, noteId);
		return (query.executeUpdate()>0);
	}

	@Override
	public List<NoteBaseBean> getNoteList(List conditions) {
		// TODO Auto-generated method stub
		String hql = " from NoteBaseBean ";
		Query query = null;
		if(conditions!=null){
			StringBuffer extrasql = new StringBuffer();
			for(String condition : (List<String>)conditions) {
				String[] strs = condition.split(":");
				if(strs!=null&&strs.length==2) {
					extrasql.append(" and ");
					extrasql.append("t."+strs[0]);
					extrasql.append("="+strs[1]);
				}
			}
			query= this.sessionfactory.getCurrentSession().createQuery(hql+extrasql.toString());
		}else {
			query= this.sessionfactory.getCurrentSession().createQuery(hql);
		}
		
		return query.list();
	}

	@Override
	public boolean updateUser(NoteBaseBean note) {
		// TODO Auto-generated method stub
		String updatehql = "update NoteBaseBean n set n.note_name = ? , n.create_date = ? , n.last_edit_date = ? "
				+ " where n.note_id = ? ";
		Query query = this.sessionfactory.getCurrentSession().createQuery(updatehql);
		query.setString(0, note.getNote_name());
		query.setTimestamp(1, note.getCreate_date());
		query.setTimestamp(2, note.getLast_edit_date());
		query.setString(3, note.getNote_id());
		
		return (query.executeUpdate()>0);
	}

	@Override
	public boolean checkNoteName(String note_name,String user_id) {
		// TODO Auto-generated method stub
		String gethql = "from NoteBaseBean n where n.note_name = ? and user_id = ? ";
		Query query = this.sessionfactory.getCurrentSession().createQuery(gethql);
		query.setString(0, note_name);
		query.setString(1, user_id);
		List<UserBaseBean> res = query.list();
		if(res==null||res.size()==0)
			return false;
		else
			return true;
	}

}
