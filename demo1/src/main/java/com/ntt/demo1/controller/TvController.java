package com.ntt.demo1.controller;


import com.ntt.demo1.domain.Canale;
import com.ntt.demo1.domain.MonitorUfficio;
import com.ntt.demo1.domain.Tv;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/tv")
public class TvController {

    @GetMapping("/")
    public ResponseEntity<Tv> returnTv(){
        Tv tv = new Tv();
        tv.setId(1);
        tv.setCanale(1);
        tv.setColore("nero");
        tv.setMarca("hp");
        Canale canale1= new Canale("rai1", 1, false);
        Canale canale2= new Canale("rai2", 2, false);
        Canale canale3= new Canale("rai3", 3, false);
        ArrayList<Canale> canali = new ArrayList<>();
        canali.add(canale1);
        canali.add(canale3);
        canali.add(canale3);
        tv.setCanali(canali);
        return new ResponseEntity<>(tv, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<?> createTv(@RequestBody Tv tv){
        Tv tv1 = tv;
        return new ResponseEntity<>(tv1, HttpStatus.CREATED);
    }
    @PutMapping("{id}")
    public ResponseEntity<?> updateTv(@PathVariable("id") long id_tv, @RequestBody Tv monitorTv) {
        Tv tv2 = new Tv();
        tv2.setId(2);
        tv2.setCanale(2);
        tv2.setColore("blu");
        tv2.setMarca("samsung");
        Canale canale1= new Canale("rai1", 1, false);
        Canale canale2= new Canale("rai2", 2, false);
        Canale canale3= new Canale("rai3", 3, false);
        ArrayList<Canale> canali = new ArrayList<>();
        canali.add(canale1);
        canali.add(canale3);
        canali.add(canale3);
        tv2.setCanali(canali);
        if (tv2.getId() == id_tv)
            return new ResponseEntity<>(monitorTv, HttpStatus.OK);
        return new ResponseEntity<>(monitorTv, HttpStatus.NO_CONTENT);
    }


}
