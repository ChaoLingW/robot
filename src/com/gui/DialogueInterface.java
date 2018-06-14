package com.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.rmi.CORBA.Util;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.api.Turing;
import com.auxiliary.Size;
import com.handle.Handling;
/**
 * 
* @ClassName: DialogueInterface  
* @Description: 主窗体，实现交互
* @author chaoling  
* @date 2018年6月13日
 */
public class DialogueInterface extends JFrame {
	
//	private static int width ;
//	private static int height ;
	JTextArea chatContent;	//文本域
	JScrollPane showPanel;	//滚动面板
	JPanel inputPanel;				//面板 
	JTextField inputField;
	JButton sendOut;
	Handling handle;
	Size size = new Size() ;
	
	/**
	 * 构造函数
	 */
	public DialogueInterface() {
		this.setLayout(new BorderLayout());  //边界布局管理器
        chatContent = new JTextArea(12, 34);
       
        showPanel = new JScrollPane(chatContent);  
          
        chatContent.setEditable(false);    // 设置文本域不可编辑  
        JPanel inputPanel = new JPanel(); 
        inputField = new JTextField(20);    
          
        sendOut = new JButton("发送"); 
        // 为按钮添加事件  
        sendOut.addActionListener(new ActionListener() {// 为按钮添加一个监听事件  
        
            public void actionPerformed(ActionEvent e) {// 重写actionPerformed方法  
                String content = inputField.getText();// 获取输入的文本信息  
                // 判断输入的信息是否为空  
                if(content!=null && !content.trim().equals("")){//trim见注释  
                    // 如果不为空，将输入的文本追加到到聊天窗口  
                    chatContent.append("小伙子："+content+"\n");  
                    handle= new Handling(content);
                     chatContent.append("机器人："+handle.getReply()+"\n");    
                }  
                else{// 如果为空，提示聊天信息不能为空  
             //   	int choice = JOptionPane.showConfirmDialog(null, "聊天信息不能为空");
                	JOptionPane.showMessageDialog(null, "聊天信息不能为空╭");  

                }  
                inputField.setText("");// 将输入的文本域内容置为空  
            }  
        });  
          
        inputPanel.add(inputField); // 将文本框添加到JPanel面板  
        inputPanel.add(sendOut);  // 将按钮添加到JPanel面板  
         
        this.add(showPanel,BorderLayout.CENTER);  
        this.add(inputPanel,BorderLayout.SOUTH);  
		
		setTitle("小助手");
		size = new Size() ;
		setSize(size.getWidth()/5, size.getHeight()/2);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);	
		setResizable(false);
		this.getContentPane().setBackground(Color.white);
		validate();
		setResizable(false);
		
	}

}
