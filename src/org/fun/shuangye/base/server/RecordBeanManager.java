package org.fun.shuangye.base.server;

import java.util.List;

import org.fun.shuangye.base.bean.RecordBaseBean;
import org.fun.shuangye.base.dao.IRecordBaseDao;
import org.springframework.stereotype.Service;

@Service
public class RecordBeanManager implements IRecordBeanManager {

	private IRecordBaseDao recorddao;
	
	public IRecordBaseDao getRecorddao() {
		return recorddao;
	}

	public void setRecorddao(IRecordBaseDao recorddao) {
		this.recorddao = recorddao;
	}

	@Override
	public RecordBaseBean getRecordById(String recordId) {
		// TODO Auto-generated method stub
		return recorddao.getRecordById(recordId);
	}

	@Override
	public RecordBaseBean addNewRecord(RecordBaseBean record) {
		// TODO Auto-generated method stub
		return recorddao.addNewRecord(record);
	}

	@Override
	public boolean delRecordById(String recordId) {
		// TODO Auto-generated method stub
		return recorddao.delRecordById(recordId);
	}

	@Override
	public List<RecordBaseBean> getRecordList(List conditions) {
		// TODO Auto-generated method stub
		return recorddao.getRecordList(conditions);
	}

	@Override
	public boolean updateRecordBaseInfo(RecordBaseBean record) {
		// TODO Auto-generated method stub
		return recorddao.updateRecordBaseInfo(record);
	}

	@Override
	public boolean updateRecordData(String record_id, String record_data) {
		// TODO Auto-generated method stub
		return recorddao.updateRecordData(record_id, record_data);
	}

	@Override
	public boolean checkRecordName(String record_name, String title_id) {
		// TODO Auto-generated method stub
		return recorddao.checkRecordName(record_name, title_id);
	}

}
