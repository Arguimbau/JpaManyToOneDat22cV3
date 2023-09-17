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
    @GetMapping("/kommuner")
    List<Kommune> getKommuner(){
        return apiServiceKommuner.getKommuner();
    }
    @GetMapping("/kommune/{kode}")
    public ResponseEntity<String> getKomunne(@PathVariable("kode") String kode) {
        try {
            kommuneRepository.findByKode(kode);
            return ResponseEntity.ok(kode);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error getting Kommune: " + e.getMessage());
        }
    }

    @PostMapping("/kommune/{kode}")
    public ResponseEntity<String> addKommune(@PathVariable("kode") String kode, @RequestBody Kommune kommune) {
        try {
            kommuneRepository.save( kommune );
            return ResponseEntity.ok("{}");
        } catch ( Exception e ) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error adding Kommune: " + e.getMessage());
        }
    }

    @PatchMapping("/kommune/{kode}")
    public ResponseEntity<String> editKommune(@PathVariable("kode") String kode, @RequestBody Kommune newKommune) {
        try {
            Kommune oldKommune = kommuneRepository.findByKode(kode);
            oldKommune.setNavn(newKommune.getNavn());
            kommuneRepository.save(oldKommune);
            return ResponseEntity.ok("{}");
        } catch ( Exception e ) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error editing Kommune: " + e.getMessage());
        }
    }

    @DeleteMapping("/kommune/{kode}")
    public ResponseEntity<String> deleteKommune(@PathVariable("kode") String kode) {
        try {
            kommuneRepository.deleteKommuneByKode(kode);
            return ResponseEntity.ok("{}");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting Kommuner in Region: " + e.getMessage());
        }
    }

}
