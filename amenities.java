import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;



class amenities extends JFrame implements ActionListener
{
	JTabbedPane t;
	JPanel pnlinsert,pnlupdate,pnldelete,pnlsearch;
	
	//Panel1
	
	JLabel ameno,amename,ametype,ametime,lmain,lpi,tfrom,am,to,pm,no;
	JTextField amenot,amenamet,ametypet,ametimet,tfromt,ttot;
	JButton badd,bclr,bback;
	
	//Panel2
	
	JLabel ameno1,amename1,ametype1,ametime1,lmain1,lpi1,tfrom1,am1,to1,pm1,no1;
	JTextField amenot1,amenamet1,ametypet1,ametimet1,tfromt1,ttot1;
	JButton badd1,bclr1,bback1,modify;
	
	String dialogmessage;
    String dialogs;
    int dialogtype = JOptionPane.PLAIN_MESSAGE;
    clsSettings settings = new clsSettings();
	
	class NameEx extends Exception{}

class BlankException extends Exception{}

    
	
amenities()
{
	super("Amenities");
	
	pnlinsert=new JPanel();
	pnlinsert.setLayout(null);
	pnlupdate=new JPanel();
	pnlupdate.setLayout(null);
	
	
	    t=new JTabbedPane();

		Container c=getContentPane();

		t.add("Insert Amenity",pnlinsert);
		t.add("Update Amenity",pnlupdate);
		//t.add("Search Amenity",pnlsearch);	
		
	/// Add Amenities 

    lmain=new JLabel("Add Amenities Information");
	lmain.setBounds(250,10,760,25);
	lmain.setFont(new Font("Dialog",Font.BOLD,28));	
	
	lpi=new JLabel("********************************  Add Amenities Information  **********************************");
	lpi.setBounds(120,60,750,15);
	lpi.setFont(new Font("Dialog",Font.BOLD,16));
	

	amename=new JLabel("Amenity Name:");
    amename.setBounds(100,100,120,100);

    amenamet=new JTextField(20);
    amenamet.setBounds(190,135,200,30);
	
	ametype=new JLabel("Amenity Type:");
    ametype.setBounds(100,150,120,100);

    ametypet=new JTextField(20);
    ametypet.setBounds(190,185,200,30);
	
	ameno=new JLabel("No_Of_Workers On Amenity:");
	ameno.setBounds(100,200,180,100);
	
	amenot=new JTextField(3);
	amenot.setBounds(265,240,30,20);
	
    tfrom=new JLabel("Start Time:");
	tfrom.setBounds(100,240,180,100);
	
    tfromt=new JTextField(2);
	tfromt.setBounds(170,282,20,20);
	
	am=new JLabel("AM");
	am.setBounds(190,282,20,20);
	
	to=new JLabel("TO");
	to.setBounds(220,282,20,20);
	
	ttot=new JTextField(2);
	ttot.setBounds(250,282,20,20);
	
	pm=new JLabel("PM");
	pm.setBounds(270,282,20,20);
	
	badd=new JButton("ADD",new ImageIcon("D:/Pro/House/src/housing/images/2rightarrow_hover.png"));
	badd.setBounds(240,330,100,30);
	
	bclr=new JButton("CLEAR",new ImageIcon("D:/Pro/House/src/housing/images/restore.png"));
	bclr.setBounds(350,330,120,30);
	
	bback=new JButton("BACK",new ImageIcon("D:/Pro/House/src/housing/images/1leftarrow_hover.png"));
	bback.setBounds(480,330,100,30);

	pnlinsert.add(lmain);
	pnlinsert.add(lpi);
    pnlinsert.add(amename);
    pnlinsert.add(amenamet);
	pnlinsert.add(ametype);
	pnlinsert.add(ametypet);
	pnlinsert.add(ameno);
	pnlinsert.add(amenot);
	pnlinsert.add(tfrom);
	pnlinsert.add(tfromt);
	pnlinsert.add(am);
	pnlinsert.add(to);
	pnlinsert.add(ttot);
    pnlinsert.add(pm);
	pnlinsert.add(badd);
	pnlinsert.add(bclr);
	pnlinsert.add(bback);
	
    pnlinsert.setSize(700,260);	
	
	
	//bclr.addActionListener(new clear());
	//badd.addActionListener(new add());
	//bback.addActionListener(new back());

	
	  /// Update Amenities 

    lmain1=new JLabel("Update Amenities Information");
	lmain1.setBounds(250,10,760,25);
	lmain1.setFont(new Font("Dialog",Font.BOLD,28));	
	
	lpi1=new JLabel("********************************  Update Amenities Information  **********************************");
	lpi1.setBounds(120,60,750,15);
	lpi1.setFont(new Font("Dialog",Font.BOLD,16));
	

	amename1=new JLabel("Amenity Name:");
    amename1.setBounds(100,100,120,100);

    amenamet1=new JTextField(20);
    amenamet1.setBounds(190,135,200,30);
	
	ametype1=new JLabel("Amenity Type:");
    ametype1.setBounds(100,150,120,100);

    ametypet1=new JTextField(20);
    ametypet1.setBounds(190,185,200,30);
	
	ameno1=new JLabel("No_Of_Workers On Amenity:");
	ameno1.setBounds(100,200,180,100);
	
	amenot1=new JTextField(3);
	amenot1.setBounds(265,240,30,20);
	
    tfrom1=new JLabel("Start Time:");
	tfrom1.setBounds(100,240,180,100);
	
    tfromt1=new JTextField(2);
	tfromt1.setBounds(170,282,20,20);
	
	am1=new JLabel("AM");
	am1.setBounds(190,282,20,20);
	
	to1=new JLabel("TO");
	to1.setBounds(220,282,20,20);
	
	ttot1=new JTextField(2);
	ttot1.setBounds(250,282,20,20);
	
	pm1=new JLabel("PM");
	pm1.setBounds(270,282,20,20);
	
	badd1=new JButton("SEARCH",new ImageIcon("D:/Pro/House/src/housing/images/search_hover.png"));
	badd1.setBounds(200,330,130,30);
	
	bclr1=new JButton("CLEAR",new ImageIcon("D:/Pro/House/src/housing/images/restore.png"));
	bclr1.setBounds(350,330,120,30);
	
	bback1=new JButton("BACK",new ImageIcon("D:/Pro/House/src/housing/images/1leftarrow_hover.png"));
	bback1.setBounds(490,330,100,30);
	
	modify=new JButton("MODIFY",new ImageIcon("D:/Pro/House/src/housing/images/modify.png"));
	modify.setBounds(610,330,130,30);

	pnlupdate.add(lmain1);
	pnlupdate.add(lpi1);
    pnlupdate.add(amename1);
    pnlupdate.add(amenamet1);
	pnlupdate.add(ametype1);
	pnlupdate.add(ametypet1);
	pnlupdate.add(ameno1);
	pnlupdate.add(amenot1);
	pnlupdate.add(tfrom1);
	pnlupdate.add(tfromt1);
	pnlupdate.add(am1);
	pnlupdate.add(to1);
	pnlupdate.add(ttot1);
    pnlupdate.add(pm1);
	pnlupdate.add(badd1);
	pnlupdate.add(bclr1);
	pnlupdate.add(bback1);
	pnlupdate.add(modify);
	
	settings.Numvalidator(amenot);
    settings.Numvalidator(tfromt);
	settings.Numvalidator(ttot);
	
	settings.Numvalidator(amenot1);
    settings.Numvalidator(tfromt1);
	settings.Numvalidator(ttot1);
	
    pnlinsert.setSize(700,260);	
	pnlupdate.setSize(700,260);
	
	bback.addActionListener(new back());
	bclr.addActionListener(new clear());
	bback1.addActionListener(new back());
	bclr1.addActionListener(new clear());
	badd.addActionListener(new submit());
	badd1.addActionListener(new submit1());
	modify.addActionListener(new modifyy());
	  
	
		c.add(t);
		setSize(900,500);
		setLocationRelativeTo(null);
		setVisible(true);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
}

public void actionPerformed(ActionEvent ae)
{}

	
	class back implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			dispose();
		}
	}
	
	class clear implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			amenamet.setText(" ");
			ametypet.setText(" ");
			amenot.setText(" ");
			tfromt.setText(" ");
			ttot.setText(" ");
			amenamet1.setText(" ");
			ametypet1.setText(" ");
			amenot1.setText(" ");
			tfromt1.setText(" ");
			ttot1.setText(" ");
		}
    }

   class submit implements ActionListener
{
	public void actionPerformed(ActionEvent ae)
	{			
		try{
			
			Class.forName("com.mysql.jdbc.Driver"); 
          Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/house","root","root");
             String name=amenamet.getText();
		 
	    if(name.equals(""))
			{
				System.out.println("name=="+name);
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
    String addr=ametypet.getText();
		if(addr.equals(""))
			{
				System.out.println("addr");
				throw new BlankException();
			}
	String con=amenot.getText();

    String from=tfromt.getText();

    String to=ttot.getText();	
	
	      

		Statement st=conn.createStatement();	

st.executeUpdate("INSERT INTO amenity (ame_name,ame_type,no_of_people,start_time,end_time) VALUES('"+name+"','"+addr+"','"+con+"','"+from+"','"+to+"');");		
	  			
		new SuccessDialog();

		    amenamet.setText(" ");
			ametypet.setText(" ");
			amenot.setText(" ");
			tfromt.setText(" ");
			ttot.setText(" ");
		} 
		catch(BlankException be)
		{
			new ErrorDialog2();
		}
		catch(NumberFormatException nfe)
		{
			new ErrorDialog();
		}
		catch(SQLException sq)
		{
			System.out.println(sq);
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
              Class.forName("com.mysql.jdbc.Driver"); 
          Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/house","root","root");
        
		String name;
		String addr;
		String con;
		String from;
		String to;
		
		String num=amename1.getText();
		
		if(num.equals(" "))
		{
			String message = "Please Enter Amenity Name in Amenity Name Field";
			 JOptionPane.showMessageDialog(new JFrame(), message, "ERROR!",
         	JOptionPane.ERROR_MESSAGE);
		}

        Statement st=conn.createStatement();
		String aaa="select * from amenity where ame_name='"+num+"'";
		ResultSet rs=st.executeQuery(aaa);
         while(rs.next())
         {
			 name=rs.getString(1);
			 addr=rs.getString(2);
			 con=rs.getString(3);
			 from=rs.getString(4);
			 to=rs.getString(5);
			 
			 amenamet1.setText(name);
			 ametypet1.setText(addr);
			 amenot1.setText(con);
			 tfromt1.setText(from);
			 ttot1.setText(to);
		 }
		} 

        catch(Exception esss)
		{
			System.out.println(esss);
		}
		
	}
} 

class modifyy implements ActionListener
{
	public void actionPerformed(ActionEvent ae)
	{		

		try{
			Class.forName("com.mysql.jdbc.Driver"); 
          Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/house","root","root");
			 String name1=amenamet1.getText();
		 
	    if(name1.equals(""))
			{
				System.out.println("name=="+name1);
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
			
			String addr1=ametypet1.getText();
		if(addr1.equals(""))
			{
				System.out.println("addr");
				throw new BlankException();
			}
			
	String con1=amenot.getText();

    String from1=tfromt.getText();

    String to1=ttot.getText();	
	
	String str="UPDATE amenity SET ame_name=?,ame_type=?,no_of_people=?,start_time=?,end_time=? WHERE ame_name=?";
			
			
			PreparedStatement psmt=conn.prepareStatement(str);
			
			psmt.setString(1,name1);
			psmt.setString(2,addr1);
			psmt.setString(3,con1);
			psmt.setString(4,from1);
			psmt.setString(5,to1);
			
			psmt.executeUpdate();
			new SuccessDialog1();
	    }
		catch(BlankException be)
			{
				new ErrorDialog2();
			}
		catch(SQLException sq)
				{
					System.out.println(sq);
				}
		catch(NameEx ne)
					{
						new ErrorDialog1();
					}
		catch(Exception er)
					{
						
					}
	}
}	
 
 public static void main(String[] args) 
	{
		new amenities();

	}
}

