package com.company;

import java.io.FileNotFoundException;

public class ChampDataProvider implements IChampData{

    private String[][] champsDataArray = {
            {"katarina","bouncing blade","preparation","shunpo","death lotus"},
            {"master yi","alpha strike","meditation","wuju style","highlander"},
            {"warwick","jaw of the beast","blood hound","primal howl","infinite duress"},
            {"yasuo","tornade","mur d'air","dash infini","igezo"},
            {"morgana","binding","flaque","shield","ult"}
    };

    private String[][] spellsDataArray={
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
            {"soryegeton","19"},
            {"binding","20"},
            {"flaque","21"},
            {"shield","22"},
            {"ult","23"}
    };



    private String[] getChampData(String champName){
        for (int i = 0; i< champsDataArray.length; i++){
            if (champName.equals(champsDataArray[i][0])){
                 return champsDataArray[i];
            }
        }
        return null;
    }

    private String[] joinChampAndSpellData(String champName){
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

    @Override
    public String[] getChampionName() {
        String[] champName = new String[champsDataArray.length];
        for (int i=0;i<champsDataArray.length;i++){
            champName[i] = champsDataArray[i][0];
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
}
