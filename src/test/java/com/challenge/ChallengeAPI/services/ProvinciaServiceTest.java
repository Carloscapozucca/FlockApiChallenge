package com.challenge.ChallengeAPI.services;

import com.challenge.ChallengeAPI.domain.Provincia;
import lombok.extern.log4j.Log4j2;
import org.json.JSONException;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@Log4j2
@RunWith(SpringRunner.class)
@SpringBootTest
class ProvinciaServiceTest {

    @Autowired
    private IProvinciaService iProvinciaService;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    void getByName() throws JSONException {
        log.info("-----Comienzo del test-----");
        log.info("Service"+iProvinciaService.getByName("Misiones"));
        Provincia provincia = new Provincia(54,"Misiones",-54.6516966230371,-26.8753965086829);
        log.info(provincia);
        assertEquals(provincia, iProvinciaService.getByName("Misiones"));
        log.info("-----Fin del test-----");
    }
}