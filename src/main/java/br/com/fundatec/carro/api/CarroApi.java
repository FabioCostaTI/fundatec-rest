package br.com.fundatec.carro.api;

import br.com.fundatec.carro.Service.CarroService;
import br.com.fundatec.carro.mapper.CarroMapper;
import br.com.fundatec.carro.model.Carro;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarroApi {

    private final CarroService carroService;
    private final CarroMapper carroMapper;
    public CarroApi(CarroService carroService, CarroMapper carroMapper) {
        this.carroService = carroService;
        this.carroMapper = carroMapper;
    }

    @GetMapping("/carros")
    public ResponseEntity<List<Carro>> getCarros(@RequestParam(required = false, defaultValue = "") String nome) {
        List<Carro> carros = carroService.listarCarros(nome);
        if (carros.size() == 0) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(carros);
        }
        List<CarroOutputDto> carroOutputDto = carroMapper.mapear(carros);
        return ResponseEntity.ok(carros);
    }
    @GetMapping("/carros/{id}")
    public ResponseEntity<Carro> getCarro(@PathVariable Long id){
        Carro carro = carroService.consultar(id);
        if (carro != null){
            CarroOutputDto carroOutputDto = carroMapper.mapear(carro);
            return ResponseEntity.ok(carroOutputDto);
        }
        return ResponseEntity.noContent().build();
    }
    @PostMapping("/carros")
    public ResponseEntity<CarroOutputDto> incluir(@RequestBody CarroInputDto carroInputDto){
        Carro carro = carroMapper.mapear(carroInputDto);
        carro = carroService.incluir(carro);
        CarroOutputDto carroOutputDto = carroMapper.mapear(carro);
        return ResponseEntity.status((HttpStatus.CREATED).body(carroOutputDto));
    }
}
