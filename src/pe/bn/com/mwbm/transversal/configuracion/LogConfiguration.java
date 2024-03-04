package pe.bn.com.mwbm.transversal.configuracion;

import org.springframework.beans.factory.config.MethodInvokingFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.Log4jConfigurer;

@SuppressWarnings("deprecation")
@Configuration
public class LogConfiguration {

	@Bean(name = "log4jIntializer")
	public MethodInvokingFactoryBean log4jIntializer() {
		MethodInvokingFactoryBean factoryBean = new MethodInvokingFactoryBean();
		factoryBean.setTargetClass(Log4jConfigurer.class);
		factoryBean.setStaticMethod("org.springframework.util.Log4jConfigurer.initLogging");
		String url = "classpath:/resources/logconfig.properties";
		Object[] arguments = new Object[1];
		arguments[0] = url;
		factoryBean.setArguments(arguments);
		return factoryBean;
	}
}