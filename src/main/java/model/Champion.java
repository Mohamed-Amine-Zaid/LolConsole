package main.java.model;

import java.time.Duration;
import java.time.LocalDateTime;

public class Champion {
    private String name;
    private Spell spellA;
    private Spell spellZ;
    private Spell spellE;
    private Spell spellR;
    private int gold;
    private Item[] inventory;

    public Champion(String name, Spell spellA, Spell spellZ, Spell spellE, Spell spellR){
        this.name = name;
        this.spellA = spellA;
        this.spellZ = spellZ;
        this.spellE = spellE;
        this.spellR = spellR;
        this.inventory = new Item[6];
        this.gold=0;
    }

    public void goldGenerator(LocalDateTime startGoldEarnTimer){
        Duration duration = Duration.between(startGoldEarnTimer, LocalDateTime.now());
        long difference = duration.toSeconds();
        setGold((int)difference*1000+getGold());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Spell getSpellA() {
        return spellA;
    }

    public Spell getSpellZ() {
        return spellZ;
    }

    public Spell getSpellE() {
        return spellE;
    }

    public Spell getSpellR() {
        return spellR;
    }

    public void setSpellA(Spell spellA) {
        this.spellA = spellA;
    }

    public void setSpellZ(Spell spellZ) {
        this.spellZ = spellZ;
    }

    public void setSpellE(Spell spellE) {
        this.spellE = spellE;
    }

    public void setSpellR(Spell spellR) {
        this.spellR = spellR;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public Item[] getInventory() {
        return inventory;
    }

    public void addItemToInventory(Item item) {
        for (int i=0;i<inventory.length;i++){
            if (inventory[i]==null){
                inventory[i] = item;
                break;
            }
        }
    }
}
