package pe.bn.com.mwbm.presentacion.modelo;

import java.io.Serializable;

import pe.bn.com.mwbm.transversal.configuracion.seguridad.Usuario;





public class SeguridadModel implements Serializable {

	private static final long serialVersionUID = 1L;
	private Usuario usuario;

	public SeguridadModel(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
