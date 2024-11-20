package com.ks.scheduler.service.impl;

import com.ks.scheduler.repository.HelloRepository;
import com.ks.scheduler.service.IHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class HelloService implements IHelloService {
    @Autowired
    private HelloRepository helloRepository;

    @Override
    public String appendName(String fName, String lName) {

       StringBuilder sB=new StringBuilder();

        return sB.append(fName).append("--").append(lName).toString();

    }

    public static Map<String, String> loadNamesIntoMap(String filePath) {
     /*  Map<String,String>  namesMap=loadNamesIntoMap("/Users/eweket/Documents/kbsasiproject/kbsasi/scheduler/src/main/resources/names.txt");

        for( Map.Entry<String, String> entry:namesMap.entrySet()){
            System.out.println("firstName: "  +entry.getKey() +" lastName: " +entry.getValue());
        } */
        Map<String, String> nameMap = new HashMap<>();


        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) { //line=Sasi Tesfahun
                String[] names = line.split(" "); //names=["Sasi", "Tesfahun"]
                if (names.length == 2) {             //true
                    String firstName = names[0];  //Sasi
                    String lastName = names[1];   //Tesfahun
                    nameMap.put(firstName, lastName); //namMap={ Sasi:Tesfahun }
                } else {
                    System.out.println("Skipping invalid line: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        return nameMap;
    }

}
