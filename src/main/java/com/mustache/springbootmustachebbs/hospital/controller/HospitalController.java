package com.mustache.springbootmustachebbs.hospital.controller;

import com.mustache.springbootmustachebbs.hospital.domain.entity.Hospital;
import com.mustache.springbootmustachebbs.hospital.repository.HospitalRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/hospitals")
public class HospitalController {

    private final HospitalRepository hospitalRepository;

    public HospitalController(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    @GetMapping("/list")
    public String page(Model model,
                       @PageableDefault(size = 10, sort = "id") Pageable pageable) {
        Page<Hospital> hospitals = hospitalRepository.findAll(pageable);
        log.info("size : {}",hospitals.getSize());

        model.addAttribute("hospitals", hospitals);
        model.addAttribute("previous", pageable.previousOrFirst().getPageNumber());
        model.addAttribute("next", pageable.next().getPageNumber());
        return "hospitals/list";
    }
}
