package com.realization;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.auxiliary.Size;

/**
 * 
* @ClassName: Screen  
* @Description: 实现截屏功能
* @author chaoling  
* @date 2018年6月13日
 */
public class Screen {
	
	private Size size;
	private Robot robot;
	private Rectangle rec ;
	private int  base;
	private String path = "D:\\img\\";
	private  String type = ".png";
	private String fielPath;
	
	public String getFilePath() {
		return fielPath;
	}
	
	public void setFilePath(String str) {
		this.fielPath = str;
	}
	/**
	 * 构造函数
	 */
	public Screen(int i) {
		this.base = i;
		size = new Size();
		try {
			robot = new Robot();
//			System.out.println(size.getHeight());
			rec = new Rectangle(0, 0, size.getWidth(), size.getHeight());
			BufferedImage bf = robot.createScreenCapture(rec);
			try {
				String str = path  +base + type;
				ImageIO.write(bf, "png",new File(str));
				this.setFilePath(str);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
