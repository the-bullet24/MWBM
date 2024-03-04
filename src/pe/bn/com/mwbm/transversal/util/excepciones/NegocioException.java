package pe.bn.com.mwbm.transversal.util.excepciones;

public class NegocioException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public NegocioException() {
    }
	public NegocioException(String message) {
        super(message);
    }

	public NegocioException(String mensaje, Throwable causa) {
		super(mensaje, causa);
	}
}
