package factories;

import factories.gear.Armor;
import factories.gear.Banner;
import factories.gear.HeavySword;
import factories.gear.SteelArmor;
import factories.gear.RedEyeBanner;
import factories.gear.Weapon;

public class MordorGearFactory implements OrcGearFactory {
    public Weapon createWeapon() { return new HeavySword(); }
    public Armor createArmor() { return new SteelArmor(); }
    public Banner createBanner() { return new RedEyeBanner(); }
}