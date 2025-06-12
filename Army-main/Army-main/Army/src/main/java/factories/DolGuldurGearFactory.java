package factories;

import factories.gear.Armor;
import factories.gear.Banner;
import factories.gear.Spear;
import factories.gear.ChainMail;
import factories.gear.SpiderBanner;
import factories.gear.Weapon;

public class DolGuldurGearFactory implements OrcGearFactory {
    public Weapon createWeapon() { return new Spear(); }
    public Armor createArmor() { return new ChainMail(); }
    public Banner createBanner() { return new SpiderBanner(); }
}