import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;


class InvalidDayException extends Exception
{

}

class InvalidMonthException extends Exception
{

}

class NameEx extends Exception{}

class BlankException extends Exception{}

class MemberInformation extends JFrame implements ActionListener
{
	JTabbedPane t;
	JPanel pnlinsert,pnlupdate,pnldelete,pnlsearch;
	
	//panel 1
	JLabel lmain,lpi,lname,ladd,ltel,lmi,lbg,ldob,lhis,lcur,lpno,lroom,ldateadd,lgender,lrtype,ldtip,ldtip2,ldocname;
	JTextField tfname,tftel,tfdob,tfpno,tfroom,tfdocname,tfdateadd;
	TextArea taadd,tahis,tacur;
	Choice chbg,chrt;
	CheckboxGroup cbmf;
	Checkbox cbm,cbf;
	JButton bsub,bclr,bback;
   datechooser.beans.DateChooserCombo dateChooserCombo1;
	
	
	String dialogmessage;
    String dialogs;
    int dialogtype = JOptionPane.PLAIN_MESSAGE;
    clsSettings settings = new clsSettings();
    
    //panel 2
    
    JLabel lmain1,lpi1,lname1,ladd1,ltel1,lmi1,lbg1,ldob1,lhis1,lcur1,lpno1,lnote1,lroom1,ldateadd1,lgender1,lrtype1,ldtip1,ldtip21,ldocname1;
	JTextField tfname1,tftel1,tfdob1,tfpno1,tfroom1,tfdateadd1,tfdocname1;
	TextArea taadd1,tahis1,tacur1;
	JButton bsub1,bclr1,bback1,bmod1;
	Choice chbg1,chrt1;
	CheckboxGroup cbmf1;
	Checkbox cbm1,cbf1;
    datechooser.beans.DateChooserCombo dateChooserCombo2;
	
	//panel 3
    
    JLabel lmain2,lpi2,lname2,ladd2,ltel2,lmi2,lbg2,ldob2,lhis2,lcur2,lpno2,lnote2,lroom2,ldateadd2,lgender2,lrtype2,ldtip12,ldtip22,ldocname2;
	JTextField tfname2,tftel2,tfdob2,tfpno2,tfroom2,tfdateadd2,tfdocname2;
	TextArea taadd2,tahis2,tacur2;
	JButton bsub2,bclr2,bback2;
	Choice chbg2,chrt2;
	CheckboxGroup cbmf2;
	Checkbox cbm2,cbf2;
     datechooser.beans.DateChooserCombo dateChooserCombo3;
	
