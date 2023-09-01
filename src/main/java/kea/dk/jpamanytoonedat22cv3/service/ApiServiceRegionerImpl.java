package kea.dk.jpamanytoonedat22cv3.service;

import kea.dk.jpamanytoonedat22cv3.model.Region;
import kea.dk.jpamanytoonedat22cv3.repository.RegionRepository;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;
@Service
public class ApiServiceRegionerImpl implements ApiServiceRegion{

    private final RestTemplate restTemplate;
    private final RegionRepository regionRepository;

    public ApiServiceRegionerImpl(RestTemplate restTemplate, RegionRepository regionRepository){
        this.restTemplate = restTemplate;
        this.regionRepository = regionRepository;
    }

    private void saveRegioner(List<Region> regions){
        //for (Region region:regions) {
          //  regionRepository.save(region);
        //}
        //Lambda Udtryk
        regions.forEach(region -> regionRepository.save(region));
    }
    @Override
    public List<Region> getRegioner() {
        String regionURL = "https://api.dataforsyningen.dk/regioner";

        ResponseEntity<List<Region>> listResponseEntity =
                restTemplate.exchange(regionURL, HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<Region>>()
                        {});
        List<Region> regions = listResponseEntity.getBody();
        saveRegioner(regions);
        return regions;
    }

}
