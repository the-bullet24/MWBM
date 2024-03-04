package pe.bn.com.mwbm.transversal.configuracion.seguridad;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import pe.bn.com.mwbm.transversal.util.Texto;

import pe.bn.com.mwbm.transversal.util.componentes.Parametros;
import pe.bn.com.mwbm.transversal.util.constantes.ConstantesGenerales;
import pe.bn.com.mwbm.transversal.util.constantes.ConstantesSeguridad;
import pe.bn.com.mwbm.transversal.util.excepciones.LoginException;
import pe.bn.com.mwbm.transversal.ws.comp.bean.SistemaParametro;
import pe.bn.com.mwbm.transversal.ws.comp.service.ParametroInterfazKeyProxy;
import seguridad.service.AutenticaRegProxy;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	private static final Logger LOGGER = Logger.getLogger(CustomAuthenticationProvider.class);
	
	@Autowired Parametros parametros;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		return autenticacion(authentication);
	}

	private Authentication autenticacion(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = String.valueOf(authentication.getCredentials());
		String[] respuesta = null;
		try {
			respuesta = enviarAutentificacion(authentication).split("\\|");
		} catch (RemoteException e) {
			LOGGER.error("Error - autenticacion - RemoteException: ",e);
			throw new LoginException(ConstantesGenerales.WS_SIN_CONEXION);
		}

		if (respuesta[ConstantesGenerales.WS_CLAVES_POSICION_STATUS]
			.equals(ConstantesGenerales.WS_CLAVES_OPERACION_EXISTOSA)) {
			
			UsernamePasswordAuthenticationToken userToken = 
			new UsernamePasswordAuthenticationToken(username, password,
			obtenerPermisosSeguridad(respuesta[ConstantesGenerales.WS_CLAVES_POSICION_PERMISOS]));
			
			if(respuesta[ConstantesGenerales.WS_CLAVES_POSICION_NOMBRES].indexOf("/")>-1)
			{
			String nombreCompleto[] = respuesta[ConstantesGenerales.WS_CLAVES_POSICION_NOMBRES].split("/");

			Usuario usuario = new Usuario(username, password,
					obtenerPermisosSeguridad(respuesta[ConstantesGenerales.WS_CLAVES_POSICION_PERMISOS]),
					respuesta[ConstantesGenerales.WS_CLAVES_POSICION_CODIGO_EMPLEADO],
					respuesta[ConstantesGenerales.WS_CLAVES_POSICION_CODIGO_AREA],
					respuesta[ConstantesGenerales.WS_CLAVES_POSICION_AREA],
					nombreCompleto[ConstantesGenerales.WS_CLAVES_APMATERNO],
					nombreCompleto[ConstantesGenerales.WS_CLAVES_APPATERNO],
					nombreCompleto[ConstantesGenerales.WS_CLAVES_NOMBRE],
					respuesta[ConstantesGenerales.WS_CLAVES_POSICION_DNI],
					respuesta[ConstantesGenerales.WS_CLAVES_POSICION_CARGO],
					obtenerListaPermisos(respuesta[ConstantesGenerales.WS_CLAVES_POSICION_PERMISOS]));
			userToken.setDetails(usuario);
			
			}
			else{
				String nombreCompleto[] = respuesta[ConstantesGenerales.WS_CLAVES_POSICION_NOMBRES].split(" ");
				
				Usuario usuario = new Usuario(username, password,
						obtenerPermisosSeguridad(respuesta[ConstantesGenerales.WS_CLAVES_POSICION_PERMISOS]),
						respuesta[ConstantesGenerales.WS_CLAVES_POSICION_CODIGO_EMPLEADO],
						respuesta[ConstantesGenerales.WS_CLAVES_POSICION_CODIGO_AREA],
						respuesta[ConstantesGenerales.WS_CLAVES_POSICION_AREA],
						nombreCompleto[ConstantesGenerales.WS_CLAVES_APMATERNO],
						"",
						"",
						respuesta[ConstantesGenerales.WS_CLAVES_POSICION_DNI],
						respuesta[ConstantesGenerales.WS_CLAVES_POSICION_CARGO],
						obtenerListaPermisos(respuesta[ConstantesGenerales.WS_CLAVES_POSICION_PERMISOS]));
				userToken.setDetails(usuario);
			}
			
			try {
//				asignarParametros();
			} catch (Exception e) {
				LOGGER.error("Error - asignarParametros",e);
				e.printStackTrace();
			}
			return userToken;
		} else {
			LoginException e = new LoginException(respuesta[ConstantesGenerales.WS_CLAVES_POSICION_MENSAJE_FALLO_STATUS]);
			LOGGER.error("Error - autenticacion : ",e);
			throw new LoginException(respuesta[ConstantesGenerales.WS_CLAVES_POSICION_MENSAJE_FALLO_STATUS]);
		}
	}

	private String enviarAutentificacion(Authentication authentication) throws RemoteException {
		
		AutenticaRegProxy proxy = new AutenticaRegProxy();
		String usuario 			= authentication.getName();
		String password 		= Texto.aumentarCaracteres((String) authentication.getCredentials(),
								  ConstantesGenerales.WS_CLAVES_NUMERO_CARACTERES_PASSWORD);
		return proxy.claveHost(usuario + password + ConstantesGenerales.WS_CLAVES_APP + ConstantesGenerales.WS_CLAVES_CONSTID);
	}

	private List<GrantedAuthority> obtenerPermisosSeguridad(String permisos) {
		List<GrantedAuthority> AUTHORITIES = new ArrayList<GrantedAuthority>();
		for (int i = 0; i < permisos.length() - 3; i = i + 3) {

			if (ConstantesSeguridad.OPCION_ACC.containsKey(permisos.substring(i, i + 3))) {
				AUTHORITIES.add(new SimpleGrantedAuthority(
				ConstantesSeguridad.OPCION_ACC.get(permisos.substring(i, i + 3))));
			}
		}
		return AUTHORITIES;
	}

	private List<String> obtenerListaPermisos(String permisos) {
		List<String> listaPermisos = new ArrayList<String>();
		for (int i = 0; i < permisos.length() - 3; i = i + 3) {
			listaPermisos.add(permisos.substring(i, i + 3));
		}
		return listaPermisos;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
	
	public void asignarParametros() throws Exception {
		try {
			byte[] llave = leerClavesSegurades();
			if (llave != null) {
				ParametroInterfazKeyProxy proxyComp = new ParametroInterfazKeyProxy();
				SistemaParametro sParam = proxyComp.datoParametroService(
						ConstantesGenerales.SISTEMA, ConstantesGenerales.CUENTA,
						ConstantesGenerales.SEMILLA, llave,ConstantesGenerales.IDUSUARIO);
				
				LOGGER.info("Codigo de proceso : " + sParam.getProceso().getCodigo());
				parametros.setErrorComp(sParam.getProceso().getCodigo());
				parametros.setDesErrorComp(sParam.getProceso().getDescripcion());

				if (sParam.getProceso().getCodigo().equals("00000")) {
					
					for (int n = 0; n < sParam.getGrupoParametro().getGrupoParametro().size(); n++) {
						int cantFilas = sParam.getGrupoParametro().getGrupoParametro().get(n).getParametro().getParametro().size() - 1;
						
						for (int j = 0; j < cantFilas + 1; j++) {
							String param = sParam.getGrupoParametro()
												 .getGrupoParametro()
												 .get(n).getParametro()
											 	 .getParametro().get(j).getAliasParam();
							
							String valor = sParam.getGrupoParametro()
									.getGrupoParametro().get(n).getParametro()
									.getParametro().get(j).getValorParam();
							
							System.out.println("param:"+param);
							System.out.println("valor:"+valor);
							
							/*if (!param.equals("")) {
								this.setParametros(sParam.getGrupoParametro().getGrupoParametro().get(n)
												.getAliasGrupo(), param, valor);
							}*/
						}
					}
					LOGGER.info("Asignacion de parametros correctamente.");
				} else {
					LOGGER.error("No se pudo obtener los datos Comp");
				}				
				
			} else {
				LOGGER.error("Error con la lectura del archivo clavesegurades.key");
			}
		} catch (Exception e) {
			LOGGER.error("Error - asignarParametros  : ",e);
		}
	}

	
	public byte[] leerClavesSegurades() {
		try {
			FileInputStream fis = new FileInputStream(new File(ConstantesGenerales.RUTA_FILE_CLAVESEGURADES));
			return IOUtils.toByteArray(fis);
		} catch (IOException e) {
			LOGGER.error("Error en la lectura del archivo: ", e);
			return null;
		}
	}
/*
	private void setParametros(String aliasGrupo, String param, String valor) {
	
		if (aliasGrupo.equals(ConstantesGenerales.WSSERVICE_GRUPO_WS)){
			this.setDatosWsService(param, valor);
		}
		if (aliasGrupo.equals(ConstantesGenerales.WSSISTEMA_GRUPO_SISTEMA)){
			this.setDatosSistema(param, valor);
		}
		if (aliasGrupo.equals(ConstantesGenerales.WSSISTEMA_GRUPO_SERVICES)){
			this.setDatosServices(param, valor);
		}
	}
	*/
/*	private void setDatosWsService(String param, String valor){
		if(param.equals(ConstantesGenerales.WSSERVICE_PARAM_CONSAFILLMADE)){
			parametros.setConsAfillMade(valor);
		} else if(param.equals(ConstantesGenerales.WSSERVICE_PARAM_INTCONSTOKEN)){
			parametros.setIntConsToken(valor);
		} else if (param.equals(ConstantesGenerales.WSSERVICE_PARAM_MSLISTDOC)){
			parametros.setMsListDoc(valor);
		} else if (param.equals(ConstantesGenerales.WSSERVICE_PARAM_MSLISTOPE)){
			parametros.setMsListOpe(valor);
		} else if (param.equals(ConstantesGenerales.WSSERVICE_PARAM_CONSSOFTOKEN)){
			parametros.setConsSofToken(valor);
		} else if (param.equals(ConstantesGenerales.WSSERVICE_PARAM_CONSOFTOKENCLIENT)){
			parametros.setConsSofTokenUsed(valor);
		} else if (param.equals(ConstantesGenerales.WSSERVICE_PARAM_CONSAFFILCLIENT)){
			parametros.setConsAffilClient(valor);
		}else if (param.equals(ConstantesGenerales.WSSERVICE_PARAM_CSCANAL)){
			parametros.setConsCsCanal(valor);
		}else if (param.equals(ConstantesGenerales.WSSERVICE_PARAM_CONSOLIOPEGROUP)){
			parametros.setConsoliOpeGroup(valor);
		}else if (param.equals(ConstantesGenerales.WSSERVICE_PARAM_CONSOLIENTITY)){
			parametros.setConsoliEntity(valor);
		} else if (param.equals(ConstantesGenerales.WSSERVICE_PARAM_MSLISTMOTDESAFI)){
			parametros.setMsListMotDesafi(valor);
		}
	}
	*/
/*	public void setDatosSistema(String param, String valor){
		if(param.equals(ConstantesGenerales.WSSISTEMA_PARAM_DATEINITSOFTOKEN)){
			parametros.setDateInitSofToken(valor);
		}
	}
	
	public void setDatosServices(String param, String valor){
		if(param.equals(ConstantesGenerales.WSSISTEMA_PARAM_URLSERVIDORCORREO)){
			parametros.setUrlServidorCorreo(valor);
		}
	}*/

}