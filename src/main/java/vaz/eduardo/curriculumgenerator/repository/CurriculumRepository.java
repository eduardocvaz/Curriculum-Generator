package vaz.eduardo.curriculumgenerator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vaz.eduardo.curriculumgenerator.domain.Curriculum;

public interface CurriculumRepository extends JpaRepository<Curriculum, Long> {
}
