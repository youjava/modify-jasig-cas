package org.stackbox.darkportal.mechanism;

import java.security.NoSuchAlgorithmException;

import org.jasig.cas.authentication.handler.AuthenticationException;
import org.jasig.cas.authentication.handler.AuthenticationHandler;
import org.jasig.cas.authentication.principal.Credentials;
import org.stackbox.darkportal.mechanism.dto.ProductDateDTO;
import org.stackbox.darkportal.mechanism.util.AbstractPauthAPI;
import org.stackbox.darkportal.mechanism.util.ProductDateAPI;
import org.stackbox.darkportal.mechanism.util.SecurityUtil;

public class DarkportalAuthenticationHandler implements AuthenticationHandler {

	
	@Override
	public boolean authenticate(Credentials credentials)
			throws AuthenticationException {

		DarkPortalCredentials mzCrendential = (DarkPortalCredentials) credentials;
		
		AbstractPauthAPI api = new ProductDateAPI();
		try {
			ProductDateDTO obj = (ProductDateDTO) api.sendRequeset(mzCrendential.getUsername(),SecurityUtil.md5(mzCrendential.getPassword()),mzCrendential.getProduct());
			if(obj.getStatus_code().equals(200)) {
				return true;
			}
		} catch (NoSuchAlgorithmException e) {
			return false;
		}
	
		return false;
	}

	@Override
	public boolean supports(Credentials credentials) {
		// TODO Auto-generated method stub
		return credentials != null
				&& DarkPortalCredentials.class.isAssignableFrom(credentials
						.getClass());
	}

}
