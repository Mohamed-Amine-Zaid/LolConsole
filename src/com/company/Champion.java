package com.company;

public class Champion {
    private String name;
    private Spell spellA;
    private Spell spellZ;
    private Spell spellE;
    private Spell spellR;
    private int gold;
    private Item[] inventory;

    public Champion(String[] tab){
        this.name = tab[0];
        spellA = new Spell(tab[1],Integer.parseInt(tab[5]));
        spellZ = new Spell(tab[2],Integer.parseInt(tab[6]));
        spellE = new Spell(tab[3],Integer.parseInt(tab[7]));
        spellR = new Spell(tab[4],Integer.parseInt(tab[8]));
        this.inventory = new Item[6];
        this.gold=0;
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
        for (Item i:this.inventory){
            if (i==null){
                i = item;
                break;
            }
        }
    }
}
