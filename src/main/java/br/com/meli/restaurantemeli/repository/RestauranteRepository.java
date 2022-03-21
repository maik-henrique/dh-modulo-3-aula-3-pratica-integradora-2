package br.com.meli.restaurantemeli.repository;

import br.com.meli.restaurantemeli.entity.Prato;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Repository
public class RestauranteRepository {
    private final List<Prato> pratos;
    private final ObjectMapper mapper;
    private static final String PRATOS_JSON_PATH = "src/main/resources/static/food.json";

    public RestauranteRepository(ObjectMapper mapper) {
        this.mapper = mapper;
        this.pratos = new ArrayList<>();
        initializePersonagens();
    }

    private void initializePersonagens() {
        try {
            TypeReference<List<Prato>> listTypeReference = new TypeReference<>() {};
            List<Prato> readPratos = mapper.readValue(Paths.get(PRATOS_JSON_PATH).toFile(), listTypeReference);
            pratos.addAll(readPratos);
        } catch (IOException  e) {
            e.printStackTrace();
        }
    }

    public Optional<Prato> findByPratosContainName(String name) {
        return this.pratos.stream().filter(p -> p.getName()
                .toLowerCase(Locale.ROOT).contains(name.toLowerCase(Locale.ROOT))).findFirst();
    }
}