	MemberInformation()
	{
		super("Member's Information");
		
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

		t.add("Insert Member",pnlinsert);
		t.add("Update Member",pnlupdate);
	//.add("Delete Member",pnldelete);
		t.add("Search Member",pnlsearch);	
			


/// 	Add	Member info panel


	lmain=new JLabel("Add Member's Information");
	lmain.setBounds(350,10,760,25);
	lmain.setFont(new Font("Dialog",Font.BOLD,28));
	
	lpi=new JLabel("********************************  Add Personal Information  **********************************");
	lpi.setBounds(200,60,750,15);
	lpi.setFont(new Font("Dialog",Font.BOLD,16));

    

     lname=new JLabel("Name :");
	lname.setBounds(104,97,70,25);

	tfname=new JTextField(30);
	tfname.setBounds(270,97,250,20);

	ladd=new JLabel("Previous Address :");
	ladd.setBounds(104,138,200,15);

	taadd=new TextArea();
	taadd.setBounds(270,138,250,100);

	ltel=new JLabel("Contact :");
	ltel.setBounds(575,138,50,25);

	lpno=new JLabel("Member ID.:");
	lpno.setBounds(570,97,70,25);

	tftel=new JTextField(30);
	tftel.setBounds(640,138,250,20);

	settings.Numvalidator(tftel);

	tfpno=new JTextField(30);
	tfpno.setBounds(643,97,50,20);
	tfpno.setEditable(false);

	lroom=new JLabel("Flat No.:");
	lroom.setBounds(720,97,60,20);


	tfroom=new JTextField(30);
	tfroom.setBounds(788,97,60,20);	
	settings.Numvalidator(tfroom);
	
	lmi=new JLabel("********************************  Medical Information  **********************************");
	lmi.setBounds(200,280,750,15);
	lmi.setFont(new Font("Dialog",Font.BOLD,16));
		
	lbg=new JLabel("Blood Group :");
	lbg.setBounds(104,336,79,15);

	chbg=new Choice();
	chbg.setBounds(270,336,53,15);
	chbg.addItem("A -ve");
	chbg.addItem("A +ve");
	chbg.addItem("B -ve");
	chbg.addItem("B +ve");
	chbg.addItem("AB -ve");
	chbg.addItem("AB +ve");
	chbg.addItem("O +ve");
	chbg.addItem("O -ve");
		
	ldob=new JLabel("Date of Birth :");
	ldob.setBounds(575,336,120,15);

	//tfdob=new JTextField(15);
	dateChooserCombo1 = new datechooser.beans.DateChooserCombo();
	dateChooserCombo1.setBounds(720,335,80,20);

	
	
	
	ldtip=new JLabel("(dd-mm-yyyy)");
	ldtip.setBounds(810,335,100,20);	

	lhis=new JLabel("History :");
	lhis.setBounds(104,395,50,15);

	tahis=new TextArea();
	tahis.setBounds(270,395,250,100);

	lcur=new JLabel("Current Problem :");
	lcur.setBounds(575,395,100,15);

	ldocname=new JLabel("Attending Doctor :");
	ldocname.setBounds(575,530,130,15);
	
	tacur=new TextArea();
	tacur.setBounds(720,395,250,100);

	Calendar currentDate = Calendar.getInstance();
	SimpleDateFormat formatter=new SimpleDateFormat("dd-MM-yyyy");
	String dateNow = formatter.format(currentDate.getTime());
	
	ldateadd=new JLabel("Date Of Admission :");
	ldateadd.setBounds(575,180,120,25);

	tfdateadd=new JTextField(dateNow);
	tfdateadd.setBounds(696,180,80,20);
	tfdateadd.setEditable(false);

	tfdocname=new JTextField(100);
	tfdocname.setBounds(720,530,250,20);

	ldtip2=new JLabel("(dd-mm-yyyy)");
	ldtip2.setBounds(782,180,100,20);

	bsub=new JButton("ADD",new ImageIcon("D:/Pro/House/src/housing/images/2rightarrow_hover.png"));
	bsub.setBounds(320,643,100,30);	

	bclr=new JButton("CLEAR",new ImageIcon("D:/Pro/House/src/housing/images/restore.png"));
	bclr.setBounds(450,643,100,30);	

	bback=new JButton("BACK",new ImageIcon("D:/Pro/House/src/housing/images/1leftarrow.png"));
	bback.setBounds(580,643,100,30);

	lgender=new JLabel("Gender :");
	lgender.setBounds(596,223,50,15);
	
	cbmf=new CheckboxGroup();
	cbm=new Checkbox("Male",cbmf,true);
	cbf=new Checkbox("Female",cbmf,false);
	cbm.setBounds(698,223,50,15);
	cbf.setBounds(760,223,60,15);

	lrtype=new JLabel("Type Of Flat : ");
	lrtype.setBounds(104,530,120,25);

	chrt=new Choice();
	chrt.setBounds(270,530,80,15);
	chrt.addItem("1BHK");
	chrt.addItem("2BHK");
	chrt.addItem("3BHK");
	chrt.addItem("DUPLEX");
     chrt.addItem("ROW-HOUSE");

 
	bclr.addActionListener(new clear());
	bsub.addActionListener(new submit());
	bback.addActionListener(new back());

	pnlinsert.add(chrt);
	pnlinsert.add(lrtype);
	pnlinsert.add(cbf);
	pnlinsert.add(cbm);
	pnlinsert.add(lgender);
	pnlinsert.add(bback);
	pnlinsert.add(bclr);
	pnlinsert.add(bsub);
	pnlinsert.add(ldtip2);
	pnlinsert.add(tfdocname);
	pnlinsert.add(tfdateadd);
	pnlinsert.add(ldateadd);
	pnlinsert.add(tacur);	
	pnlinsert.add(ldocname);
	pnlinsert.add(lcur);
	pnlinsert.add(tahis);
	pnlinsert.add(lhis);
	pnlinsert.add(ldtip);
	//pnlinsert.add(tfdob);
	pnlinsert.add(dateChooserCombo1);
	
	pnlinsert.add(ldob);
	pnlinsert.add(chbg);	
	pnlinsert.add(lbg);
	pnlinsert.add(lmi);
	pnlinsert.add(tfroom);
	pnlinsert.add(lroom);
	pnlinsert.add(tfpno);
	pnlinsert.add(tftel);
	pnlinsert.add(lpno);
	pnlinsert.add(ltel);
	pnlinsert.add(taadd);
	pnlinsert.add(ladd);
	pnlinsert.add(tfname);
	pnlinsert.add(lname);
	pnlinsert.add(lpi);
	pnlinsert.add(lmain);	
	pnlinsert.setSize(1000,760);
	
	
// End Of panel add

// Update member info panel

	lmain1=new JLabel("Update Menber's Information");
	lmain1.setBounds(350,10,760,25);
	lmain1.setFont(new Font("Dialog",Font.BOLD,28));
	
	lpi1=new JLabel("********************************  Update Personal Information  **********************************");
	lpi1.setBounds(200,60,750,15);
	lpi1.setFont(new Font("Dialog",Font.BOLD,16));

	lname1=new JLabel("Name :");
	lname1.setBounds(104,97,70,25);

	tfname1=new JTextField(30);
	tfname1.setBounds(270,97,250,20);

	ladd1=new JLabel("Previous Address :");
	ladd1.setBounds(104,138,200,15);

	taadd1=new TextArea();
	taadd1.setBounds(270,138,250,100);

	ltel1=new JLabel("Contact :");
	ltel1.setBounds(575,138,50,25);

	lpno1=new JLabel("Member ID.:");
	lpno1.setBounds(570,97,70,25);

	tftel1=new JTextField(30);
	tftel1.setBounds(640,138,250,20);

	settings.Numvalidator(tftel1);

	tfpno1=new JTextField(30);
	tfpno1.setBounds(643,97,50,20);

	settings.Numvalidator(tfpno1);

	lroom1=new JLabel("Flat No.:");
	lroom1.setBounds(720,97,60,20);

	tfroom1=new JTextField(30);
	tfroom1.setBounds(788,97,60,20);
	settings.Numvalidator(tfroom1);

	lmi1=new JLabel("********************************  Medical Information  **********************************");
	lmi1.setBounds(200,280,750,15);
	lmi1.setFont(new Font("Dialog",Font.BOLD,16));
		
	lbg1=new JLabel("Blood Group :");
	lbg1.setBounds(104,336,79,15);

	chbg1=new Choice();
	chbg1.setBounds(270,336,53,15);
	chbg1.addItem("A -ve");
	chbg1.addItem("A +ve");
	chbg1.addItem("B -ve");
	chbg1.addItem("B +ve");
	chbg1.addItem("AB -ve");
	chbg1.addItem("AB +ve");
	chbg1.addItem("O +ve");
	chbg1.addItem("O -ve");
		
	ldob1=new JLabel("Date of Birth :");
	ldob1.setBounds(575,336,120,15);

	tfdob1=new JTextField(15);
	//dateChooserCombo2 = new datechooser.beans.DateChooserCombo();
   tfdob1.setBounds(720,335,80,20);

	ldtip1=new JLabel("(dd-mm-yyyy)");
	ldtip1.setBounds(810,335,100,20);	

	lhis1=new JLabel("History :");
	lhis1.setBounds(104,395,50,15);

	tahis1=new TextArea();
	tahis1.setBounds(270,395,250,100);

	lcur1=new JLabel("Current Problem :");
	lcur1.setBounds(575,395,100,15);

	ldocname1=new JLabel("Attending Doctor :");
	ldocname1.setBounds(575,530,130,15);
	
	tacur1=new TextArea();
	tacur1.setBounds(720,395,250,100);


	
	ldateadd1=new JLabel("Date Of Admission :");
	ldateadd1.setBounds(575,180,120,25);

	tfdateadd1=new JTextField();
	tfdateadd1.setBounds(696,180,80,20);

	tfdocname1=new JTextField(100);
	tfdocname1.setBounds(720,530,250,20);

	ldtip21=new JLabel("(dd-mm-yyyy)");
	ldtip21.setBounds(782,180,100,20);
	
	
	bsub1=new JButton("SEARCH",new ImageIcon("D:/Pro/House/src/housing/images/search.png"));
	bsub1.setBounds(170,643,120,30);


	bclr1=new JButton("CLEAR",new ImageIcon("D:/Pro/House/src/housing/images/2rightarrow_hover.png"));
	bclr1.setBounds(450,643,100,30);


	bmod1=new JButton("MODIFY",new ImageIcon("D:/Pro/House/src/housing/images/modify.png"));
	bmod1.setBounds(320,643,100,30);


	bback1=new JButton("BACK",new ImageIcon("D:/Pro/House/src/housing/images/1leftarrow.png"));
	bback1.setBounds(580,643,100,30);


	lgender1=new JLabel("Gender :");
	lgender1.setBounds(596,223,50,15);
	
	cbmf1=new CheckboxGroup();
	cbm1=new Checkbox("Male",cbmf1,true);
	cbf1=new Checkbox("Female",cbmf1,false);
	cbm1.setBounds(698,223,50,15);
	cbf1.setBounds(760,223,60,15);

	lrtype1=new JLabel("Type Of Flat : ");
	lrtype1.setBounds(104,530,120,25);

	chrt1=new Choice();
	chrt1.setBounds(270,530,80,15);
	chrt1.addItem("1BHK");
	chrt1.addItem("2BHK");
	chrt1.addItem("3BHK");
	chrt1.addItem("DUPLEX");
     chrt1.addItem("ROW-HOUSE");

	bclr1.addActionListener(new clear());
	bsub1.addActionListener(new submit1());
	bmod1.addActionListener(new modify());
	bback1.addActionListener(new back());

	pnlupdate.add(chrt1);
	pnlupdate.add(lrtype1);
	pnlupdate.add(cbf1);
	pnlupdate.add(cbm1);
	pnlupdate.add(lgender1);
	pnlupdate.add(bback1);
	pnlupdate.add(bclr1);
	pnlupdate.add(bsub1);
	pnlupdate.add(bmod1);
	pnlupdate.add(ldtip21);
	pnlupdate.add(tfdocname1);
	//pnlsearch.add(dateChooserCombo2);
	pnlupdate.add(tfdateadd1);
	pnlupdate.add(ldateadd1);
	pnlupdate.add(tacur1);	
	pnlupdate.add(ldocname1);
	pnlupdate.add(lcur1);
	pnlupdate.add(tahis1);
	pnlupdate.add(lhis1);
	pnlupdate.add(ldtip1);
	pnlupdate.add(tfdob1);
	pnlupdate.add(ldob1);
	pnlupdate.add(chbg1);	
	pnlupdate.add(lbg1);
	pnlupdate.add(lmi1);
	pnlupdate.add(tfroom1);
	pnlupdate.add(lroom1);
	pnlupdate.add(tfpno1);
	pnlupdate.add(tftel1);
	pnlupdate.add(lpno1);
	pnlupdate.add(ltel1);
	pnlupdate.add(taadd1);
	pnlupdate.add(ladd1);
	pnlupdate.add(tfname1);
	pnlupdate.add(lname1);
	pnlupdate.add(lpi1);
	pnlupdate.add(lmain1);	
	pnlupdate.setSize(1000,760);
	
	
// end of panel 2
	
//Search member panel


	lmain2=new JLabel("Search Member's Information");
	lmain2.setBounds(350,10,760,25);
	lmain2.setFont(new Font("Dialog",Font.BOLD,28));
	
	lpi2=new JLabel("********************************  Search Personal Information  **********************************");
	lpi2.setBounds(200,60,750,15);
	lpi2.setFont(new Font("Dialog",Font.BOLD,16));

	lname2=new JLabel("Name :");
	lname2.setBounds(104,97,70,25);

	tfname2=new JTextField(30);
	tfname2.setBounds(270,97,250,20);

	ladd2=new JLabel("Previous Address :");
	ladd2.setBounds(104,138,200,15);

	taadd2=new TextArea();
	taadd2.setBounds(270,138,250,100);

	ltel2=new JLabel("Contact :");
	ltel2.setBounds(575,138,50,25);

	lpno2=new JLabel("Member ID.:");
	lpno2.setBounds(570,97,70,25);
	

	tftel2=new JTextField(30);
	tftel2.setBounds(640,138,250,20);

	settings.Numvalidator(tftel2);

	tfpno2=new JTextField(30);
	tfpno2.setBounds(643,97,50,20);
	
	settings.Numvalidator(tfpno2);


	lroom2=new JLabel("Flat No.:");
	lroom2.setBounds(720,97,60,20);

	tfroom2=new JTextField(30);
	tfroom2.setBounds(788,97,60,20);
	settings.Numvalidator(tfroom2);

	lmi2=new JLabel("********************************  Medical Information  **********************************");
	lmi2.setBounds(200,280,750,15);
	lmi2.setFont(new Font("Dialog",Font.BOLD,16));
		
	lbg2=new JLabel("Blood Group :");
	lbg2.setBounds(104,336,79,15);

	chbg2=new Choice();
	chbg2.setBounds(270,336,53,15);
	chbg2.addItem("A -ve");
	chbg2.addItem("A +ve");
	chbg2.addItem("B -ve");
	chbg2.addItem("B +ve");
	chbg2.addItem("AB -ve");
	chbg2.addItem("AB +ve");
	chbg2.addItem("O +ve");
	chbg2.addItem("O -ve");
		
	ldob2=new JLabel("Date of Birth :");
	ldob2.setBounds(575,336,120,15);

	tfdob2=new JTextField(15);
	//dateChooserCombo3 = new datechooser.beans.DateChooserCombo();
	tfdob2.setBounds(720,335,80,20);

	ldtip12=new JLabel("(dd-mm-yyyy)");
	ldtip12.setBounds(810,335,100,20);	

	lhis2=new JLabel("History :");
	lhis2.setBounds(104,395,50,15);

	tahis2=new TextArea();
	tahis2.setBounds(270,395,250,100);

	lcur2=new JLabel("Current Problem :");
	lcur2.setBounds(575,395,100,15);

	ldocname2=new JLabel("Attending Doctor :");
	ldocname2.setBounds(575,530,130,15);
	
	tacur2=new TextArea();
	tacur2.setBounds(720,395,250,100);


	
	ldateadd2=new JLabel("Date Of Admission :");
	ldateadd2.setBounds(575,180,120,25);

	tfdateadd2=new JTextField();
	tfdateadd2.setBounds(696,180,80,20);

	tfdocname2=new JTextField(100);
	tfdocname2.setBounds(720,530,250,20);

	ldtip22=new JLabel("(dd-mm-yyyy)");
	ldtip22.setBounds(782,180,100,20);
	
	
	bsub2=new JButton("SEARCH",new ImageIcon("D:/Pro/House/src/housing/images/search.png"));
	bsub2.setBounds(300,643,120,30);


	bclr2=new JButton("CLEAR",new ImageIcon("D:/Pro/House/src/housing/images/restore.png"));
	bclr2.setBounds(450,643,100,30);

	bback2=new JButton("BACK",new ImageIcon("D:/Pro/House/src/housing/images/1leftarrow.png"));
	bback2.setBounds(580,643,100,30);


	lgender2=new JLabel("Gender :");
	lgender2.setBounds(596,223,50,15);
	
	cbmf2=new CheckboxGroup();
	cbm2=new Checkbox("Male",cbmf2,true);
	cbf2=new Checkbox("Female",cbmf2,false);
	cbm2.setBounds(698,223,50,15);
	cbf2.setBounds(760,223,60,15);

	lrtype2=new JLabel("Type Of Flat : ");
	lrtype2.setBounds(104,530,120,25);

	chrt2=new Choice();
	chrt2.setBounds(270,530,80,15);
	chrt2.addItem("1BHK");
	chrt2.addItem("2BHK");
	chrt2.addItem("3BHK");
	chrt2.addItem("DUPLEX");
     chrt2.addItem("ROW-HOUSE");

	bclr2.addActionListener(new clear());
	bsub2.addActionListener(new submit2());
	bback2.addActionListener(new back());

	pnlsearch.add(chrt2);
	pnlsearch.add(lrtype2);
	pnlsearch.add(cbf2);
	pnlsearch.add(cbm2);
	pnlsearch.add(lgender2);
	pnlsearch.add(bback2);
	//pnlsearch.add(dateChooserCombo3);
	pnlsearch.add(bclr2);
	pnlsearch.add(bsub2);
	pnlsearch.add(ldtip22);
	pnlsearch.add(tfdocname2);
	pnlsearch.add(tfdateadd2);
	pnlsearch.add(ldateadd2);
	pnlsearch.add(tacur2);	
	pnlsearch.add(ldocname2);
	pnlsearch.add(lcur2);
	pnlsearch.add(tahis2);
	pnlsearch.add(lhis2);
	pnlsearch.add(ldtip12);
	pnlsearch.add(tfdob2);
	pnlsearch.add(ldob2);
	pnlsearch.add(chbg2);	
	pnlsearch.add(lbg2);
	pnlsearch.add(lmi2);
	pnlsearch.add(tfroom2);
	pnlsearch.add(lroom2);
	pnlsearch.add(tfpno2);
	pnlsearch.add(tftel2);
	pnlsearch.add(lpno2);
	pnlsearch.add(ltel2);
	pnlsearch.add(taadd2);
	pnlsearch.add(ladd2);
	pnlsearch.add(tfname2);
	pnlsearch.add(lname2);
	pnlsearch.add(lpi2);
	pnlsearch.add(lmain2);	
	pnlsearch.setSize(1000,760);
	

	invoice();
	
		c.add(t);
		
		
		setSize(1024,768);
		setLocationRelativeTo(null);
		setVisible(true);
		setLayout(null);
				
	}


