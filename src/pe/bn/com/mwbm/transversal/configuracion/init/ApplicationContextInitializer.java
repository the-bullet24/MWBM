package pe.bn.com.mwbm.transversal.configuracion.init;

import org.springframework.context.annotation.ComponentScan;	
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages={"pe.bn.com.mwbm.transversal.configuracion","pe.bn.com.mwbm.transversal.util.anotaciones"})
public class ApplicationContextInitializer {

}
