package pe.bn.com.mwbm.presentacion.controlador;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;

import pe.bn.com.mwbm.presentacion.modelo.loginModel;
import pe.bn.com.mwbm.transversal.util.UsefulWebApplication;
import pe.bn.com.mwbm.transversal.util.excepciones.LoginException;

@Controller("loginController")
@Scope("view")
public class LoginController implements PhaseListener, Serializable {

	/**
	 * 
	 */
	private static final Logger LOGGER = Logger.getLogger(LoginController.class);
	private static final long serialVersionUID = 1L;
	private loginModel loginModel;

	@PostConstruct
	public void init() {
	}

	public void iniciarSesion() {
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		RequestDispatcher dispatcher = ((ServletRequest) context.getRequest())
				.getRequestDispatcher("/login_autenticacion");
		try {
			dispatcher.forward((ServletRequest) context.getRequest(), (ServletResponse) context.getResponse());
			System.out.println("**********CRENDECIALES LOGIN:**********"+context.getRequest());
		} catch (ServletException e1) {
			LOGGER.error("Error - iniciarSesion - ServletException : ", e1);
			e1.printStackTrace();
		} catch (IOException e1) {
			LOGGER.error("Error - iniciarSesion - IOException : ", e1);
			e1.printStackTrace();
		}
		FacesContext.getCurrentInstance().responseComplete();
	}

	public boolean estaLogeado() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if ((!(auth instanceof AnonymousAuthenticationToken))) {
			this.redireccionar();
			return true;
		}
		return false;

	}

	private void redireccionar() {
		try {
			UsefulWebApplication.redireccionar("/principal.jsf");
			UsefulWebApplication.actualizarComponente("loginForm");
		} catch (IOException e) {
			LOGGER.error("Error - redireccionar - IOException : ", e);
			e.printStackTrace();
		}
	}

	public loginModel getLoginModel() {
		return loginModel;
	}

	public void setLoginModel(loginModel loginModel) {
		this.loginModel = loginModel;
	}

	@Override
	public void afterPhase(PhaseEvent arg0) {

	}

	@Override
	public void beforePhase(PhaseEvent arg0) {
		try {
			Exception e = (Exception) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
					.remove(WebAttributes.AUTHENTICATION_EXCEPTION);

			FacesContext ctx = FacesContext.getCurrentInstance();
			HttpServletRequest servletRequest = (HttpServletRequest) ctx.getExternalContext().getRequest();
			String fullURI = servletRequest.getRequestURI();

			if (fullURI.equals("/SABM/index.jsf")) {
				if (e instanceof LoginException) {
					UsefulWebApplication.mostrarMensajeJSF(3, e.getMessage(), "");
				}
				UsefulWebApplication.actualizarComponente("form");
			}
		} catch (Exception e) {
			LOGGER.error("Error - beforePhase -Exception : ",e);
		}
		
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RENDER_RESPONSE;
	}

}
