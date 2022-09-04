import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.*;

class Report extends JFrame implements ActionListener
{
	JTabbedPane t;
	JPanel pnlmember,pnlworker,pnlbill,pnlser,pnltest,pnlamenity,pnlmaterial;
	DefaultTableModel dm;
	JTable jt;
	
	Vector rows,header,row1,rows1,header1,row11,rows11,header11,row111,rows4,header4,row4,rows5,header5,row5;
	Vector r,head,aname,atype,ano,stime,etime,rr;
	Vector r2,head2,mate_name,mate_type,company,mfg_date,exp_date,qty,price,rr2;
	
	JButton close=new JButton("OK",new ImageIcon("D:/Pro/House/src/housing/images/exit.png"));
	JButton close1=new JButton("OK",new ImageIcon("D:/Pro/House/src/housing/images/exit.png"));
	JButton close2=new JButton("OK",new ImageIcon("D:/Pro/House/src/housing/images/exit.png"));
	JButton close3=new JButton("OK",new ImageIcon("D:/Pro/House/src/housing/images/exit.png"));
	JButton close4=new JButton("OK",new ImageIcon("D:/Pro/House/src/housing/images/exit.png"));
	JButton close5=new JButton("OK",new ImageIcon("D:/Pro/House/src/housing/images/exit.png"));
	JButton close6=new JButton("OK",new ImageIcon("D:/Pro/House/src/housing/images/exit.png"));

	Statement stmt=null;
	
	Report()
	{
		super("Reports");
		
		pnlmember=new JPanel();
		pnlworker=new JPanel();			
		pnlbill=new JPanel();
		pnlamenity=new JPanel();
		pnlmaterial=new JPanel();
		
		//pnlser=new JPanel();
		//pnltest=new JPanel();
		
		
		pnlmember.setLayout(null);
		pnlworker.setLayout(null);
		pnlbill.setLayout(null);
		pnlamenity.setLayout(null);
		pnlmaterial.setLayout(null);
		//pnlser.setLayout(null);
		//pnltest.setLayout(null);

		t=new JTabbedPane();

		Container c=getContentPane();

		t.add("Reports Members",pnlmember);
		t.add("Reports Workers",pnlworker);
        t.add("Reports Amenity",pnlamenity);
        t.add("Reports Bills",pnlbill);	
      //  t.add("Reports Material",pnlmaterial);		
		//t.add("Reports Services",pnlser);	
		//t.add("Reports Tests",pnltest);	
			
		
		//panel 1
	
		rows=new Vector();
		header=new Vector();
		header.addElement("M_ID");
		header.addElement("NAME");
		header.addElement("ADDRESS");
		header.addElement("CONTACT_NO");
		header.addElement("B_GROUP");
		header.addElement("HISTORY");
		header.addElement("D_O_B");
		header.addElement("CURRENT PROBLEM");
		header.addElement("FLAT NO. ");
		header.addElement("ENTRY_DATE");
		header.addElement("FLAT_TYPE");
		header.addElement("GENDER");
		header.addElement("DOC Name");
			
		try
		{
    		/*	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			
		//String stra="house";
		//String strb="jdbc:mysql://localhost:3306/";
		//String strc="root";
		//String strd="root";
	
		Connection conn=DriverManager.getConnection("jdbc:odbc:house"); */

Class.forName("com.mysql.jdbc.Driver"); 
          Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/house","root","root");
			
		
			stmt=conn.createStatement();
		}
		catch(Exception ae)
		{
			System.out.print("Driver not found");
			ae.printStackTrace();	
		}
		
		try
		{
			ResultSet rs=stmt.executeQuery("select mem_id,mem_name,mem_address,mem_contact,mem_blood,mem_history,mem_dob,mem_current,mem_roomno,mem_adddate,mem_rtype,mem_gender,mem_docname from member ORDER BY mem_id");
			while(rs.next())
			{
			    row1=new Vector();
				row1.addElement(rs.getString(1));
				row1.addElement(rs.getString(2));
				row1.addElement(rs.getString(3));
				row1.addElement(rs.getString(4));
				row1.addElement(rs.getString(5));
				row1.addElement(rs.getString(6));
				row1.addElement(rs.getString(7));
				row1.addElement(rs.getString(8));
				row1.addElement(rs.getString(9));
				row1.addElement(rs.getString(10));
				row1.addElement(rs.getString(11));
				row1.addElement(rs.getString(12));
				row1.addElement(rs.getString(13));
				
				
				rows.addElement(row1);
			}
		}
		catch(NullPointerException e)
		{
			System.out.print("Exception is there" +e);
				e.printStackTrace();
		}
		catch(SQLException aw)
		{
			System.out.print("Exception for sql" +aw);
				aw.printStackTrace();
		}
		
		
		dm=new DefaultTableModel(rows,header);
		jt=new JTable(dm);		
		JScrollPane p=new JScrollPane(jt);
		p.setBounds(45,20,900,550);
		pnlmember.add(p);
		jt.setRowSelectionAllowed(false);
		jt.setEnabled(false);
	
		close.setBounds(450,590,100,30);
		pnlmember.add(close);
	    close.addActionListener(this);
		close.setToolTipText("OK Alt+0");
		close.setMnemonic(KeyEvent.VK_O);
		
	
	//end panel 1
	
	//panel 2
	
		rows1=new Vector();
		header1=new Vector();
		header1.addElement("	W_ID");
		header1.addElement("WORKER NAME");
		header1.addElement("WORKER ADDRESS");
		header1.addElement("CONTACT_NO");
		header1.addElement("FIELDS");
		header1.addElement("TIME_FROM");
		header1.addElement("TIME_TO");

			
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
			
		

			stmt=conn.createStatement();
		}
		catch(Exception ae)
		{
			System.out.print("Driver not found");
			ae.printStackTrace();	
		}
		
