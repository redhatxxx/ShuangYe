package org.fun.shuangye.base.dao;

import java.util.List;
import java.util.Map;

import org.fun.shuangye.base.bean.NoteBaseBean;

public interface INoteBaseDao {

	/**
	 * 根据ID获取笔记对象
	 * */
	NoteBaseBean getNoteById(String noteId);
	
	/**
	 * 新添加一个笔记对象
	 * */
	NoteBaseBean addNewNote(NoteBaseBean note);
	
	/**
	 * 删除笔记对象
	 * */
	boolean delNoteById(String noteId);
	
	/**
	 * 获取笔记list
	 * */
	List<NoteBaseBean> getNoteList(List conditions);
	
	/**
	 * 更新笔记信息
	 * */
	boolean updateUser(NoteBaseBean note);

	/**
	 * 	检查笔记名是否存在
	 * */
	boolean checkNoteName(String note_name,String user_id);

}
