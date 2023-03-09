package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


//import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size plus
     one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    /**
     * Create a mock city
     * Check whether the list has the mock city
     * Add the mock city to the list
     * Check whether the list has the mock city now
     */
    @Test
    public void hasCityTest(){
        list = MockCityList();
        City mockSity = new City("Edmonton", "AB");
        assertFalse(list.hasCity(mockSity));
        list.addCity(mockSity);
        assertTrue(list.hasCity(mockSity));
    }

    /**
     * Remove a city that is not inside the list
     * Add a mock city to the list
     * Remove the mock city from the list*/
    @Test
    public void deleteCityTest(){
        list = MockCityList();
        City mockSity = new City("Edmonton", "AB");

        assertFalse(list.deleteCity(mockSity));
        assertFalse(list.hasCity(mockSity));

        list.addCity(mockSity);

        assertTrue(list.hasCity(mockSity));
        assertTrue(list.deleteCity(mockSity));
        assertFalse(list.hasCity(mockSity));
    }

    @Test
    public void countCitiesTest(){
        City city1 = new City("Edmonton", "AB");
        City city2 = new City("Calgary", "AB");
        City city3 = new City("Vancouver", "BC");
        list = MockCityList();
        assertEquals(list.countCities(), 0);
        list.addCity(city1);
        assertEquals(list.countCities(), 1);
        list.deleteCity(city1);
        assertEquals(list.countCities(), 0);
        list.addCity(city1);
        list.addCity(city2);
        assertEquals(list.countCities(), 2);
        list.addCity(city3);
        assertEquals(list.countCities(), 3);
    }

}
