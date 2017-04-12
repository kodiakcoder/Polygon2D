import java.util.Scanner;

class Polygon2D
{

  private Point2D[] vertices;
  
  public Polygon2D(Point2D[] inPts)
  {
   vertices = inPts; 
  }
  
  public Point2D getPoint(int n)
  {
   return vertices[n]; 
  }
  
  public double getxMin()
  {
    double min  = vertices[0].getx();
   for(int count = 0 ; count < vertices.length; count++)
   {
     if(vertices[count].getx() < min)
     {
    	 min = vertices[count].getx();
     }
   }
   return min;
  }
  public double getxMax()
  {
   double max = vertices[0].getx();
   for(int count = 1;count < vertices.length;count++)
   {
     if (vertices[count].getx() > max)
     {
      max = vertices[count].getx();
    }
   }
   return max;
  }
  
  
  public int getNumbVertices()
  {
	  return vertices.length;
  }
  

 public void changePoint(int n, double newx, double newy)
  {
   vertices[n].setx(newx);
   vertices[n].sety(newy);
  }
  
  
  public double getArea()
  {
	  double area = 0;
	  int j = 0;
  for (int i = 0; i < vertices.length; i++) 
  {
	   j = (i + 1) % vertices.length;
	   area = area + vertices[i].getx() * vertices[j].gety();
	   area = area - vertices[j].getx() * vertices[i].gety();
	  }
	  area = (area)/ 2;
	  return (area);
  }
  
 public static Polygon2D getPolygon()
 {
	 Scanner input = new Scanner(System.in);
	 int n = 0;
	 
	 System.out.println("How many points does the polygon have ? Enter below : ");
	 n = input.nextInt();
	 
	 Point2D[] inV = new Point2D[n];
	 for( int i = 0; i < n; i++)
	 {
		 
		 System.out.println("Enter the x coordinate of point " + i +" : ");
		 double xIn = input.nextDouble();
		 System.out.println("Enter the y coordinate point " + i +" : ");
		 double yIn = input.nextDouble();
		 inV[i] = new Point2D(xIn,yIn);
		 
		 
	 }
	 Polygon2D mypolygon = new Polygon2D(inV);
	 return mypolygon;
 }

 

 
 
 
 
 
 
 
 
 
 
 
}