		try
		{
			ResultSet rs=stmt.executeQuery("select wor_id,wor_name,wor_address,wor_contact,wor_specialization,wor_workfrom,wor_workto from worker ORDER BY wor_id");
			while(rs.next())
			{
			    row11=new Vector();
				row11.addElement(rs.getString(1));
				row11.addElement(rs.getString(2));
				row11.addElement(rs.getString(3));
				row11.addElement(rs.getString(4));
				row11.addElement(rs.getString(5));
				row11.addElement(rs.getString(6));
				row11.addElement(rs.getString(7));
				
				
				rows1.addElement(row11);
			}
		}
		catch(NullPointerException e)
		{
			System.out.print("Exception is there" +e);
				e.printStackTrace();
		}
		catch(SQLException aw)
		{
			System.out.print("Exception for sql" +aw);
				aw.printStackTrace();
		}
		
		
		dm=new DefaultTableModel(rows1,header1);
		jt=new JTable(dm);		
		JScrollPane p1=new JScrollPane(jt);
		p1.setBounds(45,20,900,550);
		pnlworker.add(p1);
		jt.setRowSelectionAllowed(false);
		jt.setEnabled(false);
	
		close1.setBounds(450,590,100,30);
		pnlworker.add(close1);
	    close1.addActionListener(this);
		close1.setToolTipText("OK Alt+0");
		close1.setMnemonic(KeyEvent.VK_O);
		
		//end panel2
	
		// panel 3
		
		rows11=new Vector();
		header11=new Vector();
		header11.addElement("B_ID");
		header11.addElement("MEM_ID");
		header11.addElement("MEMBER_NAME");
		header11.addElement("DATE_OF_COMPLAIN");
		header11.addElement("DATE_OF_HANDLE");
		header11.addElement("ROOM_TYPE");
	header11.addElement("TOTAL_SERVICE_CHARGE+(2000)");

			
		try
		{
    		/*	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			
		//String stra="house";
		//String strb="jdbc:mysql://localhost:3306/";
		//String strc="root";
		//String strd="root";
	
		Connection conn=DriverManager.getConnection("jdbc:odbc:house"); */

Class.forName("com.mysql.jdbc.Driver"); 
          Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/house","root","root");
			
		
			stmt=conn.createStatement();
		}
		catch(Exception ae)
		{
			System.out.print("Driver not found");
			ae.printStackTrace();	
		}
		
		try
		{
			ResultSet rs=stmt.executeQuery("select bill_id,mem_id,mem_name,date_of_complain,date_of_handle,room_type,bill_amt from bill ORDER BY bill_id");
			while(rs.next())
			{
			    row111=new Vector();
				row111.addElement(rs.getString(1));
				row111.addElement(rs.getString(2));
				row111.addElement(rs.getString(3));
				row111.addElement(rs.getString(4));
				row111.addElement(rs.getString(5));
				row111.addElement(rs.getString(6));
				row111.addElement(rs.getString(7));
				
				
				rows11.addElement(row111);
			}
		}
		catch(NullPointerException e)
		{
			System.out.print("Exception is there" +e);
				e.printStackTrace();
		}
		catch(SQLException aw)
		{
			System.out.print("Exception for sql" +aw);
				aw.printStackTrace();
		}
		
		
		dm=new DefaultTableModel(rows11,header11);
		jt=new JTable(dm);		
		JScrollPane p11=new JScrollPane(jt);
		p11.setBounds(45,20,900,550);
		pnlbill.add(p11);
		jt.setRowSelectionAllowed(false);
		jt.setEnabled(false);
	
