package com.company;

public class ItemDataProvider implements IItemData{
    public static String[][] itemsAndGoldArray ={
            {"trinity force","3250"},
            {"zhonya","2800"},
            {"zzrot portal","2700"},
            {"spirit visage","2900"},
            {"infinite edge","2700"},
            {"rabadon","3000"},
            {"boots of mercury","1300"},
            {"warmog","3150"}
    };

    public static String[] getItemData(String itemName){
        for (int i=0;i<itemsAndGoldArray.length;i++){
            if (itemName.equals(itemsAndGoldArray[i][0])){
                return itemsAndGoldArray[i];
            }
        }
        return null;
    }

    @Override
    public Item getItemByName(String itemName) {
        return null;
    }
}
