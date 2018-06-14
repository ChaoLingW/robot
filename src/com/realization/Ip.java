package com.realization;
/**
 * 
* @ClassName: Ip  
* @Description: 提供本机的IP
* @author chaoling  
* @date 2018年6月13日
 */

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Ip {
	private String ip;

	public String getIp() {
		return ip;
	}

	/**
	 * 
	* @Title: setIp  
	* @Description: 或去本机IP
	* @param    
	* @return void  
	* @throws
	 */
	public void setIp(){
		try {
			this.ip = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 构造函数
	 */
	public Ip() {
		setIp();
	}
	
}
