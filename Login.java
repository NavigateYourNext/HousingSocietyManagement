/*Login screen*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.sql.*;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.MetalTheme;
import javax.swing.UIManager;


public class Login extends JFrame  implements ActionListener,KeyListener
{


	private static final long serialVersionUID = 1L;
	ImageIcon i;
	JLabel lblBack,lblUser,lblPass,lblAar,lblque,lbluse,lblask,lblans;
	JTextField txtUser,txtPa,txtuse,txtans;
	JPasswordField txtPass;
	JButton btnLog,btnExit,btnChange,getpass;
	String user,pass;
	String str1,str2;


	FrmSplash FormSplash = new FrmSplash();
	//--End variable the contains forms

	Thread ThFormSplash = new Thread(FormSplash);
	//End the form container variable

	Login()
	{


		try {
            javax.swing.UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
    	} catch (Exception e) {
    		//System.out.println("Error Loading Theme:" + e.toString());
			//If Failed to load the liquid them then load my own XPStyleTheme
//    		MetalTheme myXPStyleTheme = new XPStyleTheme();
 //   		MetalLookAndFeel.setCurrentTheme(myXPStyleTheme);
    		try {
    		    UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
    		} catch (Exception err) {
        		//System.out.println("Error loading myXPStyleTheme:" + err.toString());
   		 	}
   		}

		loadSplashScreen();

		//We will dispose now the FormSplash because it is now useless
		FormSplash.dispose();



		i=new ImageIcon("sun/back.png");


		lblAar=new JLabel("HOUSING SOCIETY MANAGEMENT \n SYSTEM",SwingConstants.CENTER);
		lblAar.setBounds(60,10,510,20);
		lblAar.setFont(new Font("Dialog",Font.BOLD,28));
		lblAar.setForeground(Color.red);

		lblBack=new JLabel(i);
		lblBack.setBounds(0,0,600,400);



		lblUser=new JLabel("User ID :",JLabel.RIGHT);
                lblUser.setForeground(Color.blue);
		lblUser.setBounds(355,120,80,20);


		lblPass=new JLabel("Password :",JLabel.RIGHT);
                lblPass.setForeground(Color.blue);
		lblPass.setBounds(355,180,80,20);


		txtUser=new JTextField(15);
		txtUser.setBounds(445,120,80,20);



		txtPass=new JPasswordField(15);
		txtPass.setBounds(445,180,80,20);




		btnLog=new JButton("Log In",new ImageIcon("housing/images/1rightarrow_hover.png"));
		btnLog.setToolTipText("LOGIN Alt+L");
		btnLog.setBounds(335,260,115,30);
		btnLog.addActionListener(this);
		btnLog.addKeyListener(this);
		btnLog.setMnemonic(KeyEvent.VK_L);




		btnExit=new JButton("Exit",new ImageIcon("housing/images/exit.png"));
		btnExit.setToolTipText("EXIT Alt+X");
		btnExit.setBounds(475,260,115,30);
		btnExit.addActionListener(this);
		btnExit.addKeyListener(this);
		btnExit.setMnemonic(KeyEvent.VK_X);

		btnChange=new JButton("Forgot Password?",new ImageIcon("housing/images/help.png"));
		btnChange.setBounds(380,300,160,30);
		btnChange.addActionListener(this);


		Container c=this.getContentPane();
		c.setLayout(null);

		c.add(btnChange);
		c.add(lblAar);
		c.add(lblUser);
		c.add(lblPass);
		c.add(txtUser);
		c.add(txtPass);
		c.add(btnLog);
		c.add(btnExit);
		c.add(lblBack);





		setUndecorated(true);
		setSize(600,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);





	}


	protected void loadSplashScreen(){
		//Start the thread
		ThFormSplash.start();
		while(!FormSplash.isShowing()){
			try{
				//Display the FormSplash for 5 seconds
				Thread.sleep(5000);
			}catch(InterruptedException e){
				System.out.println("Splash Thread error"+e);
			}
		}
	}



	void temp()
	{
		try
		{


			/*Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

		//String stra="house";
		//String strb="jdbc:mysql://localhost:3306/";
		//String strc="tybcs30";
		//String strd="tybcs30";

		Connection conn=DriverManager.getConnection("jdbc:odbc:house");*/

Class.forName("com.mysql.jdbc.Driver");
          Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/house","root","root");



			String str07="user";
			String str09="pass";

			PreparedStatement ps=conn.prepareStatement("select * from login");

			System.out.println(str07);
			System.out.println(str09);

			ResultSet rs=ps.executeQuery();

			while(rs.next())
			{
				user=rs.getString(1);
				pass=rs.getString(2);

			}

			System.out.println(user);
			System.out.println(pass);
			conn.close();
		}

		catch(Exception e)
		{
			System.out.print("\n Error in authenctication"+e);
		}


	}



	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent ae)
	{




		str1=txtUser.getText();
		str2=txtPass.getText();

		if(ae.getSource()==btnLog)
		{


			temp();

			if(str1.equals("user")&& str2.equals("pass"))
			{
				JOptionPane.showMessageDialog(null,"<html><b>Login Successful","Success",JOptionPane.INFORMATION_MESSAGE);
				{
					new ParentScreen();
				}

				this.dispose();
			}
			else
			{


				txtUser.setText("");
				txtPass.setText("");
				JOptionPane.showMessageDialog(null,"<html><b><font color=red>Invalid User ID or Password","Error",JOptionPane.ERROR_MESSAGE);
				txtUser.requestFocus();
			}
		}

		else if(ae.getSource()==btnExit)
		{
			System.exit(0);

		}

		else if(ae.getSource() == btnChange)
		{
			new ChangePass();
		}



	}

	@SuppressWarnings({ "deprecation", "static-access" })
	@Override
	public void keyPressed(KeyEvent ke) {
		// TODO Auto-generated method stub


		str1=txtUser.getText();
		str2=txtPass.getText();

		if(ke.getKeyCode()==ke.VK_ENTER)
		{
			temp();

			if(str1.equals("user")&& str2.equals("pass"))
			{
				JOptionPane.showMessageDialog(null,"<html><b>Login Successful","Success",JOptionPane.INFORMATION_MESSAGE);
				{
					new ParentScreen();
				}

				this.dispose();
			}
			else
			{


				txtUser.setText("");
				txtPass.setText("");
				JOptionPane.showMessageDialog(null,"<html><b><font color=red>Invalid User ID or Password","Error",JOptionPane.ERROR_MESSAGE);
				txtUser.requestFocus();
			}
		}

		else  if(ke.getSource()==btnExit)
		{
			System.exit(0);
			//this.dispose();
		}

	}

	@Override
	public void keyReleased(KeyEvent arg0) {

	}

	@Override
	public void keyTyped(KeyEvent ke) {
		// TODO Auto-generated method stub


	}



}








