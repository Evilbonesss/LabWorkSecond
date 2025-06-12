package gui;

import builders.OrcBuilder;
import model.ArmyTree;
import director.OrcDirector;
import factories.OrcBuilderFactory;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import model.Orc;

public class GUI extends JFrame {
    private final OrcDirector director;
    private final ArmyTree armyTree;
    private final JTree tree;
    private final JPanel infoPanel;

    public GUI(OrcDirector director, ArmyTree armyTree) {
        this.director = director;
        this.armyTree = armyTree;
        this.tree = new JTree(armyTree.getTreeModel());
        this.infoPanel = new JPanel(new GridLayout(0, 1));
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Менеджер Армии Саурона");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 450);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        tree.setRootVisible(true);
        tree.addTreeSelectionListener(e -> updateOrcInfo());

        JPanel controlPanel = createControlPanel();

        infoPanel.setBorder(BorderFactory.createTitledBorder("Об орке: "));

        add(controlPanel, BorderLayout.SOUTH);
        add(new JScrollPane(tree), BorderLayout.WEST);
        add(new JScrollPane(infoPanel), BorderLayout.CENTER);
    }

    private JPanel createControlPanel() {
        JPanel panel = new JPanel(new GridLayout(1, 3));
        JComboBox<String> tribeCombo = new JComboBox<>(new String[]{"Мордор", "Дол Гулдур", "Мглистые Горы"});
        JComboBox<String> typeCombo = new JComboBox<>(new String[]{"Базовый орк", "Командир", "Разведчик"});

        panel.add(new JLabel("Племя:"));
        panel.add(tribeCombo);
        panel.add(new JLabel("Тип:"));
        panel.add(typeCombo);

        JButton createButton = new JButton("Создать орка");
        createButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String tribe = (String) tribeCombo.getSelectedItem();
                String type = (String) typeCombo.getSelectedItem();
                
                OrcBuilder builder = OrcBuilderFactory.createBuilderForTribe(tribe);
                Orc orc = createOrkByType(builder, type);
            
                armyTree.addOrk(orc);
            }
        });
        panel.add(createButton);

        return panel;
    }

    private Orc createOrkByType(OrcBuilder builder, String type) {
        switch(type) {
            case "Командир": return director.createLeaderOrc(builder);
            case "Разведчик": return director.createScoutOrc(builder);
            default: return director.createBasicOrc(builder);
        }
    }

    private void updateOrcInfo() {
        infoPanel.removeAll();
        Object selected = tree.getLastSelectedPathComponent();
        
        if (selected instanceof DefaultMutableTreeNode) {
            Object userObject = ((DefaultMutableTreeNode) selected).getUserObject();
            if (userObject instanceof Orc) {
                displayOrkInfo((Orc) userObject);
            }
        }
        
        infoPanel.revalidate();
        infoPanel.repaint();
    }

    private void displayOrkInfo(Orc orc) {
        infoPanel.add(new JLabel("Имя: " + orc.getName()));
        infoPanel.add(new JLabel("Племя: " + orc.getTribe()));
        infoPanel.add(new JLabel("Тип: " + orc.getType()));
        infoPanel.add(new JLabel("Оружие: " + (orc.getWeapon() != null ? orc.getWeapon().getDescription() : "-")));
        infoPanel.add(new JLabel("Броня: " + orc.getArmor().getDescription()));
        infoPanel.add(new JLabel("Знамя: " + (orc.getBanner() != null ? orc.getBanner().getDescription() : "-")));
        
        infoPanel.add(new JLabel("Характеристики:"));
        addProgressBar(infoPanel, "Сила: ", orc.getStrength(), 100);
        addProgressBar(infoPanel, "Ловкость: ", orc.getAgility(), 100);
        addProgressBar(infoPanel, "Интеллект: ", orc.getIntellect(), 50);
        addProgressBar(infoPanel, "Здоровье: ", orc.getHealth(), 200);
    }

    private void addProgressBar(JPanel panel, String label, int value, int max) {
        JProgressBar bar = new JProgressBar(0, max);
        bar.setValue(value);
        bar.setString(label + value);
        bar.setStringPainted(true);
        panel.add(bar);
    }
}