

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class FrmSplash extends JWindow implements Runnable{

	private static final long serialVersionUID = 1L;
	JLabel lbl;
	JTextField txt;
	int num=30;

	public void run(){
		JLabel SplashLabel = new JLabel(new ImageIcon("sun/mm1.jpg"));
		Dimension screen = 	Toolkit.getDefaultToolkit().getScreenSize();

		getContentPane().add(SplashLabel,BorderLayout.CENTER);

		setSize(500,667);
	//	setLocation((screen.width - 610)/2,((screen.height-390)/2));
		setLocationRelativeTo(null);
		setVisible(true);
		txt=new JTextField();
		txt.setBorder(new LineBorder(Color.black));
		txt.setBackground(Color.GREEN);
		for(int i=0;i<9;i++)
		{
			System.out.print("*");
			//lbl.setBounds(50,50,num=num+30 ,10);
			//add(lbl);

			txt.setBounds(140,360,num=num+30 ,10);
			add(txt);
			try
			{
			Thread.sleep(500);
			}
			catch(Exception e)
			{
				System.out.print(e);
			}
		}


	}
}
