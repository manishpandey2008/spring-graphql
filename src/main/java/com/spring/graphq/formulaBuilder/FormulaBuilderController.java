package com.spring.graphq.formulaBuilder;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/formula-builder")
public class FormulaBuilderController {

    private final FormulaBuilderService formulaBuilderService;

    public FormulaBuilderController(FormulaBuilderService formulaBuilderService) {
        this.formulaBuilderService = formulaBuilderService;
    }

    @PostMapping("/build")
    @CrossOrigin(origins = "*")
    public Double FormulaBuilder(@RequestBody FormulaBuilderInput formulaBuilderInput){
        return formulaBuilderService.result(formulaBuilderInput.finalFormula);
    }
}
