package main.java;

import main.java.dataAccessLayer.CsvDataProvider;
import main.java.dataAccessLayer.HardDataProvider;
import main.java.vue.Console;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        HardDataProvider hardDataProvider = new HardDataProvider();
        CsvDataProvider csvDataProvider = new CsvDataProvider();
        var console = new Console(csvDataProvider);
        console.champChoice();
        console.askChampion();
        console.checkChampSpells();
    }
}
