package sk.fri.uniza.sporthealthsystem;

import org.dozer.CustomConverter;
import org.dozer.DozerBeanMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import sk.fri.uniza.sporthealthsystem.core.mapper.InstantConverter;
import sk.fri.uniza.sporthealthsystem.module.attributes.m_adresa_hraca.mapper.PlayerAddressConverter;
import sk.fri.uniza.sporthealthsystem.module.attributes.m_specializacia.mapper.SpecializationConverter;
import sk.fri.uniza.sporthealthsystem.module.attributes.m_specializacia_lekara.mapper.DocSpecializationConverter;
import sk.fri.uniza.sporthealthsystem.module.buildings.m_lekaren.mapper.ApothecaryConverter;
import sk.fri.uniza.sporthealthsystem.module.buildings.m_institut.mapper.InstitutionConverter;
import sk.fri.uniza.sporthealthsystem.module.buildings.m_poistovna.mapper.AssuranceConverter;
import sk.fri.uniza.sporthealthsystem.module.documents.m_zdravotny_zaznam.mapper.HealthRecordConverter;
import sk.fri.uniza.sporthealthsystem.module.fileMedia.mapper.DBFileConverter;
import sk.fri.uniza.sporthealthsystem.module.location.m_adresa.mapper.AddressConverter;
import sk.fri.uniza.sporthealthsystem.module.location.m_krajina.mapper.CountryConverter;
import sk.fri.uniza.sporthealthsystem.module.location.m_kraj.mapper.RegionConverter;
import sk.fri.uniza.sporthealthsystem.module.location.m_okres.mapper.DistrictConverter;
import sk.fri.uniza.sporthealthsystem.module.operations.m_liecba.mapper.TreatmentConverter;
import sk.fri.uniza.sporthealthsystem.module.operations.m_operacia.mapper.SurgeryConverter;
import sk.fri.uniza.sporthealthsystem.module.operations.m_operacie_pacienta.mapper.PacientOperationConverter;
import sk.fri.uniza.sporthealthsystem.module.persons.m_doktor.mapper.DoctorConverter;
import sk.fri.uniza.sporthealthsystem.module.persons.m_hrac.mapper.PlayerConverter;
import sk.fri.uniza.sporthealthsystem.module.persons.m_osetrujuci_doktor.mapper.DoctorCareConverter;
import sk.fri.uniza.sporthealthsystem.module.persons.m_osoba.mapper.PersonConverter;
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
		mapper.addMapping(new PersonConverter());
		mapper.addMapping(new AssuranceConverter());
		mapper.addMapping(new HealthRecordConverter());
		mapper.addMapping(new DocSpecializationConverter());
		mapper.addMapping(new SpecializationConverter());
		mapper.addMapping(new DoctorConverter());
		mapper.addMapping(new PlayerAddressConverter());
		mapper.addMapping(new DoctorCareConverter());
		mapper.addMapping(new PacientOperationConverter());

		return mapper;
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
