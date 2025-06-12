package factories;

import factories.gear.Weapon;
import factories.gear.Armor;
import factories.gear.Banner;

public interface OrcGearFactory {
    Weapon createWeapon();
    Armor createArmor();
    Banner createBanner();
}