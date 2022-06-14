package com.challenge.ChallengeAPI.services;

import com.challenge.ChallengeAPI.domain.Provincia;
import lombok.extern.log4j.Log4j2;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.TrustAllStrategy;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.client.HttpClient;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.json.JSONArray;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

@Log4j2
@Service
public class ProvinciaService implements IProvinciaService {

    @Value("${challenge.api.url}")
    private String url;

    private ResponseEntity<String> getResponse(String name) {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        HttpEntity<Provincia> entity = new HttpEntity<>(httpHeaders);
        HttpClient httpClient = null;
        try {
            httpClient = HttpClients.custom()
                    .setSSLContext(new SSLContextBuilder().loadTrustMaterial(null, TrustAllStrategy.INSTANCE).build())
                    .setSSLHostnameVerifier(NoopHostnameVerifier.INSTANCE)
                    .build();
        } catch (NoSuchAlgorithmException | KeyStoreException | KeyManagementException e) {
            e.printStackTrace();
        }
        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        assert httpClient != null;
        requestFactory.setHttpClient(httpClient);

        RestTemplate clientHtpp = new RestTemplate(requestFactory);
        ResponseEntity<String> response = clientHtpp.exchange(url + "?nombre=" + name, HttpMethod.GET, entity, String.class);

        return response;
    }

    @Override
    public Provincia getByName(String name) throws JSONException {

        Provincia provincia = new Provincia();

        JSONObject jsonObject = new JSONObject(getResponse(name).getBody());
        JSONArray jsonArray = jsonObject.getJSONArray("provincias");

        try {
            provincia.setName(jsonArray.getJSONObject(0).getString("nombre"));
            provincia.setId(jsonArray.getJSONObject(0).getInt("id"));
            provincia.setLat(jsonArray.getJSONObject(0).getJSONObject("centroide").getDouble("lat"));
            provincia.setLon(jsonArray.getJSONObject(0).getJSONObject("centroide").getDouble("lon"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return provincia;
    }

}
