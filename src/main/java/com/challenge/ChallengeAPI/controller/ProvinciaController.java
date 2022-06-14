package com.challenge.ChallengeAPI.controller;

import com.challenge.ChallengeAPI.domain.Provincia;
import com.challenge.ChallengeAPI.services.IProvinciaService;
import lombok.extern.log4j.Log4j2;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequestMapping("api")
public class ProvinciaController {
    private IProvinciaService iProvinciaService;

    @Autowired
    public ProvinciaController(IProvinciaService iProvinciaService){
        this.iProvinciaService = iProvinciaService;
    }

    @GetMapping(value = "/provincia/{name}")
    public ResponseEntity<Provincia> findProvincia(@PathVariable String name) throws JSONException {

        log.info("GetFindProvincia Request");
        Provincia provincia = iProvinciaService.getByName(name);

        if(provincia!=null){
            return new ResponseEntity<>(provincia, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

}
