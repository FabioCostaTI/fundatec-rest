package br.com.fundatec.carro.Service;

import br.com.fundatec.carro.Repository.CarroRepository;
import br.com.fundatec.carro.model.Carro;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroService {
  private final CarroRepository carroRepository;
  public CarroService(CarroRepository carroRepository){
  this.carroRepository = carroRepository;
    }

    public List<Carro> listarCarros(String nome){

    return carroRepository.listarCarros(nome);
}
    public Carro consultar(Long id){
    return carroRepository.consultar(id);
}
}
