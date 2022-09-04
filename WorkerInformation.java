import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class WorkerInformation extends JFrame implements ActionListener
{
	JTabbedPane t;
	JPanel pnlinsert,pnlupdate,pnldelete,pnlsearch;
	
	//panel 1
	
	JLabel lmain,ldii,ldi,lname,ladd,ltel,lspecial,ldid,ldspec,lwork,lworkfrom,lworkto,lfee;
	JTextField tfname,tftel,tfdid,tfworkf,tfworkt,tffee;
	TextArea taadd,tacur,taspecial;
	JButton bsub,bclr,bback;

	//panel 2
	
	JLabel lmain1,ldii1,ldi1,lname1,ladd1,ltel1,lspecial1,ldid1,ldspec1,lwork1,lworkfrom1,lworkto1;
	JTextField tfname1,tftel1,tfdid1,tfworkf1,tfworkt1;
	TextArea taadd1,taspecial1;
	JButton bsub1,bclr1,bmod1,bback1;
	
	//panel 3
	
	JLabel lmain2,ldii2,ldi2,lname2,ladd2,ltel2,lspecial2,ldid2,ldspec2,lwork2,lworkfrom2,lworkto2,lfee2;
	JTextField tfname2,tftel2,tfdid2,tfworkf2,tfworkt2,tffee2;
	TextArea taadd2,tacur2,taspecial2;
	JButton bsub2,bclr2,bback2;
	
	clsSettings settings = new clsSettings();
	
	WorkerInformation()
	{
		super("Worker's Information");
		
		pnlinsert=new JPanel();
		pnlupdate=new JPanel();		
//		pnldelete=new JPanel();		
		pnlsearch=new JPanel();
		
		pnlinsert.setLayout(null);
		pnlupdate.setLayout(null);
//		pnldelete.setLayout(null);
		pnlsearch.setLayout(null);
		
		t=new JTabbedPane();

		Container c=getContentPane();

		t.add("Insert Worker",pnlinsert);
		t.add("Update Worker",pnlupdate);
	//.add("Delete Worker",pnldelete);
		t.add("Search Worker",pnlsearch);	
		
		//panel 1
		
		lmain=new JLabel("Add Worker's Information");
		lmain.setBounds(350,10,760,25);
		lmain.setFont(new Font("Dialog",Font.BOLD,28));
		
		ldi=new JLabel("********************************  Add Personal Information  **********************************");
		ldi.setBounds(200,60,750,15);
		ldi.setFont(new Font("Dialog",Font.BOLD,16));
		
		
		ldid=new JLabel("Worker ID :");
		ldid.setBounds(104,110,70,25);
	
		tfdid=new JTextField(30);
		tfdid.setBounds(240,110,50,20);
		tfdid.setEditable(false);
		
		ltel=new JLabel("Contact :");
		ltel.setBounds(104,150,50,25);
	
		tftel=new JTextField(30);
		tftel.setBounds(240,150,200,20);
		
		lname=new JLabel("Name :");
		lname.setBounds(570,110,70,25);
		
	
		tfname=new JTextField(30);
		tfname.setBounds(670,110,250,20);
		
	
		ladd=new JLabel("Address :");
		ladd.setBounds(570,150,70,15);
	
		taadd=new TextArea();
		taadd.setBounds(670,150,250,100);
	
		ldii=new JLabel("********************************  Add Working Information  **********************************");
		ldii.setBounds(200,290,750,15);
		ldii.setFont(new Font("Dialog",Font.BOLD,16));
		
		settings.Numvalidator(tftel);
	
		ldspec=new JLabel("Field :");
		ldspec.setBounds(570,340,100,25);
	
		taspecial=new TextArea();
		taspecial.setBounds(670,340,250,100);
	
		lwork=new JLabel("Working hours :");
		lwork.setBounds(104,345,100,15);
	
		lworkfrom=new JLabel("From :");
		lworkfrom.setBounds(240,340,37,25);
	
		tfworkf=new JTextField(30);
		tfworkf.setBounds(280,340,50,20);
		settings.Numvalidator(tfworkf);
		
		JLabel amm=new JLabel("am");
		amm.setBounds(330,340,37,25);
		
		lworkto=new JLabel("to :");
		lworkto.setBounds(370,340,20,25);	
	

		
		tfworkt=new JTextField(30);
		tfworkt.setBounds(390,340,50,20);
		settings.Numvalidator(tfworkt);
	     	
        JLabel pmm=new JLabel("pm");
		pmm.setBounds(445,340,37,25);
		
		
			bsub=new JButton("ADD",new ImageIcon("D:/Pro/House/src/housing/images/2rightarrow_hover.png"));
		bsub.setBounds(300,480,100,30);
	
		bclr=new JButton("CLEAR",new ImageIcon("D:/Pro/House/src/housing/images/restore.png"));
		bclr.setBounds(450,480,100,30);	
	
		bback=new JButton("BACK",new ImageIcon("D:/Pro/House/src/housing/images/1leftarrow.png"));
		bback.setBounds(600,480,100,30);
		
		bclr.addActionListener(new clear());
		bsub.addActionListener(new submit());
		bback.addActionListener(new back());			
		
		pnlinsert.add(bback);
		pnlinsert.add(bclr);
		pnlinsert.add(bsub);
		pnlinsert.add(tfworkt);
		pnlinsert.add(lworkto);
		pnlinsert.add(tfworkf);
		pnlinsert.add(lworkfrom);
		pnlinsert.add(lwork);
		pnlinsert.add(taspecial);
		pnlinsert.add(ldspec);
		pnlinsert.add(tftel);
		pnlinsert.add(tfdid);
		pnlinsert.add(ldid);
		pnlinsert.add(amm);
		pnlinsert.add(pmm);
		pnlinsert.add(ltel);
		pnlinsert.add(taadd);
		pnlinsert.add(ladd);
		pnlinsert.add(tfname);
		pnlinsert.add(lname);	
		pnlinsert.add(lmain);
		pnlinsert.add(ldi);
		pnlinsert.add(ldii);
		pnlinsert.setSize(1000,600);
		
		
		// End PAnel 1
		
		
		// PAnel 2
		
		lmain1=new JLabel("Update Worker's Information");
		lmain1.setBounds(350,10,760,25);
		lmain1.setFont(new Font("Dialog",Font.BOLD,28));
		
		ldi1=new JLabel("********************************  Update Personal Information  **********************************");
		ldi1.setBounds(200,60,750,15);
		ldi1.setFont(new Font("Dialog",Font.BOLD,16));
		
		lname1=new JLabel("Name :");
		lname1.setBounds(104,97,70,25);
	
	
		tfname1=new JTextField(30);
		tfname1.setBounds(270,97,250,20);
			
	
		ladd1=new JLabel("Address :");
		ladd1.setBounds(104,138,70,15);
	
	
		taadd1=new TextArea();
		taadd1.setBounds(270,138,250,100);
	
	
		ltel1=new JLabel("Contact :");
		ltel1.setBounds(575,138,50,25);
	
	
		ldid1=new JLabel("Worker ID:");
		ldid1.setBounds(570,97,70,25);
		
	
		tfdid1=new JTextField(30);
		tfdid1.setBounds(643,97,50,20);
		settings.Numvalidator(tfdid1);
	
	
		tftel1=new JTextField(30);
		tftel1.setBounds(640,138,200,20);
		
		settings.Numvalidator(tftel1);
	
		ldii1=new JLabel("********************************  Update Working Information  **********************************");
		ldii1.setBounds(200,290,750,15);
		ldii1.setFont(new Font("Dialog",Font.BOLD,16));
	
		ldspec1=new JLabel("Fields :");
		ldspec1.setBounds(104,340,100,25);
	
	
		taspecial1=new TextArea();
		taspecial1.setBounds(270,340,250,100);
	
	
		lwork1=new JLabel("Working hours :");
		lwork1.setBounds(570,345,100,15);
	
	
		lworkfrom1=new JLabel("From :");
		lworkfrom1.setBounds(670,340,37,25);
	
	
		tfworkf1=new JTextField(30);
		tfworkf1.setBounds(710,340,50,20);

		settings.Numvalidator(tfworkf1);
		
		lworkto1=new JLabel("to :");
		lworkto1.setBounds(767,340,20,25);
	
	
		tfworkt1=new JTextField(30);
		tfworkt1.setBounds(795,340,50,20);
	
		settings.Numvalidator(tfworkt1);	
				
		bsub1=new JButton("SEARCH",new ImageIcon("D:/Pro/House/src/housing/images/search.png"));
		bsub1.setBounds(250,480,120,30);
			
		bclr1=new JButton("CLEAR",new ImageIcon("D:/Pro/House/src/housing/images/restore.png"));
		bclr1.setBounds(420,480,100,30);		
	
		bmod1=new JButton("MODIFY",new ImageIcon("D:/Pro/House/src/housing/images/modify.png"));
		bmod1.setBounds(570,480,100,30);	
	
		bback1=new JButton("BACK",new ImageIcon("D:/Pro/House/src/housing/images/1leftarrow.png"));
		bback1.setBounds(720,480,100,30);

		bclr1.addActionListener(new clear());
		bsub1.addActionListener(new submit1());
		bmod1.addActionListener(new modify1());
		bback1.addActionListener(new back());
		
	
		pnlupdate.add(ldi1);
		pnlupdate.add(lmain1);
		pnlupdate.add(ldii1);
		pnlupdate.add(bback1);
		pnlupdate.add(bmod1);
		pnlupdate.add(bclr1);
		pnlupdate.add(bsub1);
		pnlupdate.add(tfworkt1);
		pnlupdate.add(lworkto1);
		pnlupdate.add(tfworkf1);
		pnlupdate.add(lworkfrom1);
		pnlupdate.add(lwork1);
		pnlupdate.add(taspecial1);
		pnlupdate.add(ldspec1);
		pnlupdate.add(tftel1);
		pnlupdate.add(tfdid1);
		pnlupdate.add(ldid1);
		pnlupdate.add(ltel1);
		pnlupdate.add(taadd1);
		pnlupdate.add(lname1);
		pnlupdate.add(tfname1);
		pnlupdate.add(ladd1);
				
		//End of panel 2
		
		//panel 3
		
		
		
		lmain2=new JLabel("Search Worker's Information");
		lmain2.setBounds(350,10,760,25);
		lmain2.setFont(new Font("Dialog",Font.BOLD,28));
		
		ldi2=new JLabel("********************************  Search Personal Information  **********************************");
		ldi2.setBounds(200,60,750,15);
		ldi2.setFont(new Font("Dialog",Font.BOLD,16));
		
		
		ldid2=new JLabel("Worker ID :");
		ldid2.setBounds(104,110,70,25);
	
		tfdid2=new JTextField(30);
		tfdid2.setBounds(240,110,50,20);
		settings.Numvalidator(tfdid2);
		
		ltel2=new JLabel("Contact :");
		ltel2.setBounds(104,150,50,25);
	
		tftel2=new JTextField(30);
		tftel2.setBounds(240,150,200,20);
		
		lname2=new JLabel("Name :");
		lname2.setBounds(570,110,70,25);
		
	
		tfname2=new JTextField(30);
		tfname2.setBounds(670,110,250,20);
		
	
		ladd2=new JLabel("Address :");
		ladd2.setBounds(570,150,70,15);
	
		taadd2=new TextArea();
		taadd2.setBounds(670,150,250,100);
	
		ldii2=new JLabel("********************************  Search Working Information  **********************************");
		ldii2.setBounds(200,290,750,15);
		ldii2.setFont(new Font("Dialog",Font.BOLD,16));
		
		settings.Numvalidator(tftel2);
	
		ldspec2=new JLabel("Fields :");
		ldspec2.setBounds(570,340,100,25);
	
		taspecial2=new TextArea();
		taspecial2.setBounds(670,340,250,100);
	
		lwork2=new JLabel("Working hours :");
		lwork2.setBounds(104,345,100,15);
	
		lworkfrom2=new JLabel("From :");
		lworkfrom2.setBounds(240,340,37,25);
	
		tfworkf2=new JTextField(30);
		tfworkf2.setBounds(280,340,50,20);
				
		settings.Numvalidator(tfworkf2);
		
		lworkto2=new JLabel("to :");
		lworkto2.setBounds(340,340,20,25);	
	
		tfworkt2=new JTextField(30);
		tfworkt2.setBounds(370,340,50,20);	 
		
		settings.Numvalidator(tfworkt2);
	     	
		bsub2=new JButton("SEARCH",new ImageIcon("D:/Pro/House/src/housing/images/search.png"));
		bsub2.setBounds(280,480,120,30);
	
		bclr2=new JButton("CLEAR",new ImageIcon("D:/Pro/House/src/housing/images/restore.png"));
		bclr2.setBounds(450,480,100,30);	
	
		bback2=new JButton("BACK",new ImageIcon("D:/Pro/House/src/housing/images/1leftarrow.png"));
		bback2.setBounds(600,480,100,30);
		
		bclr2.addActionListener(new clear());
		bsub2.addActionListener(new submit2());
		bback2.addActionListener(new back());			
		
		pnlsearch.add(bback2);
		pnlsearch.add(bclr2);
		pnlsearch.add(bsub2);
		pnlsearch.add(tfworkt2);
		pnlsearch.add(lworkto2);
		pnlsearch.add(tfworkf2);
		pnlsearch.add(lworkfrom2);
		pnlsearch.add(lwork2);
		pnlsearch.add(taspecial2);
		pnlsearch.add(ldspec2);
		pnlsearch.add(tftel2);
		pnlsearch.add(tfdid2);
		pnlsearch.add(ldid2);
		pnlsearch.add(ltel2);
		pnlsearch.add(taadd2);
		pnlsearch.add(ladd2);
		pnlsearch.add(tfname2);
		pnlsearch.add(lname2);	
		pnlsearch.add(lmain2);
		pnlsearch.add(ldi2);
		pnlsearch.add(ldii2);
		pnlsearch.setSize(1000,600);
		
		//end of panel 3
		
		c.add(t);
		invoice();
		setSize(1024,608);
		setLocationRelativeTo(null);
		setVisible(true);
		setLayout(null);				
	}

	void invoice()
	{

		try
		{

		/* Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			
		//String stra="house";
		//String strb="jdbc:mysql://localhost:3306/";
		//String strc="root";
		//String strd="root";
	
		Connection conn=DriverManager.getConnection("jdbc:odbc:house"); */

          Class.forName("com.mysql.jdbc.Driver"); 
          Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/house","root","root");
			
		
		
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery("select MAX(wor_id)+1 from worker");
			while(rs.next())
			{



				String workerno=rs.getString(1);
				
				if(workerno==null)

				{
					tfdid.setText("1");
					System.out.println("success.....");
				}
				else
				{

					tfdid.setText(workerno);
					System.out.println("Success------");
				}
			}

		}

		catch(Exception e)
		{

			e.printStackTrace();
			System.out.println("Error Logic In Autogenerate ");
		}


	}


	public void actionPerformed(ActionEvent ae)
		{}

class clear implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			
			tfname.setText("");
			tftel.setText("");
			tfworkf.setText("");
			tfworkt.setText("");
			taadd.setText("");
			taspecial.setText("");
			
			tfname1.setText("");
			tftel1.setText("");
			tfworkf1.setText("");
			tfworkt1.setText("");
			taadd1.setText("");
			taspecial1.setText("");
			
			tfname2.setText("");
			tftel2.setText("");
			tfworkf2.setText("");
			tfworkt2.setText("");
			taadd2.setText("");
			taspecial2.setText("");
			
			
		}
	}


