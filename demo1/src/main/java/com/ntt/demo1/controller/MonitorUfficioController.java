package com.ntt.demo1.controller;

import com.ntt.demo1.domain.MonitorUfficio;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/monitorUfficio")

public class MonitorUfficioController {

    @GetMapping("/") //get serve per la lettura di ciò che inseriamo
    public ResponseEntity<MonitorUfficio> returnMonitorUfficio(){
        MonitorUfficio monitorUfficio = new MonitorUfficio();
        Set<String> inputs = new HashSet<>();
        inputs.add("hdmi");
        monitorUfficio.setInput("avg");
        monitorUfficio.setColore("giallo");
        monitorUfficio.setMarca("dell");
        monitorUfficio.setInputs(inputs);
        return new ResponseEntity<>(monitorUfficio, HttpStatus.OK);

    }
    @PostMapping("/")
    public ResponseEntity<?> createMonitor(@RequestBody MonitorUfficio monitorUfficio){
        MonitorUfficio monitorUfficio1 = monitorUfficio;
        return new ResponseEntity<>(monitorUfficio1, HttpStatus.CREATED);
    }
    @PutMapping("{marca}")
    public ResponseEntity<?> updateMonitor(@PathVariable String marca, @RequestBody MonitorUfficio monitorUfficio){
        MonitorUfficio monitorUfficio2 = new MonitorUfficio();
        Set<String> inputs = new HashSet<>();
        inputs.add("hdmi");
        monitorUfficio2.setInput("avg");
        monitorUfficio2.setColore("nero");
        monitorUfficio2.setMarca("dell");
        monitorUfficio2.setInputs(inputs);
        if(monitorUfficio2.getMarca().equals(marca))
            return new ResponseEntity<>(monitorUfficio, HttpStatus.OK);
            return new ResponseEntity<>(monitorUfficio, HttpStatus.CREATED);

    }
    @DeleteMapping("/{marca}")
    public ResponseEntity<?> deleteMonitor(@PathVariable String marca, @RequestBody MonitorUfficio monitorUfficio){
        System.out.println("Monitor ufficio è stato eliminato: " +marca);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
