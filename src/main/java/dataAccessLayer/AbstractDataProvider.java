package main.java.dataAccessLayer;

import main.java.model.Champion;
import main.java.model.Item;
import main.java.model.Spell;

public abstract class AbstractDataProvider implements IDataProvider {
    protected String[][] champsData;
    protected String[][] spellsData;
    protected String[][] itemsData;

    private String[] getChampData(String champName){
        for (int i = 0; i< champsData.length; i++){
            String test= champsData[i][0];
            if (champName.equals(champsData[i][0])){
                return champsData[i];
            }
        }
        return null;
    }

    private String[] joinChampAndSpellData(String champName){
        String[] champsDataArray = getChampData(champName);
        if (champsDataArray==null){
            return null;
        }
        String[] cdArray = new String[spellsData.length];
        boolean isFound=false;
        for (int i = 0; i< spellsData.length && !isFound; i++){
            for (int j=0; j<champsDataArray.length; j++){
                if (spellsData[i][0].equals(champsDataArray[j])){
                    cdArray[0] = spellsData[i][1];
                    cdArray[1] = spellsData[i+1][1];
                    cdArray[2] = spellsData[i+2][1];
                    cdArray[3] = spellsData[i+3][1];
                    isFound=true;
                    break;
                }
            }
        }
        int champsDataArrayLength = champsDataArray.length;
        int spellsDataArrayLength = cdArray.length;
        String[] joinedArrays = new String[(champsDataArrayLength + spellsDataArrayLength)];
        System.arraycopy(champsDataArray, 0, joinedArrays, 0, champsDataArrayLength);
        System.arraycopy(cdArray, 0, joinedArrays, champsDataArrayLength, spellsDataArrayLength);
        return joinedArrays;
    }

    @Override
    public String[] getChampionName() {
        String[] champName = new String[champsData.length];
        for (int i = 0; i< champsData.length; i++){
            champName[i] = champsData[i][0];
        }
        return champName;
    }

    @Override
    public Champion getChampionByName(String name) {
        String[] champsData = joinChampAndSpellData(name);

        if (champsData==null){
            return null;
        }
        Champion champion = new Champion(champsData[0],
                new Spell(champsData[1],Integer.parseInt(champsData[5])),
                new Spell(champsData[2],Integer.parseInt(champsData[6])),
                new Spell(champsData[3],Integer.parseInt(champsData[7])),
                new Spell(champsData[4],Integer.parseInt(champsData[8]))
        );
        return champion;
    }

    @Override
    public Item getItemByName(String itemName) {
        for (int i = 0; i< itemsData.length; i++){
            if (itemName.equals(itemsData[i][0])){
                return new Item(itemsData[i][0],Integer.parseInt(itemsData[i][1]));
            }
        }
        return null;
    }

    @Override
    public Item[] getItems() {
        Item[] items= new Item[itemsData.length];
        int i=0;
        for (String[] item: itemsData
        ) {
            items[i] = new Item(item[0],Integer.parseInt(item[1]));
            i++;
        }
        return items;
    }
}
