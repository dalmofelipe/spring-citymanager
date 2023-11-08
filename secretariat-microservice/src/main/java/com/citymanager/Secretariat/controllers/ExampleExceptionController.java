package com.citymanager.Secretariat.controllers;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citymanager.Secretariat.dtos.ExampleDTO;
import com.citymanager.Secretariat.dtos.SuccessDTO;
import com.citymanager.Secretariat.exceptions.business.ExampleNameRuleException;
import com.citymanager.Secretariat.exceptions.business.ExampleNameRuleWithParamsException;
import com.google.gson.Gson;

@RestController
@RequestMapping("/custom-exception-example")
public class ExampleExceptionController {

    private static final Gson gson = new Gson();

    @PostMapping("/validation")
    public ResponseEntity<ExampleDTO> exampleModelValidationEndpoint(@Validated @RequestBody ExampleDTO dto) {
        return ResponseEntity.ok(dto);
    }

    @PostMapping(value = "/business", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> exampleBusinessValidationEndpoint(@Validated @RequestBody ExampleDTO dto) {

        if (dto.getName().equalsIgnoreCase("params")) {
            throw new ExampleNameRuleWithParamsException("params");
        }

        if (!dto.getName().equalsIgnoreCase("business")) {
            throw new ExampleNameRuleException();
        }

        SuccessDTO successDTO = new SuccessDTO();
        successDTO.setMessage("Ok deu bom!");

        return ResponseEntity.ok(gson.toJson(successDTO));
    }
}

