import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import java.text.*;


class Billing extends JFrame implements ActionListener
{	
	
	static Connection cn=null;
	Statement st=null;
	ResultSet rs=null;
	
	 clsSettings settings = new clsSettings();
	
    

	JLabel lmain,lpname,lpno,lpno1,ldad,lddis,lrt,ltamt,temp,l_ppk,l_km,l_amb;
	JTextField tfname,tfno,tfno1,tfdateadd,tfrtype,tftamt,t_ppk,t_km,t_amb;
	JButton bsub,bclr,bback,bsave,calu;
	
	JLabel bl=new JLabel("Invalid Member ID");
	Billing()
	{
		super("Billing Information");
		
		
		lmain=new JLabel("Billing Information");
		lmain.setBounds(300,35,407,35);
		lmain.setFont(new Font("Dialog",Font.BOLD,30));
	


		lpno=new JLabel("Member ID. :");
		lpno.setBounds(104,97,100,35);
		

		tfno=new JTextField(30);
		tfno.setBounds(230,100,70,30);
		
		lpno1=new JLabel("Bill No. :");
		lpno1.setBounds(480,97,70,35);
		

		tfno1=new JTextField(30);
		tfno1.setBounds(604,100,70,30);
		tfno1.setEditable(false);
		
		
		lpname=new JLabel("Member Name :");
		lpname.setBounds(104,155,205,35);
		
		

		tfname=new JTextField(30);
		tfname.setBounds(230,155,225,30);
		

	
		
		ldad=new JLabel("Last Date :");
		ldad.setBounds(480,155,120,35);

		tfdateadd=new JTextField(20);
		tfdateadd.setBounds(604,158,80,30);


	
		lddis=new JLabel("Current Date :");
		lddis.setBounds(480,205,120,35);
	
		
		lrt=new JLabel("Room Type :");
		lrt.setBounds(104,222,100,35);
	

		tfrtype=new JTextField(20);
		tfrtype.setBounds(230,222,120,30);
		
		
		l_ppk=new JLabel("Total Price Of Use Services:");
		l_ppk.setBounds(104,265,190,35);
	

		t_ppk=new JTextField(5);
		t_ppk.setBounds(280,265,50,30);
		
		//l_km=new JLabel("Total Services:");
		//l_km.setBounds(280,265,650,35);
	

		//t_km=new JTextField(5);
		//t_km.setBounds(390,265,50,30);
		
	    calu=new JButton("Calculate",new ImageIcon("D:/Pro/House/src/housing/images/calc.png"));
		calu.setBounds(500,265,120,30);

		ltamt=new JLabel("Maintenance :");
		ltamt.setBounds(450,320,102,35);
		

		tftamt=new JTextField(20);
		tftamt.setBounds(550,320,120,30);
	
		l_amb=new JLabel("Total Charges :");
		l_amb.setBounds(104,320,200,35);
		

		t_amb=new JTextField(20);
		t_amb.setBounds(260,320,120,30);
	
		//JLabel bl=new JLabel("Invalid Member ID");
		
		

		bsub=new JButton("SEARCH" ,new ImageIcon("D:/Pro/House/src/housing/images/2rightarrow_hover.png"));
		bsub.setBounds(300,380,110,30);
	
		
		bsave=new JButton("SAVE" ,new ImageIcon("D:/Pro/House/src/housing/images/save_all.png"));
		bsave.setBounds(150,380,110,30);
	

		bclr=new JButton("CLEAR",new ImageIcon("D:/Pro/House/src/housing/images/restore.png"));
		bclr.setBounds(450,380,110,30);
		
		bback=new JButton("BACK",new ImageIcon("D:/Pro/House/src/housing/images/1leftarrow_hover.png"));
		bback.setBounds(600,380,110,30);
		

		settings.Numvalidator(tfno);



	
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		df.setLenient(false);  
		System.out.println(df.format(cal.getTime()));
		String dd1=df.format(cal.getTime());
		

		temp=new JLabel(dd1);
		temp.setBounds(604,205,80,30);
		
		
		
		bclr.addActionListener(new clear());
		bsub.addActionListener(new submit());
		bsave.addActionListener(new save());
		bback.addActionListener(new back());
		calu.addActionListener(new callu());
		
		tfname.setEditable(false);
		tfdateadd.setEditable(false);
		tfrtype.setEditable(false);
		tftamt.setEditable(false);
		t_amb.setEditable(false);
		
		add(lmain);
		add(lpno);
		add(tfno);
		add(lpno1);
		add(tfno1);
		add(lpname);
		add(tfname);
		//add(ldad);
		//add(tfdateadd);
		add(lddis);
		add(lrt);
		add(tfrtype);
		add(ltamt);
		add(tftamt);
		add(temp);
		add(bsub);
		add(bsave);
		add(bclr);
		add(bback);
	    add(l_ppk);
	    add(t_ppk);
	  //  add(t_km);
	  //  add(l_km);
		add(calu);
		add(l_amb);
		add(t_amb);
		add(bl);
		
		
		
				invoice();

	
		setSize(840,500);		
		setLocationRelativeTo(null);
		setLayout(null);
		setVisible(true);



		}
	void invoice()
	{

		try
		{
/* Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			
		
	
		Connection conn=DriverManager.getConnection("jdbc:odbc:house"); */

      Class.forName("com.mysql.jdbc.Driver"); 
          Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/house","root","root");
			
		

			
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery("select MAX(bill_id)+1 from bill");
			while(rs.next())
			{



				String billno=rs.getString(1);
				
				if(billno==null)

				{
					tfno1.setText("1");
					System.out.println("success.....");
				}
				else
				{

					tfno1.setText(billno);
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
				tfno.setText("");
				tfdateadd.setText("");
				tfrtype.setText("");
				tftamt.setText("");
				t_amb.setText("");
				t_km.setText("");
				t_ppk.setText("");
			}
	}



	class back implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			
			dispose();
			
		}
	}



