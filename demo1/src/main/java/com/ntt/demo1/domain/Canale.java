package com.ntt.demo1.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Canale {
    private String nome;
    private int numeroCanale;
    private boolean status;
}
