package applet_test;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class FirstTest_SimpleApplet extends Applet{
	
	private static final long serialVersionUID = 1L;

	@Override
	public void init() {
		setBackground(Color.cyan);
		super.init();
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawString("hello world", 0, 10);
		super.paint(g);
	}

}
