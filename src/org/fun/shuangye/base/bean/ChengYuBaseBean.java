package org.fun.shuangye.base.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 成语持久化类
 * 成语详细信息
 * 映射成语表SYS_SY_CY
 * 
 * author by redhat;
 * date 2018.8.22
 * 
 * */
@Entity
@Table(name="SYS_SY_CY")
public class ChengYuBaseBean {

	private String id;
	
	//成语名称
	private String name;
	
	//拼音
	private String spell;
	
	//成语解释
	private String content;
	
	//成语出处
	private String derivation;
	
	//举例
	private String samples;

	@Id
	@Column(name="id")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name="name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="spell")
	public String getSpell() {
		return spell;
	}

	public void setSpell(String spell) {
		this.spell = spell;
	}

	@Column(name="content")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name="derivation")
	public String getDerivation() {
		return derivation;
	}

	public void setDerivation(String derivation) {
		this.derivation = derivation;
	}

	@Column(name="samples")
	public String getSamples() {
		return samples;
	}

	public void setSamples(String samples) {
		this.samples = samples;
	}
}
