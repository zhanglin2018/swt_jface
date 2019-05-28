package com.advantest.character.seven.tree;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;



public class UsingTreeViewer {

	private static Shell sShell = null;
	private static Tree tree = null;

	/**
	 * This method initializes sShell
	 */
	public static void main(String[] args) {
		Display display = Display.getDefault();
		sShell = new Shell(display);
		sShell.setText("Shell");
		sShell.setSize(new Point(349, 252));
		sShell.setLayout(new FillLayout());
		
		tree = new Tree(sShell, SWT.NONE);
		tree.setHeaderVisible(true);
		tree.setLinesVisible(true);
		TreeColumn treeColumn = new TreeColumn(tree, SWT.NONE);
		treeColumn.setWidth(60);
		treeColumn.setText("ID");
		TreeColumn treeColumn1 = new TreeColumn(tree, SWT.NONE);
		treeColumn1.setWidth(60);
		treeColumn1.setText("Name");
		
		TreeViewer treeViewer = new TreeViewer(tree);
		
		treeViewer.setContentProvider(new UserTreeContentProvider());
		treeViewer.setLabelProvider(new TreeLabelProvider());
		
		User president = new User("0","President");
		UserStructure input = new UserStructure(president);
		treeViewer.setInput(input);
		
		input.add(new int[]{}, new User("0", "hua wei"));
		input.add(new int[]{}, new User("1", "apple"));

		input.add(new int[]{0}, new User("2", "Manager0"));
		input.add(new int[]{0}, new User("3", "Manager1"));
		
		
		
		sShell.open();
		sShell.layout();

		while (!sShell.isDisposed())
		{
			if (!display.readAndDispatch())
			{
				display.sleep();
			}
		}
		
	}

}
