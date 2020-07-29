package com.company;
import java.time.LocalDateTime;

public class Spell {
    private String name;
    private int cooldown;
    private LocalDateTime lastTimeSpellUsed;

    public Spell (String name, int cooldown) {
        this.name = name;
        this.cooldown = cooldown;
        lastTimeSpellUsed=LocalDateTime.MIN;
    }

    public LocalDateTime getLastTimeSpellUsed() {
        return lastTimeSpellUsed;
    }

    public void setLastTimeSpellUsed(LocalDateTime lastTimeSpellUsed) {
        this.lastTimeSpellUsed = lastTimeSpellUsed;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public int getCooldown() { return cooldown; }

    public void setCooldown(int cooldown) { this.cooldown = cooldown; }
}
