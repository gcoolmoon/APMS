package edu.mum.apms.security;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

/**
 *
 * @author sean.vichrak
 *
 */
@Component
public class CustomAuthentication implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(final HttpServletRequest request, final HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		response.setStatus(HttpServletResponse.SC_OK);
		GrantedAuthority grantedAuthority = authentication.getAuthorities()
			.iterator()
			.next();
		response.sendRedirect(StringUtils.substringAfter(grantedAuthority.getAuthority(), "_")
			.toLowerCase());
	}
}
