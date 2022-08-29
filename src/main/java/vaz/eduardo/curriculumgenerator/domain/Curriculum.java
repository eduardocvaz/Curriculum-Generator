package vaz.eduardo.curriculumgenerator.domain;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "curriculum")
@EqualsAndHashCode(of = {"id"})
public class Curriculum {
    @Id
    private Long id;

    @OneToOne
    private Contact contact;

    @OneToOne
    private About about;

    @OneToMany
    private List<Education> educationList;

    @OneToMany
    private List<ProfessionalExperience> experienciaProfissionalList;





}
