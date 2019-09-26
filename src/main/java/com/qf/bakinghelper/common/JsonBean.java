package com.qf.bakinghelper.common;

import lombok.Data;

@Data
public class JsonBean {

	private int code;
	private Object info;

	public JsonBean() {
	}

	public JsonBean(int code, Object info) {
		this.code = code;
		this.info = info;
	}
}
