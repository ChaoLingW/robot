package com.realization;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JOptionPane;

/**
 * 
* @ClassName: Serach  
* @Description: 利用浏览器去搜索给定字符串
* @author chaoling  
* @date 2018年6月14日
 */
public class Serach {
	
		private String str;
		
		public String getStr() {
			return str;
		}
		public void setStr(String s) {
			this.str = s;
		}
		public Serach(String st,int index) {
			
			st = st.substring(index+2);
			if(st.length() != 0) {
				Desktop desktop = Desktop.getDesktop();
				//在浏览器里面输入一个地址
				try {
					desktop.browse(new URI("https://www.baidu.com/s?wd="+st));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (URISyntaxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				this.setStr("已完成搜索");
			}else {
				JOptionPane.showMessageDialog(null, "搜索内容不能为空!");  
				this.setStr("你输入的为空，我怎么知道你想搜什么!");
			}    
	}


}
