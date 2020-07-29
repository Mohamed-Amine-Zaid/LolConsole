package com.company;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Console {
    private Champion champion;
    private Scanner sc;

    public Console() {
        this.sc = new Scanner(System.in);
    }

    public void champChoice(){
        System.out.println("Choose between those champions : ");

        for(int i = 0; i<DataProvider.champsDataArray.length; i++){
            System.out.println(DataProvider.champsDataArray[i][0]);
        }
    }

    public void checkChampName(){
        String userInputChampName="";
        String[] champData;
        while (champion==null){
            userInputChampName = sc.nextLine().toLowerCase();
            champData = DataProvider.joinChampAndSpellData(userInputChampName);
            if (champData==null){
                System.out.println("This is not a valid champion name, choose an appropriate name.");
                continue;
            }
            champion = new Champion(champData);
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
            goldGenerator(startGoldEarnTimer);
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
            System.out.println("This spell is not ready yet");
        }else {
            System.out.println(champion.getName() + " used " + spellLetter.getName());
            spellLetter.setLastTimeSpellUsed(LocalDateTime.now());
        }
    }

    public void goldGenerator(LocalDateTime startGoldEarnTimer){
        Duration duration = Duration.between(startGoldEarnTimer, LocalDateTime.now());
        long difference = duration.toSeconds();
        champion.setGold((int)difference*200+champion.getGold());
    }

    public void displayShop(){
        System.out.println("Here is the amount of gold you have : " + champion.getGold());
        System.out.println("Choose between those items : ");
        String[][] itemsAndGoldArray = DataProvider.itemsAndGoldArray;
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
            String[] itemData = DataProvider.getItemData(itemChosed);
            if (itemData==null){
                System.out.println("Enter a valid item name.");
                continue;
            }
            item = new Item(itemData);
        }
        return item;
    }

}
