package com.spc.jpa.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
 
/**
 * MessageUtil
 * @author lKJ
 */
public class MessageUtil {
 
    private MessageSourceAccessor messageSourceAccessor = null;
     
    public void setMessageSourceAccessor(MessageSourceAccessor msAcc) {
        this.messageSourceAccessor = msAcc;
    }
     
    public String getMessage(String key) {
    	if( null == RequestContextHolder.getRequestAttributes() ) {
    		return messageSourceAccessor.getMessage(key);
    	}
    	else {
    		Locale locale = LocaleContextHolder.getLocale();
    		return messageSourceAccessor.getMessage(key, locale);
    	}
    }
    
    public String encodeSHA256(String str){
    	String sha = ""; 
    	try{
    		MessageDigest sh = MessageDigest.getInstance("SHA-256"); 
    		sh.update(str.getBytes()); 
    		byte byteData[] = sh.digest();
    		StringBuffer sb = new StringBuffer(); 
    		for(int i = 0 ; i < byteData.length ; i++){
    			sb.append(Integer.toString((byteData[i]&0xff) + 0x100, 16).substring(1));
    		}
    		sha = sb.toString();
    		
    	}catch(NoSuchAlgorithmException e){
    		e.printStackTrace(); 
    		sha = null; 
    	}
    	return sha;
    }
}
