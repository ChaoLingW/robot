package com.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.auxiliary.Size;
import com.handle.Handling;
import com.realization.BaiduTranslate;
/**
 * 
* @ClassName: Translate  
* @Description: 翻译窗体的实现
* @author chaoling  
* @date 2018年6月13日
 */
public class Translate extends JFrame{
	
	Size size ;
	JTextArea inputContent;
	JTextArea outputContent;
	JButton conversion; 
	JScrollPane inputPanel;
	JScrollPane outputPanel;
	JPanel panel ;
	BaiduTranslate baiduTranslate;
	/**
	 * 构造函数
	 */
	public Translate() {
		size = new Size() ;
		this.setLayout(new BorderLayout());  //边界布局管理器
		inputContent = new JTextArea();
		inputContent.setColumns(40);
		inputContent.setLineWrap(true);
		inputPanel = new JScrollPane(inputContent); 
		
		outputContent = new JTextArea();
		outputContent.setColumns(40);
		inputContent.setLineWrap(true);
		outputPanel = new JScrollPane(outputContent); 
		
		conversion = new JButton("翻译");
		conversion.setSize(67, 40);
		conversion.setLocation(0, (size.getHeight()/4-40));
		panel = new JPanel();
		panel.setLayout(null);
		panel.add(conversion);
		
		this.add(inputPanel,BorderLayout.WEST);
		this.add(outputPanel,BorderLayout.EAST);
		this.add(panel,BorderLayout.CENTER);
		
		conversion.addActionListener(new ActionListener() {// 为按钮添加一个监听事件  
            public void actionPerformed(ActionEvent e) {// 重写actionPerformed方法  
                String content = inputContent.getText();// 获取输入的文本信息  
                // 判断输入的信息是否为空  
                if(content!=null && !content.trim().equals("")){//trim见注释  
                	
                    // 如果不为空，将输入的文本追加到到聊天窗口  
                	baiduTranslate = new BaiduTranslate(content);
                	baiduTranslate.translate();
                	outputContent.append(baiduTranslate.getAlreadyTranslated());    
                }  
                else{// 如果为空，提示聊天信息不能为空  
                	JOptionPane.showMessageDialog(null, "翻译内容不能为空╭");  

                }   
            }  
        });  
		
		setTitle("小助手——翻译");
		setSize(size.getWidth()/2, size.getHeight()/2);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);	
		setResizable(false);
		this.getContentPane().setBackground(Color.white);
		validate();
		setResizable(false);
	}
	
}
