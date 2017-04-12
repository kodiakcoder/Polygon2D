
class Point2D
{
  private double x;
  private double y;
  
  
  public Point2D()
  {
  }
  
  public Point2D(double a, double b)
  {
    x = a;
    y = b;
  }
  
  public void setx(double a)
  {
    x = a;
  }
  
  public void sety(double b)
  {
    y = b;
  }
  
  public double getx()
  {
    return x;
  }
  
  public double gety()
  {
    return y;
  }
  
  public double distance(Point2D pt2)
  {
   double dist = Math.sqrt(Math.pow((pt2.x - this.x), 2) + Math.pow((pt2.y - this.y), 2)); 
   return dist;
  }
                    
  public static double distance(Point2D pt1,Point2D pt2)
  {
	  double dist = Math.sqrt(Math.pow((pt2.x - pt1.x), 2) + Math.pow((pt2.y - pt1.y), 2)); 
	  return dist;
  }
                           
                           
                           
                           
                           
                           
                           
                           
                           
                           
                           
                           
                           
}