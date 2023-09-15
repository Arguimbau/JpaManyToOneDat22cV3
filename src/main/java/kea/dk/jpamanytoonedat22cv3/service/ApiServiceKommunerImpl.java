package kea.dk.jpamanytoonedat22cv3.service;

import kea.dk.jpamanytoonedat22cv3.model.Kommune;
import kea.dk.jpamanytoonedat22cv3.repository.KommuneRepository;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ApiServiceKommunerImpl implements ApiServiceKommuner
{
    private final RestTemplate restTemplate;
    private final KommuneRepository kommuneRepository;

    public ApiServiceKommunerImpl(RestTemplate restTemplate, KommuneRepository kommuneRepository){
        this.restTemplate = restTemplate;
        this.kommuneRepository = kommuneRepository;
    }

    private void saveKommuner(List<Kommune> kommuneList){
        kommuneList.forEach(kommune -> kommuneRepository.save(kommune));
    }
    @Override
    public List<Kommune> getKommuner() {
        String kommuneURL = "https://api.dataforsyningen.dk/kommuner";

        ResponseEntity<List<Kommune>> listResponseEntity =
                restTemplate.exchange(kommuneURL, HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<Kommune>>()
                        {});
        List<Kommune> kommuneList = listResponseEntity.getBody();
        saveKommuner(kommuneList);
        return kommuneList;
    }
    @Override
    public List<Kommune> getKommune() {
        String kommuneURL = "https://api.dataforsyningen.dk/kommuner/{kode}";

        ResponseEntity<List<Kommune>> listResponseEntity =
                restTemplate.exchange(kommuneURL, HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<Kommune>>()
                        {});
        List<Kommune> kommuneList = listResponseEntity.getBody();
        saveKommuner(kommuneList);
        return kommuneList;
    }


}
