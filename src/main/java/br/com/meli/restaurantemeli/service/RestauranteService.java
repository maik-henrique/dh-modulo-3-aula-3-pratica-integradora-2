package br.com.meli.restaurantemeli.service;

import br.com.meli.restaurantemeli.entity.Prato;
import br.com.meli.restaurantemeli.repository.RestauranteRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RestauranteService {
    private final RestauranteRepository restauranteRepository;

    public RestauranteService(RestauranteRepository restauranteRepository) {
        this.restauranteRepository = restauranteRepository;
    }


    public Optional<Prato> findPersonagemByContainingName(String nome) {
        return restauranteRepository.findByPratosContainName(nome);
    }
}
