package com.advantest.character.three;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class BlankWindow2 {

	public static void main(String[] args) {
		Display display = Display.getDefault();
		Shell shell = new Shell(display);
		shell.setSize(100, 100);
		
		Display display1 = Display.getDefault();
		shell.open();
		shell.layout();
		
		System.out.println(display.equals(display1));

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}
}
