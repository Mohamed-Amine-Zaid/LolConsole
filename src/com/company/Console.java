package com.company;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Scanner;

public class Console {
    private Champion champion;
    private Scanner sc;
    private IChampData dataProvider;

    public Console(IChampData dataProvider) {
        this.sc = new Scanner(System.in);
        this.dataProvider = dataProvider;
    }

    public void champChoice(){
        System.out.println("Choose between those champions : ");
        Arrays.asList(dataProvider.getChampionName()).forEach(System.out::println);
    }

    public void checkChampName(){
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
            System.out.println("which spell do you want to use between a,z,e and r? You can also press p to open the shop");
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
        String[][] itemsAndGoldArray = ItemDataProvider.itemsAndGoldArray;
        for(int i = 0; i<itemsAndGoldArray.length; i++){
            System.out.println(itemsAndGoldArray[i][0] + ":  " + itemsAndGoldArray[i][1] + " gold");
        }
        
        itemToInventory(itemChecker());
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

    public Item itemChecker() {
        Item item=null;
        while(item==null){
            String itemChosed = sc.nextLine().toLowerCase();
            String[] itemData = ItemDataProvider.getItemData(itemChosed);
            if (itemData==null){
                System.out.println("Enter a valid item name.");
                continue;
            }
            item = new Item(itemData);
        }
        return item;
    }
}
