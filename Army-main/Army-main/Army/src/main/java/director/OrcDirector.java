package director;

import builders.OrcBuilder;
import model.Orc;

public class OrcDirector {
    public Orc createBasicOrc(OrcBuilder builder) {
        return builder.setRandomName()
                    .setType("Базовый орк")
                    .setAttributes()
                    .setEquipment()
                    .build();
    }

    public Orc createLeaderOrc(OrcBuilder builder) {
        return builder.setRandomName()
                    .setType("Командир")
                    .setAttributes()
                    .setEquipment()
                    .build();
    }

    public Orc createScoutOrc(OrcBuilder builder) {
        return builder.setRandomName()
                    .setType("Разведчик")
                    .setAttributes()
                    .setEquipment()
                    .build();
    }
}