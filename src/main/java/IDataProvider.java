package main.java;

public interface IDataProvider {
    String[] getChampionName();
    Champion getChampionByName(String name);
    Item getItemByName(String itemName);
    Item[] getItems();
}
