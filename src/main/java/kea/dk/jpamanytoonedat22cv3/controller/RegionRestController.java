package kea.dk.jpamanytoonedat22cv3.controller;

import kea.dk.jpamanytoonedat22cv3.model.Kommune;
import kea.dk.jpamanytoonedat22cv3.model.Region;
import kea.dk.jpamanytoonedat22cv3.repository.KommuneRepository;
import kea.dk.jpamanytoonedat22cv3.repository.RegionRepository;
import kea.dk.jpamanytoonedat22cv3.service.ApiServiceKommuner;
import kea.dk.jpamanytoonedat22cv3.service.ApiServiceRegion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class RegionRestController
{
    @Autowired
    ApiServiceRegion apiServiceRegion;

    @Autowired
    RegionRepository regionRepository;


    @GetMapping("/getregioner")
    List<Region> getRegioner()
    {
        return apiServiceRegion.getRegioner();
    }

    @DeleteMapping("/deleteregion/{kode}")
    public ResponseEntity<String> deleteRegion(@PathVariable("kode") String kode)
    {
        Optional<Region> optionalRegion = regionRepository.findById(String.valueOf(kode));
        if(optionalRegion.isPresent()){
            regionRepository.deleteById(kode);
            return ResponseEntity.ok("Region Deleted");
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Region ikke fundet");
        }
    }


}
