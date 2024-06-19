package br.com.localvarejo.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("docker")
public class ConfigDocker implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		
	}

}
