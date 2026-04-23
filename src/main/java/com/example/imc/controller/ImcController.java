package com.example.imc.controller;

import com.example.imc.dto.ImcRequest;
import com.example.imc.dto.ImcResponse;
import com.example.imc.service.ImcService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/imc")
public class ImcController {

    private final ImcService imcService;

    public ImcController(ImcService imcService){
        this.imcService = imcService;
    }

    @PostMapping("/calcular")
    public ResponseEntity<ImcResponse> calulcar(@RequestBody ImcRequest request){
        return ResponseEntity.ok(imcService.calcularImc(request));
    }

    @GetMapping("/ultimo-resultado")
    public ResponseEntity<ImcResponse> obterUltimoResultado(){

        ImcResponse ultimoResultado = imcService.obterUltimoResultado();
        if(ultimoResultado == null) return ResponseEntity.noContent().build();
        return  ResponseEntity.ok(ultimoResultado);

    }

}
