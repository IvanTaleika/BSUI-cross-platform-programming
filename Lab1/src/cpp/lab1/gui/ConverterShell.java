package cpp.lab1.gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;

public class ConverterShell extends Shell {
    public final int nColumns = 2;
    public final String[] valueNames = {"Метры", "Дюймы"};

    private Label[] valueLabels;
    private Text[] valueTextFields;
    private Button[] convertButtons;
    private GridLayout shellLayout;

    public ConverterShell(Display display) {
        super(display);
        shellLayout = new GridLayout(nColumns, true);
        setLayout(shellLayout);
        buildLabels();
        buildTextFields();
        buildConvertButtons();
        pack();
    }

    private void buildLabels() {
        valueLabels = new Label[nColumns];
        for(int i = 0; i < nColumns; i++) {
            buildLabel(valueLabels[i], valueNames[i]);
        }
    }

    private void buildLabel(Label valueLabel, String text) {
        valueLabel = new Label(this, SWT.HORIZONTAL);
        valueLabel.setText(text);
        GridData gridData = new GridData();
//        gridData.verticalAlignment = GridData.CENTER;
        valueLabel.setLayoutData(gridData);
    }

    private void buildTextFields() {
        valueTextFields = new Text[nColumns];
        for(int i = 0; i < nColumns; i++) {
            buildTextField(valueTextFields[i]);
        }
    }

    private void buildTextField(Text textField) {
        textField = new Text(this, SWT.SINGLE | SWT.BORDER);
        GridData gridData = new GridData();
        gridData.horizontalAlignment = GridData.FILL;
        gridData.grabExcessHorizontalSpace = true;
//        gridData.verticalAlignment = GridData.CENTER;
        textField.setLayoutData(gridData);
    }

    private void buildConvertButtons() {
        convertButtons = new Button[nColumns];
        buildConvertButton(convertButtons[0], valueNames[0] + " в " + valueNames[1]);
        buildConvertButton(convertButtons[1], valueNames[1] + " в " + valueNames[0]);
    }

    private void buildConvertButton(Button convertButton, String text){
        convertButton = new Button(this, SWT.PUSH);
        convertButton.setText(text);
        GridData gridData = new GridData();
        gridData.verticalIndent = 10;
//        gridData.verticalAlignment = GridData.END;
        convertButton.setLayoutData(gridData);
    }

    //Allows subclassing
    protected void checkSubclass() {

    }

}
