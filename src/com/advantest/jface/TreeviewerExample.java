package com.advantest.jface;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class TreeviewerExample {
	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("Tree viewer Example");
		
		shell.setBounds(100, 100, 200, 200);
		shell.setLayout(new FillLayout());
		
		final TreeViewer treeViewer = new TreeViewer(shell, SWT.SINGLE);
		treeViewer.setLabelProvider(new PersonListLabelProvider());
		
		treeViewer.setContentProvider(new PersonTreeContentProvider());
		
		treeViewer.setInput(Person.example());
	}

}
