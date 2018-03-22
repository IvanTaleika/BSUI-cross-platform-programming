package cpp.lab1;

import cpp.lab1.gui.ConverterShell;
import org.eclipse.swt.widgets.*;

public class Source {

	public static void main(String[] args) {
		Display display = new Display ();

		ConverterShell shell = new ConverterShell(display);
		shell.open ();
		shell.setMinimumSize(400,200);
		while (!shell.isDisposed ()) {
			if (!display.readAndDispatch ()) display.sleep ();
		}
		display.dispose ();
	}

}
