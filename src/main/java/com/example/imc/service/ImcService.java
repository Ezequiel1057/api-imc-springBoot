package com.example.imc.service;

import com.example.imc.dto.ImcRequest;
import com.example.imc.dto.ImcResponse;
import com.example.imc.storage.LastResultStorage;
import com.example.imc.util.ImcCalculator;
import org.springframework.stereotype.Service;

@Service
public class ImcService {

    private final LastResultStorage lastResultStorage;


    public ImcService(LastResultStorage lastResultStorage) {
        this.lastResultStorage = lastResultStorage;
    }

    public ImcResponse calcularImc(ImcRequest request){
        double alturaCm = ImcCalculator.calculaAlturaCm(request.altura());
        double pesoIdeal = ImcCalculator.calcularPesoIdeal(alturaCm, request.peso());
        double imc = ImcCalculator.calcularImc(request.altura(), request.peso());
        String interpretacao = ImcCalculator.interpretarImc(imc);

        ImcResponse response = new ImcResponse(imc, interpretacao, pesoIdeal,alturaCm);
        lastResultStorage.salvarResultado(response);
        return  response;
    }


    public ImcResponse obterUltimoResultado(){
        return lastResultStorage.obterUltimoResultado();
    }

}
