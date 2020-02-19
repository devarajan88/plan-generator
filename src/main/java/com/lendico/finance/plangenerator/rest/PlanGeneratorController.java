package com.lendico.finance.plangenerator.rest;

import com.lendico.finance.plangenerator.bean.InputParameter;
import com.lendico.finance.plangenerator.bean.ResponseEntity;
import com.lendico.finance.plangenerator.service.PlanGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class PlanGeneratorController {

    @Autowired
    private PlanGeneratorService planGeneratorService;


    @PostMapping("/generate-plan")
    public List<ResponseEntity> calculateAnnuity(@RequestBody InputParameter inputs) {
        List<ResponseEntity> result = planGeneratorService.calculate(inputs);
        return result;
    }

}
