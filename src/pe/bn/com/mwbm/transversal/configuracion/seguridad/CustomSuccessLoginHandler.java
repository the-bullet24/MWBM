package pe.bn.com.mwbm.transversal.configuracion.seguridad;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import pe.bn.com.mwbm.transversal.util.UsefulWebApplication;

@Component
public class CustomSuccessLoginHandler implements AuthenticationSuccessHandler {
	private static final Logger LOGGER = Logger.getLogger(CustomSuccessLoginHandler.class);
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		try {
			UsefulWebApplication.redireccionar("/principal.jsf");	
		} catch (Exception e) {
			LOGGER.error("Error - onAuthenticationSuccess  : ",e);
		}
		
	}
}