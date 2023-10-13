
abstract class Shape implements Comparable<Shape> {
	protected Point origin;
	protected Text name;
	abstract protected Double area();
	abstract protected Double perimeter();
	abstract protected Double volume();
	//abstract public int compareTo();
	
	protected Shape(Double x_origin, Double y_origin, String name, Colour colour){
		
		origin = new Point(x_origin,y_origin, colour);
		this.name = new Text(name);
	}


	protected Point  getOrigin()   {
		return origin;
	}
	
	protected String  getName()   {
		return name.getText();
	}
	 
	
	protected  Double distance(   Shape  other){
		return origin.distance(other.origin);
	}
	
	protected Double  distance(Shape a, Shape  b){
		return Point.distance(a.origin, b.origin);
	}
	
	
	protected void  move(Double dx, Double dy){
		origin.setx(origin.getx()+dx);
		origin.sety(origin.gety()+dy);
	}
	
	@Override
	public String toString(){
		String s = "\nShape name: " + name + "\nOrigin: " + origin;
		return s;
	}
	
	//compare the area to the other shape
	// return -1 if less than, 1 if greater than
	public int compareTo(Shape other) {
		
		return this.area() < other.area() ? -1 : (this.area() > other.area() ? 1 : 0);
		
		
	}
}

