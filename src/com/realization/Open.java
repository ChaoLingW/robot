package com.realization;

import com.auxiliary.OpenApplication;

/**
 * 
* @ClassName: Open  
* @Description: 调用打开应用的OpenApplication
* @author chaoling  
* @date 2018年6月14日
 */
public class Open {
	private String str;
	private OpenApplication op;
	
	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public Open(String s,int index) {
		op = new OpenApplication(s,index);		
		this.setStr(op.getStr());
	}
}