		close2.setBounds(450,590,100,30);
		pnlbill.add(close2);
	    close2.addActionListener(this);
		close2.setToolTipText("OK Alt+0");
		close2.setMnemonic(KeyEvent.VK_O);
		
		//end panel 3
	
	
	//panel 4
	
        r=new Vector();
		head=new Vector();
		head.addElement("Amenity Name");
		head.addElement("Amenity Type");
		head.addElement("No.Of.Peoples At Time");
		head.addElement("Start Time");
		head.addElement("End Time");
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver"); 
          Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/house","root","root");
			
		
			stmt=conn.createStatement();
		}
		catch(Exception ae)
		{
			System.out.print("Driver not found");
			ae.printStackTrace();	
		}
		
		try
		{
			ResultSet rs=stmt.executeQuery("select ame_name,ame_type,no_of_people,start_time,end_time from amenity");
            while(rs.next())
			{
              rr=new Vector();
			  rr.addElement(rs.getString(1));
			  rr.addElement(rs.getString(2));
			  rr.addElement(rs.getString(3));
			  rr.addElement(rs.getString(4));
			  rr.addElement(rs.getString(5));
              
              r.addElement(rr);			  
		    }
		}

        catch(NullPointerException e)
		{
			System.out.print("Exception is there" +e);
				e.printStackTrace();
		}
		catch(SQLException aw)
		{
			System.out.print("Exception for sql" +aw);
				aw.printStackTrace();
		}

		
        dm=new DefaultTableModel(r,head);
		jt=new JTable(dm);		
		JScrollPane p7=new JScrollPane(jt);
		p7.setBounds(45,20,900,550);
		pnlamenity.add(p7);
		jt.setRowSelectionAllowed(false);
		jt.setEnabled(false);
	
		close5.setBounds(450,590,100,30);
		pnlamenity.add(close5);
	    close5.addActionListener(this);
		close5.setToolTipText("OK Alt+0");
		close5.setMnemonic(KeyEvent.VK_O);		
   	
	
	//panel 5
	
        r2=new Vector();
		head2=new Vector();
		head2.addElement("Material Name");
		head2.addElement("Material Type");
		head2.addElement("Company");
		head2.addElement("Manufacture Date");
		head2.addElement("Expiry Date");
		head2.addElement("Quantity");
		head2.addElement("Price");
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver"); 
          Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/house","root","root");
			
		
			stmt=conn.createStatement();
		}
		
		catch(Exception ae)
		{
			System.out.print("Driver not found");
			ae.printStackTrace();	
		}
		
		try
		{
			ResultSet rs=stmt.executeQuery("select mate_name,mate_type,company,mfg_date,exp_date,qty,price from material");
            while(rs.next())
			{
              rr2=new Vector();
			  rr2.addElement(rs.getString(1));
			  rr2.addElement(rs.getString(2));
			  rr2.addElement(rs.getString(3));
			  rr2.addElement(rs.getString(4));
			  rr2.addElement(rs.getString(5));
			  rr2.addElement(rs.getString(6));
			  rr2.addElement(rs.getString(7));
              
              r2.addElement(rr2);			  
		    }
		}

        catch(NullPointerException e)
		{
			System.out.print("Exception is there" +e);
				e.printStackTrace();
		}
		catch(SQLException aw)
		{
			System.out.print("Exception for sql" +aw);
				aw.printStackTrace();
		}

		
        dm=new DefaultTableModel(r2,head2);
		jt=new JTable(dm);		
		JScrollPane p8=new JScrollPane(jt);
		p8.setBounds(45,20,900,550);
		pnlmaterial.add(p8);
		jt.setRowSelectionAllowed(false);
		jt.setEnabled(false);
	
		close6.setBounds(450,590,100,30);
		pnlmaterial.add(close6);
	    close6.addActionListener(this);
		close6.setToolTipText("OK Alt+0");
		close6.setMnemonic(KeyEvent.VK_O);		
    		

        c.add(t);
		
		setSize(1000,700);
		setLocationRelativeTo(null);
		setVisible(true);
		setLayout(null); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
    }
	
	public void actionPerformed(ActionEvent ae)
		{
			if(ae.getSource()==close || ae.getSource()==close1 || ae.getSource()==close2 || ae.getSource()==close3 || ae.getSource()==close4 || ae.getSource()==close5 || ae.getSource() ==close6)
			{
				dispose();
			}
		}



	public static void main(String[] args) 
	{
		new Report();
	
	}
}
