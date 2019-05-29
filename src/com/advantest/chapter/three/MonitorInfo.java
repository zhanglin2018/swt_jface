package com.advantest.chapter.three;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Monitor;

/*
 * 
 * 3.1.5 
 */

public class MonitorInfo {
	public static void main(String[] args) {
		Display disp = Display.getDefault();
		Monitor monitor = disp.getPrimaryMonitor();
		System.out.println(monitor.getClientArea());
		System.out.println(monitor.getBounds());
	}

}
