package model;

import factories.gear.Weapon;
import factories.gear.Armor;
import factories.gear.Banner;

public class Orc {
    private final String name;
    private final String tribe;
    private final String type;
    private final Weapon weapon;
    private final Armor armor;
    private final Banner banner;
    private final int strength;
    private final int agility;
    private final int intellect;
    private final int health;

    public Orc(String name, String tribe, String type, Weapon weapon, Armor armor, 
               Banner banner, int strength, int agility, int intellect, int health) {
        this.name = name;
        this.tribe = tribe;
        this.type = type;
        this.weapon = weapon;
        this.armor = armor;
        this.banner = banner;
        this.strength = strength;
        this.agility = agility;
        this.intellect = intellect;
        this.health = health;
    }

    public String getName() { return name; }
    public String getTribe() { return tribe; }
    public String getType() { return type; }
    public Weapon getWeapon() { return weapon; }
    public Armor getArmor() { return armor; }
    public Banner getBanner() { return banner; }
    public int getStrength() { return strength; }
    public int getAgility() { return agility; }
    public int getIntellect() { return intellect; }
    public int getHealth() { return health; }

    @Override
    public String toString() {
        return name + " (" + type + ")";
    }
}