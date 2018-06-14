package com.auxiliary;

import java.awt.Dimension;
import java.awt.Toolkit;

/**
 * 
* @ClassName: Size  
* @Description: 获取当前屏幕大小
* @author chaoling  
* @date 2018年6月13日
 */
public class Size {
	private int width;
	private int height;
	
	public int getWidth() {
		return width;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	/**
	 * 构造函数
	 */
	public Size() {
		Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		this.width = screenSize.width;
		this.height = screenSize.height;
	}
	

}
