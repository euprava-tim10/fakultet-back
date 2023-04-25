package com.borisavz.fakultetback.service;

import com.borisavz.fakultetback.entity.Obavestenje;
import com.borisavz.fakultetback.entity.ProcitanoObavestenje;
import com.borisavz.fakultetback.repository.ObavestenjeRepository;
import com.borisavz.fakultetback.repository.ProcitanoObavestenjeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static com.borisavz.fakultetback.security.AuthHelper.authUser;

@Service
public class ObavestenjeService {

    @Autowired
    private ObavestenjeRepository obavestenjeRepository;

    @Autowired
    private ProcitanoObavestenjeRepository procitanoObavestenjeRepository;

    public List<Obavestenje> getObavestenja() {
        ProcitanoObavestenje procitanoObavestenje = ProcitanoObavestenje.builder()
                .studentId(authUser().getId())
                .procitano(new Date())
                .build();

        procitanoObavestenjeRepository.save(procitanoObavestenje);

        return obavestenjeRepository.getByStudentId(authUser().getId());
    }

    public int getBrojNeprocitanihObavestenja() {
        long studentId = authUser().getId();

        Optional<ProcitanoObavestenje> optionalProcitanoObavestenje = procitanoObavestenjeRepository.findById(studentId);

        if(optionalProcitanoObavestenje.isEmpty())
            return obavestenjeRepository.getBrojNotifikacija(studentId);

        ProcitanoObavestenje procitanoObavestenje = optionalProcitanoObavestenje.get();

        return obavestenjeRepository.getBrojNeprocitanih(studentId, procitanoObavestenje.getProcitano());
    }
}
