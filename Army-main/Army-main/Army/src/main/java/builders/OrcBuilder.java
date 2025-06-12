package builders;

import com.github.javafaker.Faker;
import factories.OrcGearFactory;
import factories.gear.Weapon;
import factories.gear.Armor;
import factories.gear.Banner;
import model.Orc;

public abstract class OrcBuilder {
    protected final OrcGearFactory gearFactory;
    protected final Faker faker = new Faker();
    protected String name;
    protected String type;
    protected Weapon weapon;
    protected Armor armor;
    protected Banner banner;
    protected int strength;
    protected int agility;
    protected int intellect;
    protected int health;

    protected OrcBuilder(OrcGearFactory gearFactory) {
    this.gearFactory = gearFactory;
    }
    
    public OrcBuilder setRandomName() {
        this.name = faker.lordOfTheRings().character();
        return this;
    }

    public OrcBuilder setType(String type) {
        this.type = type;
        return this;
    }

    public abstract OrcBuilder setAttributes();
    public abstract OrcBuilder setEquipment();

    public Orc build() {
        return new Orc(name, getTribeName(), type, weapon, armor, banner, 
                      strength, agility, intellect, health);
    }

    protected abstract String getTribeName();
}