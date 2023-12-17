package com.alfaDEV1.incidentReportApi.controller;

import com.alfaDEV1.incidentReportApi.persistence.dto.ServiceDTO;
import com.alfaDEV1.incidentReportApi.persistence.entity.Service;
import com.alfaDEV1.incidentReportApi.service.interfaces.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/services")

public class ServiceController {
    @Autowired
    private IServiceService serviceService;

    @PostMapping("/saveService")
    public ResponseEntity<?> saveService(@RequestBody ServiceDTO serviceDTO) throws URISyntaxException {
        if (serviceDTO.getName().isBlank()) {
            return ResponseEntity.badRequest().build();
        }
        serviceService.saveService(Service.builder()
                .name(serviceDTO.getName())
                .description(serviceDTO.getDescription())
                .build());
        return ResponseEntity.created(new URI("/api/services/saveService")).build();
    }

    @DeleteMapping("/deleteServiceById/{id}")
    public ResponseEntity<?> deleteServiceById(@PathVariable Long id) {
        Optional<Service> serviceOptional = serviceService.findServiceById(id);
        if (serviceOptional.isPresent()) {
            serviceService.deleteServiceById(id);
            return ResponseEntity.ok("Register deleted");
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/findServiceById/{id}")
    public ResponseEntity<?> findServiceById(@PathVariable Long id) {
        Optional<Service> serviceOptional = serviceService.findServiceById(id);
        if (serviceOptional.isPresent()) {
            Service service = serviceOptional.get();
            ServiceDTO serviceDTO = ServiceDTO.builder()
                    .name(service.getName())
                    .description(service.getDescription())
                    .build();
            return ResponseEntity.ok(serviceDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findAllServices")
    public ResponseEntity<?> findAllServices() {
        List<ServiceDTO> serviceDTOList = serviceService.findAllServices()
                .stream()
                .map(service -> ServiceDTO.builder()
                        .name(service.getName())
                        .description(service.getDescription())
                        .build())
                .toList();
        return ResponseEntity.ok(serviceDTOList);
    }
}
