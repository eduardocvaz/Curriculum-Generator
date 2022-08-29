package vaz.eduardo.curriculumgenerator.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Education {
    @Id
    private Long id;

    private String title;

    private String description;
}
