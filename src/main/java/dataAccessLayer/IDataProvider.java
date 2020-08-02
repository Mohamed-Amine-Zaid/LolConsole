package main.java.dataAccessLayer;

import main.java.model.Champion;
import main.java.model.Item;

public interface IDataProvider {
    String[] getChampionName();
    Champion getChampionByName(String name);
    Item getItemByName(String itemName);
    Item[] getItems();
}
