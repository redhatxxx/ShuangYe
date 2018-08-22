package org.fun.shuangye.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.fun.shuangye.base.bean.RecordBaseBean;
import org.fun.shuangye.base.server.IRecordBeanManager;
import org.fun.shuangye.base.server.ITitleBeanManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONObject;

@Controller
@RequestMapping(value="/Record")
public class RecordController {

	@Resource(name="recordmanager")
	private IRecordBeanManager recordmanager;
	
	@Resource(name="titlemanager")
	private ITitleBeanManager titlemanager;
	
	@RequestMapping(value="/doSaveNewRecord")
	@ResponseBody
	private Map<String,String> saveNewRecord(@RequestBody JSONObject requestJson){
		RecordBaseBean record = new RecordBaseBean();
		Map datamap = (Map)requestJson;
		Map resultdata = new HashMap();
		String title_id = (String)datamap.get("title_id");
		String record_data = (String)datamap.get("record_data");
		String record_name  = (String)datamap.get("record_name");
		record.setTitle_parent(titlemanager.getTitleById(title_id));
		record.setRecord_data(record_data);
		record.setRecord_name(record_name);
		recordmanager.addNewRecord(record);
		if(record.getRecord_id()!=null)
			resultdata.put("result", "success");
		else
			resultdata.put("result", "fail");
		return resultdata;
	}
	
	@RequestMapping(value="/updatRecordData")
	@ResponseBody
	private Map<String,String> updateRecordData(@RequestBody JSONObject requestjson){
		Map datamap = (Map) requestjson;
		Map resultdata = new HashMap();
		String record_data = (String)datamap.get("record_data");
		String record_id = (String)datamap.get("record_id");
		boolean flag = this.recordmanager.updateRecordData(record_id, record_data);
		if(flag)
			resultdata.put("result", "success");
		else
			resultdata.put("result", "fail");
		return resultdata;
	}
}
