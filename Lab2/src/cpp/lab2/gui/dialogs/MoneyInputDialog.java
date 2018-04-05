package cpp.lab2.gui.dialogs;

import cpp.lab2.gui.GBC;

import javax.swing.*;
import java.awt.*;

public class MoneyInputDialog {
    private JDialog dialog;
    private JTextField moneyField;
    public static final int DEFAULT_INSETS = 5;
    public static final int MINIMUM_WIDTH = 300;
    public static final int MINIMUM_HEIGHT = 150;

    public MoneyInputDialog(){
        dialog = new JDialog();
        dialog.setModal(true);
        dialog.setTitle("Money input");
        dialog.setMinimumSize(new Dimension(MINIMUM_WIDTH, MINIMUM_HEIGHT));
        GridBagLayout layout = new GridBagLayout();
        dialog.setLayout(layout);

        dialog.add(new JLabel("Enter new amount of money:"), new GBC(0,0,2,
                1).setWeight(100,0).setAnchor(GBC.WEST)
                  .setInsets(DEFAULT_INSETS));

        moneyField = new JTextField();
        dialog.add(moneyField, new GBC(0,1,2,
                1).setWeight(100,0).setFill(GBC.BOTH)
                  .setInsets(DEFAULT_INSETS));


        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(e -> {
            dialog.setVisible(false);
        });

        dialog.add(cancelButton, new GBC(0,2).setInsets(5));
        JButton okButton = new JButton("Add");
        okButton.addActionListener(e -> okButtonListener());
        dialog.add(okButton, new GBC(1,2).setAnchor(GBC.EAST)
                                         .setInsets(DEFAULT_INSETS));
    }

    private void okButtonListener(){
        String moneyStringValue = moneyField.getText();
        double amountDoubleValue;
        try {
            amountDoubleValue = Double.parseDouble(moneyStringValue);
        } catch(NumberFormatException e1) {
            JOptionPane.showConfirmDialog(dialog,
                    "Invalid amount!","Error", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        //TODO: send data from fields to ClientDatabase
        moneyField.setText("");
        dialog.setVisible(false);
    }

    public void setVisible(boolean b){
        dialog.setVisible(b);
    }
}