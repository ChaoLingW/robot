package com.auxiliary;
/**
 * 
* @ClassName: Command  
* @Description: 命令
* @author chaoling  
* @date 2018年6月14日
 */
public class Command {
	//应该设置常量
	private String close = "shutdown -s -t " ;
	private String restar =  "shutdown -r -t ";
	private String cancel =  "shutdown -a"   ;
	
	public String getClose() {
		return close;
	}
	
	public String getRestart() {
		return restar;
	}
	
	public String getCancel() {
		return cancel;
	}

}
