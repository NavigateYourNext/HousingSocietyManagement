import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


class ParentScreen extends JFrame implements ActionListener,KeyListener,WindowListener,MouseListener
{
	JButton bmem,bworker,bbill,breport,bback,bmaterial,bservices,bamenities,bdetails;
	JLabel linfo,linfo1,linfo2,linfo3,linfo4,linfo5;
	Dimension screen = 	Toolkit.getDefaultToolkit().getScreenSize();
	JPanel pnlHouse;

	ParentScreen()
	{
		super("Housing Society Management System");

		pnlHouse =new JPanel();
		pnlHouse.setLayout(null);
		pnlHouse.setBounds((screen.width-850)/2,(screen.height-730)/2,900,650);
		pnlHouse.setBorder(BorderFactory.createLineBorder(Color.WHITE));
	//	pnlHouse.setForeground(Color.white);

	//	Container c=getContentPane();
    	//	c.setLayout(null);
	 //	c.setBackground(Color.gray);
     //		c.setBackground("");
	/*		try
		{
		setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("images/backgr.jpg")))));
		}
			catch(IOException ie)
		{

		}	*/
		ImageIcon i=new ImageIcon("images/2.jpg");
		ImageIcon i1=new ImageIcon("images/2.jpg");

		JLabel ilbl1=new JLabel(i);
		ilbl1.setBounds(0,0,screen.width,screen.height);

		JLabel ilbl11=new JLabel(i1);
		ilbl11.setBounds(0,0,900,650);

		linfo=new JLabel("HOUSING SOCIETY MANAGEMENT SYSTEM");
		linfo.setBounds(120,85,750,40);
		linfo.setFont(new Font("Dialog",Font.BOLD,30));
		linfo.setForeground(Color.WHITE);

		bamenities=new JButton("AMENITIES", new ImageIcon("images/house/sun25.jpg"));
		bamenities.setBounds(700,180,150,150);
        bamenities.setVerticalTextPosition(AbstractButton.BOTTOM);
		bamenities.setHorizontalTextPosition(AbstractButton.CENTER);
		bamenities.addMouseListener(this);

        bback=new JButton("LOG-OUT" ,new ImageIcon("images/Logout.png"));
		bback.setBounds(700,390,150,150);
		bback.setVerticalTextPosition(AbstractButton.BOTTOM);
		bback.setHorizontalTextPosition(AbstractButton.CENTER);
		bback.addMouseListener(this);


		bmem=new JButton("MEMBERS", new ImageIcon("images/house/sun11.jpg"));
		bmem.setBounds(100,180,150,150);
		bmem.setVerticalTextPosition(AbstractButton.BOTTOM);
		bmem.setHorizontalTextPosition(AbstractButton.CENTER);
		bmem.addMouseListener(this);


                bservices=new JButton("ABOUT-US",new ImageIcon("images/house/sun15.jpg"));
				bservices.setBounds(100,390,150,150);
				bservices.setVerticalTextPosition(AbstractButton.BOTTOM);
				bservices.setHorizontalTextPosition(AbstractButton.CENTER);
				bservices.addMouseListener(this);



		bworker=new JButton("WORKERS",new ImageIcon("images/house/sun17.jpg"));
		bworker.setVerticalTextPosition(AbstractButton.BOTTOM);
		bworker.setHorizontalTextPosition(AbstractButton.CENTER);
		bworker.setBounds(300,180,150,150);
		bworker.addMouseListener(this);


        breport=new JButton("VIEW DETAILS",new ImageIcon("images/house/sun35.jpg"));
		breport.setBounds(300,390,150,150);
		breport.setVerticalTextPosition(AbstractButton.BOTTOM);
		breport.setHorizontalTextPosition(AbstractButton.CENTER);
		breport.addMouseListener(this);

		bbill=new JButton("BILLING",new ImageIcon("images/house/sun19.jpg"));
		bbill.setBounds(500,180,150,150);
		bbill.setVerticalTextPosition(AbstractButton.BOTTOM);
		bbill.setHorizontalTextPosition(AbstractButton.CENTER);
		bbill.addMouseListener(this);






		bdetails=new JButton("REPORTS",new ImageIcon("images/r1.png"));
			bdetails.setBounds(500,390,150,150);
			bdetails.setVerticalTextPosition(AbstractButton.BOTTOM);
			bdetails.setHorizontalTextPosition(AbstractButton.CENTER);
			bdetails.addMouseListener(this);









		bmem.addActionListener(new member());
		bworker.addActionListener(new worker());
		bbill.addActionListener(new billing());
		bback.addActionListener(new back());
		breport.addActionListener(new report());
	    bdetails.addActionListener(new details());
	    bservices.addActionListener(new services());
		bamenities.addActionListener(new amenitiess());

		//pnlHouse.add(bmaterial);
		pnlHouse.add(linfo);
		pnlHouse.add(bmem);
		pnlHouse.add(bworker);pnlHouse.add(bdetails);
		pnlHouse.add(bbill);
		pnlHouse.add(bamenities);
		pnlHouse.add(bservices);
		pnlHouse.add(breport);
		pnlHouse.add(bback);
        pnlHouse.add(ilbl11);


	/*	c.add(linfo);
		c.add(bmem);
		c.add(bworker);
		c.add(bbill);
		c.add(breport);
		c.add(bback);
		c.add(ilbl1);   */

	//	c.add(pnlHouse);

		add(pnlHouse);
		add(ilbl1);
		addWindowListener(this);



		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setIconImage(new ImageIcon("mobile.png").getImage());
		setLocation(0,0);
		setLayout(null);
		setSize(screen);
		setResizable(true);
		setVisible(true);


	}

