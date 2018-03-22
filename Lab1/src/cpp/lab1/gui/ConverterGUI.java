package cpp.lab1.gui;

import cpp.lab1.logic.Converter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import java.text.DecimalFormat;

/**
 * Provides GUI for a {@link Converter} class.
 * <p>
 * Contents a shell with 2 {@link Label}, 2 {@link Text} and 2 {@link Button}
 * on it that gives user a possibility to convert metres to inches
 * and backwards.
 */
public class ConverterGUI {
    /**
     * Number of columns in GridLayout.
     */
    private static final int N_COLUMNS = 2;
    /**
     * Array of label names.
     */
    private static final String[] VALUE_NAMES = {"Метры", "Дюймы"};
    /**
     * Indent between button and text field.
     */
    private static final int BUTTONS_VERTICAL_INDENT = 10;
    /**
     * Minimum width of GUI shell.
     */
    private static final int MINIMUM_WIDTH = 400;
    /**
     * Minimum height of GUI shell.
     */
    private static final int MINIMUM_HEIGHT = 180;
    /**
     * Default number decimal digits that are showed in a text field
     * after converting.
     */
    private static final int N_DECIMAL_DIGITS_DEFAULT = 2;


    private Shell shell;
    private Label metreLabel;
    private Label inchLabel;
    private Text metreTextField;
    private Text inchTextField;
    private Button metreToInchConvertButton;
    private Button inchToMetreConvertButton;


    /**
     * Construct a new instance of a class on a display.
     * @param display a display object to create a shell on it
     */
    public ConverterGUI(final Display display) {
        shell = new Shell(display);
        GridLayout shellLayout = new GridLayout(N_COLUMNS, true);
        shell.setLayout(shellLayout);
        buildLabels();
        buildTextFields();
        buildConvertButtons();
        shell.setMinimumSize(MINIMUM_WIDTH, MINIMUM_HEIGHT);
        shell.setSize(MINIMUM_WIDTH, MINIMUM_HEIGHT);
    }

    /**
     * Calls {@code Shell.open()} method.
     */
    public void open() {
        shell.open();
    }

    /**
     * Calls {@code Shell.setMinimumSize(int, int)} method.
     *
     * @param width  specifies shell width in pixels
     * @param height specifies shell width in pixels
     */
    public void setMinimumSize(final int width, final int height) {
        shell.setMinimumSize(width, height);
    }

    /**
     * Calls {@code Shell.isDisposed()<} method.
     * @return true if this widget has been disposed, and false otherwise
     */
    public boolean isDisposed() {
        return shell.isDisposed();
    }

    /**
     * Creates, customizes and adds labels on interface.
     */
    private void buildLabels() {
        metreLabel = new Label(shell, SWT.HORIZONTAL);
        buildLabel(metreLabel, VALUE_NAMES[0]);
        inchLabel = new Label(shell, SWT.HORIZONTAL);
        buildLabel(inchLabel, VALUE_NAMES[1]);
    }

    /**
     * Customizes and adds single label on interface.
     * @param valueLabel a label that should be built
     * @param text       a label's text
     */
    private void buildLabel(final Label valueLabel, final String text) {
        valueLabel.setText(text);
        GridData gridData = new GridData();
        valueLabel.setLayoutData(gridData);
    }

    /**
     * Creates, customizes and adds text input fields on interface.
     */
    private void buildTextFields() {
        metreTextField = new Text(shell, SWT.SINGLE | SWT.BORDER);
        buildTextField(metreTextField);
        inchTextField = new Text(shell, SWT.SINGLE | SWT.BORDER);
        buildTextField(inchTextField);
    }

    /**
     * Customizes and adds single text field on interface.
     * @param textField a text field that should be built
     */
    private void buildTextField(final Text textField) {
        GridData gridData = new GridData();
        gridData.horizontalAlignment = GridData.FILL;
        gridData.grabExcessHorizontalSpace = true;
        textField.setLayoutData(gridData);
    }

    /**
     * Creates, customizes and adds buttons on interface.
     */
    private void buildConvertButtons() {
        metreToInchConvertButton = new Button(shell, SWT.PUSH);
        buildConvertButton(metreToInchConvertButton,
                VALUE_NAMES[0] + " в " + VALUE_NAMES[1]);
        metreToInchConvertButton.addListener(SWT.Selection, event -> {
            if (metreTextField.getText().isEmpty()) {
                return;
            }
            String metreStringValue = metreTextField.getText();
            if (isDouble(metreStringValue)) {
                inchTextField.setText(getTextDecimalFormat(metreStringValue)
                        .format(Converter.metreToInch(Double
                                .parseDouble(metreStringValue))));
            }
        });

        inchToMetreConvertButton = new Button(shell, SWT.PUSH);
        buildConvertButton(inchToMetreConvertButton,
                VALUE_NAMES[1] + " в " + VALUE_NAMES[0]);
        inchToMetreConvertButton.addListener(SWT.Selection, event -> {
            if (inchTextField.getText().isEmpty()) {
                return;
            }
            String inchStringValue = inchTextField.getText();
            if (isDouble(inchStringValue)) {
                metreTextField.setText(getTextDecimalFormat(inchStringValue)
                        .format(Converter.inchToMetre(Double
                                .parseDouble(inchStringValue))));
            }
        });
    }

    /**
     * Customizes and adds single button on interface.
     * @param convertButton a button that should be built
     * @param text          a button's text
     */
    private void buildConvertButton(final Button convertButton,
                                    final String text) {
        convertButton.setText(text);
        GridData gridData = new GridData();
        gridData.verticalIndent = BUTTONS_VERTICAL_INDENT;
        convertButton.setLayoutData(gridData);
    }

    /**
     * Checks is string can be converted to double.
     *
     * @param str source string
     * @return {@code true} if string can be converted, {@code false} instead
     */
    private boolean isDouble(final String str) {
        try {
            Double.parseDouble(str);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    /**
     * Creates {@link DecimalFormat} object with certain fraction digits
     * numbers built on stringValue content.
     * @param stringValue text from source Text object
     * @return DecimalFormat object
     */
    private DecimalFormat getTextDecimalFormat(final String stringValue) {
        int numberOfDecimalDigit = stringValue.indexOf('.') == -1 ? 0
                : stringValue.length() - stringValue.indexOf('.') - 1;
        DecimalFormat decimalFormat = new DecimalFormat();
        decimalFormat.setMaximumFractionDigits(
                numberOfDecimalDigit > N_DECIMAL_DIGITS_DEFAULT
                        ? numberOfDecimalDigit : N_DECIMAL_DIGITS_DEFAULT);
        return decimalFormat;
    }



//    public void setNDecimalDigitsDefault(int nDecimalDigitsDefault) {
//        this.N_DECIMAL_DIGITS_DEFAULT = nDecimalDigitsDefault;
//    }
//
//    public int getNDecimalDigitsDefault() {
//        return N_DECIMAL_DIGITS_DEFAULT;
//    }

//    //Allows subclassing
//    protected void checkSubclass() {
//
//    }

}
