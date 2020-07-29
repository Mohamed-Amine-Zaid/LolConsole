package com.company;

public class DataProvider {

    public static String[][] champsDataArray = {
            {"katarina","bouncing blade","preparation","shunpo","death lotus"},
            {"master yi","alpha strike","meditation","wuju style","highlander"},
            {"warwick","jaw of the beast","blood hound","primal howl","infinite duress"},
            {"yasuo","tornade","mur d'air","dash infini","igezo"},
            {"morgana","binding","flaque","shield","ult"}
    };

    public static String[][] spellsDataArray={
            {"bouncing blade","5"},
            {"preparation","6"},
            {"shunpo","7"},
            {"death lotus","8"},
            {"alpha strike","9"},
            {"meditation","10"},
            {"wuju style","11"},
            {"highlander","12"},
            {"jaw of the beast","13"},
            {"blood hound","14"},
            {"primal howl","15"},
            {"infinite duress","16"},
            {"tornade","24"},
            {"mur d'air","17"},
            {"dash infini","18"},
            {"igezo","19"},
            {"binding","20"},
            {"flaque","21"},
            {"shield","22"},
            {"ult","23"}
    };

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

    public static String[] getChampData(String champName){
        for (int i = 0; i< champsDataArray.length; i++){
            if (champName.equals(champsDataArray[i][0])){
                 return champsDataArray[i];
            }
        }
        return null;
    }

    public static String[] joinChampAndSpellData(String champName){
        String[] champsDataArray = getChampData(champName);
        if (champsDataArray==null){
            return null;
        }
        String[] cdArray = new String[spellsDataArray.length];
        boolean isFound=false;
        for (int i=0; i<spellsDataArray.length && !isFound; i++){
            for (int j=0; j<champsDataArray.length; j++){
                if (spellsDataArray[i][0].equals(champsDataArray[j])){
                    cdArray[0] = spellsDataArray[i][1];
                    cdArray[1] = spellsDataArray[i+1][1];
                    cdArray[2] = spellsDataArray[i+2][1];
                    cdArray[3] = spellsDataArray[i+3][1];
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

    public static String[] getItemData(String itemName){
        for (int i=0;i<itemsAndGoldArray.length;i++){
            if (itemName.equals(itemsAndGoldArray[i][0])){
                return itemsAndGoldArray[i];
            }
        }
        return null;
    }
}
