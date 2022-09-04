import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.*;

class detail extends JFrame implements ActionListener,ItemListener
{
	JTabbedPane t;
	JPanel pnlmember,pnlworker,pnlbill,pnlser,pnltest,pnlamenity,pnlmaterial;
	DefaultTableModel dm;
	JTable jt;

	Vector rows,header,row1,rows1,header1,row11,rows11,header11,row111,rows4,header4,row4,rows5,header5,row5;

	JButton close=new JButton("OK",new ImageIcon("D:/Pro/House/src/housing/images/exit.png"));

	Statement stmt=null;
	JScrollPane p;
       Choice chrt;
	detail()
	{
		super("Reports");

		pnlmember=new JPanel();



		pnlmember.setLayout(null);

        JLabel l=new JLabel("ENTER FLAT-TYPE:");

		t=new JTabbedPane();

		Container c=getContentPane();

		t.add("Member Details ",pnlmember);


            chrt=new Choice();
            chrt.addItem("SELECT");
            chrt.addItem("1BHK");
			chrt.addItem("2BHK");
			chrt.addItem("3BHK");
			chrt.addItem("DUPLEX");
            chrt.addItem("ROW-HOUSE");

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






		dm=new DefaultTableModel(rows,header);
		jt=new JTable(dm);
		 p=new JScrollPane(jt);

		p.setBounds(45,20,900,550);
		pnlmember.add(p);


		close.setBounds(570,590,100,30);
		chrt.setBounds(450,590,100,30);
        l.setBounds(300,590,140,30);

		pnlmember.add(close);
		pnlmember.add(chrt);
		pnlmember.add(l);
	    close.addActionListener(this);
		close.setToolTipText("OK Alt+0");
		close.setMnemonic(KeyEvent.VK_O);


         chrt.addItemListener(this);


        c.add(t);

		setSize(1000,700);
		setLocationRelativeTo(null);
		setVisible(true);
		setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }



   public void itemStateChanged(ItemEvent ie)
   {

        String type=(String)ie.getItem();
                    t.remove(pnlmember);
					pnlmember.add(close);
	             	pnlmember.add(chrt);
                    pnlmember.remove(p);
                    rows.removeAllElements();

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
					ResultSet rs=stmt.executeQuery("select mem_id,mem_name,mem_address,mem_contact,mem_blood,mem_history,mem_dob,mem_current,mem_roomno,mem_adddate,mem_rtype,mem_gender,mem_docname from member where mem_rtype='"+type+"' ORDER BY mem_id");

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
		     				t.add("Member Details ",pnlmember);



   }

	public void actionPerformed(ActionEvent ae)
		{
			if(ae.getSource()==close )
			{
				dispose();
			}
		}




}
