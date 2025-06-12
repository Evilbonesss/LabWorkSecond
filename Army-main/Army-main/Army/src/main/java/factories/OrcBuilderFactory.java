package factories;

import builders.OrcBuilder;
import builders.MordorOrcBuilder;
import builders.DolGuldurOrcBuilder;
import builders.MistyMountainsOrcBuilder;
    
public class OrcBuilderFactory {
    private final MordorGearFactory mordorGearFactory = new MordorGearFactory();
    private final DolGuldurGearFactory dolGuldurGearFactory = new DolGuldurGearFactory();
    private final MistyMountainsGearFactory mistyMountainsGearFactory = new MistyMountainsGearFactory();

        static public OrcBuilder createBuilderForTribe(String tribe) {
        return switch(tribe) {
            case "Дол Гулдур" -> new DolGuldurOrcBuilder(new DolGuldurGearFactory());
            case "Мглистые Горы" -> new MistyMountainsOrcBuilder(new MistyMountainsGearFactory());
            default -> new MordorOrcBuilder(new MordorGearFactory());
        };
    }
}
