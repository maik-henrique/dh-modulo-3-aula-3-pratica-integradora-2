package br.com.meli.restaurantemeli.controller;

import br.com.meli.restaurantemeli.service.RestauranteService;
import br.com.meli.restaurantemeli.entity.Prato;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class RestauranteController {
    private final RestauranteService restauranteService;

    public RestauranteController(RestauranteService restauranteService) {
        this.restauranteService = restauranteService;
    }

    @GetMapping("/{nome}")
    public ResponseEntity<?> findPratoByName(@PathVariable String nome) {
        Optional<Prato> optionalPersonagem = restauranteService.findPersonagemByContainingName(nome);

        if (optionalPersonagem.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(optionalPersonagem.get());
    }
}
