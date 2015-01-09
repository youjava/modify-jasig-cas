package org.stackbox.darkportal.mechanism;

import java.util.HashMap;
import java.util.Map;

import org.jasig.cas.authentication.principal.Credentials;
import org.jasig.cas.authentication.principal.CredentialsToPrincipalResolver;
import org.jasig.cas.authentication.principal.Principal;
import org.jasig.cas.authentication.principal.SimplePrincipal;

public class DarkportalCredentialsToPrincipalResolver implements
		CredentialsToPrincipalResolver {

	private static final String ATTR_USERNAME = "username";
	private static final String ATTR_PASSWORD = "password";
	
	@Override
	public Principal resolvePrincipal(Credentials credentials) {
		final DarkPortalCredentials mzCredentials = (DarkPortalCredentials)credentials;
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(ATTR_USERNAME, mzCredentials.getUsername());
		map.put(ATTR_PASSWORD, mzCredentials.getPassword());
		
		
		SimplePrincipal simple = new SimplePrincipal(mzCredentials.getUsername(), map);
		
		System.out.println("------>AttrSize : "  + simple.getAttributes().size());
		
		return simple;
	
	}

	@Override
	public boolean supports(Credentials credentials) {
		return credentials != null
				&& DarkPortalCredentials.class.isAssignableFrom(credentials
						.getClass());
	}

}
