package com.borisavz.fakultetback.service;

import com.borisavz.fakultetback.entity.Obavestenje;
import com.borisavz.fakultetback.entity.ProcitanoObavestenje;
import com.borisavz.fakultetback.repository.ObavestenjeRepository;
import com.borisavz.fakultetback.repository.ProcitanoObavestenjeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.borisavz.fakultetback.security.AuthHelper.authUser;

@Service
public class ObavestenjeService {

    @Autowired
    private ObavestenjeRepository obavestenjeRepository;

    @Autowired
    private ProcitanoObavestenjeRepository procitanoObavestenjeRepository;

    public List<Obavestenje> getObavestenja() {
        return obavestenjeRepository.getByStudentId(authUser().getId());
    }

    public int getBrojNeprocitanihObavestenja() {
        long studentId = authUser().getId();

        ProcitanoObavestenje procitanoObavestenje = procitanoObavestenjeRepository.getById(studentId);

        return obavestenjeRepository.getBrojNeprocitanih(studentId, procitanoObavestenje.getProcitano());
    }
}
