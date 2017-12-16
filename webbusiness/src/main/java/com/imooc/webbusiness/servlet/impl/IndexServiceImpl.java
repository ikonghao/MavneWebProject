package com.imooc.webbusiness.servlet.impl;

import javax.lang.model.element.VariableElement;

import org.springframework.stereotype.Service;

import com.imooc.webbusiness.entity.IndexEntity;
import com.imooc.webbusiness.servlet.IndexService;

@Service("indexService")
public class IndexServiceImpl implements IndexService {

	@Override
	public IndexEntity getIndexEntityByID(int Id) {
		IndexEntity result=new IndexEntity();
		result.setID(Id);
		result.setAge(25);
		result.setDesc("这个是个测试服务使用的:id");
		result.setName("我是business index");
		// TODO 自动生成的方法存根
		return result;
	}

}
