package sk.fri.uniza.sporthealthsystem;

import org.dozer.CustomConverter;
import org.dozer.DozerBeanMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import sk.fri.uniza.sporthealthsystem.core.mapper.InstantConverter;
import sk.fri.uniza.sporthealthsystem.module.buildings.apothecary.mapper.ApothecaryConverter;
import sk.fri.uniza.sporthealthsystem.module.buildings.institution.mapper.InstitutionConverter;
import sk.fri.uniza.sporthealthsystem.module.fileMedia.mapper.DBFileConverter;
import sk.fri.uniza.sporthealthsystem.module.location.m_adresa.mapper.AddressConverter;
import sk.fri.uniza.sporthealthsystem.module.location.m_krajina.mapper.CountryConverter;
import sk.fri.uniza.sporthealthsystem.module.location.m_kraj.mapper.RegionConverter;
import sk.fri.uniza.sporthealthsystem.module.location.m_okres.mapper.DistrictConverter;
import sk.fri.uniza.sporthealthsystem.module.operations.m_liecba.mapper.TreatmentConverter;
import sk.fri.uniza.sporthealthsystem.module.operations.m_operacia.mapper.SurgeryConverter;
import sk.fri.uniza.sporthealthsystem.module.persons.player.mapper.PlayerConverter;
import sk.fri.uniza.sporthealthsystem.module.pharmaceutics.m_liek.mapper.DrugConverter;
import sk.fri.uniza.sporthealthsystem.module.pharmaceutics.m_vyrobca_liekov.mapper.DrugMakerConverter;
import sk.fri.uniza.sporthealthsystem.user.mapper.UserBeanMappingBuilder;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableJpaAuditing
public class SportHealthSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SportHealthSystemApplication.class, args);
	}

	@Bean
	public DozerBeanMapper mapper() {
		List<CustomConverter> customConverters = new ArrayList<>();
		customConverters.add(new InstantConverter());

		DozerBeanMapper mapper = new DozerBeanMapper();
		mapper.setCustomConverters(customConverters);
		mapper.addMapping(new UserBeanMappingBuilder());
		mapper.addMapping(new DBFileConverter());
		mapper.addMapping(new CountryConverter());
		mapper.addMapping(new RegionConverter());
		mapper.addMapping(new DistrictConverter());
		mapper.addMapping(new AddressConverter());
		mapper.addMapping(new DrugMakerConverter());
		mapper.addMapping(new DrugConverter());
		mapper.addMapping(new ApothecaryConverter());
		mapper.addMapping(new InstitutionConverter());
		mapper.addMapping(new PlayerConverter());
		mapper.addMapping(new SurgeryConverter());
		mapper.addMapping(new TreatmentConverter());
		return mapper;
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
