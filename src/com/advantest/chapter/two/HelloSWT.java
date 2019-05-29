package com.advantest.chapter.two;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.widgets.*;

public class HelloSWT extends Shell {
	private static Text text;
	private static Button swtButton;
	private static Button swingButton;
	private static Button awtButton;
	private static Group group;
	private static Button button;
	private static Label benefitOfSwtLabel;
	private static List list;

	public static void main(String[] args) {
		Display display = Display.getDefault();
		final Shell shell = new Shell(display);
		shell.setText("Hello SWT");
		shell.setSize(260, 283);
		shell.open();

		text = new Text(shell, SWT.BORDER);
		text.setText("SWT is a tool kit");
		text.setBounds(10, 8, 230, 35);

		list = new List(shell, SWT.BORDER);
		list.setItems(new String[] {"native widget",
				"provide a set of code",
				"faster",
				"more and more..." 
				});
		list.setBounds(10, 68, 232, 82);

		benefitOfSwtLabel = new Label(shell, SWT.NONE);
		benefitOfSwtLabel.setText("benefit: ");
		benefitOfSwtLabel.setBounds(10, 49, 90, 15);

		group = new Group(shell, SWT.NONE);
		group.setText("which of tool kit do you use?");
		group.setBounds(10, 159, 230, 47);

		awtButton = new Button(group, SWT.CHECK);
		awtButton.setText("AWT");
		awtButton.setBounds(10, 20, 54, 18);

		swingButton = new Button(group, SWT.CHECK);
		swingButton.setText("Swing");
		swingButton.setBounds(70, 22, 60, 15);

		swtButton = new Button(group, SWT.CHECK);
		swtButton.setBounds(136, 22, 62, 15);
		swtButton.setText("SWT");

		button = new Button(shell, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent e) {
				MessageBox msgBox = new MessageBox(shell, SWT.ICON_INFORMATION);
				msgBox.setMessage("Hello SWT!");
				msgBox.open();
			}
		});
		
		button.setText("say hello to SWT!");
		button.setBounds(10, 214, 227, 25);

		shell.layout();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

}
