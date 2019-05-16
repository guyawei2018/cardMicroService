/**
 * 
 */
package com.lanswon.security.validate.code.sms;

/**
 * 
 * @author GU-YW
 *
 */
public interface SmsCodeSender {
	
	void send(String mobile, String code);

}
