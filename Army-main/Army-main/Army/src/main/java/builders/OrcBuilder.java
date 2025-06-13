package builders;

import com.github.javafaker.Faker;
import factories.OrcGearFactory;
import factories.gear.Weapon;
import factories.gear.Armor;
import factories.gear.Banner;
import model.Orc;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public abstract class OrcBuilder {
    protected final OrcGearFactory gearFactory;
    protected final Faker faker = new Faker();
    private static final Set<String> usedNames = new HashSet<>();
    private static final Map<String, Integer> nameCounters = new HashMap<>();
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
        String base = faker.lordOfTheRings().character();
        int count = nameCounters.getOrDefault(base, 0);
        String generated = base;
        if (count > 0) {
            generated = base + " " + count;
        }
        nameCounters.put(base, count + 1);
        usedNames.add(generated);
        this.name = generated;
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