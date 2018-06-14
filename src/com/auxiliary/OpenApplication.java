package com.auxiliary;

import java.awt.Desktop;
import java.io.IOException;

import javax.swing.JOptionPane;

/**
 * 
* @ClassName: OpenApplication  
* @Description: 实现打开特定的应用
* @author chaoling  
* @date 2018年6月14日
 */
public class OpenApplication {
	private String str;

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}
	
	/**
	 * 构造函数
	 * @param s
	 * @param index
	 */
	public OpenApplication(String s, int index) {
		// TODO Auto-generated constructor stub
		judge(s,index);
	}
	
	/**
	 * 
	* @Title: judge  
	* @Description: 实现打开不同的应用程序
	* @param @param s
	* @param @param index   
	* @return void  
	* @throws
	 */
	public void judge(String s, int index) {
		
		s = s.substring(index+2);
		Runtime run=Runtime.getRuntime();  
		Desktop desktop = Desktop.getDesktop();
		//对判断条件算法 进行优化，增加新功能  利用选择路径方式
		try {
			if(s.length() !=0) {
				index = s.indexOf("网易云音乐");
				if(index == -1) {
					index = s.toLowerCase().indexOf("tim");
					if(index == -1) {
						index = s.indexOf("计算器");
						if(index == -1) {
							index = s.indexOf("任务管理器");
							if(index == -1) {
								index = s.indexOf("邮箱");
								if(index == -1) {
									index = s.toLowerCase().indexOf("绘图板");
									if(index == -1) {
										index = s.indexOf("资源管理器");
										if(index == -1) {
											setStr("没有找到要打开的应用，你是不是打错了！");
										}else {
											//打开资源管理器
											run.exec("explorer.exe");
											setStr("已经打开了，厉害吧！");
										}
									}else {
										//打开绘图板
										run.exec("mspaint");
										setStr("已经打开了，厉害吧！");
									}
								}else {
									//打开邮箱
									desktop.mail();
									setStr("已经打开了，厉害吧！");
								}
							}else {
								//打开任务管理器
								run.exec("taskmgr");
								setStr("已经打开了，厉害吧！");
							}
						}else {
							//打开计算器
							run.exec("calc"); 
							setStr("已经打开了，厉害吧！");
						}
					}else {
						//打开tim
						run.exec("R:\\Tencent\\TIM\\Bin\\TIM.exe");
						setStr("已经打开了，厉害吧！");
					}	
				}else {
					//打开网易云
					run.exec("R:\\Netease\\CloudMusic\\cloudMusic.exe");
					setStr("已经打开了，厉害吧！");
				}	
				
			}else {
				//打开为空的情况
				JOptionPane.showMessageDialog(null, "打开内容不能为空!");  
				setStr("你想打开啥？");
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
