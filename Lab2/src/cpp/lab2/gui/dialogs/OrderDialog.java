package cpp.lab2.gui.dialogs;

import cpp.lab2.gui.GBC;

import javax.swing.*;
import java.awt.*;

public class OrderDialog {
    private JDialog dialog;
    private JTextField nameField;
    private JTextField amountField;
    public static final int DEFAULT_INSETS = 5;
    public static final int MINIMUM_WIDTH = 500;
    public static final int MINIMUM_HEIGHT = 200;

    public OrderDialog() {
        dialog = new JDialog();
        dialog.setModal(true);
        dialog.setTitle("New order");
        dialog.setMinimumSize(new Dimension(MINIMUM_WIDTH, MINIMUM_HEIGHT));
        GridBagLayout layout = new GridBagLayout();
        dialog.setLayout(layout);

        dialog.add(new JLabel("Order №:"), new GBC(0, 0, 2, 1).setWeight(100, 0).setAnchor(GBC.WEST).setInsets(DEFAULT_INSETS));
        //TODO: add order id
        dialog.add(new JLabel("Name:"), new GBC(0, 1));

        nameField = new JTextField();
        dialog.add(nameField, new GBC(1, 1, 1, 1).setWeight(100, 0).setFill(GBC.BOTH).setInsets(DEFAULT_INSETS));

        dialog.add(new JLabel("Amount:"), new GBC(0, 2));

        amountField = new JTextField();
        dialog.add(amountField, new GBC(1, 2, 1, 1).setWeight(100, 0).setFill(GBC.BOTH).setInsets(DEFAULT_INSETS));

        //TODO: add calculate button

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(e -> {
            dialog.setVisible(false);
        });

        dialog.add(cancelButton, new GBC(0, 4).setInsets(5));
        JButton okButton = new JButton("Add");
        okButton.addActionListener(e -> okButtonListener());
        dialog.add(okButton, new GBC(1, 4).setAnchor(GBC.EAST).setInsets(DEFAULT_INSETS));
    }

    private void okButtonListener() {
        String name = nameField.getText();
        if(name.isEmpty()) {
            JOptionPane.showConfirmDialog(dialog, "Invalid name!",
                    "Error", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE);
            return;
        }
        String moneyStringValue = amountField.getText();
        int amountIntValue;
        try {
            amountIntValue = Integer.parseInt(moneyStringValue);
        } catch(NumberFormatException e1) {
            JOptionPane.showConfirmDialog(dialog, "Invalid amount!", "Error",
                    JOptionPane.DEFAULT_OPTION ,JOptionPane.WARNING_MESSAGE);
            return;
        }
        //TODO: send data from fields to ClientDatabase
        nameField.setText("");
        amountField.setText("");
        dialog.setVisible(false);
    }

    public void setVisible(boolean b) {
        dialog.setVisible(b);
    }
}
