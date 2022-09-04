/*import java.io.*;

class InvalidDayException extends Exception
{
  public String toString ()
  {
    return "Invalid Day !!";
  }
}

class InvalidMonthException extends Exception
{
  public String toString ()
  {
    return "Invalid Month !!";
  }
}

class MyDate
{
  public static void main (String ... args)
  {
    try
    {
      int dd = Integer.parseInt (args[0]);
      int mm = Integer.parseInt (args[1]);
      int yy = Integer.parseInt (args[2]);
      boolean leap = ((yy % 4 == 0 || yy % 400 == 0)
	    && (yy % 100 != 0));
      switch (mm)
	{
	case 1:
	case 3:
	case 5:
	case 7:
	case 8:
	case 10:
	case 12:
	  if (dd < 0 || dd > 31)
	    throw new InvalidDayException ();
	    break;
	  case 4:case 6:case 9:case 11:if (dd < 0 || dd > 30)
	    throw new InvalidDayException ();
	    break;
	  case 2:
	  if (leap)
	    {
	      if (dd < 0 || dd > 29)
		throw new InvalidDayException ();
	    }
	 else if (dd < 0 || dd > 28)
	    throw new InvalidDayException ();
	  break;
	default:
	  throw new InvalidMonthException ();
	}
      System.out.println ("Valid Date!!");
    }

    catch (InvalidDayException e)
    {
      System.out.println (e);
    }
    catch (InvalidMonthException e)
    {
      System.out.println (e);
    }
    catch (Exception e)
    {
      System.out.println (e);
    }
  }
}
*/