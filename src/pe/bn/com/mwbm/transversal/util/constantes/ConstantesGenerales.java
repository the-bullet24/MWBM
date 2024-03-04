package pe.bn.com.mwbm.transversal.util.constantes;



public class ConstantesGenerales {

	public static final int TIEMPO_MAXIMO_INACTIVIDAD = 1000 * 60 * 30;

	public static final String MENSAJE_SESION_EXPIRADA = "Estimado Usuario, su tiempo de sesión ha expirado";

	public static final String WS_SIN_CONEXION = "No se puede conectar al servicio web de autentica";

	public static final String DESC_VERSIONES = "Versiones";
	public static final String DESC_MENSAJES = "Mensajes";



	/**
	 * Constantes para los mensajes de validacion, operacion exitosa
	 */
	public static final int SEVERITY_INFO = 1;
	public static final int SEVERITY_WARN = 2;
	public static final int SEVERITY_ERROR = 3;
	public static final int SEVERITY_FATAL = 4;

	public static final String TITULO_MENSAJE = "Mensaje";



	// Listar Servicios
	public static final String TRANS_LISTA_SERVICIOS = "SP05";
	// Obtener Formulario
	public static final String TRANS_FORMUL_PAGOS = "SP06";

	// Constantes servicio web autentica
	public static String WS_CLAVES_OPERACION_EXISTOSA = "00";
	public static int LONGITUD_USUARIO = 4;
	public static int LONGITUD_CLAVE = 8;
	public static int WS_CLAVES_NUMERO_CARACTERES_PASSWORD = 8;
	public static String WS_CLAVES_CONSTID = "00";
	public static String WS_CLAVES_APP = "SIOP";
	public static int WS_CLAVES_POSICION_STATUS = 0;
	public static int WS_CLAVES_POSICION_MENSAJE_FALLO_STATUS = 1;
	public static int WS_CLAVES_POSICION_CODIGO_AREA = 1;
	public static int WS_CLAVES_POSICION_CODIGO_EMPLEADO = 3;
	public static int WS_CLAVES_POSICION_PERMISOS = 4;
	public static int WS_CLAVES_POSICION_NOMBRES = 5;
	public static int WS_CLAVES_POSICION_AREA = 6;
	public static int WS_CLAVES_POSICION_CARGO = 11;
	public static int WS_CLAVES_POSICION_DNI = 9;

	
	
	/*// GRUPO WS/SERVICE
	public final static String WSSERVICE_GRUPO_WS = "WS/SERVICIO";
	public final static String WSSERVICE_PARAM_CONSAFILLMADE = "msIntegracionClaveSMS.afillmade";
	public final static String WSSERVICE_PARAM_INTCONSTOKEN = "msIntegracionClaveSMS.int.constoken";
	public final static String WSSERVICE_PARAM_MSLISTDOC = "msList.listDoc";
	public final static String WSSERVICE_PARAM_MSLISTOPE = "msList.tipoOperacion";
	public final static String WSSERVICE_PARAM_CONSSOFTOKEN = "msIntegracionClaveSMS.cons.softoken";
	public final static String WSSERVICE_PARAM_CONSAFFILCLIENT = "cons.consoliaffilclave";
	public final static String WSSERVICE_PARAM_CONSOFTOKENCLIENT = "cons.consoliusedclave";
	public final static String WSSERVICE_PARAM_CSCANAL= "msIntegracionClaveSMS.cons.cscanal";
	public final static String WSSERVICE_PARAM_CONSOLIOPEGROUP= "cons.consoliopegroup";
	public final static String WSSERVICE_PARAM_CONSOLIENTITY= "cons.consolientity";
	public final static String WSSERVICE_PARAM_MSLISTMOTDESAFI = "msList.listMotDesafi";
	
	// GRUPO SISTEMA
	public final static String WSSISTEMA_GRUPO_SISTEMA = "SISTEMA";
	public final static String WSSISTEMA_PARAM_DATEINITSOFTOKEN = "dateinit.softoken";
	
	// GRUPO SERVICES
	public final static String WSSISTEMA_GRUPO_SERVICES = "SERVICES";
	public final static String WSSISTEMA_PARAM_URLSERVIDORCORREO = "url.servidorCorreo";
		*/
		
