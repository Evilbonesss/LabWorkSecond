package builders;

import factories.OrcGearFactory;
import factories.gear.Bow;
import factories.gear.Horn;

public class MordorOrcBuilder extends OrcBuilder {
     public MordorOrcBuilder(OrcGearFactory gearFactory){
        super(gearFactory);
    }
     
    @Override
    public OrcBuilder setAttributes() {
        this.strength = (int)(1 + Math.random() * 100 * 1.3);
        this.agility = 1 + (int)(Math.random() * 40);
        this.intellect = 1 + (int)(Math.random() * 50);
        this.health = 50 + (int)(Math.random() * 151);
        return this;
    }

        @Override
    public OrcBuilder setEquipment() {
        if ("Командир".equals(type)) {
            this.weapon = new Horn();
            this.banner = gearFactory.createBanner();
        } 
        else if ("Разведчик".equals(type)) {
            this.weapon = new Bow();
            this.banner = null;
        }
        else {
            this.weapon = gearFactory.createWeapon();
            this.banner = null;
        }
        
        this.armor = gearFactory.createArmor();
        return this;
    }

    @Override
    protected String getTribeName() {
        return "Мордор";
    }
}