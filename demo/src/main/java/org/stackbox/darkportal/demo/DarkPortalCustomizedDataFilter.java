package org.stackbox.darkportal.demo;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jasig.cas.client.authentication.AttributePrincipal;
import org.jasig.cas.client.util.AssertionHolder;
import org.jasig.cas.client.validation.Assertion;

public class DarkPortalCustomizedDataFilter implements Filter {

	public static final String CONST_PAUTH_HASDATA_ASSERTION = "_const_pauth_hasdata_assertion_";
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		Assertion assertion = AssertionHolder.getAssertion();
		AttributePrincipal attrPrincipal = assertion.getPrincipal();
		
		
		
		if(req.getSession().getAttribute(CONST_PAUTH_HASDATA_ASSERTION) == null) {
			System.out.println("CurrentUser:"  + attrPrincipal.getName());
			
			Map map = attrPrincipal.getAttributes();
			
			System.out.println(map.toString());
			System.out.println("CurrentPwd:"  + map.get("password"));
			System.out.println("CurrentPwd:"  + map.get("username"));
			preAndPostRequest(req,resp,attrPrincipal);
			req.getSession().setAttribute(CONST_PAUTH_HASDATA_ASSERTION, CONST_PAUTH_HASDATA_ASSERTION);
		}
		
		chain.doFilter(request, response);

	}

	@Override
	public void destroy() {
	
	}
	
	/**
	 * 获取项目根路径
	 * @param request
	 * @return
	 */
	private String getRootPath(HttpServletRequest request) {
		String basePath = request.getScheme() + "://"
				+ request.getServerName() + ":" + request.getServerPort()
				+ request.getContextPath() + "/";
		return basePath;
	}
	
	/**
	 * 使session失效
	 * @param request
	 */
    private void invalidateSession(HttpServletRequest request) {
    	HttpSession session = request.getSession();
    	session.invalidate();
    }
    
    /**
     * 自定义pauth相关操作
     */
    private void preAndPostRequest(HttpServletRequest req, HttpServletResponse resp, AttributePrincipal attrPrincipal) {
    	
 	   	

    	
    }

}
