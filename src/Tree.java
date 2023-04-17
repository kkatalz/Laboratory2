import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Tree extends JFrame {
    JPanel panel;

    public Tree(Storage storage) {
        Group[] groups = storage.getGroups();


        DefaultMutableTreeNode top = new DefaultMutableTreeNode(" Склад ");
        for (Group group : groups) {
            DefaultMutableTreeNode groupNode = new DefaultMutableTreeNode(group.getName());

            for (Goods good : group.getGoods()) {
                DefaultMutableTreeNode goodNode = new DefaultMutableTreeNode(good.getName());
                groupNode.add(goodNode);
            }

            top.add(groupNode);
        }

        JTree tree = new JTree(top);


        tree.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    TreePath tp = tree.getPathForLocation(e.getX(), e.getY());
                    if (tp != null) {
                        DefaultMutableTreeNode node = (DefaultMutableTreeNode) tp.getLastPathComponent();
                        Object obj = node.getUserObject();
                    }
                }
            }
        });

        panel = new JPanel(new BorderLayout());
        panel.add(new JScrollPane(tree), BorderLayout.CENTER);
        tree.setBackground(Color.BLACK);


        setContentPane(panel);
        setTitle("Tree Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);

    }

    public JPanel getPanel() {
        return panel;
    }
}
