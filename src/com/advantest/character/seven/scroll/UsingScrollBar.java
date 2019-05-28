package com.advantest.character.seven.scroll;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Slider;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;

public class UsingScrollBar {

	public static void main(String[] args) {
		Display display = Display.getDefault();
		Shell shell1 = new Shell(display, SWT.SHELL_TRIM);
		shell1.setSize(300, 200);
		shell1.setLayout(new FillLayout());
		
		Image image = new Image(display, UsingScrollBar.class.getResourceAsStream("dddgs04.jpg"));
		
		ScrolledComposite scrolledComposite = new ScrolledComposite(shell1, SWT.HORIZONTAL|SWT.VERTICAL);
		
		Label label = new Label(scrolledComposite, SWT.NONE);
		
		label.setImage(image);
		
		label.pack();
		
		scrolledComposite.setContent(label);
		
		shell1.open();

		while (!(shell1.isDisposed())) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		
		display.dispose();
	}	
	
}
