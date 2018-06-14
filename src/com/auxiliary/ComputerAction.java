package com.auxiliary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JOptionPane;
/**
 * 
* @ClassName: CommandListen  
* @Description: 对执行命令给出响应
* @author chaoling  
* @date 2018年6月14日
 */
public class ComputerAction implements ActionListener {
	private Command command;
	Runtime run; 
	String str;
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		str = e.getActionCommand() ;
		run=Runtime.getRuntime();
		command =new Command();
		
		try {
			if(str =="立即关机") {

				run.exec(command.getClose() + "0");
			}
			if(str=="稍后关机") {
				run.exec(command.getClose() + "600");
			}
			if(str =="取消关机") {
				run.exec(command.getCancel());
			}
			if(str =="立即重启") {
				run.exec(command.getRestart());
			}
			if(str=="稍后重启") {
				run.exec(command.getRestart() + "600");
			}
			if(str =="取消重启") {
				run.exec(command.getCancel());
			}else {
				JOptionPane.showMessageDialog(null, str);  
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}
}
