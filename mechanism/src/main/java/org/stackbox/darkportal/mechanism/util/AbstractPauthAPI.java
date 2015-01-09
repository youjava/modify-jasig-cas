package org.stackbox.darkportal.mechanism.util;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.stackbox.darkportal.mechanism.dto.AdditionalParamItem;

/**
 * Pauth抽象API
 * @author stackbox
 *
 */
public abstract class AbstractPauthAPI {
	
	/**
	 * pauth 接口地址
	 */
	protected static final String BASE_URL = "http://119.90.0.227";
	protected static final String URL_AUTH = BASE_URL + "/api/auth";
	protected static final String URL_PRODUCT_DATE = BASE_URL + "/api/getUseProductDate";
	protected static final String URL_Product_PERMISSION = BASE_URL + "/api/getProductPermission";
	protected static final String URL_PRODUCT_DATA = BASE_URL + "/api/getProductData";
	protected static final String URL_RESOURCE = BASE_URL + "/api/getResource";
	protected static final String URL_DATAREG = BASE_URL + "/api/getDataRegList";
	protected static final String URL_UPLOADLOG = BASE_URL + "/api/uploadLog";
	protected static final String URL_CHGPWD = BASE_URL + "/api/chgPassword";
	
	public abstract Object sendRequeset(String userName, String password, String product);
	
	protected String buidParamsString(String userName, String password, String product, AdditionalParamItem ...addtionOptions) {
		
		List <String> paramPairs = new LinkedList<String>();
		
		paramPairs.add(String.format("%s=%s", "userName", userName ));
		paramPairs.add(String.format("%s=%s", "password", password));
		paramPairs.add(String.format("%s=%s", "product_identity", product));
		
		if(null != addtionOptions && addtionOptions.length > 0) {
			for(AdditionalParamItem item : addtionOptions) {
				paramPairs.add(String.format("%s=%s", item.getKey(), item.getValue()));
			}
		}
		
		return StringUtils.join(paramPairs, "&");
	}
	
	
}
