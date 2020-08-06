package com.lambdaschool.countries.models;

import javax.persistence.*;


@Entity
@Table(name = "countries")
public class Country
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO);

    private long cid;
    private String cname;
    private long population;
    private long landmasskm2;
    private int medianage;




    public Country(
        String cname,
        long population,
        long landmasskm2,
        int medianage)
    {
        this.cname = cname;
        this.population = population;
        this.landmasskm2 = landmasskm2;
        this.medianage = medianage;
    }

    public Country()
    {
    }

    public long getCid()
    {
        return cid;
    }


    public String getCname()
    {
        return cname;
    }

    public void setCname(String cname)
    {
        this.cname = cname;
    }

    public long getPopulation()
    {
        return population;
    }

    public void setPopulation(long population)
    {
        this.population = population;
    }

    public long getLandmasskm2()
    {
        return landmasskm2;
    }

    public void setLandmasskm2(long landmasskm2)
    {
        this.landmasskm2 = landmasskm2;
    }

    public int getMedianage()
    {
        return medianage;
    }

    public void setMedianage(int medianage)
    {
        this.medianage = medianage;
    }

    @Override
    public String toString()
    {
        return "Country{" +
            "cid=" + cid +
            ", cname='" + cname + '\'' +
            ", population=" + population +
            ", landmasskm2=" + landmasskm2 +
            ", medianage=" + medianage +
            '}';
    }
}
