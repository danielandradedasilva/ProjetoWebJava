package br.com.stackx.projetoweb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration // informar para o Spring que ? uma classe de configura??es
@EnableWebMvc // habilitar o MVC no Spring
@ComponentScan(basePackages = { "br.com.stackx.projetoweb" })
public class ProjetoWebConfig implements WebMvcConfigurer {

	@Bean
	public InternalResourceViewResolver resolver() {
		System.out.println("### INICIALIZANDO ProjotoWebConfig ###");

		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/WEB-INF/pages/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
}