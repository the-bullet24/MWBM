package pe.bn.com.mwbm.transversal.configuracion;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.poi.util.IOUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;


import pe.bn.com.mwbm.transversal.util.componentes.Parametros;
import pe.bn.com.mwbm.transversal.util.constantes.ConstantesGenerales;
import pe.bn.com.mwbm.transversal.ws.comp.bean.SistemaParametro;
import pe.bn.com.mwbm.transversal.ws.comp.service.ParametroInterfazKeyProxy;

@Configuration
@EnableTransactionManagement
public class CompConfig {

	private static final Logger LOGGER = Logger.getLogger(CompConfig.class);
	
	@Autowired Parametros parametros;
	
	@Bean
	public String asignarParametros() throws Exception {
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
		return "COMO EJECUTADO CORRECTAMENTE";
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
	private void setDatosWsService(String param, String valor){
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
	
	public void setDatosSistema(String param, String valor){
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
