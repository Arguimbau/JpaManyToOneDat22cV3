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
import java.util.Optional;

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
    @PutMapping("/getkommunebykode/{kode}")
    public ResponseEntity<Kommune> putKomunne
            (@PathVariable("kode") String kode){
    Optional<Kommune> optionalKommune = kommuneRepository.findById(kode);
    if (optionalKommune.isPresent()){
        Kommune kommune = optionalKommune.get();
        kommune.setKode(kode);
        kommuneRepository.save(kommune);
        return ResponseEntity.ok(kommune);
    }else {
        return ResponseEntity.notFound().build();
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
