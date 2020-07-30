package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CsvData {
    public static List<String[]> championsDataCsv() throws FileNotFoundException {

        File fileChamp = new File("C:\\Users\\zaid-\\OneDrive\\Desktop\\Champions.csv");
        Scanner sc = new Scanner(fileChamp);

        List<String[]> championsList = new ArrayList<>();

        while (sc.hasNextLine()){
            championsList.add(sc.nextLine().split(";"));
        }
        sc.close();
        return championsList;
    }

    public static void spellsDataCsv() throws FileNotFoundException {
        File fileSpell = new File("C:\\Users\\zaid-\\OneDrive\\Desktop\\Spells.csv");

        Scanner sc = new Scanner(fileSpell);

        while (sc.hasNextLine()){
            List<List> spellsList = new ArrayList<>();
            spellsList.add(Arrays.asList(sc.nextLine().split(";")));
            System.out.println(spellsList);
        }
        sc.close();
    }

    public static String[] getChampDataCsv(String champName) throws FileNotFoundException {
        for (String[] champsArray : championsDataCsv()){
            if (champName.equals(champsArray[0])){
                return champsArray;
            }
        }
        return null;
    }
}
