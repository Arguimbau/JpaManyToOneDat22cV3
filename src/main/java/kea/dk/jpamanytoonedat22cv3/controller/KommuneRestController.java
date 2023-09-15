package kea.dk.jpamanytoonedat22cv3.controller;

import kea.dk.jpamanytoonedat22cv3.model.Kommune;
import kea.dk.jpamanytoonedat22cv3.repository.KommuneRepository;
import kea.dk.jpamanytoonedat22cv3.service.ApiServiceKommuner;
import kea.dk.jpamanytoonedat22cv3.service.ApiServiceKommunerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class KommuneRestController
{
    @Autowired
    ApiServiceKommunerImpl apiServiceKommuner;

    @Autowired
    KommuneRepository kommuneRepository;
    @GetMapping("/getkommuner")
    List<Kommune> getKommuner(){
        return apiServiceKommuner.getKommuner();
    }

    @GetMapping("/getkommunebykode/{kode}")
    public ResponseEntity<String> getkomunne(@PathVariable("kode") String kode)
    {
        Kommune kommune = new Kommune();
        try {
            kommuneRepository.findByKode(kode);
            return ResponseEntity.ok(kode + kommune.getNavn() + kommune.getRegion());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error getting Kommune");
        }
    }

    @DeleteMapping("/kommune/{regionId}")
    public ResponseEntity<String> deleteKommuneByRegionId(@PathVariable String regionId) {
        try {
            kommuneRepository.deleteKommuneByRegionKode(regionId);
            return ResponseEntity.ok("Kommuner in Region Deleted");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting Kommuner in Region");
        }
    }

    @GetMapping("/getkommune/{kode}")
    public ResponseEntity<List<Kommune>> getKommuneByRegion(@PathVariable("kode") String kode){
        List<Kommune> kommuneList = kommuneRepository.findByRegionKode(kode);
        return ResponseEntity.ok(kommuneList);
    }

}
