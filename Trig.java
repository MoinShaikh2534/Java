package MyMath;
public class Trig
{
  double angle;
  public Trig(double Ang)
 {
   angle=Ang;
 }
  public double getSin()
   {
          return Math.sin(angle);
   }
  public double getCosin()
  {
       return Math.cos(angle);
  }
  public double getTan()
 {
       return Math.tan(angle);

  }
 public double getSec()
 {
       return 1.0 / Math.cos(angle);

 }
 public double getCosec()
 {
       return 1.0 / Math.sin(angle);

 }
public double getCotan()
  {
       return 1.0 / Math.tan(angle);

  }

}
