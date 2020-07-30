package com.company;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        ChampDataProvider champDataProvider = new ChampDataProvider();
        var console = new Console(champDataProvider);
        console.champChoice();
        console.checkChampName();
        console.checkChampSpells();
    }
}
