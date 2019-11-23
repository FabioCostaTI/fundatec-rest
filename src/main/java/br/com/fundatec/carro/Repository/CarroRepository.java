package br.com.fundatec.carro.Repository;

import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class CarroRepository {
    public List<String> listarCarros(){
        List<String> carros= Arrays.asList("Mustang","Fusca","Fumbica","Celta","Camaro","Uno de firma");
        return carros;
    }

}
