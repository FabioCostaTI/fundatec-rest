package br.com.fundatec.carro.Repository;

import br.com.fundatec.carro.model.Carro;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class CarroRepository {
    private static List<Carro> listaCarros =
            Arrays.asList(new Carro(1L, "Mustang","MAX1000"), new Carro(2L,
                    "Uno de firma","abc1234"), new Carro(3L,"Chevette","ASD1235"));

    public List<Carro> listarCarros(String nome) {
        List <Carro> listaResultado= new ArrayList<>();

        for (Carro carro : listaCarros) {
            if (carro.getNome().toLowerCase().contains(nome.toLowerCase())){
                listaResultado.add(carro);

            }
        }
        return listaResultado;

    }

    public Carro consultar(Long id){
        for (Carro carro : listaCarros){
            if (carro.getId().equals(id)){
                return carro;
            }
        }
            return null;
    }

    public Carro incluir(Carro carro) {
        carro.setId(new Long(listaCarros.size() + 1));
        listaCarros.add(carro);
        return carro;
    }
}