package org.fun.shuangye.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.fun.shuangye.base.bean.NoteBaseBean;
import org.fun.shuangye.base.bean.RecordBaseBean;
import org.fun.shuangye.base.bean.TitleBaseBean;
import org.fun.shuangye.base.server.INoteBeanManager;
import org.fun.shuangye.base.server.IRecordBeanManager;
import org.fun.shuangye.base.server.ITitleBeanManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/Note")
public class NoteController {
	
	@Resource(name="notemanager")
	private INoteBeanManager notemanager;
	
	@Resource(name="titlemanager")
	private ITitleBeanManager titlemanager;
	
	@Resource(name="recordmanager")
	private IRecordBeanManager recordmanager;
	
	@RequestMapping(value="/getAllInfo")
	private String getAllNoteInfo(Model model,HttpSession session) {
		String user_id = (String)session.getAttribute("user_id");
		List<NoteBaseBean> notelist = null;
		if(user_id!=null&&!"".equals(user_id)) {
			List conditions = new ArrayList();
			String condition = "user_id:"+user_id;
			conditions.add(condition);
			notelist = this.notemanager.getNoteList(conditions);
			for(NoteBaseBean notebean : notelist) {
				List note_conditions = new ArrayList();
				String note_id = notebean.getNote_id();
				String not_condition = "note_id:"+note_id;
				note_conditions.add(not_condition);
				List<TitleBaseBean> titlelist = titlemanager.getTitleList(note_conditions);
				for(TitleBaseBean titlebean : titlelist) {
					List title_conditions = new ArrayList();
					String titel_id = titlebean.getTitle_id();
					String title_condition = "titel_id:"+titel_id;
					title_conditions.add(title_condition);
					List<RecordBaseBean> recordlist = recordmanager.getRecordList(title_conditions);
					titlebean.setRecordlist(recordlist);
				}
				notebean.setTitlelist(titlelist);
			}
		}
		model.addAttribute("notelist", notelist);
		return "/jsp/note/frontpage";
	}
	
}
