package com.handle;

import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.swing.JOptionPane;

import com.api.Turing;
import com.gui.*;
import com.realization.Ip;
import com.realization.Open;
import com.realization.Screen;
import com.realization.Serach;

/**
 * 
* @ClassName: Handling  
* @Description: 对输入进行处理的中间函数
* @author chaoling  
* @date 2018年6月13日
 */
public class Handling {
	private Turing turing;
	private String reply;
	private String content;
	private Ip ip;
	private static int base =1;
	private Screen screen;
	private Serach serach;
	private Open open;
	
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Handling(String content) {
		// TODO Auto-generated constructor stub
		this.content= content;
		inputHanding();
	}
	
	/**
	 * 
	* @Title: inputHanding  
	* @Description: 对输入内容进行判断
	* @param    
	* @return void  
	* @throws
	 */
	public  void inputHanding() {
		
		String str = content.replace(" ", "").replace(" ", "");
		/**
		 * 需要算法改进
		 */
		int index = str.indexOf("打开");
		if(index == -1  ) {
			index = str.indexOf("搜索");
			if(index  == -1 ) {
				index = str.toLowerCase().indexOf("computer");    //关机/睡眠//  定时关机
				if(index == -1) {
					index = str.indexOf("截屏") ;
					if(index == -1) {
						index = str.toLowerCase().indexOf("ip");
						if(index == -1) {
							index = str.indexOf("翻译");
							if(index == -1) {
								turing = new Turing();
								this.setReply(turing.getMessage(content));
							}else {
								this.setReply("正在跳转到翻译界面");
								new Translate();
							}
						}else {
							ip = new Ip();
							this.setReply(ip.getIp());
						}
					}else {
						screen = new Screen(base);
						this.setReply("已完成截屏,图片存放在"+screen.getFilePath());
						base++;
					}
				}else {
					//调用Computer类
					this.setReply("正在跳转界面");
					new Computer();
					
				}
			}else {
				serach = new Serach(str,index);
				this.setReply(serach.getStr());
			}
		}else {
			open = new Open(str,index);
			this.setReply(open.getStr());
		}
	}
	
}

