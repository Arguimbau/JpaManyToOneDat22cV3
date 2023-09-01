package kea.dk.jpamanytoonedat22cv3.repository;

import kea.dk.jpamanytoonedat22cv3.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegionRepository extends JpaRepository<Region, String>
{

}
