package main.java.dataAccessLayer;

import main.java.dataAccessLayer.AbstractDataProvider;
import main.java.dataAccessLayer.IDataProvider;

public class HardDataProvider extends AbstractDataProvider implements IDataProvider {

    public HardDataProvider() {
        champsData = new String[][]{
                {"katarina", "bouncing blade", "preparation", "shunpo", "death lotus"},
                {"master yi", "alpha strike", "meditation", "wuju style", "highlander"},
                {"warwick", "jaw of the beast", "blood hound", "primal howl", "infinite duress"},
                {"yasuo", "tornade", "mur d'air", "dash infini", "igezo"},
                {"morgana", "binding", "flaque", "shield", "ult"}
        };

        spellsData = new String[][]{
                {"bouncing blade", "5"},
                {"preparation", "6"},
                {"shunpo", "7"},
                {"death lotus", "8"},
                {"alpha strike", "9"},
                {"meditation", "10"},
                {"wuju style", "11"},
                {"highlander", "12"},
                {"jaw of the beast", "13"},
                {"blood hound", "14"},
                {"primal howl", "15"},
                {"infinite duress", "16"},
                {"tornade", "24"},
                {"mur d'air", "17"},
                {"dash infini", "18"},
                {"soryegeton", "19"},
                {"binding", "20"},
                {"flaque", "21"},
                {"shield", "22"},
                {"ult", "23"}
        };

        itemsData = new String[][]{
                {"trinity force", "3250"},
                {"zhonya", "2800"},
                {"zzrot portal", "2700"},
                {"spirit visage", "2900"},
                {"infinite edge", "2700"},
                {"rabadon", "3000"},
                {"boots of mercury", "1300"},
                {"warmog", "3150"}
        };
    }
}
