package pe.bn.com.mwbm.transversal.configuracion.seguridad;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import pe.bn.com.mwbm.transversal.util.constantes.ConstantesPagina;
import pe.bn.com.mwbm.transversal.util.constantes.ConstantesSeguridad;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	private static final Logger LOGGER = Logger.getLogger(SecurityConfiguration.class);
	private @Autowired CustomAuthenticationProvider customAuthenticationProvider;
	private @Autowired CustomFailureLoginHandler customFailureLoginHandler;

	@Override
	public void configure(WebSecurity webSecurity) throws Exception {
		try {
			webSecurity.ignoring().antMatchers("/resources/**");	
		} catch (Exception e) {
			LOGGER.error("Error - configure(WebSecurity webSecurity)  : ",e);
		}
		
	}

	protected void configure(HttpSecurity http) throws Exception  {
		try {
			http.authorizeRequests()
			/*INI - HU004 Miguel Garcia*/
			.antMatchers(ConstantesPagina.PAGINA_CONSULTA_CLAVE_SMS_ACTIVOS_CANAL).hasAnyAuthority(ConstantesSeguridad.ACCESO_CONSULTA_CLAVE_SMS_ACTIVOS_CANAL)
			/*FIN - HU004 Miguel Garcia*/
			
			/*HU001 César Barreto*/
			.antMatchers(ConstantesPagina.PAGINA_CONSULTA_CLAVE_SMS_GENERADAS).hasAnyAuthority(ConstantesSeguridad.ACCESO_CONSULTA_CLAVE_SMS_GENERADAS)
			/*HU001 César Barreto*/
			/*INICIO HU003 Piero Sánchez*/
			.antMatchers(ConstantesPagina.PAGINA_CONSULTA_CONSOLIDADO_CLIENTES_AFILIADOS).hasAnyAuthority(ConstantesSeguridad.ACCESO_CONSULTA_CLIENTES_AFILIADOS)
			/*FIN HU003 Piero Sánchez*/
			.antMatchers(ConstantesPagina.PAGINA_CONSULTA_OPERACIONES).hasAnyAuthority(ConstantesSeguridad.ACCESO_CONSULTA_OPERACIONES_REALIZADAS)
			.antMatchers(ConstantesPagina.PAGINA_CONSULTA_OPERACIONES_PRESTAMOS).hasAnyAuthority(ConstantesSeguridad.ACCESO_CONSULTA_OPERACIONES_PRESTAMOS)
			.antMatchers(ConstantesPagina.PAGINA_CONSULTA_AFILIACIONES).hasAnyAuthority(ConstantesSeguridad.ACCESO_CONSULTAR_AFILIACION)
			.antMatchers(ConstantesPagina.PAGINA_CONSULTA_RESUMENES_OPERATIVOS).hasAnyAuthority(ConstantesSeguridad.ACCESO_CONSULTA_RESUMENES_OPERATIVOS)
			.antMatchers(ConstantesPagina.PAGINA_CONSULTA_ACTIVIDADES_USUARIO).hasAnyAuthority(ConstantesSeguridad.ACCESO_CONSULTA_ACTIVIDADES_USUARIO)
			.antMatchers(ConstantesPagina.PAGINA_MANTENIMIENTO_PARAMETROS).hasAnyAuthority(ConstantesSeguridad.ACCESO_MANTENIMIENTO_PARAMETROS)
			.antMatchers(ConstantesPagina.PAGINA_GESTION_BANDEJA_INVITACIONES).hasAnyAuthority(ConstantesSeguridad.ACCESO_GESTION_BANDEJA_INVITACIONES)
			.antMatchers(ConstantesPagina.PAGINA_CONSULTA_OPERACIONES_MULTIRED_VIRTUAL).hasAnyAuthority(ConstantesSeguridad.ACCESO_CONSULTA_OPERACIONES_MULTIRED_VIRTUAL)
			.antMatchers(ConstantesPagina.PAGINA_CONSULTA_SELLO_SEGURIDAD).hasAnyAuthority(ConstantesSeguridad.ACCESO_CONSULTA_SELLO_SEGURIDAD)
			.antMatchers(ConstantesPagina.PAGINA_CONSULTA_MENSAJES_SATI).hasAnyAuthority(ConstantesSeguridad.ACCESO_CONSULTA_MENSAJES_SATI)
			.antMatchers(ConstantesPagina.PAGINA_MANTENIMIENTO_VALIDACION_IP).hasAnyAuthority(ConstantesSeguridad.ACCESO_MANTENIMIENTO__VALIDACION_IP)
			.antMatchers(ConstantesPagina.PAGINA_CONSULTA_TRANSACCION).hasAnyAuthority(ConstantesSeguridad.ACCESO_CONSULTA_TRANSACCION)
			.antMatchers(ConstantesPagina.PAGINA_CONSOLIDADO_TRANSACCION).hasAnyAuthority(ConstantesSeguridad.ACCESO_CONSOLIDADO_TRANSACCION)
			.antMatchers(ConstantesPagina.PAGINA_CONSULTA_ARCHIVO_DIARIO).hasAnyAuthority(ConstantesSeguridad.ACCESO_CONSULTA_ARCHIVO_DIARIO)
			.antMatchers(ConstantesPagina.PAGINA_CONSULTA_REGISTRO_AFILIACION).hasAnyAuthority(ConstantesSeguridad.ACCESO_CONSULTA_REGISTRO_AFILIACION)
			.antMatchers(ConstantesPagina.PAGINA_CONSULTA_IP_NO_PERMITIDA).hasAnyAuthority(ConstantesSeguridad.ACCESO_CONSULTA_IP_NO_PERMITIDA)
			.antMatchers(ConstantesPagina.PAGINA_CONSULTA_GENERACION_CLAVE_SEIS).hasAnyAuthority(ConstantesSeguridad.ACCESO_CONSULTA_GENERACION_CLAVE_SEIS)
			.antMatchers(ConstantesPagina.PAGINA_PRINCIPAL).authenticated().and().formLogin()
			.loginPage(ConstantesPagina.PAGINA_INDEX).usernameParameter(ConstantesPagina.LOGIN_PARAMETRO_USUARIO)
			.passwordParameter(ConstantesPagina.LOGIN_PARAMETRO_CONTRASENIA)
			.loginProcessingUrl(ConstantesPagina.LOGIN_URL_AUTENTICACION)
			.successHandler(authenticationSuccessHandler()).failureHandler(customFailureLoginHandler).and()
			.exceptionHandling().accessDeniedPage(ConstantesPagina.PAGINA_ACCESO_DENEGADO).and().logout()
			.logoutUrl(ConstantesPagina.LOGIN_URL_CERRAR_SESION).logoutSuccessUrl(ConstantesPagina.PAGINA_INDEX)
			.and().csrf().disable();
		} catch (Exception e) {
			LOGGER.error("Error - configure - Exception : " , e);
			throw new Exception(e);
		}
	}

	@Bean
	public AuthenticationSuccessHandler authenticationSuccessHandler() {
		return new CustomSuccessLoginHandler();
	}

	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		try {
			auth.authenticationProvider(customAuthenticationProvider);	
		} catch (Exception e) {
			LOGGER.error("Error - configure(AuthenticationManagerBuilder auth)  :",e);
		}
		
	}

}
