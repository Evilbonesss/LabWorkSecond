package mephi.b23902.i.army;

import director.OrcDirector;
import gui.GUI;
import javax.swing.*;
import model.ArmyTree;

public class Army {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ArmyTree armyTree = new ArmyTree();
                OrcDirector director = new OrcDirector();
                GUI gui = new GUI(director, armyTree);
                gui.setVisible(true);
            }
        });
    }
}