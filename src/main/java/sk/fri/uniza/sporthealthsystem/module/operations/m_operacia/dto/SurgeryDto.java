package sk.fri.uniza.sporthealthsystem.module.operations.m_operacia.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.fri.uniza.sporthealthsystem.module.operations.m_operacie_pacienta.dto.PacientOperationDto;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "m_operacia")
public class SurgeryDto {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "popis")
    private String popis;

    @Column(name = "nazov")
    private String nazov;

    @OneToMany(mappedBy = "surgery", cascade = CascadeType.ALL)
    private Set<PacientOperationDto> pacientOperations;
}
