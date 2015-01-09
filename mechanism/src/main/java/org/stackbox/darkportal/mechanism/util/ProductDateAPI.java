package org.stackbox.darkportal.mechanism.util;

import net.sf.json.JSONObject;

import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.stackbox.darkportal.mechanism.dto.ProductDateDTO;

public class ProductDateAPI extends AbstractPauthAPI {

	
			

	@Override
	public Object sendRequeset(String userName, String password, String product) {
		
		String requestUrl = URL_PRODUCT_DATE +"?" + buidParamsString(userName, password, product);
		
		System.out.print(requestUrl);
		PostMethod postMethod = new PostMethod(requestUrl);
		postMethod.setRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=UTF-8");
		
		int statusCode = 400;
		try {
			statusCode = HttpClientUtils.getInstance().executeMethod(postMethod);
			
			if(HttpStatus.SC_OK == statusCode) {
				String body = postMethod.getResponseBodyAsString();
				JSONObject jsonObject = JSONObject.fromObject(body);
				
				return (ProductDateDTO) jsonObject.toBean(jsonObject, ProductDateDTO.class);
				
				
			}
		} catch (Exception e) {
			return null;
		}
		return null;
	}

}
