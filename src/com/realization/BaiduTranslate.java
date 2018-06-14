package com.realization;

import com.api.TransApi;

import net.sf.json.JSONObject;

/**
 * 
* @ClassName: BaiduTranslate  
* @Description: 调用百度API实现翻译功能
* @author chaoling  
* @date 2018年6月13日
 */
public class BaiduTranslate {  
	  
//    / 在平台申请的APP_ID 详见 http://api.fanyi.baidu.com/api/trans/product/desktop?req=developer  
    private static final String APP_ID = "";  
    private static final String SECURITY_KEY = "";  
    private String toTranslated; 
    private String alreadyTranslated;
    
    public String getToTranslated() {
		return toTranslated;
	}
	public void setToTranslated(String toTranslated) {
		this.toTranslated = toTranslated;
	}
	public String getAlreadyTranslated() {
		return alreadyTranslated;
	}
	public void setAlreadyTranslated(String alreadyTranslated) {
		this.alreadyTranslated = alreadyTranslated;
	}
	
	/*
	 * 构造函数  必须给toTranslated传参  获取需要翻译的语句
	 */
	public BaiduTranslate(String str) {
		this.toTranslated = str;
	}
	
	/**
	 * 
	* @Title: translate  
	* @Description: 翻译功能实现
	* @param @return   
	* @return String  
	* @throws
	 */
    public void translate() {
    	String str;
    	TransApi api = new TransApi(APP_ID, SECURITY_KEY);
    	 str=api.getTransResult(toTranslated, "auto", "zh");  
         JSONObject json=JSONObject.fromObject(str.toString());  
         String str1=json.get("trans_result").toString();  
         //去掉[]  
          str1=str1.replace("[", "");  
          str1=str1.replace("]", "");  
          JSONObject json1=JSONObject.fromObject(str1);  
          setAlreadyTranslated(json1.get("dst").toString());
    }
    
}