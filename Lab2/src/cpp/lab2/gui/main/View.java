package cpp.lab2.gui.main;

import cpp.lab2.Subscriber;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

/**
 * @author xefza
 * @version 1.0
 * @created 03-Apr-2018 17:46:47
 */
public class View implements Subscriber {

    private JPanel infoPanel;
    private JLabel moneyLabel;
    private JLabel nameLabel;
    private JLabel typeLabel;
    private JTable ordersTable;
    private JScrollPane tableScrollPane;
    public final String[] columnNames = {"id", "name", "amount", "cost"};

    public View() {
        infoPanel = new JPanel();
        BoxLayout infoPanelLayout = new BoxLayout(infoPanel, BoxLayout.LINE_AXIS);
        infoPanel.setLayout(infoPanelLayout);
        //TODO: grey color at the start
        infoPanel.add(Box.createHorizontalGlue());
        typeLabel = new JLabel("type");
        infoPanel.add(typeLabel);
        infoPanel.add(Box.createRigidArea(new Dimension(5, 0)));
        nameLabel = new JLabel("name");
        infoPanel.add(nameLabel);
        infoPanel.add(Box.createRigidArea(new Dimension(5, 0)));
        moneyLabel = new JLabel("money");
        infoPanel.add(moneyLabel);
        infoPanel.add(Box.createHorizontalGlue());
        //TODO: set table row count
        Object[][] tableData = {{"", "", "", ""}};

        ordersTable = new JTable(tableData, columnNames) {
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };
        ordersTable.setFillsViewportHeight(true);
        tableScrollPane = new JScrollPane(ordersTable);


    }


    public JPanel getInfoPanel() {
        return infoPanel;
    }

    public JScrollPane getOrdersTable() {
        return tableScrollPane;
    }

    /**
     * @param clientType
     * @param name
     * @param money
     */
    public void updateClientInfo(String clientType, String name, String money) {
        typeLabel.setText(clientType);
        nameLabel.setText(name);
        moneyLabel.setText(money);
    }

    /**
     * @param orders
     */
    public void updateClientOrders(LinkedList<String> orders) {
        //TODO: init table
    }

}