package com.advantest.character.seven.tree;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

import java.awt.TexturePaint;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.TreeEvent;
import org.eclipse.swt.events.TreeListener;
import org.eclipse.swt.widgets.TreeColumn;

public class UsingTree {

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
		
		tree = new Tree(sShell, SWT.CHECK|SWT.MULTI); // check style
		
		tree.setHeaderVisible(true);
		tree.setLinesVisible(true);
		
		TreeColumn treeColumn = new TreeColumn(tree, SWT.NONE);
		treeColumn.setWidth(100);
		treeColumn.setText("Column 1");
		
		TreeColumn treeColumn1 = new TreeColumn(tree, SWT.NONE);
		treeColumn1.setWidth(100);
		treeColumn1.setText("Column 2");
		
		TreeItem root1 = new TreeItem(tree,SWT.NONE);
		root1.setText(new String[]{"Root 1","Root 1 Content"});
		
		TreeItem root2 = new TreeItem(tree,SWT.NONE);
		root2.setText(new String[]{"Root 2","Root 2 Content"});
		
		TreeItem child1 = new TreeItem(root1,SWT.NONE);
		child1.setText("Child 1");
		
		TreeItem child2 = new TreeItem(root1,SWT.NONE);
		child2.setText("Child 2");
		
		TreeItem child3 = new TreeItem(root2,SWT.NONE);
		child3.setText("Child 3");
		
		root1.setExpanded(true);
		
		tree.addTreeListener(new TreeListener() {
			
			@Override
			public void treeExpanded(TreeEvent arg0) {
				if (root1.equals(arg0.item)){
					System.out.println(arg0.item);
					root2.setExpanded(false);
				}
				
				if (root2.equals(arg0.item)){
					System.out.println(arg0.item);

					root1.setExpanded(false);
				}
			}
			
			@Override
			public void treeCollapsed(TreeEvent arg0) {
				if (root1.equals(arg0.item)){
					System.out.println(arg0.item);

					root2.setExpanded(true);
				}
				
				if (root2.equals(arg0.item)){
					System.out.println(arg0.item);

					root1.setExpanded(true);
				}
			}
		});
		
		tree.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println("widgetSelected: " + e.item);
				super.widgetSelected(e);
			}
		});
		
		sShell.open();
		
		sShell.layout();


		while (!sShell.isDisposed())
			if (!display.readAndDispatch())
				display.sleep();
		
	}

}
