package com.advantest.chapter.three;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/*
 * 3.1.6
 */

public class UIThread_1 {

	public static void main(String args[]) {
		try {
			final Display display = Display.getDefault();
			Shell shell = new Shell(display, SWT.SHELL_TRIM);
			shell.setText("Multi Thread");
			shell.setSize(204, 92);
			
			final Button button = new Button(shell, SWT.NONE);
			System.out.println("start1==>" + Thread.currentThread().getName());

			button.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(final SelectionEvent e) {
					try {
						System.out.println("start==>" + Thread.currentThread().getName());
						Thread.sleep(10000);
						button.setText("Execution done");
						System.out.println("end==>" + Thread.currentThread().getName());

					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}
			});
			
			button.setText("button");
			button.setBounds(20, 15, 155, 25);

			shell.open();
			shell.layout();
			while (!shell.isDisposed()) {
				if (!display.readAndDispatch())
					display.sleep();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
