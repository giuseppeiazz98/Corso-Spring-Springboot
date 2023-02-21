package com.ntt.esercitazionespringboot.controller;

import com.ntt.esercitazionespringboot.domain.Course;
import com.ntt.esercitazionespringboot.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CourseController {
    @Autowired
    CourseRepository corsoRepository;

    @PostMapping("/corso") //inserimento e verifica il duplicato
    public ResponseEntity<Course> creazioneCorso (@RequestBody Course corso){
        List<Course> lista = corsoRepository.findAll();
        boolean b = false;
        for(Course c: lista){
            if(c.getId() == corso.getId()){
                b = true;
            }
        }if(b)
        {    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            Course corso1 = corsoRepository.save(corso);
            return new ResponseEntity<>(corso1, HttpStatus.CREATED);}
    }

    @GetMapping("/corso") //mostra tutte le righe
    public ResponseEntity<List<Course>> findAll(){
        List<Course> corsoList=corsoRepository.findAll();
        return new ResponseEntity<List<Course>>(corsoList, HttpStatus.OK);
    }

    @PutMapping("/corso/{id}") //aggiornamento della riga
    public ResponseEntity<?> updateCorso (@PathVariable long id, @RequestBody Course corso){
    Course corso2 = corsoRepository.save(corso);
    if(corso2.getId() == id)
    return new ResponseEntity<>(corso2, HttpStatus.CREATED);
    return new ResponseEntity<>(corso2, HttpStatus.NO_CONTENT);

    }
    @DeleteMapping("/corso/{id}") //cancellazione della riga
    public ResponseEntity<?> deleteCorso(@PathVariable long id){
        corsoRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/prefisso") //inserimento all'interno del database con il prefisso 'corso_'
    public ResponseEntity<?> createCorso(@RequestBody Course corso) {
        if (corso.getNomeCorso().substring(0, 6).equals("corso_") && corso.getNomeCorso().length() >= 8) {
            Course corso1 = corsoRepository.save(corso);
            return new ResponseEntity<>(corso1, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Nome errato", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/checkNumeri") //numero dei corsi presenti
    public ResponseEntity<?> getNum() {
        List<Course> lista = corsoRepository.findAll();
        int i = lista.size();
        return new ResponseEntity<>(i , HttpStatus.OK);
    }
    @GetMapping("/campi") //visualizza tutti i campi
    public ResponseEntity<?> getCampi() {
        List<Course> lista = corsoRepository.findAll();
        String campiC = null;
        String sc;
        for(Course c: lista){
            sc = c.toString();
            campiC = campiC +sc;    }
        return new ResponseEntity<>(campiC , HttpStatus.OK);
    }
    @GetMapping("/descrizione") //visualizza quelli con almeno 20 caratteri nella descrizione
    public ResponseEntity<?> getCourses() {
        List<Course> corsi = corsoRepository.findAll();
        List<Course> corsi1 = new ArrayList<>();
        int i=0;
        for(Course corso: corsi){
            if(corso.getDescCorso().length() > 20){
                corsi1.add(corso);        }
        }
        return new ResponseEntity<>(corsi1 , HttpStatus.OK);
    }
    @GetMapping("/controllo")//verifica se è presente il nome del corso con almeno 6 caratteri
    public ResponseEntity<?> getCourses1(){
        List<Course> corsi = corsoRepository.findAll();
        int conta = 0;
        for(Course c : corsi){
            if(c.getNomeCorso().substring(0,6).equals("corso_")){
                conta++;
            }
        }
        return new ResponseEntity<>(conta, HttpStatus.OK);
    }


}