	// Constantes para los segmentos de nombre completo
	public static int WS_CLAVES_NOMBRE = 2;
	public static int WS_CLAVES_APPATERNO = 1;
	public static int WS_CLAVES_APMATERNO = 0;

	// Constantes de parametros
	public static final String TITULO_ERROR_AGREGAR_PARAMETRO = "ERROR AGREGAR PARAMETRO";
	public static final String TITULO_ERROR_EDITAR_PARAMETRO = "ERROR EDITAR PARAMETRO";
	public static final String TITULO_ERROR_OBTENER_PARAMETRO = "ERROR AL OBTENER PARAMETROS";

	public static final String ERROR_NEGOCIO_AGREGAR_PARAMETRO = "Error al agregar un parametro en el negocio";
	public static final String ERROR_NEGOCIO_EDITAR_PARAMETRO = "Error al editar un parametro en el negocio";
	public static final String ERROR_NEGOCIO_OBTENER_PARAMETRO = "Error al obtener un parametro en el negocio";

	public static final String ERROR_NEGOCIO_LOGICA_GENERAL = "Error de logica general en el negocio, consulte con el administrador";

	
	// Ambientes
	public static final String AMBIENTE_DESA = "desa";
	public static final String AMBIENTE_CERT = "cert";
	public static final String AMBIENTE_PROD = "prod";

	// Funcionalidades accionadas
	public static final String MANT_PARAMETROS = "Mantenimiento de Parametros";
	public static final String CONS_OPERACIONES_REALIZADAS = "Consultar operaciones realizadas";
	public static final String CONS_AFILIACIONES = "Consultar afiliaciones";
	public static final String CONS_RESUMENES_OPERATIVOS = "Consultar resumenes operativos";
	public static final String CONS_ACTIVIDADES_USUARIO = "Consultar actividades de usuario";


	// PARAMETRO COMP
	public static final String SISTEMA = "SIOP";
	public static final String CUENTA = "USERSIOP";
	public static final String SEMILLA = "semillaSIOP";
	public static final String IDUSUARIO = "USERSIOP";
	
	// PARAMETRO COMP MS
	public static final String CUENTA_MS = "MS/CONSULTING";
		
		
	public static final int BUSQUEDA_NO_REALIZADA = 0;
	
	//Datos varios
	public static final String NINGUNO = "Ninguno";
	public static final String ACTIVOS = "1";

//	public static final String RUTA_FILE_CLAVESEGURADES = "C:/opt/software/key/mwbm/clavesegurades.key";
	public static final String RUTA_FILE_CLAVESEGURADES = "/opt/software/key/jsfsiop/clavesegurades.key";
	
    //Constantes Servicio Consulta
	//APPLICATION="MWBM"
	public static final String APPLICATION = "SABM";
	//CHANNEL="WEB"
	public static final String CHANNEL="ATM";
	//CHANNELCODE="WEB"
	public static final String CHANNELCODE="1";

	
	/*
	codRequerimiento 
	public static final String COD_REQ_PAGO_TARJETA_DIFERIDA_OTRO_BANCO= "117";
	
	*//**CODIGO DE TEXTOS DE AYUDA**//*		
	public static final String COD_HLP_CORREO		= "00000";
	
	public static final String CONST_ACTIVO			= "1";
	public static final String CONST_INACTIVO		= "0";*/

/*	public static final String IP_PATTERN = "/^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$/";
	public static final String IP_PATTERN_ERROR_MESSAGE = "Dato ingresado no es una IP Válida";
	public static final String MENSAJE_IP_EXITO = "Nuevo Rango IP Agregago";*/
	
	 /* public  static final String IPV4_PATTERN_ALLOW_LEADING_ZERO =
	            "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
	            "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
	            "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
	            "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
	  
	  
	  //falg de lazy
	  public static String FLAG_BUSQUEDA = "";*/
}
