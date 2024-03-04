package pe.bn.com.mwbm.transversal.configuracion.seguridad;

import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;


public class SecurityContextFacade {
	private static final Logger LOGGER = Logger.getLogger(SecurityContextFacade.class);
	
	public static boolean hasAuthenticatedUserRole(String role) {
		boolean  isUseRole = false;
		try {
			for (GrantedAuthority authority : getAuthenticatedUser().getAuthorities()) {
				if (authority.getAuthority().equals(role.toString())) {
					isUseRole = true;
				}
			}
			return isUseRole;
		} catch (Exception e) {
			LOGGER.error("Error - hasAuthenticatedUserRole : ",e);
		}
		return false;

	}

	public static Usuario getAuthenticatedUser() {
		Usuario user = null;
		try {
			Authentication aut = SecurityContextHolder.getContext()
					.getAuthentication();
			if (aut == null) {
				return null;
			} else {
				user = (Usuario) SecurityContextHolder.getContext()
						.getAuthentication().getDetails();
			}
		} catch (Exception e) {
			LOGGER.error("Error - getAuthenticatedUser : ",e);
		}
		return user;

	}

}