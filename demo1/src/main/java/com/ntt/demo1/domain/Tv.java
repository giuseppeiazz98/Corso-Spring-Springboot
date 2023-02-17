package com.ntt.demo1.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tv extends Monitor {
    private long id;
    private int canale;
    private ArrayList<Canale> canali = new ArrayList<>();

}
