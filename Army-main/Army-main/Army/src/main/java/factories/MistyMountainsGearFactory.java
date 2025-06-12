package factories;

import factories.gear.Armor;
import factories.gear.Axe;
import factories.gear.Banner;
import factories.gear.LeatherArmor;
import factories.gear.MoonBanner;
import factories.gear.Weapon;

public class MistyMountainsGearFactory implements OrcGearFactory {
    public Weapon createWeapon() { return new Axe(); }
    public Armor createArmor() { return new LeatherArmor(); }
    public Banner createBanner() { return new MoonBanner(); }
}
