package vaz.eduardo.curriculumgenerator.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vaz.eduardo.curriculumgenerator.repository.CurriculumRepository;

@Service
@RequiredArgsConstructor
public class CurriculumService {

    private final CurriculumRepository curriculumRepository;

}
