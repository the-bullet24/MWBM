package pe.bn.com.mwbm.presentacion.controlador;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import pe.bn.com.mwbm.presentacion.modelo.SeguridadModel;
import pe.bn.com.mwbm.transversal.util.UsefulWebApplication;
import pe.bn.com.mwbm.transversal.util.constantes.ConstantesGenerales;
import pe.bn.com.mwbm.transversal.util.constantes.ConstantesPagina;

@Controller("seguridadController")
@Scope("view")
public class SeguridadController implements Serializable {

	private static final Logger LOGGER = Logger.getLogger(SeguridadController.class);
	private static final long serialVersionUID = 1L;

	private SeguridadModel seguridadModel;

	@PostConstruct
	public void init() {
		try {
			seguridadModel = new SeguridadModel(UsefulWebApplication.obtenerUsuario());	
		} catch (Exception e) {
			LOGGER.error("Error - init : ",e);
		}
		
		// permisos = seguridadModel.getPermisos();
		// crearMenuPrincSecun();
	}

	public void cerrarSesion() throws IOException {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		SecurityContextHolder.clearContext();
		UsefulWebApplication.redireccionar(ConstantesPagina.PAGINA_INDEX);
	}

	public void forzarCierreSesion() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		SecurityContextHolder.clearContext();
	}

	/**
	 * @return tiempo de inactividad maximo de una sesión
	 */
	public int tiempoMaximoInactividad() {
		return ConstantesGenerales.TIEMPO_MAXIMO_INACTIVIDAD;
	}

	/**
	 * @return mensaje que mostrara el dialogo luego de que expire la sesión
	 */
	public String mensajeSesionExpirada() {
		return ConstantesGenerales.MENSAJE_SESION_EXPIRADA;
	}

	/**
	 * @return url de la pagina de inicio de sesión
	 */
	public String paginaLogin() {
		return ConstantesPagina.PAGINA_INDEX;
	}

	public boolean renderizar(String valor) {
		for (GrantedAuthority sg : SecurityContextHolder.getContext().getAuthentication().getAuthorities()) {
			if (valor.equals(sg.getAuthority())) {
				return true;
			}
		}
		return false;
	}

	public void redireccionar(ActionEvent event) {
		String pagina = (String) event.getComponent().getAttributes().get("pagina");
		try {
			UsefulWebApplication.redireccionar(pagina);
		} catch (IOException e) {
			LOGGER.error("Error - redireccionar - IOException : ", e);
			e.printStackTrace();
		}
	}

	public SeguridadModel getseguridadModel() {
		return seguridadModel;
	}

	public void setseguridadModel(SeguridadModel seguridadModel) {
		this.seguridadModel = seguridadModel;
	}

}
