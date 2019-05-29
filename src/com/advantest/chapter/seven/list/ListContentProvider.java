package com.advantest.chapter.seven.list;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.Viewer;

public class ListContentProvider implements IStructuredContentProvider,
		PropertyChangeListener {

	private ListViewer viewer;

	private ListModel model;

	@Override
	public Object[] getElements(Object arg0) {
		return model.elements();
	}

	public void dispose() {
	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		this.viewer = (ListViewer) viewer;

		if (oldInput instanceof ListModel)
			((ListModel) oldInput).removePropertyChangeListener(this);

		if (newInput instanceof ListModel) {
			this.model = (ListModel) newInput;
			((ListModel) newInput).addPropertyChangeListener(this);
		}

	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if (ListModel.ADD_ELEMENT.equals(evt.getPropertyName()))
			viewer.add(evt.getNewValue());
		if (ListModel.REMOVE_ELEMENT.equals(evt.getPropertyName()))
			viewer.remove(evt.getNewValue());
	}

}
