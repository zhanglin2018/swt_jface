package com.advantest.chapter.three;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class BlankWindow3 {

	public static void main(String[] args) {
		Display display = Display.getDefault();
		Shell shell = new Shell(display);
		shell.setSize(100, 100);
		
		Display display1 = Display.getDefault();
		shell.open();
		shell.layout();
		
//		Display display2 = new Display(); // error
		
		
		System.out.println(display.equals(display1));
//		System.out.println(display1.equals(display2));
		
		Display display3 = Display.getDefault();

//		System.out.println(display2.equals(display3));
		
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}
}
