import java.util.*;

public class Program {

	public static void main(String[] args) 
	{
	int polyselect = 0, polychoice = 0, polypoint = 0 ;
	double newx=0 , newy = 0;
	boolean quit = true;
	Scanner input = new Scanner(System.in);
	System.out.println("Enter the number of polygons you want to enter : ");
	int numPolygons = input.nextInt();
	Vector<Polygon2D> polyVect = new Vector<Polygon2D>();
	for(int count = 0; count < numPolygons; count++)
	{
	 System.out.println("Enter the data for polygon no " + count);
	 polyVect.addElement(Polygon2D.getPolygon());	
	}
	
	System.out.println("The maximum area among all polygons is : " + getMaxArea(polyVect));
	System.out.println("The minimum area among all polygons is : " + getMinArea(polyVect));
	
	while(quit)
	{
	System.out.println("\nWhat is the index of the polygon you want to operate on: ");
	polyselect = input.nextInt();
	printchoice();
	polychoice = input.nextInt();
	

	switch(polychoice){
	case 1:
	{
		System.out.println("Which point of the polygon do you want to change : ");
		polypoint = input.nextInt();
		System.out.println("Enter the new x coordinate at this point : ");
		newx = input.nextDouble();
		System.out.println("Enter the new y coordinate at this point : ");
		newy = input.nextDouble();
		polyVect.elementAt(polyselect).changePoint(polypoint, newx, newy);
		System.out.println("The new area of this polygon is : " + polyVect.elementAt(polyselect).getArea());
		break;
	}
	case 2:
	{
		double maxiD = 0;
		double temp = 0;
		int j;
		for(int i = 0;i < polyVect.elementAt(polyselect).getNumbVertices(); i++)
		{
		for(  j = 1; j < (polyVect.elementAt(polyselect).getNumbVertices()); j++)							
			{
				
				temp = polyVect.elementAt(polyselect).getPoint(i).distance(polyVect.elementAt(polyselect).getPoint(j));
				if(temp > maxiD)
				{
					maxiD = temp;
				}
			}
			
		}
		System.out.printf("the maximum distance between (two distinct) points is : %.2f", maxiD);
		break;
	}
	
	case 3:
	{
		double miniD = Point2D.distance(polyVect.elementAt(polyselect).getPoint(0), polyVect.elementAt(polyselect).getPoint(1));
		double temp = 0;
		
		int j;
		for(int i = 0;i < polyVect.elementAt(polyselect).getNumbVertices(); i++)
		{
		for(  j = 1; j < (polyVect.elementAt(polyselect).getNumbVertices()); j++)							
			{
				
				temp = Point2D.distance(polyVect.elementAt(polyselect).getPoint(i), polyVect.elementAt(polyselect).getPoint(j));
				
				if(temp < miniD  && temp > 0.0)
				{
					miniD = temp;
					}
			}
			
		}
		
		System.out.printf("the minimum distance between (two distinct) points is : %.2f", miniD);
		break;
	}
	case 4:
	{
		quit = false;
		break;
	}
	}
	
	}
	input.close();
	}
	

	
	public static void printchoice()
	{
		System.out.println("Please enter one of the options below.");
		System.out.println("1. Change the coordinates of a point of this polygon, and print the new area.");
		System.out.println("2. Get the maximum distance between any two points, in the polygon.");
		System.out.println("3. Get the minimum distance between any two points, in the polygon.");
		System.out.println("4. Exit");
	}
	
	
	
	public static double getMaxArea(Vector<Polygon2D> polygons)
	{
		double maxarray[] = new double[polygons.size()];
		for(int count = 0 ; count< polygons.size(); count++)
		{
			maxarray[count] = polygons.elementAt(count).getArea();
		}
		Arrays.sort(maxarray);
		return maxarray[(polygons.size()-1)];
	
	}
	public static double getMinArea(Vector<Polygon2D> polygons)
	{
		double minarray[] = new double[polygons.size()];
		for(int count = 0 ; count< polygons.size(); count++)
		{
			minarray[count] = polygons.elementAt(count).getArea();
		}
		Arrays.sort(minarray);
		return minarray[0];
	
	}
	
}
