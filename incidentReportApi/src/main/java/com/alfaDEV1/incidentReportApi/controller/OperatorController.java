package com.alfaDEV1.incidentReportApi.controller;

import com.alfaDEV1.incidentReportApi.persistence.dto.OperatorDTO;
import com.alfaDEV1.incidentReportApi.persistence.entity.Operator;
import com.alfaDEV1.incidentReportApi.service.interfaces.IOperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/operators")

public class OperatorController {

    @Autowired
    private IOperatorService operatorService;

    @PostMapping("/saveOperator")
    public ResponseEntity<?> saveOperator(@RequestBody OperatorDTO operatorDTO) throws URISyntaxException {
        if (operatorDTO.getName().isBlank()) {
            return ResponseEntity.badRequest().build();
        }
        operatorService.saveOperator(Operator.builder()
                .name(operatorDTO.getName())
                .build());
        return ResponseEntity.created(new URI("/api/operator/saveOperator")).build();
    }

    @DeleteMapping("/deleteOperatorById/{id}")
    public ResponseEntity<?> deleteOperatorById(@PathVariable Long id) {
        Optional<Operator> operatorOptional = operatorService.findOperatorById(id);
        if (operatorOptional.isPresent()) {
            operatorService.deleteOperatorById(id);
            return ResponseEntity.ok("Register deleted");
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/findOperatorById/{id}")
    public ResponseEntity<?> findOperatorById(@PathVariable Long id) {
        Optional<Operator> operatorOptional = operatorService.findOperatorById(id);
        if (operatorOptional.isPresent()) {
            Operator operator = operatorOptional.get();
            OperatorDTO operatorDTO = OperatorDTO.builder()
                    .name(operator.getName())
                    .build();
            return ResponseEntity.ok(operatorDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findAllOperators")
    public ResponseEntity<?> findAllOperators() {
        List<OperatorDTO> operatorDTOList = operatorService.findAllOperators()
                .stream()
                .map(operator -> OperatorDTO.builder()
                        .name(operator.getName())
                        .build())
                .toList();
        return ResponseEntity.ok(operatorDTOList);
    }

}
