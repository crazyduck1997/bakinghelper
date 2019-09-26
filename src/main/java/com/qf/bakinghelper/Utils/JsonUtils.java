package com.qf.bakinghelper.Utils;


import com.qf.bakinghelper.common.JsonBean;

public class JsonUtils {

	public static JsonBean createJsonBean(int code, Object info){
		JsonBean bean = new JsonBean();
		bean.setCode(code);
		bean.setInfo(info);
		
		return bean;
	}
}
