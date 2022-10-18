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
//		paintSomeGeometry(g);
		//畫出圓
		drawCircle(g,100,100,30,50,Color.BLUE);
		
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
	
	//畫出定位點
	private void drawDot(Graphics g,int x, int y,int r,Color color) {
		Color originalColor = g.getColor();
		g.setColor(color);
		g.fillOval(x-r, y-r,r*2 , r*2);
		g.setColor(originalColor);
	}
	
	//畫出輔助弧線，用來表示角度
		private void drawAngle(Graphics g,int x, int y,int r,int degree,Color color) {
			Color originalColor = g.getColor();
			g.setColor(color);
			g.drawArc(x-r, y-r,r*2 , r*2, 0,degree);
			g.setColor(originalColor);
		}
	
	
	/***畫出圓
	 * 
	 * @param g 
	 * @param x 圓心x
	 * @param y 圓心y
	 * @param r 半徑
	 * @param accuracy 精度，表示用幾條線段構成這個圓，值越高越像個圓
	 * @param color
	 */
	private void drawCircle(Graphics g,int x, int y,int r,int accuracy,Color color) {
		Color originalColor = g.getColor();
		
		//標出圓心
		drawDot(g,x,y,3,Color.red);
		//每線段對應角度
		float perDegree = 360/(float)accuracy;
		//當前xy，畫出線段用
		double nowx=0,nowy=0;
		//上一個點的xy，畫出線段用
		double lastx=0,lasty=0;
		for(int i =0;i<=accuracy;i++) {
			//當前角度
			float nowDegree = perDegree*i;
			System.out.println("nowDegree:"+nowDegree);
			//x = 半徑*cos(theda)+圓心，y=半徑*sin(theda)+圓心
			//pi = 圓周/直徑，
			nowx = r*Math.cos(nowDegree/180*Math.PI)+x;
			nowy = r*Math.sin(nowDegree/180*Math.PI)+y;
			//每個點顏色越來越淡
			Color nowColor = new Color(1*i,255/accuracy*i,255/accuracy*i);
			drawDot(g,(int)Math.round(nowx),(int)Math.round(nowy), 3, nowColor);
			
			//角度輔助線
//			g.setColor(nowColor);
//			drawAngle(g,x,y,i*r/accuracy,-(int)nowDegree,nowColor);
//			g.drawLine(x, y,(int)Math.round(nowx),(int)Math.round(nowy));
//			g.drawLine((int)Math.round(nowx), y,(int)Math.round(nowx),(int)Math.round(nowy));
//			g.setColor(Color.black);
			
			//第一個點以外皆和上一個點連線畫出線段
			
			if(i>0) {
				g.drawLine((int)Math.round(lastx), (int)Math.round(lasty),(int)Math.round(nowx),(int)Math.round(nowy));
			}
			lastx = nowx;
			lasty = nowy;
		}
		g.setColor(color);
		
		g.setColor(originalColor);
	}

}
