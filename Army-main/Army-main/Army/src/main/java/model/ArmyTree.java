package model;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.util.HashMap;
import java.util.Map;

public class ArmyTree {
    private final DefaultTreeModel treeModel;
    private final DefaultMutableTreeNode rootNode;
    private final Map<String, DefaultMutableTreeNode> tribeNodes;

    public ArmyTree() {
        this.rootNode = new DefaultMutableTreeNode("Армия");
        this.treeModel = new DefaultTreeModel(rootNode);
        this.tribeNodes = new HashMap<>();
        initializeTribeNodes();
    }

    private void initializeTribeNodes() {
        addTribeNode("Мордор");
        addTribeNode("Дол Гулдур");
        addTribeNode("Мглистые Горы");
    }

    private void addTribeNode(String tribeName) {
        DefaultMutableTreeNode node = new DefaultMutableTreeNode(tribeName);
        rootNode.add(node);
        tribeNodes.put(tribeName, node);
    }

    public void addOrk(Orc ork) {
        DefaultMutableTreeNode tribeNode = tribeNodes.get(ork.getTribe());
        if (tribeNode != null) {
            tribeNode.add(new DefaultMutableTreeNode(ork));
            treeModel.reload();
        }
    }

    public DefaultTreeModel getTreeModel() {
        return treeModel;
    }
}