	class callu implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
		
		String qty=t_ppk.getText();	
		for(int i=0; i<qty.length(); i++)
				{
					boolean check = Character.isLetter(qty.charAt(i));
					char a=qty.charAt(i);
					System.out.print("  "+a);
					if(!( (a>='0' && a<='9') ))
					{
				t_ppk.setEditable(true);
              String st="* Enter only numeric digits(0-9) in the Price/km Field";
              JOptionPane.showMessageDialog(null,st);
              t_ppk.setText(null);
              break;
				}}
			
			
			/*String qty1=t_km.getText();	
		for(int i=0; i<qty1.length(); i++)
				{
					boolean check = Character.isLetter(qty.charAt(i));
					char a=qty1.charAt(i);
					System.out.print("  "+a);
					if(!( (a>='0' && a<='9') ))
					{
				t_km.setEditable(true);
              String st="* Enter only numeric digits(0-9) in the Total km Field";
              JOptionPane.showMessageDialog(null,st);
              t_km.setText(null);
              break;
				}}
		*/	
			
	    int  pq=Integer.parseInt(t_ppk.getText());
		//int pw=Integer.parseInt(t_km.getText());
        int ccc=pq+2000;
        
       String TOTAL=String.valueOf(ccc);			  
		  t_amb.setText(TOTAL);
        
        
	//t_amb.setText(ccc);	
	System.out.print(ccc);
		}
	}


	class save implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			try
			{
			
			String str1,str2,str3,str4,str5,str6,str7,str8;
			
			str1=tfno1.getText();
			str2=tfno.getText();
			str3=tfname.getText();
			str4=tfdateadd.getText();
			str5=temp.getText();
			str6=tfrtype.getText();
			str7=tftamt.getText();
			str8=t_amb.getText();
			
			
	/* Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			
		
	
		Connection conn=DriverManager.getConnection("jdbc:odbc:house");
			
		Statement st=conn.createStatement(); */

Class.forName("com.mysql.jdbc.Driver"); 
          Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/house","root","root");
			
		
Statement st=conn.createStatement();
		st.executeUpdate("INSERT INTO bill(mem_id,mem_name,date_of_complain,date_of_handle,room_type,bill_amt) VALUES('"+str2+"','"+str3+"','"+str4+"','"+str5+"','"+str6+"','"+str8+"');");
			  	
		tfname.setText("");
		tfno.setText("");
		tfdateadd.setText("");
		tfrtype.setText("");
		tftamt.setText("2000");
		t_amb.setText("");
		t_km.setText("");
		t_ppk.setText("");
			  	
		new SuccessDialog();
		
		invoice();
		int sel=JOptionPane.showConfirmDialog(null,"<html><b><font color=black>Do You Want To Create More Bill","Information",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
			if(sel==JOptionPane.NO_OPTION)
			{	
				dispose();
			}
		tfno.requestFocus();
			
		}
		catch(Exception e)
		{
			
		}
	}
	}

