package kea.dk.jpamanytoonedat22cv3.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Region
{

    @Id
    private String kode;
    private String navn;
    private String href;

    @OneToMany(mappedBy = "region", cascade = CascadeType.ALL)
    @JsonBackReference
    private Set<Kommune> kommuneSet = new HashSet<>();


    public Set<Kommune> getKommuneSet()
    {
        return kommuneSet;
    }

    public void setKommuneSet(Set<Kommune> kommuneSet)
    {
        this.kommuneSet = kommuneSet;
    }

    public String getKode()
    {
        return kode;
    }

    public void setKode(String kode)
    {
        this.kode = kode;
    }

    public String getNavn()
    {
        return navn;
    }

    public void setNavn(String navn)
    {
        this.navn = navn;
    }

    public String getHref()
    {
        return href;
    }

    public void setHref(String href)
    {
        this.href = href;
    }
}

