package applet_test;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class SecondTest_DrawCircleByLineSegment extends Applet {
	private static final long serialVersionUID = 1L;

//	這個window的大小預計為800*500
	final int WIDTH = 800;
	final int HEIGHT = 500;

	@Override
	public void init() {
		// 改變底色為淡黃
		setBackground(new Color(255, 255, 200));
	}

	@Override
	public void paint(Graphics g) {
		// 畫出10*10的格子
		paintGrid(g);
		
		//隨便畫一些圖形
		paintSomeGeometry(g);
		
		
		super.paint(g);
	}

	
	private void paintGrid(Graphics g) {
		Color originalColor = g.getColor();
		// 改畫筆顏色:淡灰色
		Color custom_gray = new Color(230, 230, 230);
		g.setColor(custom_gray);
		// 畫直線:x不變，y=0~maxY(畫布高)
		for (int i = 0; i < WIDTH; i += 10)
			g.drawLine(i, 0, i, HEIGHT);
		// 畫橫線:y不變，x=0~maxX(畫布寬)
		for (int i = 0; i < HEIGHT; i += 10)
			g.drawLine(0, i, WIDTH, i);
		g.setColor(originalColor);
	}
	
	private void paintSomeGeometry(Graphics g) {
		Color originalColor = g.getColor();
		g.setColor(Color.RED);
		g.drawRect(10, 10, 100, 200);
		
		g.setColor(Color.GREEN);
		g.drawOval(200, 10, 100, 200);
		
		g.setColor(Color.BLUE);
		g.drawLine(400, 10, 400, 200);
		
		g.setColor(Color.PINK);
		int [] xArray = {430,410,430,410,430,410} ;
		int [] yArray = {10,50,60,100,110,150};
		g.drawPolygon( xArray, yArray, xArray.length);
		g.setColor(originalColor);
	}

}
