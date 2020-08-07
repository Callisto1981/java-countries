package com.lambdaschool.countries.models;

import javax.persistence.*;


@Entity
@Table(name = "countries")
public class Country
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long countryid;
    private String cname;
    private int population;
    private int landmasskm2;
    private int medianage;




    public Country(
        String cname,
        int population,
        int landmasskm2,
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

    public long getCountryid()
    {
        return countryid;
    }


    public String getCname()
    {
        return cname;
    }

    public void setCname(String cname)
    {
        this.cname = cname;
    }

    public int getPopulation()
    {
        return population;
    }

    public void setPopulation(int population)
    {
        this.population = population;
    }

    public int getLandmasskm2()
    {
        return landmasskm2;
    }

    public void setLandmasskm2(int landmasskm2)
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
