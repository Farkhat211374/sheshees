package com.example.demo1;

import java.io.FileReader;
//import com.opencsv.CSVReader;

public class findPoints {

    double lat = 0.0;
    double lng = 0.0;

/*    public findPoints(String city){
        findLanLng(city);
    }

    private void findLanLng(String city) {
        CSVReader reader = null;


        int counter = 0;


        try {
            //parsing a CSV file into CSVReader class constructor
            reader = new CSVReader(new FileReader("C:\\my\\Web-work\\2022\\demo1\\src\\main\\java\\com\\example\\demo1\\files\\worldcitiesNew.csv"));
            String[] nextLine;


            //reads one line at a time
            while ((nextLine = reader.readNext()) != null) {
                for (String token: nextLine) {

                    if(token.equals(city)){
                        if(counter==2){
                        }else{
                            counter=2;
                        }
                    }else{
                        if(counter==4){
                            System.out.println("counter - 4");
                            counter=0;
                        }else if(counter==3){
                            lng = Double.parseDouble(token);
                            counter++;
                            break;
                        }else if(counter==2){
                            lat = Double.parseDouble(token);
                            counter++;
                        }
                    }
                }
                counter=0;
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }

    }*/
}