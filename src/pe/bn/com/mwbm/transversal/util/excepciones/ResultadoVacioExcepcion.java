package pe.bn.com.mwbm.transversal.util.excepciones;

public class ResultadoVacioExcepcion extends Exception{
	private static final long serialVersionUID = 1L;

	public ResultadoVacioExcepcion() {
		// TODO Auto-generated constructor stub
	}

	public ResultadoVacioExcepcion(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ResultadoVacioExcepcion(String mensaje, Throwable causa) {
		super(mensaje, causa);
	}
}
