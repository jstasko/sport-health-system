package sk.fri.uniza.sporthealthsystem;

import org.dozer.DozerBeanMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import sk.fri.uniza.sporthealthsystem.module.healthCard.HealthCardBeanMappingBuilder;
import sk.fri.uniza.sporthealthsystem.user.mapper.UserBeanMappingBuilder;

@SpringBootApplication
public class SportHealthSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SportHealthSystemApplication.class, args);
	}

	@Bean
	public DozerBeanMapper mapper() {
		DozerBeanMapper mapper = new DozerBeanMapper();
		mapper.addMapping(new UserBeanMappingBuilder());
		mapper.addMapping(new HealthCardBeanMappingBuilder());
		return mapper;
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