class submit extends Frame implements ActionListener
{
	public void actionPerformed(ActionEvent ae)
	{	
		try
		{
			//bl.setText(null);
			String qty=tfno.getText();	
			for(int i=0; i<qty.length(); i++)
					{
						boolean check = Character.isLetter(qty.charAt(i));
						char a=qty.charAt(i);
						System.out.print("  "+a);
						if(!( (a>='0' && a<='9') ))
						{
					//t_ppk.setEditable(true);
							
							bl.setBounds(210,132,100,9);
							bl.setForeground(Color.red);	
	              //String st="* Enter only numeric digits(0-9) in the Member ID Field";
	              //JOptionPane.showMessageDialog(null,st);
	              tfno.setText(null);
	              break;
					}}
			
			Integer no,num=Integer.parseInt(qty);
			bl.setText(" ");
			String name,room,dateadd,rtype;

/*	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			
		
	
		Connection conn=DriverManager.getConnection("jdbc:odbc:house"); */

Class.forName("com.mysql.jdbc.Driver"); 
          Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/house","root","root");
			
		
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery("SELECT * FROM member WHERE mem_id="+num);

			if(rs.next())
			{

				no=rs.getInt("mem_id");
				name=rs.getString("mem_name");
				dateadd=rs.getString("mem_adddate");
				System.out.println(dateadd);
				//d=rs.getString("dateadd");	
				rtype=rs.getString("mem_rtype");
				
				tfname.setText(name);
				tfdateadd.setText(dateadd);
				tfrtype.setText(rtype);	
				

			}
			else
			{
				JOptionPane.showMessageDialog(null, "Invalid Member ID","Invalid",JOptionPane.ERROR_MESSAGE);
			}
		

			
			try
			{
				Calendar cal=Calendar.getInstance();
				SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
				df.setLenient(false);  

				int dnow=cal.get(Calendar.DAY_OF_MONTH);
				int mnow=cal.get(Calendar.MONTH);
				int ynow=cal.get(Calendar.YEAR);
				int	mnowF=mnow+1;
				//cal.setTime(df.parse(tfdateadd.getText()));
				System.out.println(dnow+"\n"+mnow+"\n"+ynow);

				Calendar cal1=Calendar.getInstance();
				cal1.setTime(df.parse(tfdateadd.getText()));
				


				SimpleDateFormat sf2=new SimpleDateFormat("yyyy,MM,dd");
				sf2.setLenient(false);  





		



				int daddd=cal1.get(Calendar.DAY_OF_MONTH);
				int daddMM=cal1.get(Calendar.MONTH);
				int daddYY=cal1.get(Calendar.YEAR);
				int daddMMF=daddMM+1;


			System.out.println(daddd+"\n"+daddMM+"\n"+daddYY);


			
				long from = new java.util.GregorianCalendar(ynow,mnowF,dnow).getTime().getTime(); 
				long to = new java.util.GregorianCalendar(daddYY,daddMMF,daddd).getTime().getTime();
				double difference = from-to;

			System.out.println(from+"\n"+to);	
				
long days = Math.round((difference/(1000*60*60*24)));

				long bill=0;

				String rt=tfrtype.getText();


				if(rt.equals("Duplex"))
				{
					System.out.println(tfrtype.getText());
					int m=2000;
					System.out.println(m);	
					System.out.println(days);		
					bill=days*m;
					System.out.println("total  bill = "+bill);
				}
				if(rt.equals("2BHK"))
				{
					int m=800;
					System.out.println(m);			
					bill=days*m;
					System.out.println("total  bill = "+bill);
				}
				if(rt.equals("1BHK"))
				{
					int m=600;
					System.out.println(m);			
					bill=days*m;
					System.out.println("total  bill = "+bill);
				}
				if(rt.equals("General"))
				{
					int m=400;
					System.out.println(m);			
					bill=days*m;
					System.out.println("total  bill = "+bill);
				}

				

				//Final Bill
				//String FinalBill=(new Long(bill)).toString();
				tftamt.setText("2000");


		
			}

		catch (Exception e)
			{
				//new ErrorDialog2();
				System.out.println(e);
			}



		}
		catch (Exception sq)
		{
			System.out.println(sq);
		}



	}
}

	public static void main(String[] args) 
	{
		new Billing();
	}
}



