package org.fun.shuangye.base.server;

import java.util.List;

import org.fun.shuangye.base.bean.TitleBaseBean;
import org.fun.shuangye.base.dao.ITitleBaseDao;
import org.springframework.stereotype.Service;

@Service
public class TitleBeanManager implements ITitleBeanManager {

	private ITitleBaseDao titledao;
	
	public ITitleBaseDao getTitledao() {
		return titledao;
	}

	public void setTitledao(ITitleBaseDao titledao) {
		this.titledao = titledao;
	}

	@Override
	public TitleBaseBean getTitleById(String titleId) {
		// TODO Auto-generated method stub
		return titledao.getTitleById(titleId);
	}

	@Override
	public TitleBaseBean addNewTitle(TitleBaseBean title) {
		// TODO Auto-generated method stub
		return titledao.addNewTitle(title);
	}

	@Override
	public boolean delTitleById(String TitleId) {
		// TODO Auto-generated method stub
		return titledao.delTitleById(TitleId);
	}

	@Override
	public List<TitleBaseBean> getTitleList(List conditions) {
		// TODO Auto-generated method stub
		return titledao.getTitleList(conditions);
	}

	@Override
	public boolean updateUser(TitleBaseBean title) {
		// TODO Auto-generated method stub
		return titledao.updateUser(title);
	}

	@Override
	public boolean checkTitleName(String title_name, String note_id) {
		// TODO Auto-generated method stub
		return titledao.checkTitleName(title_name, note_id);
	}

}
