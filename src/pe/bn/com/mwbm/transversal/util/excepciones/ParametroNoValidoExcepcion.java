package pe.bn.com.mwbm.transversal.util.excepciones;

public class ParametroNoValidoExcepcion extends Exception {
	private static final long serialVersionUID = 1L;

	public ParametroNoValidoExcepcion() {
		// TODO Auto-generated constructor stub
	}

	public ParametroNoValidoExcepcion(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ParametroNoValidoExcepcion(String mensaje, Throwable causa) {
		super(mensaje, causa);
	}
}
