package com.borisavz.fakultetback.service;

import com.borisavz.fakultetback.dto.FakultetDiplomaDTO;
import com.borisavz.fakultetback.entity.StatusStudija;
import com.borisavz.fakultetback.repository.StatusStudijaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PublicStudentService {

    @Autowired
    private StatusStudijaRepository statusStudijaRepository;

    public List<FakultetDiplomaDTO> getDiplomeStudenta(String jmbg) {
        List<StatusStudija> diplome = statusStudijaRepository.getDiplomeByStudentJmbg(jmbg);

        return diplome.stream()
                .map(FakultetDiplomaDTO::fromStatusStudija)
                .collect(Collectors.toList());
    }
}
