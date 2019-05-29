package com.advantest.chapter.three;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/*
 * 3.1.4 
 */

public class DisplayDispose {
	
	public static void main(String[] args) {
		Display display = Display.getDefault();
		Shell shell1 = new Shell(display);
		shell1.setSize(200, 100);

		Button button = new Button(shell1, SWT.NONE);
		button.setText("Dispose Display");
		button.setBounds(10, 10, 120, 120);
		
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Display.getDefault().dispose();
			}
		});

		shell1.open();
		
		Shell shell2 = new Shell(display);
		shell2.setSize(200, 100);
		shell2.open();

		while (!(shell1.isDisposed() && shell2.isDisposed())) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		
		display.dispose();
	}

}
