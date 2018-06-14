package com.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import com.auxiliary.ComputerAction;
import com.auxiliary.Size;

/**
 * 
* @ClassName: Computer  
* @Description: 实现对电脑的关机，取消关机，重启 取消重启
* @author chaoling  
* @date 2018年6月14日
 */
public class Computer extends JFrame{
	
	private String str;
	private Runtime run=Runtime.getRuntime();  
	private Size size; 
	private String in;
	
	JButton determine;
	JButton cancel;
	ButtonGroup choice;
	JRadioButton nowClose;
	JRadioButton laterClose;
	JRadioButton cancleClose;
	JRadioButton nowRestart;
	JRadioButton laterRestart;
	JRadioButton cancelRestar;
	
	public String getIn() {
		return in;
	}

	public void setIn(String in) {
		this.in = in;
	}
	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}
	
	/**
	 * 构造函数
	 */
	public Computer() {
		// TODO Auto-generated constructor stub
		
		size = new Size();
		choice = new ButtonGroup();
		
		setLayout(null);
		
		nowClose = new JRadioButton("立即关机");
		choice.add(nowClose);
		nowClose.setSelected(true);
		nowClose.setBounds(30, 30,100,20);
		nowClose.addActionListener(new ComputerAction());
		getContentPane().add(nowClose);

		laterClose = new JRadioButton("稍后关机");
		choice.add(laterClose);
		laterClose.setBounds(140, 30,100,20);
		laterClose.addActionListener(new ComputerAction());
		getContentPane().add(laterClose);
		
		cancleClose = new JRadioButton("取消关机");
		choice.add(cancleClose);
		cancleClose.setBounds(250, 30,100,20);
		cancleClose.addActionListener(new ComputerAction());
		getContentPane().add(cancleClose);
		
		nowRestart = new JRadioButton("立即重启");
		choice.add(nowRestart);
		nowRestart.setBounds(30, 100,100,20);
		nowRestart.addActionListener(new ComputerAction());
		getContentPane().add(nowRestart);

		laterRestart = new JRadioButton("稍后重启");
		choice.add(laterRestart);
		laterRestart.setBounds(140, 100,100,20);
		laterRestart.addActionListener(new ComputerAction());
		getContentPane().add(laterRestart);
		
		cancelRestar = new JRadioButton("取消重启");
		choice.add(cancelRestar);
		cancelRestar.setBounds(250, 100,100,20);
		cancelRestar.addActionListener(new ComputerAction());
		getContentPane().add(cancelRestar);
		
		setTitle("小助手——选择");
		setSize(size.getWidth()/5, size.getHeight()/4);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	
		setLocationRelativeTo(null);	
		setResizable(false);
		this.getContentPane().setBackground(Color.white);
		validate();
		setResizable(false);
	}

}
