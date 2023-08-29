package drawing;

import java.awt.Color;
import java.awt.Graphics;

public class Donut extends Circle {

	private int innerRadius;

	public int getInnerRadius() {
		return innerRadius;
	}

	public void setInnerRadius(int innerRadius) {
		this.innerRadius = innerRadius;
	}
	
	public Donut() {
		
	}
	
	public Donut(Point center,int radius,int innerRadius) {
		super(center,radius);
		this.innerRadius = innerRadius;
	}
	
	public Donut(Point center,int radius,int innerRadius,boolean selected) {
		this(center,radius,innerRadius);
		setSelected(selected);
	}
	
	public String toString() {
		return "Donut [ innerRadius = " + innerRadius + " , [Outer " + super.toString() + "]]";
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.black);
		g.setColor(getOutline());
		super.draw(g);
		g.drawOval(this.getCenter().getX() - this.getInnerRadius(), 
				   this.getCenter().getY() - this.getInnerRadius(), 
				   this.getInnerRadius()*2, this.getInnerRadius()*2);
	}
	
	public boolean contains(int x, int y) {
		return super.contains(x, y) && this.getCenter().distance(x, y)>=this.getInnerRadius();
	}
	
	@Override
	public void DialogEdit() {
		DlgDonut dlgDonut = new DlgDonut();
		for(Shape shape : PnlDrawing.shapesArrList) {
			if(shape.isSelected()) {
				String[] split = shape.toString().split(" ");
				dlgDonut.getTxtXCoord().setText(split[12]);
				dlgDonut.getTxtYCoord().setText(split[15]);
				dlgDonut.getTxtRadius().setText(split[21]);
				dlgDonut.getTxtInnerRadius().setText(split[4]);
			}
		}
		dlgDonut.setVisible(true);
		
	}
	
	
	@Override
	public void AreaPainter(Graphics g) {
		super.AreaPainter(g);
		g.setColor(getFill());
		g.drawOval(this.getCenter().getX() - this.getInnerRadius(), this.getCenter().getY() - this.getInnerRadius(), this.getInnerRadius() *2, this.getInnerRadius() *2);
		g.setColor(Color.white);
		g.fillOval(this.getCenter().getX() - this.getInnerRadius(), this.getCenter().getY() - this.getInnerRadius(), this.getInnerRadius() *2, this.getInnerRadius() *2);
	}
	}
