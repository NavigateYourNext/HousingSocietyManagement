import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ErrorDialog 
	{
		ErrorDialog()
		{
		 String message = "Data Added Successfully.";
		 JOptionPane.showMessageDialog(new JFrame(), message, "Done!",
         JOptionPane.ERROR_MESSAGE);
		}

  public static void main(String argv[])
	  {
			new ErrorDialog();
	  }
}


