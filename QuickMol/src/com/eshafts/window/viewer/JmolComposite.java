/**
 * The code should never changed.
 * Copyright By Wenhao Wei @2016
 */
package com.eshafts.window.viewer;

import java.awt.Dimension;
import java.awt.Graphics;

import org.eclipse.swt.widgets.Composite;
import org.jmol.adapter.smarter.SmarterJmolAdapter;
import org.jmol.api.JmolAdapter;
import org.jmol.api.JmolViewer;

import javafx.fxml.Initializable;

/**
 * introduction: Jmol组件整合，用于主界面的
 * JmolComposite.java, Created by @author AlphaWei at 2016年9月25日
 *
 */
public class JmolComposite extends Composite {

	private static JmolViewer viewer;
	
	private static JmolAdapter adapter;
	
	private static final Dimension CURRENT_SIZE = new Dimension();
	
	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public JmolComposite(Composite parent, int style) {
		super(parent, style);
		
		initialize();

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	
	private void initialize() {
        adapter = new SmarterJmolAdapter();
        viewer = JmolViewer.allocateViewer(this, adapter);
        viewer.setColorBackground("black");
        viewer.evalString("set language en");
    }

}
