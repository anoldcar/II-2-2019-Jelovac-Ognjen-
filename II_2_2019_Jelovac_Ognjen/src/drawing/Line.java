package drawing;

import java.awt.Color;
import java.awt.Graphics;

public class Line extends Shape {
	
	private Point start;
	private Point end;

	
	public Point getStart() {
		return start;
	}
	public void setStart(Point start) {
		this.start = start;
	}
	public Point getEnd() {
		return end;
	}
	public void setEnd(Point end) {
		this.end = end;
	}
	
	public Line() {
		
	}
	
	public Line(Point start, Point end) {
		this.start = start;
		this.end = end;
	}
	
	public Line(Point start,Point end,boolean selected) {
		this(start,end);
		setSelected(selected);
	}
	
	public String toString() {
		return "Line [start= " + start + ", end= " + end + ",selected = " + isSelected() + "]";
	}
	
	public Point middleOfLine() {
		int middleX = (this.getStart().getX() + this.getEnd().getX())/2;
		int middleY = (this.getStart().getY() + this.getEnd().getY())/2;
		Point middle = new Point(middleX,middleY);
		return middle;
	}
	@Override
	public int compareTo(Object o) {
		return 0;
	}
	@Override
	public void draw(Graphics g) {
		g.setColor(Color.black);
		g.setColor(getOutline());
		g.drawLine(this.getStart().getX(), this.getStart().getY(), this.getEnd().getX(), this.getEnd().getY());
		if(isSelected() == true) {
			g.drawRect(this.getStart().getX() -3, this.getStart().getY()-3,6,6);
			g.drawRect(this.getEnd().getX()-3, this.getEnd().getY()-3, 6, 6);
			g.drawRect(this.middleOfLine().getX()-3, this.middleOfLine().getY() -3, 6,6);
		}
	}
	
	public double lenght() {
		return start.distance(end.getX(), end.getY());
	}
	@Override
	public boolean contains(int x, int y) {
		return (start.distance(x, y) + end.distance(x, y))- lenght()<0.1;
	}
	@Override
	public void move(int newX, int newY) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void DialogEdit() {
		DlgLine dlgLine = new DlgLine();
		for(Shape shape : PnlDrawing.shapesArrList) {
			if(shape.isSelected()) {
				String[] split = shape.toString().split(" ");
				dlgLine.getTxtXStart().setText(split[4]);
				dlgLine.getTxtYStart().setText(split[7]);
				dlgLine.getTxtXEnd().setText(split[15]);
				dlgLine.getTxtYEnd().setText(split[18]);
			}
		}
		dlgLine.setVisible(true);
		
	}
	@Override
	public void AreaPainter(Graphics g) {
		// TODO Auto-generated method stub
		
	}

}
