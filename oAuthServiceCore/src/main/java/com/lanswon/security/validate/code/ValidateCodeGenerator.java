/**
 * 
 */
package com.lanswon.security.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * 
 * @author GU-YW
 *
 */
public interface ValidateCodeGenerator {

	ValidateCode generate(ServletWebRequest request);
	
}
