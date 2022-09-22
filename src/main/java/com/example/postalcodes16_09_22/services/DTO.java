package com.example.postalcodes16_09_22.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class DTO {

  private ArrayList<City> cityList;

  public DTO() {
    cityList = new ArrayList<>();
    loadCSV();
  }

  public void loadCSV() {
    try {
      Scanner fileScanner = new Scanner(new File("danish-postal-codes.csv"));
      while (fileScanner.hasNextLine()) {
        String line = fileScanner.nextLine();
        Scanner input = new Scanner(line).useDelimiter(",").useLocale(Locale.ENGLISH);
        String postalCode = input.next();
        String city = input.next();
        cityList.add(new City(city,postalCode));
      }
    } catch (FileNotFoundException e) {
      System.out.println("File not found");
    } catch (NoSuchElementException e){
      System.out.println("No such element");
    }
  }

  public String cityListToString(){
    String cities = "";
    for (City city:cityList){
      cities += city.toString() + " ";
    }
    return cities;
  }

  public String correctCity(String postalCode){
    for (City city:cityList){
      if(city.getPostalCode().equals(postalCode)){
        return city.getName();
      }
    } return "No city with that postal code!";
  }
}
