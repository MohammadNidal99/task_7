package jo.secondstep.hrServises;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class MySqlConnection1Application {

	public static void main(String[] args) {
		SpringApplication.run(MySqlConnection1Application.class, args);
	}
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/greeting-javaconfig").allowedOrigins("http://localhost:8080");
				registry.addMapping("/greeting-javaconfig").allowedHeaders("*");
				
				registry.addMapping("/hrServices/**").allowedOrigins("http://localhost:8080");
				registry.addMapping("/hrServices/**").allowedHeaders("*");
			}
		};
	}

}
