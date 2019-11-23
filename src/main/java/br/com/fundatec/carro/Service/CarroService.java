package br.com.fundatec.carro.Service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CarroService {
    public List<String> listarCarros(){
        List<String> carros= Arrays.asList("Mustang","Fusca","Fumbica","Celta","Camaro","Uno de firma");
        return carros;   }
}
