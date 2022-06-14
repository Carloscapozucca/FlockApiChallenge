package com.challenge.ChallengeAPI.services;

import com.challenge.ChallengeAPI.domain.Provincia;
import org.json.JSONException;

public interface IProvinciaService {

    Provincia getByName(String name) throws JSONException;
}
