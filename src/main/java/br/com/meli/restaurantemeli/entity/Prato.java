package br.com.meli.restaurantemeli.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
public class Prato {

    private String name;
    private Integer calories;
}
