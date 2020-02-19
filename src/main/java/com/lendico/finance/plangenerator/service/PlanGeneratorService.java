package com.lendico.finance.plangenerator.service;

import com.lendico.finance.plangenerator.bean.InputParameter;
import com.lendico.finance.plangenerator.bean.ResponseEntity;
import com.lendico.finance.plangenerator.model.PlanGenerator;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PlanGeneratorService {

    public List<ResponseEntity> calculate(InputParameter inputs) {
        PlanGenerator planGenerator = new PlanGenerator();
        return planGenerator.calculate(inputs);
    }
}