	public void actionPerformed(ActionEvent ae)
		{}


	class report implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			new  Report();
		}
	}

	class services implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			JOptionPane.showMessageDialog(null,"This system of maintaining a society is made in such a manner, \n so that the most common problem faced in residential societies are solved. \n In many societies, bills and receipts are being generated manually \n  or they outsource to do it.\n But this involves lots of cost, time, and also maintain the registers.\n In this system the bills, report are generated in easy manner \n also the system is user friendly. \n The other details that can be stored in this system are \n member details, worker details,billing detail,material details etc.\n The system also provides a way to see the collection and expenditures made.");
		}
	}

	class back implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			UnloadWindow();
		}
	}


	class details implements ActionListener
		{
			public void actionPerformed(ActionEvent ae)
				{
					new detail();
				}
		}


	class member implements ActionListener
		{
			public void actionPerformed(ActionEvent ae)
				{
					new MemberInformation();
				}
		}

	class worker implements ActionListener
		{
			public void actionPerformed(ActionEvent ae)
				{
					new WorkerInformation();
				}
		}

	class billing implements ActionListener
		{
			public void actionPerformed(ActionEvent ae)
				{
					new Billing();
				}
		}

	class amenitiess implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			new amenities();
		}
	}


public void keyPressed(KeyEvent arg0) {


	}



	public void keyReleased(KeyEvent arg0) {


	}



	public void keyTyped(KeyEvent arg0) {


	}



	public void windowActivated(WindowEvent arg0) {

	}



	public void windowClosed(WindowEvent arg0) {




	}



	public void windowClosing(WindowEvent arg0) {

		UnloadWindow();
	}



	public void windowDeactivated(WindowEvent arg0) {


	}



	public void windowDeiconified(WindowEvent arg0) {


	}



	public void windowIconified(WindowEvent arg0) {


	}



	public void windowOpened(WindowEvent arg0) {


	}
	protected void UnloadWindow(){
		int PromptResult = JOptionPane.showConfirmDialog(null,"<html><b>Are You Sure You Want To Exit?","Housing Management System",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
		if(PromptResult==JOptionPane.YES_OPTION){
			System.exit(0);
		}
	}


	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}


	@Override
	public void mouseEntered(MouseEvent me) {
		// TODO Auto-generated method stub


		Object o = me.getSource();
		if(o == bmem)
			bmem.setIcon(new ImageIcon("images/house/sun12.jpg"));
		else  if(o == bworker)
			bworker.setIcon(new ImageIcon("images/house/sun18.jpg"));
		else  if(o == bbill)
			bbill.setIcon(new ImageIcon("images/house/sun20.jpg"));
			else  if(o == bmaterial)
			bmaterial.setIcon(new ImageIcon("images/house/sun14.jpg"));

		else  if(o == breport)
			breport.setIcon(new ImageIcon("images/house/sun34.jpg"));
		else  if(o == bback)
			bback.setIcon(new ImageIcon("images/Logout1.png"));
			else  if(o == bservices)
			bservices.setIcon(new ImageIcon("images/house/sun16.jpg"));
		else if(o == bamenities)
			bamenities.setIcon(new ImageIcon("images/house/sun26.jpg"));
				else if(o == bdetails)
			bdetails.setIcon(new ImageIcon("images/r2.png"));

	}








	@Override
	public void mouseExited(MouseEvent me) {
		// TODO Auto-generated method stub
		Object o = me.getSource();
		if(o == bmem)
			bmem.setIcon(new ImageIcon("images/house/sun11.jpg"));
		else if(o == bworker)
			bworker.setIcon(new ImageIcon("images/house/sun17.jpg"));
		else  if(o == bbill)
			bbill.setIcon(new ImageIcon("images/house/sun19.jpg"));
		else  if(o == bmaterial)
			bmaterial.setIcon(new ImageIcon("images/house/sun13.jpg"));

		else  if(o == breport)
			breport.setIcon(new ImageIcon("images/house/sun35.jpg"));
		else  if(o == bback)
			bback.setIcon(new ImageIcon("images/Logout.png"));
			else  if(o == bservices)
			bservices.setIcon(new ImageIcon("images/house/sun15.jpg"));
		else if(o == bamenities)
			bamenities.setIcon(new ImageIcon("images/house/sun25.jpg"));
		else if(o == bdetails)
			bdetails.setIcon(new ImageIcon("images/r1.png"));


	}








	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}








	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args)
	{
		new ParentScreen();
	}
}
