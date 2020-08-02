package main.java.vue;
import main.java.dataAccessLayer.IDataProvider;
import main.java.model.Champion;
import main.java.model.Item;
import main.java.model.Spell;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Scanner;

public class Console {
    private Champion champion;
    private Scanner sc;
    private IDataProvider dataProvider;

    public Console(IDataProvider dataProvider) {
        this.sc = new Scanner(System.in);
        this.dataProvider = dataProvider;
    }

    public void champChoice(){
        System.out.println("Choose between those champions : ");
        Arrays.asList(dataProvider.getChampionName()).forEach(System.out::println);
    }

    public void askChampion(){
        String userInputChampName="";
        while (champion==null){
            userInputChampName = sc.nextLine().toLowerCase();
            if (dataProvider.getChampionByName(userInputChampName)==null){
                System.out.println("This is not a valid champion name, choose an appropriate name.");
                continue;
            }
            champion = dataProvider.getChampionByName(userInputChampName);
        }
    }

    public void checkChampSpells(){
        String keySpell;
        LocalDateTime startGoldEarnTimer;
        boolean isff20=false;
        while (!isff20){
            startGoldEarnTimer=LocalDateTime.now();
            System.out.println("which spell do you want to use between a,z,e and r? You can also press p to open the shop or i to show your inventory.");
            keySpell = sc.nextLine().toLowerCase();
            champion.goldGenerator(startGoldEarnTimer);
            switch (keySpell){
                case "a":
                    cooldownChecker(champion.getSpellA());
                    break;
                case "z":
                    cooldownChecker(champion.getSpellZ());
                    break;
                case "e":
                    cooldownChecker(champion.getSpellE());
                    break;
                case "r":
                    cooldownChecker(champion.getSpellR());
                    break;
                case "p":
                    displayShop();
                    break;
                case "i":
                    displayInventory();
                    break;
                case "ff20":
                    isff20=true;
                    System.out.println("Defeat.");
                    break;
                default:
                    System.out.println("This is not a valid spell");
                    break;
            }
        }
    }


    private void displayInventory() {
        for (Item item:champion.getInventory()
             ) {
            if (item!=null){
                System.out.print (item.getName());
                System.out.print(" - ");
            }
        }
        System.out.println("");
    }

    public void cooldownChecker(Spell spellLetter){
        Duration duration = Duration.between(spellLetter.getLastTimeSpellUsed(), LocalDateTime.now());
        long difference = duration.toSeconds();
        if (difference < spellLetter.getCooldown()){
            System.out.println("This spell is not ready yet. " + (spellLetter.getCooldown() - difference) + " seconds remaining.");
        }else {
            System.out.println(champion.getName() + " used " + spellLetter.getName());
            spellLetter.setLastTimeSpellUsed(LocalDateTime.now());
        }
    }

    public void displayShop(){
        System.out.println("Here is the amount of gold you have : " + champion.getGold());
        System.out.println("Choose between those items : ");
        for (Item item:dataProvider.getItems()
             ) {
            System.out.println(item);       // on a override la méthode toString()
        }
        itemToInventory(askItem());
    }

    public void itemToInventory(Item item) {
        if (champion.getGold()>=item.getPrice()){
            champion.addItemToInventory(item);
            champion.setGold(champion.getGold() - item.getPrice());
            System.out.println("You have purchased " + item.getName());
        }else   {
            System.out.println("you don't have enough gold.");
        }
    }

    public Item askItem() {
        Item item = null;
        String userInput = "";
        while(item==null){
            userInput = sc.nextLine().toLowerCase();
            item = dataProvider.getItemByName(userInput);
            if (item==null){
                System.out.println("Enter a valid item name.");
            }
        }
        return item;
    }
}
