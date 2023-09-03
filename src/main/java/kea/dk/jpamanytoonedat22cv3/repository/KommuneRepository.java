package kea.dk.jpamanytoonedat22cv3.repository;

import jakarta.transaction.Transactional;
import kea.dk.jpamanytoonedat22cv3.model.Kommune;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KommuneRepository extends JpaRepository<Kommune, String>
{
    @Modifying
    @Transactional
    @Query("DELETE FROM Kommune k WHERE k.region.kode = :regionKode")
    void deleteKommuneByRegionKode(@Param("regionKode") String regionKode);

    List<Kommune> findByRegionKode(String regionKode);



}
