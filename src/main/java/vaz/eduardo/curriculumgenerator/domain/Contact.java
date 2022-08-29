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
public class Contact {
    @Id
    private Long id;

    private String phone;

    private String email;

}
