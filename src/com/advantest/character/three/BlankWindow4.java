package com.advantest.character.three;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class BlankWindow4 {

	public static void main(String[] args) {
		Display display = new Display(); 
		
		Shell shell = new Shell(display);
		shell.setSize(100, 100);
		shell.open();
		shell.layout();
		
		Display display1 = Display.getDefault();
		
		
		System.out.println(display.equals(display1));
		
		new Thread() {
			public void run() {
				Display threadDisplay = new Display();
				
				System.out.println(threadDisplay);
				
				Display threadDisplay2 = Display.getCurrent(); //returns the display which the currently running thread.
				
				System.out.println("thread:" + threadDisplay.equals(threadDisplay2));
				
				threadDisplay2.dispose();
			};
		}.start();
		
		
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		
		display.dispose();
	}
}
