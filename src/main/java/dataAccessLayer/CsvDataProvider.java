package main.java.dataAccessLayer;

import main.java.dataAccessLayer.AbstractDataProvider;
import main.java.dataAccessLayer.IDataProvider;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CsvDataProvider extends AbstractDataProvider implements IDataProvider {

    public CsvDataProvider() throws FileNotFoundException {
        champsData = getData("src/main/resources/Champions.csv");
        spellsData = getData("src/main/resources/Spells.csv");
        itemsData = getData("src/main/resources/Items.csv");
    }

    private String[][] getData(String pathName) throws FileNotFoundException {
        File file = new File(pathName);
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File not found.");
        }
        List<String[]> data = new ArrayList<>();
        while (sc.hasNextLine()) {
            data.add(sc.nextLine().replaceAll("[\uFEFF-\uFFFF]", "").split(";"));
        }
        sc.close();
        String[][] toReturn = new String[data.size()][data.get(0).length];

        return  data.toArray(toReturn);
    }
}
