package kea.dk.jpamanytoonedat22cv3.controller;

import kea.dk.jpamanytoonedat22cv3.model.Kommune;
import kea.dk.jpamanytoonedat22cv3.repository.KommuneRepository;
import kea.dk.jpamanytoonedat22cv3.service.ApiServiceKommuner;
import kea.dk.jpamanytoonedat22cv3.service.ApiServiceKommunerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    @DeleteMapping("/kommuneDelete/{regionId}")
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
