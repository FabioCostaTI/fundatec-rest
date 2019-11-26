package br.com.fundatec.carro.api;

import br.com.fundatec.carro.Service.CarroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
public class CarroApi {

    private final CarroService carroService;

    public CarroApi(CarroService carroService){
        this.carroService = carroService;
    }

    @GetMapping("carros")
    public ResponseEntity <List<String>> getCarros(@RequestParam (required = false, defaultValue = "") String nome){
        List<String> carros = carroService.listarCarros();
        System.out.println(nome);
        return ResponseEntity.ok(carros);
    }
}