	void invoice()
	{

		try
		{

		/*Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			
		//String stra="house";
		//String strb="jdbc:mysql://localhost:3306/";
		//String strc="root";
		//String strd="root";
	
		Connection conn=DriverManager.getConnection("jdbc:odbc:house");
Connection conn=DriverManager.getConnection("jdbc:odbc:house");*/

          Class.forName("com.mysql.jdbc.Driver"); 
          Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/house","root","root");

			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery("select MAX(mem_id)+1 from member");
			while(rs.next())
			{



				String memberno=rs.getString(1);
				
				if(memberno==null)

				{
					tfpno.setText("1");
					System.out.println("success.....");
				}
				else
				{

					tfpno.setText(memberno);
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

			tfname.setText("");
			tftel.setText("");
			dateChooserCombo1.setText("");
			taadd.setText("");
			tahis.setText("");
			tacur.setText("");
			tfroom.setText("");
			tfdocname.setText("");
			
			tfname1.setText("");
			tftel1.setText("");
			tfdob1.setText("");
			taadd1.setText("");
			tahis1.setText("");
			tacur1.setText("");
			tfroom1.setText("");
			tfdocname1.setText("");
			tfpno1.setText("");
			tfdateadd1.setText("");
			
			
			tfname2.setText("");
			tftel2.setText("");
		    tfdob2.setText("");
			taadd2.setText("");
			tahis2.setText("");
			tacur2.setText("");
			tfroom2.setText("");
			tfdocname2.setText("");
			tfpno2.setText("");
			tfdateadd2.setText("");
		}
	}
	
	
	
	class submit implements ActionListener
{
	public void actionPerformed(ActionEvent ae)
	{			
		try{
		
		Integer count=0;

		
		Integer num=Integer.parseInt(tfpno.getText());
		if(num==0)
			{
				System.out.println("num");
				throw new BlankException();
			}
		 
		
		 String name=tfname.getText();
		 
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
		
		String addr=taadd.getText();
		if(addr.equals(""))
			{
				System.out.println("addr");
				throw new BlankException();
			}

		String contact=tftel.getText();
		
		int k=contact.length();
		if(k!=10)
		{	
		 JOptionPane.showMessageDialog(null,"Invalid Contact","Invalid",JOptionPane.ERROR_MESSAGE);	
         throw new BlankException();
		}
		String blgr=chbg.getSelectedItem();

		String hist=tahis.getText();

		//String dob=tfdob.getText();
		
		String dob=dateChooserCombo1.getText();
		dateChooserCombo1.setText(dob);
		
					if(dob.equals(""))
			{
				System.out.println("dob");
				throw new BlankException();
			}
	
		
		


            String current=tacur.getText();
			if(current.equals(""))
			{
				System.out.println("current");
				throw new BlankException();
			}

		String room=tfroom.getText();

		String docname=tfdocname.getText();
			if(docname.equals(""))
			{
				System.out.println("docname");
				throw new BlankException();
			}

		String dateadd=tfdateadd.getText();

		String rtype=chrt.getSelectedItem();

		String gender="";

		if(cbm.getState()==true)
			{
				gender="male";
			}
		if(cbf.getState()==true)
			{
				gender="female";
			}
			
		/* Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			
		//String stra="house";
		//String strb="jdbc:mysql://localhost:3306/";
		//String strc="root";
		//String strd="root";
	
		Connection conn=DriverManager.getConnection("jdbc:odbc:house"); */

Class.forName("com.mysql.jdbc.Driver"); 
          Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/house","root","root");

		Statement st=conn.createStatement();	

		st.executeUpdate("INSERT INTO member (mem_name,mem_address,mem_contact,mem_blood,mem_history,mem_dob,mem_current,mem_roomno,mem_adddate,mem_rtype,mem_gender,mem_docname) VALUES('"+name+"','"+addr+"','"+contact+"','"+blgr+"','"+hist+"','"+dob+"','"+current+"','"+room+"','"+dateadd+"','"+rtype+"','"+gender+"','"+docname+"');");
			  	
		new SuccessDialog();
		
		tfname.setText("");
			tftel.setText("");
			tfdob.setText("");
			taadd.setText("");
			tahis.setText("");
			tacur.setText("");
			tfroom.setText("");
			tfdocname.setText("");
			
			invoice();
		int sel=JOptionPane.showConfirmDialog(null,"<html><b><font color=black>Do You Want To Add More Members","Information",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
			if(sel==JOptionPane.NO_OPTION)
			{	
				dispose();
			}
		tfname.requestFocus();
		
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

class modify implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			try{

			/* Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			
		//String stra="house";
		//String strb="jdbc:mysql://localhost:3306/";
		//String strc="root";
		//String strd="root";
	
		Connection conn=DriverManager.getConnection("jdbc:odbc:house");
*/

Class.forName("com.mysql.jdbc.Driver"); 
          Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/house","root","root");
				
			Integer num1=Integer.parseInt(tfpno1.getText());
			if(num1==0)
			{
				throw new BlankException();
			}


			String name1=tfname1.getText();
			
			if(name1.equals(""))
			{
				throw new BlankException();
			}
			 for(int i=0; i<name1.length(); i++)
				{
					boolean check = Character.isLetter(name1.charAt(i));
					char a=name1.charAt(i);
					System.out.print(a);
					if(!((a>=65 && a<=90) || (a>=97 && a<=122) || (a==32)))
					{
					  throw new NameEx();
					}

				}

			String addr1=taadd1.getText();
			if(addr1.equals(null))
			{
				throw new BlankException();
			}


			String contact1=tftel1.getText();
			
			int k=contact1.length();
			if(k!=10)
			{
				JOptionPane.showMessageDialog(null,"Invalid Contact","Invalid Contact",JOptionPane.ERROR_MESSAGE);	
				 throw new BlankException();
			} 
			String blgr1=chbg1.getSelectedItem();

			String hist1=tahis1.getText();
	
		String dob1=tfdob1.getText();
		//String dob=dateChooserCombo2.getText();
		//dateChooserCombo2.setText(dob);
			if(dob1.equals(""))
			{
				throw new BlankException();
			}

			
			String current1=tacur1.getText();
			if(current1.equals(""))
			{
				throw new BlankException();
			}

		
			String roomno1=tfroom1.getText();

			String dateadd1=tfdateadd1.getText();
			if(dateadd1.equals(""))
			{
				throw new BlankException();
			}

			String rtype1=chrt1.getSelectedItem();

			String gender1="";

			String docname=tfdocname1.getText();



			if(cbm1.getState()==true)
				{
					gender1="male";
				}
			if(cbf1.getState()==true)
				{
					gender1="female";
				}

			//Statement st1=cn.createStatement();	

			String str="UPDATE member SET mem_name=?,mem_address=?,mem_contact=?,mem_history=?,mem_blood=?,mem_dob=?,mem_current=?,mem_roomno=?,mem_adddate=?,mem_rtype=?,mem_gender=?,mem_docname=? WHERE mem_id=?";
			
			
			PreparedStatement psmt=conn.prepareStatement(str);
			psmt.setString(1,name1);
			psmt.setString(2,addr1);
			psmt.setString(3,contact1);
			psmt.setString(4,hist1);
			psmt.setString(5,blgr1);
			psmt.setString(6,dob1);
			psmt.setString(7,current1);
			psmt.setString(8,roomno1);
			psmt.setString(9,dateadd1);
			psmt.setString(10,rtype1);
			psmt.setString(11,gender1);
			psmt.setString(12,docname);
			psmt.setInt(13,num1);

			psmt.executeUpdate();
			new SuccessDialog1();

	
			//st.executeUpdate("UPDATE MAT SET memberno="+num1+",name='"+name1+"',address='"+addr1+"',contact='"+contact1+"',history='"+hist1+"',dd='"+dd1+"',mm='"+mm1+"',yy='"+yy1+"',current='"+current1+"' WHERE patientno='"+num1+"';");
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
					catch(Exception e)
					{
						
					}


		}
	}


class submit1 implements ActionListener
{
	public void actionPerformed(ActionEvent ae)
	{			
		try{


			/*Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			
		//String stra="house";
		//String strb="jdbc:mysql://localhost:3306/";
		//String strc="root";
		//String strd="root";
	
		Connection conn=DriverManager.getConnection("jdbc:odbc:house"); */

Class.forName("com.mysql.jdbc.Driver"); 
          Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/house","root","root");
		
		Integer num=Integer.parseInt(tfpno1.getText());
		
		if(num==null)
		{
			String message = "Please Enter Member-ID in member-ID Field";
			 JOptionPane.showMessageDialog(new JFrame(), message, "ERROR!",
         	JOptionPane.ERROR_MESSAGE);
		}
		
		System.out.println(num);
		
		String name;
		String addr;
		String contact;
		String blgr;
		String hist;
		String dob;
		String current;
		String roomno;
		String dateadd;
		String rtype;
		String gender;
		String docname;

		Statement st=conn.createStatement();
		ResultSet rs=st.executeQuery("SELECT * FROM member WHERE mem_id="+num);
		
		if(rs.next())
			{
				num=rs.getInt(1);
				name=rs.getString(2);
				addr=rs.getString(3);
				contact=rs.getString(4);
				hist=rs.getString(6);
				dob=rs.getString(7);
				current=rs.getString(8);
				blgr=rs.getString(5);
				roomno=rs.getString(9);
				dateadd=rs.getString(10);
				rtype=rs.getString(11);
				gender=rs.getString(12);
				docname=rs.getString(13);

				
				tfname1.setText(name);
				tftel1.setText(contact);
				tfdob1.setText(dob);
				taadd1.setText(addr);
				tahis1.setText(hist);
				tacur1.setText(current);
				chbg1.select(blgr);
				tfroom1.setText(roomno);
				tfdateadd1.setText(dateadd);
				tfdocname1.setText(docname);
				chrt1.select(rtype);
				if(gender.equals("male"))
				{
					System.out.println(gender);
					cbm1.setState(true);
				}
				if(gender.equals("female"))
				{
					System.out.println(gender);
					cbf1.setState(true);
				}
				
			}
		
				

		
		}
		catch(Exception esss)
		{
			System.out.println(esss);
		}
		
					
	}
}

class submit2 implements ActionListener
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
		
		Integer num=Integer.parseInt(tfpno2.getText());
		
		if(num.equals(""))
		{
			String message = "Please Enter Member-ID in member-ID Field";
			 JOptionPane.showMessageDialog(new JFrame(), message, "ERROR!",
         	JOptionPane.ERROR_MESSAGE);
		}
		System.out.println(num);
		
		String name;
		String addr;
		String contact;
		String blgr;
		String hist;
		String dob;
		String current;
		String roomno;
		String dateadd;
		String rtype;
		String gender1;
		String docname;

		Statement st=conn.createStatement();
		ResultSet rs=st.executeQuery("SELECT * FROM member WHERE mem_id="+num);
		
		if(rs.next())
			{
				num=rs.getInt(1);
				name=rs.getString(2);
				addr=rs.getString(3);
				contact=rs.getString(4);
				hist=rs.getString(6);
				dob=rs.getString(7);
				current=rs.getString(8);
				blgr=rs.getString(5);
				roomno=rs.getString(9);
				dateadd=rs.getString(10);
				rtype=rs.getString(11);
				gender1=rs.getString(12);
				docname=rs.getString(13);

				
				tfname2.setText(name);
				tftel2.setText(contact);
				tfdob2.setText(dob);
				taadd2.setText(addr);
				tahis2.setText(hist);
				tacur2.setText(current);
				chbg2.select(blgr);
				tfroom2.setText(roomno);
				tfdateadd2.setText(dateadd);
				tfdocname2.setText(docname);
				chrt2.select(rtype);
				if(gender1.equals("male"))
				{
					System.out.println(gender1);
					cbm2.setState(true);
				}
				if(gender1.equals("female"))
				{
					System.out.println(gender1);
					cbf2.setState(true);
				}
				
			}
		
				

		
		}
		catch(Exception ess)
		{
			System.out.println(ess);
		}
		
					
	}
}

	public static void main(String[] args) 
	{
		new MemberInformation();

	}
}
