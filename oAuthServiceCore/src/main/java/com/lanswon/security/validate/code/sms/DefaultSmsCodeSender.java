/**
 * 
 */
package com.lanswon.security.validate.code.sms;

/**
 * 
 * @author GU-YW
 *
 */
public class DefaultSmsCodeSender implements SmsCodeSender {

	/* (non-Javadoc)
	 * @see com.imooc.security.core.validate.code.sms.SmsCodeSender#send(java.lang.String, java.lang.String)
	 */
	@Override
	public void send(String mobile, String code) {
		System.out.println("向手机"+mobile+"发送短信验证码"+code);
	}

}