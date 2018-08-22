package org.fun.shuangye.base.server;

import java.util.List;

import org.fun.shuangye.base.bean.NoteBaseBean;
import org.fun.shuangye.base.dao.INoteBaseDao;
import org.springframework.stereotype.Service;

@Service
public class NoteBeanManager implements INoteBeanManager {

	private INoteBaseDao notedao;
	
	public INoteBaseDao getNotedao() {
		return notedao;
	}

	public void setNotedao(INoteBaseDao notedao) {
		this.notedao = notedao;
	}

	@Override
	public NoteBaseBean getNoteById(String noteId) {
		// TODO Auto-generated method stub
		return notedao.getNoteById(noteId);
	}

	@Override
	public NoteBaseBean addNewNote(NoteBaseBean note) {
		// TODO Auto-generated method stub
		return notedao.addNewNote(note);
	}

	@Override
	public boolean delNoteById(String noteId) {
		// TODO Auto-generated method stub
		return notedao.delNoteById(noteId);
	}

	@Override
	public List<NoteBaseBean> getNoteList(List conditions) {
		// TODO Auto-generated method stub
		return notedao.getNoteList(conditions);
	}

	@Override
	public boolean updateUser(NoteBaseBean note) {
		// TODO Auto-generated method stub
		return notedao.updateUser(note);
	}

	@Override
	public boolean checkNoteName(String note_name, String user_id) {
		// TODO Auto-generated method stub
		return notedao.checkNoteName(note_name, user_id);
	}

}