class back implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			dispose();
		}
	}


class submit implements ActionListener
{
	public void actionPerformed(ActionEvent ae)
	{			
		try{
		
		
		int num=Integer.parseInt(tfdid.getText());
		if(num==0)
			{
				System.out.println("num");
				throw new BlankException();
			}

		String name=tfname.getText();
		if(name.equals(""))
			{
				throw new BlankException();
			}
		else
			{
				for(int i=0; i<name.length(); i++)
				{
					boolean check = Character.isLetter(name.charAt(i));
					char a=name.charAt(i);
					System.out.print("  "+a);
					if(!((a>=65 && a<=90) || (a>=97 && a<=122) || (a==32) ||(a==46)))
					{
					  throw new NameEx();
					}

				}
			}

		String addr=taadd.getText();
			if(addr.equals(null))
			{
				System.out.println("addr");
				throw new BlankException();
			}


		String contact=tftel.getText();

		 int k=contact.length();
		 if(k!=10)
		 {
			 JOptionPane.showMessageDialog(null,"Invalid Contact","Invalid Contact",JOptionPane.ERROR_MESSAGE);
			 throw new BlankException();
		 }

		String spec=taspecial.getText();

		String workf=tfworkf.getText();

		String workt=tfworkt.getText();
		
		int aa=Integer.parseInt(workf);
		int bb=Integer.parseInt(workt);
		
		if(aa >=13 || aa <=0 || bb <=0 || bb >=13)
		{
			JOptionPane.showMessageDialog(null,"Invalid Time","Error",JOptionPane.ERROR_MESSAGE);
	      throw new BlankException();
        }	
		/*Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			
		//String stra="house";
		//String strb="jdbc:mysql://localhost:3306/";
		//String strc="root";
		//String strd="root";
	
		Connection conn=DriverManager.getConnection("jdbc:odbc:house"); */

Class.forName("com.mysql.jdbc.Driver"); 
          Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/house","root","root");
			
		
		
		Statement st=conn.createStatement();	

		st.executeUpdate("INSERT INTO worker (wor_name,wor_address,wor_contact,wor_specialization,wor_workfrom,wor_workto) VALUES('"+name+"','"+addr+"','"+contact+"','"+spec+"','"+workf+"','"+workt+"');");
		
		
			tfname.setText("");
			tftel.setText("");
			tfworkf.setText("");
			tfworkt.setText("");
			taadd.setText("");
			taspecial.setText("");
		
		new SuccessDialog();
				
		invoice();
		
		int sel=JOptionPane.showConfirmDialog(null,"<html><b><font color=black>Do You Want To Add More Worker","Information",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
			if(sel==JOptionPane.NO_OPTION)
			{	
				dispose();
			}
			tfname.requestFocus();	
		}
		catch(SQLException sq)
		{
			String message = "Enter Valid Worker ID and Contact.";
			JOptionPane.showMessageDialog(new JFrame(), message, "ERROR!",
			JOptionPane.ERROR_MESSAGE);
			System.out.println(sq);
		}
	
		catch(NumberFormatException nfe)
		{
			new ErrorDialog();
		}
			catch(BlankException be)
		{
			new ErrorDialog2();
		}
		catch(NameEx ne)
		{
			new ErrorDialog1();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
					
	}
					
	}

class submit1 implements ActionListener
{
	

	public void actionPerformed(ActionEvent ae)
	{			
		try{

					
			/* Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			
		//String stra="house";
		//String strb="jdbc:mysql://localhost:3306/";
		//String strc="root";
		//String strd="root";
	
		Connection conn=DriverManager.getConnection("jdbc:odbc:house"); */

Class.forName("com.mysql.jdbc.Driver"); 
          Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/house","root","root");
			
		
					
		Integer num=Integer.parseInt(tfdid1.getText());
		String name;
		String addr;
		String contact;
		String spec;
		String workf;
		String workt;
		

		

		Statement st=conn.createStatement();
		ResultSet rs=st.executeQuery("SELECT * FROM worker WHERE wor_id="+num);
		
		if(rs.next())
			{
				num=rs.getInt(1);
				name=rs.getString(2);
				addr=rs.getString(3);
				contact=rs.getString(4);
				spec=rs.getString(5);
				workf=rs.getString(6);
				workt=rs.getString(7);

				tfname1.setText(name);
				taadd1.setText(addr);
				tftel1.setText(contact);
				taspecial1.setText(spec);
				tfworkf1.setText(workf);
				tfworkt1.setText(workt);


			}
		
		}
		catch(Exception sq)
		{
			System.out.println(sq);
		}
		
	}

}

class submit2 implements ActionListener
{
	

	public void actionPerformed(ActionEvent ae)
	{			
		try{
/*
					
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			
		//String stra="house";
		//String strb="jdbc:mysql://localhost:3306/";
		//String strc="root";
		//String strd="root";
	
		Connection conn=DriverManager.getConnection("jdbc:odbc:house"); */

Class.forName("com.mysql.jdbc.Driver"); 
          Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/house","root","root");
			
		
					
		Integer num=Integer.parseInt(tfdid2.getText());
		String name;
		String addr;
		String contact;
		String spec;
		String workf;
		String workt;
		

		

		Statement st=conn.createStatement();
		ResultSet rs=st.executeQuery("SELECT * FROM worker WHERE wor_id="+num);
		
		if(rs.next())
			{
				num=rs.getInt(1);
				name=rs.getString(2);
				addr=rs.getString(3);
				contact=rs.getString(4);
				spec=rs.getString(5);
				workf=rs.getString(6);
				workt=rs.getString(7);

				tfname2.setText(name);
				taadd2.setText(addr);
				tftel2.setText(contact);
				taspecial2.setText(spec);
				tfworkf2.setText(workf);
				tfworkt2.setText(workt);


			}
		
		}
		catch(Exception sq)
		{
			System.out.println(sq);
		}
		
	}

}

class modify1 implements ActionListener
{
	public void actionPerformed(ActionEvent ae)
	{
		try{

			Integer num1=Integer.parseInt(tfdid1.getText());
			if(num1.equals(null))
			{
				System.out.println("num");
				throw new BlankException();
			}


			String name1=tfname1.getText();
		
			if(name1.equals(""))
				{
					throw new BlankException();
				}
			else
			{
				for(int i=0; i<name1.length(); i++)
				{
					boolean check = Character.isLetter(name1.charAt(i));
				    char a=name1.charAt(i);
					System.out.print("  "+a);
					if(!((a>=65 && a<=90) || (a>=97 && a<=122) || (a==32) ||(a==46)))
					{
					  throw new NameEx();
					}

				}
			}


			String addr1=taadd1.getText();
			if(addr1.equals(null))
			{
				System.out.println("addr1");
				throw new BlankException();
			}

			String contact1=tftel1.getText();

			int k=contact1.length();
			 if(k!=10)
			 {
				 JOptionPane.showMessageDialog(null,"Invalid Contact","Invalid Contact",JOptionPane.ERROR_MESSAGE);
				 throw new BlankException();
			 }
			 
			String spec1=taspecial1.getText();
			String workf1=tfworkf1.getText();
			String workt1=tfworkt1.getText();
		
			/* Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			
		//String stra="house";
		//String strb="jdbc:mysql://localhost:3306/";
		//String strc="root";
		//String strd="root";
	
		Connection conn=DriverManager.getConnection("jdbc:odbc:house"); */
Class.forName("com.mysql.jdbc.Driver"); 
          Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/house","root","root");
			
		

			String str="UPDATE worker SET wor_name=?,wor_address=?,wor_contact=?,wor_specialization=?,wor_workfrom=?,wor_workto=? WHERE wor_id=?";
			
			PreparedStatement psmt=conn.prepareStatement(str);
			psmt.setString(1,name1);
			psmt.setString(2,addr1);
			psmt.setString(3,contact1);
			psmt.setString(4,spec1);
			psmt.setString(5,workf1);
			psmt.setString(6,workt1);
			psmt.setInt(7,num1);
			
			psmt.executeUpdate();

			new SuccessDialog1();
	
	
			}catch(SQLException sq)
		{
			String message = "Enter Valid Worker ID and Contact.";
			JOptionPane.showMessageDialog(new JFrame(), message, "ERROR!",
			JOptionPane.ERROR_MESSAGE);
			System.out.println(sq);
		}
		catch(BlankException be)
		{
			new ErrorDialog2();
		}
		catch(NumberFormatException nfe)
		{
			new ErrorDialog();
		}
		catch(NameEx ne)
		{
			new ErrorDialog1();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
}



	public static void main(String[] args) 
	{
		new WorkerInformation();
	}
}
