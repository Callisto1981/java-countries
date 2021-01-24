package com.lambdaschool.countries.controllers;

import com.lambdaschool.countries.models.Country;
import com.lambdaschool.countries.respositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CountryController
{
    @Autowired
    CountryRepository crepos;

    private List<Country> findCountries(List<Country> myList, CheckCountry tester)
    {
        List<Country> tempList = new ArrayList<>();

        for (Country c : myList)
        {
            if (tester.test(c))
            {
                tempList.add(c);
            }
        }
        return tempList;
    }

    // http://localhost:2019/names/all
    @GetMapping(value = "/names/all", produces = {"application/json"})
    public ResponseEntity<?> listAllCountries()
    {
        List<Country> myList = new ArrayList<>();
        crepos.findAll().iterator().forEachRemaining(myList::add);
        return new ResponseEntity<>(myList, HttpStatus.OK);
    }

    // http://localhost:2019/names/start/u
    @GetMapping(value = "names/start/{u}", produces = {"application/json"})
    public ResponseEntity<?> listCNameStartWithU(@PathVariable char u)
    {
        List<Country> myList = new ArrayList<>();
        crepos.findAll().iterator().forEachRemaining(myList::add);
        List<Country> returnList = findCountries(myList, c-> c.getCname().charAt(0) == u);

        //double totalSalary = 0;
        //for (Country c : returnList)
        //{
        //    totalSalary = totalSalary + c.getSalary();
        //    System.out.println(c);
        //}
        for (Country c : returnList)
        {
            System.out.println(c);
        }
        return new ResponseEntity<>(returnList, HttpStatus.OK);
    }

    // http://localhost:2019/population/total
    @GetMapping(value = "population/total", produces = {"application/json"})
    public ResponseEntity<?> listTotalPopulation()
    {
        List<Country> myList = new ArrayList<>();
        crepos.findAll().iterator().forEachRemaining(myList::add);
        return new ResponseEntity<>(myList, HttpStatus.OK);
    }


    // http://localhost:2019/population/min
    @GetMapping(value = "/population/min", produces = {"application/json"})
    public ResponseEntity<?> listMin()
    {
        List<Country> myList = new ArrayList<>();
        crepos.findAll().iterator().forEachRemaining(myList::add);
        myList.sort((c1, c2) -> c1.getPopulation() - c2.getPopulation());
        return new ResponseEntity<>(myList, HttpStatus.OK);
    }

    // http://localhost:2019/population/max
    @GetMapping(value = "/population/max", produces = {"application/json"})
    public ResponseEntity<?> listMax()
    {
        List<Country> myList = new ArrayList<>();
        crepos.findAll().iterator().forEachRemaining(myList::add);
        myList.sort((c1, c2) -> c1.getPopulation() + c2.getPopulation());
        return new ResponseEntity<>(myList, HttpStatus.OK);
    }
}
