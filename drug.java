import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class drug extends JFrame implements ActionListener
{
	JTabbedPane t;
	JPanel pnlinsert,pnlupdate,pnldelete,pnlsearch;
	JLabel lmain2;

	//panel 1

	JLabel l_name1,l_type1,l_comp1,l_mfg1,l_exp1,l_qty1,l_price1,header1;
	JTextField t_name1,t_type1,t_comp1,t_mfg1,t_exp1,t_qty1,t_price1;
	JButton bsub1,bclr1,bback1,insert;

	//panel 2

	JLabel l_name2,l_type2,l_comp2,l_mfg2,l_exp2,l_qty2,l_price2,header2,l_input2;
	JTextField t_name2,t_type2,t_comp2,t_mfg2,t_exp2,t_qty2,t_price2,t_input2;
	JButton bsub2,bclr2,bmod2,bback2,submit2,update;

	//panel 3
	JLabel l_name3,l_type3,l_comp3,l_mfg3,l_exp3,l_qty3,l_price3,header3,l_input3;
	JTextField t_name3,t_type3,t_comp3,t_mfg3,t_exp3,t_qty3,t_price3,t_input3;
	JButton bsub3,bclr3,bback3,submit3;

	//panel 4
	JLabel l_name4,l_type4,l_comp4,l_mfg4,l_exp4,l_qty4,l_price4,header4,l_input4;
	JTextField t_name4,t_type4,t_comp4,t_mfg4,t_exp4,t_qty4,t_price4,t_input4;
	JButton bsub4,bclr4,bback4,submit4,delete;

	clsSettings settings = new clsSettings();

	drug()
	{
		super("Material Information");

		pnlinsert=new JPanel();
		pnlupdate=new JPanel();
		pnldelete=new JPanel();
		pnlsearch=new JPanel();

		pnlinsert.setLayout(null);
		pnlupdate.setLayout(null);
		pnldelete.setLayout(null);
		pnlsearch.setLayout(null);

		t=new JTabbedPane();

		Container c=getContentPane();

		t.add("Insert Material",pnlinsert);
		t.add("Update Material",pnlupdate);

		t.add("Search Material",pnlsearch);
		t.add("Delete Material",pnldelete);

		//panel 1
		header1=new JLabel("Add Material Information");
		header1.setBounds(350,10,760,35);
		header1.setFont(new Font("Dialog",Font.BOLD,28));


	l_name1=new JLabel("MATERIAL NAME :");
	l_name1.setBounds(300,150,150,20);
	t_name1=new JTextField(20);
    t_name1.setBounds(480,150,150,20);

    l_type1=new JLabel("MATERIAL TYPE :");
	l_type1.setBounds(300,190,150,20);
	t_type1=new JTextField(20);
    t_type1.setBounds(480,190,150,20);

    l_comp1=new JLabel("COMPANY :");
	l_comp1.setBounds(300,230,150,20);
	t_comp1=new JTextField(20);
    t_comp1.setBounds(480,230,150,20);

    l_mfg1=new JLabel("MANUFACTURE DATE :");
	l_mfg1.setBounds(300,270,150,20);
	t_mfg1=new JTextField(20);
    t_mfg1.setBounds(480,270,150,20);
JLabel l_mfgintruc1=new JLabel("dd-mm-yyyy");
    l_mfgintruc1.setBounds(650,270,150,20);

    l_exp1=new JLabel("EXPIRE DATE :");
	l_exp1.setBounds(300,310,150,20);
	t_exp1=new JTextField(20);
    t_exp1.setBounds(480,310,150,20);

JLabel l_expintruc1=new JLabel("dd-mm-yyyy");
    l_expintruc1.setBounds(650,310,150,20);

    l_qty1=new JLabel("QUANTITY :");
	l_qty1.setBounds(300,350,150,20);
	t_qty1=new JTextField(20);
    t_qty1.setBounds(480,350,150,20);

    l_price1=new JLabel("PRICE PER UNIT :");
	l_price1.setBounds(300,390,150,20);
	t_price1=new JTextField(20);
    t_price1.setBounds(480,390,150,20);


		insert=new JButton("ADD",new ImageIcon("housing/images/2rightarrow_hover.png"));
		insert.setBounds(270,480,120,30);

		bclr1=new JButton("CLEAR",new ImageIcon("housing/images/restore.png"));
		bclr1.setBounds(420,480,120,30);

		bback1=new JButton("BACK",new ImageIcon("housing/images/1leftarrow.png"));
		bback1.setBounds(570,480,120,30);

		bclr1.addActionListener(new clear());
		insert.addActionListener(new addinfo());
		bback1.addActionListener(new back());


	    pnlinsert.add(header1);
		pnlinsert.add(l_name1);
		pnlinsert.add(l_type1);
		pnlinsert.add(l_mfg1);
        pnlinsert.add(l_mfgintruc1);
		pnlinsert.add(l_exp1);
		pnlinsert.add(l_expintruc1);
		pnlinsert.add(l_comp1);
		pnlinsert.add(l_qty1);
		pnlinsert.add(l_price1);
		pnlinsert.add(t_name1);
		pnlinsert.add(t_type1);
		pnlinsert.add(t_mfg1);
		pnlinsert.add(t_exp1);
		pnlinsert.add(t_comp1);
		pnlinsert.add(t_qty1);
		pnlinsert.add(t_price1);
		pnlinsert.add(bback1);
		pnlinsert.add(bclr1);
		pnlinsert.add(insert);
		pnlinsert.setSize(1000,600);


		// End PAnel 1


		// PAnel 2



		header2=new JLabel("Update Material Information");
		header2.setBounds(350,10,760,35);
		header2.setFont(new Font("Dialog",Font.BOLD,28));

	 l_input2=new JLabel("Enter Material name to Be Updated :");
	l_input2.setBounds(150,70,800,20);
	t_input2=new JTextField(20);
    t_input2.setBounds(420,70,150,20);

    submit2=new JButton("Submit",new ImageIcon("housing/images/save.gif"));
	submit2.setBounds(600,70,130,30);


	l_name2=new JLabel("MATERIAL NAME :");
	l_name2.setBounds(300,150,150,20);
	t_name2=new JTextField(20);
    t_name2.setBounds(480,150,150,20);

    l_type2=new JLabel("MATERIAL TYPE :");
	l_type2.setBounds(300,190,150,20);
	t_type2=new JTextField(20);
    t_type2.setBounds(480,190,150,20);

    l_comp2=new JLabel("COMPANY :");
	l_comp2.setBounds(300,230,150,20);
	t_comp2=new JTextField(20);
    t_comp2.setBounds(480,230,150,20);

    l_mfg2=new JLabel("MANUFACTURE DATE :");
	l_mfg2.setBounds(300,270,150,20);
	t_mfg2=new JTextField(20);
    t_mfg2.setBounds(480,270,150,20);

    l_exp2=new JLabel("EXPIRE DATE :");
	l_exp2.setBounds(300,310,150,20);
	t_exp2=new JTextField(20);
    t_exp2.setBounds(480,310,150,20);

    l_qty2=new JLabel("QUANTITY :");
	l_qty2.setBounds(300,350,150,20);
	t_qty2=new JTextField(20);
    t_qty2.setBounds(480,350,150,20);

    l_price2=new JLabel("PRICE PER UNIT :");
	l_price2.setBounds(300,390,150,20);
	t_price2=new JTextField(20);
    t_price2.setBounds(480,390,150,20);

JLabel l_mfgintruc2=new JLabel("dd-mm-yyyy");
    l_mfgintruc2.setBounds(650,270,150,20);
JLabel l_expintruc2=new JLabel("dd-mm-yyyy");
    l_expintruc2.setBounds(650,310,150,20);

		update=new JButton("UPDATE",new ImageIcon("housing/images/add.gif"));
		update.setBounds(270,480,120,30);

		bclr2=new JButton("CLEAR",new ImageIcon("housing/images/restore.png"));
		bclr2.setBounds(420,480,120,30);

		bback2=new JButton("BACK",new ImageIcon("housing/images/1leftarrow.png"));
		bback2.setBounds(570,480,120,30);

		bclr2.addActionListener(new clear());
		update.addActionListener(new updateinfo());
		bback2.addActionListener(new back());
		submit2.addActionListener(new upsearchinfo());

		pnlupdate.add(header2);
		pnlupdate.add(l_input2);
		pnlupdate.add(t_input2);
		pnlupdate.add(submit2);
		pnlupdate.add(l_mfgintruc2);
		pnlupdate.add(l_expintruc2);

		pnlupdate.add(l_name2);
		pnlupdate.add(l_type2);
		pnlupdate.add(l_mfg2);
		pnlupdate.add(l_exp2);
		pnlupdate.add(l_comp2);
		pnlupdate.add(l_qty2);
		pnlupdate.add(l_price2);
		pnlupdate.add(t_name2);
		pnlupdate.add(t_type2);
		pnlupdate.add(t_mfg2);
		pnlupdate.add(t_exp2);
		pnlupdate.add(t_comp2);
		pnlupdate.add(t_qty2);
		pnlupdate.add(t_price2);
		pnlupdate.add(bback2);
		pnlupdate.add(bclr2);
		pnlupdate.add(update);
		pnlupdate.setSize(1000,600);

		//End of panel 2

		//panel 3


	header3=new JLabel("Search Material Information");
		header3.setBounds(300,10,760,35);
		header3.setFont(new Font("Dialog",Font.BOLD,28));

    l_input3=new JLabel("Enter Material name to Be Searched :");
	l_input3.setBounds(150,70,800,20);
	t_input3=new JTextField(20);
   t_input3.setBounds(420,70,150,20);

    submit3=new JButton("Search",new ImageIcon("housing/images/search.png"));
	submit3.setBounds(600,70,100,30);

	l_name3=new JLabel("MATERIAL NAME :");
	l_name3.setBounds(300,150,150,20);
	t_name3=new JTextField(20);
    t_name3.setBounds(480,150,150,20);

    l_type3=new JLabel("MATERIAL TYPE :");
	l_type3.setBounds(300,190,150,20);
	t_type3=new JTextField(20);
    t_type3.setBounds(480,190,150,20);

    l_comp3=new JLabel("COMPANY :");
	l_comp3.setBounds(300,230,150,20);
	t_comp3=new JTextField(20);
    t_comp3.setBounds(480,230,150,20);

    l_mfg3=new JLabel("MANUFACTURE DATE :");
	l_mfg3.setBounds(300,270,150,20);
	t_mfg3=new JTextField(20);
    t_mfg3.setBounds(480,270,150,20);

    l_exp3=new JLabel("EXPIRE DATE :");
	l_exp3.setBounds(300,310,150,20);
	t_exp3=new JTextField(20);
    t_exp3.setBounds(480,310,150,20);

    l_qty3=new JLabel("QUANTITY :");
	l_qty3.setBounds(300,350,150,20);
	t_qty3=new JTextField(20);
    t_qty3.setBounds(480,350,150,20);

    l_price3=new JLabel("PRICE PER UNIT :");
	l_price3.setBounds(300,390,150,20);
	t_price3=new JTextField(20);
    t_price3.setBounds(480,390,150,20);

    t_comp3.setEditable(false);
    t_exp3.setEditable(false);
    t_mfg3.setEditable(false);
    t_exp3.setEditable(false);
    t_name3.setEditable(false);
    t_type3.setEditable(false);
    t_qty3.setEditable(false);
    t_price3.setEditable(false);



		bback3=new JButton("BACK",new ImageIcon("housing/images/1leftarrow_hover.png"));
		bback3.setBounds(400,480,120,30);

	submit3.addActionListener(new searchinfo());
		bback3.addActionListener(new back());


		pnlsearch.add(header3);
		pnlsearch.add(l_input3);

		pnlsearch.add(t_input3);
		pnlsearch.add(submit3);
		pnlsearch.add(l_name3);
		pnlsearch.add(l_type3);
		pnlsearch.add(l_mfg3);
		pnlsearch.add(l_exp3);
		pnlsearch.add(l_comp3);
		pnlsearch.add(l_qty3);
		pnlsearch.add(l_price3);
		pnlsearch.add(t_name3);
		pnlsearch.add(t_type3);
		pnlsearch.add(t_mfg3);
		pnlsearch.add(t_exp3);
		pnlsearch.add(t_comp3);
		pnlsearch.add(t_qty3);
		pnlsearch.add(t_price3);
		pnlsearch.add(bback3);

		pnlsearch.setSize(1000,600);

		//end of panel 3

				//panel 4


	header4=new JLabel("Delete Material Information");
		header4.setBounds(300,10,760,35);
		header4.setFont(new Font("Dialog",Font.BOLD,28));

    l_input4=new JLabel("Enter Material name to Be Deleted :");
	l_input4.setBounds(150,70,800,20);
	t_input4=new JTextField(20);
   t_input4.setBounds(420,70,150,20);

    submit4=new JButton("Submit",new ImageIcon("housing/images/save_all.png"));
	submit4.setBounds(600,70,100,30);

	l_name4=new JLabel("MATERIAL NAME :");
	l_name4.setBounds(300,150,150,20);
	t_name4=new JTextField(20);
    t_name4.setBounds(480,150,150,20);

    l_type4=new JLabel("MATERIAL TYPE :");
	l_type4.setBounds(300,190,150,20);
	t_type4=new JTextField(20);
    t_type4.setBounds(480,190,150,20);

    l_comp4=new JLabel("COMPANY :");
	l_comp4.setBounds(300,230,150,20);
	t_comp4=new JTextField(20);
    t_comp4.setBounds(480,230,150,20);

    l_mfg4=new JLabel("MANUFACTURE DATE :");
	l_mfg4.setBounds(300,270,150,20);
	t_mfg4=new JTextField(20);
    t_mfg4.setBounds(480,270,150,20);

    l_exp4=new JLabel("EXPIRE DATE :");
	l_exp4.setBounds(300,310,150,20);
	t_exp4=new JTextField(20);
    t_exp4.setBounds(480,310,150,20);

    l_qty4=new JLabel("QUANTITY :");
	l_qty4.setBounds(300,350,150,20);
	t_qty4=new JTextField(20);
    t_qty4.setBounds(480,350,150,20);

    l_price4=new JLabel("PRICE PER UNIT :");
	l_price4.setBounds(300,390,150,20);
	t_price4=new JTextField(20);
    t_price4.setBounds(480,390,150,20);


		delete=new JButton("DELETE",new ImageIcon("housing/images/delete.png"));
		delete.setBounds(350,480,120,30);

		bclr4=new JButton("CLEAR",new ImageIcon("housing/images/restore.png"));
		bclr4.setBounds(420,480,100,30);

		bback4=new JButton("BACK",new ImageIcon("housing/images/1leftarrow.png"));
		bback4.setBounds(540,480,120,30);

    t_comp4.setEditable(false);
    t_exp4.setEditable(false);
    t_mfg4.setEditable(false);
    t_exp4.setEditable(false);
    t_name4.setEditable(false);
    t_type4.setEditable(false);
    t_qty4.setEditable(false);
    t_price4.setEditable(false);

		bclr4.addActionListener(new clear());
		delete.addActionListener(new delinfo());
		bback4.addActionListener(new back());
		submit4.addActionListener(new delsearchinfo());

		pnldelete.add(header4);
		pnldelete.add(l_input4);

		pnldelete.add(t_input4);
		pnldelete.add(submit4);
		pnldelete.add(l_name4);
		pnldelete.add(l_type4);
		pnldelete.add(l_mfg4);
		pnldelete.add(l_exp4);
		pnldelete.add(l_comp4);
		pnldelete.add(l_qty4);
		pnldelete.add(l_price4);
		pnldelete.add(t_name4);
		pnldelete.add(t_type4);
		pnldelete.add(t_mfg4);
		pnldelete.add(t_exp4);
		pnldelete.add(t_comp4);
		pnldelete.add(t_qty4);
		pnldelete.add(t_price4);
		pnldelete.add(bback4);

		pnldelete.add(delete);
		pnldelete.setSize(1000,600);

		//end of panel 4





		c.add(t);
		//invoice();
		setSize(1024,608);
		setLocationRelativeTo(null);
		setVisible(true);
		setLayout(null);
	}




public void actionPerformed(ActionEvent ae)
		{}

class clear implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{

			t_name1.setText("");
			t_type1.setText("");
			t_comp1.setText("");
			t_mfg1.setText("");
			t_exp1.setText("");
			t_qty1.setText("");
			t_price1.setText("");
			t_name2.setText("");
			t_type2.setText("");
			t_comp2.setText("");
			t_mfg2.setText("");
			t_exp2.setText("");
			t_qty2.setText("");
			t_price2.setText("");


		}
	}


class back implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			dispose();
		}
	}


class addinfo implements ActionListener
{
	public void actionPerformed(ActionEvent ae)
	{





		String nam=t_name1.getText();
		String typ=t_type1.getText();
        String com=t_comp1.getText();
        String mfg=t_mfg1.getText();
        String exp=t_exp1.getText();
        String qty=t_qty1.getText();
        String pri=t_price1.getText();



		try{


					if(qty.equals(""))
			{
					t_qty1.setEditable(true);
              String st="* QUANTITY field blank";
              JOptionPane.showMessageDialog(null,st);
              t_qty1.setText(null);
			}
			else{

				for(int i=0; i<qty.length(); i++)
				{
					boolean check = Character.isLetter(qty.charAt(i));
					char a=qty.charAt(i);
					System.out.print("  "+a);
					if(!( (a>='0' && a<='9') ))
					{
				t_qty1.setEditable(true);
              String st="* Enter only numeric digits(0-9) in the quantity Field";
              JOptionPane.showMessageDialog(null,st);
              t_qty1.setText(null);
              break;
				}}
			}

		if(pri.equals(""))
			{
					t_price1.setEditable(true);
              String st="* PRICE field blank";
              JOptionPane.showMessageDialog(null,st);
              t_price1.setText(null);
			}
			else{

				for(int i=0; i<pri.length(); i++)
				{
					boolean check = Character.isLetter(pri.charAt(i));
					char a=pri.charAt(i);
					System.out.print("  "+a);
					if(!( (a>='0' && a<='9') ))
					{
				t_price1.setEditable(true);
              String st="* Enter only numeric digits(0-9) in the Price Field";
              JOptionPane.showMessageDialog(null,st);
              t_price1.setText(null);
              break;
				}}
			}




		if(nam.equals(""))
			{
				throw new BlankException();
			}
		else
			{
				for(int i=0; i<nam.length(); i++)
				{
					boolean check = Character.isLetter(nam.charAt(i));
					char a=nam.charAt(i);
					System.out.print("  "+a);
					if(!((a>=65 && a<=90) || (a>=97 && a<=122) || (a==32) ||(a==46)))
					{
					  throw new NameEx();
					}

				}
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

		st.executeUpdate("INSERT INTO material(mate_name,mate_type,company,mfg_date,exp_date,qty,price) VALUES('"+nam+"','"+typ+"','"+com+"','"+mfg+"','"+exp+"','"+qty+"','"+pri+"');");

			t_name1.setText("");
			t_type1.setText("");
			t_comp1.setText("");
			t_mfg1.setText("");
			t_exp1.setText("");
			t_qty1.setText("");
			t_price1.setText("");

		new SuccessDialog();



		int sel=JOptionPane.showConfirmDialog(null,"<html><b><font color=black>Do You Want To Add More Material's?","Information",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
			if(sel==JOptionPane.NO_OPTION)
			{
				dispose();
			}
			t_name1.requestFocus();
		}
		catch(SQLException sq)
		{


			System.out.println(sq);
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



class delinfo implements ActionListener
{
	public void actionPerformed(ActionEvent ae)
	{




          String aaaa=t_input4.getText();



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



		Statement st=conn.createStatement();



		String aaa=" delete from material where mate_name='"+aaaa+"'";
		st.executeUpdate(aaa);

			t_name1.setText("");
			t_type1.setText("");
			t_comp1.setText("");
			t_mfg1.setText("");
			t_exp1.setText("");
			t_qty1.setText("");
			t_price1.setText("");

		new SuccessDialog2();



		int sel=JOptionPane.showConfirmDialog(null,"<html><b><font color=black>Do You Want To Delete More Material?","Information",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
			if(sel==JOptionPane.NO_OPTION)
			{
				dispose();
			}
			t_input4.requestFocus();
		t_input4.setText("");
		t_name4.setText("");
			t_type4.setText("");
			t_comp4.setText("");
			t_mfg4.setText("");
			t_exp4.setText("");
			t_qty4.setText("");
			t_price4.setText("");

		}
		catch(Exception sq)
		{


			System.out.println(sq);
		}


	}

	}



class updateinfo implements ActionListener
{
	public void actionPerformed(ActionEvent ae)
	{




        String name56=t_input2.getText();
		String nam=t_name2.getText();
		String typ=t_type2.getText();
        String com=t_comp2.getText();
        String mfg=t_mfg2.getText();
        String exp=t_exp2.getText();
        String qty=t_qty2.getText();
        String pri=t_price2.getText();



		try{
				if(qty.equals(""))
			{
					t_qty2.setEditable(true);
              String st="* QUANTITY field blank";
              JOptionPane.showMessageDialog(null,st);
              t_qty2.setText(null);
			}
			else{

				for(int i=0; i<qty.length(); i++)
				{
					boolean check = Character.isLetter(qty.charAt(i));
					char a=qty.charAt(i);
					System.out.print("  "+a);
					if(!( (a>='0' && a<='9') ))
					{
				t_qty2.setEditable(true);
              String st="* Enter only numeric digits(0-9) in the quantity Field";
              JOptionPane.showMessageDialog(null,st);
              t_qty2.setText(null);
              break;
				}}
			}

		if(pri.equals(""))
			{
					t_price2.setEditable(true);
              String st="* PRICE field blank";
              JOptionPane.showMessageDialog(null,st);
              t_price2.setText(null);
			}
			else{

				for(int i=0; i<pri.length(); i++)
				{
					boolean check = Character.isLetter(pri.charAt(i));
					char a=pri.charAt(i);
					System.out.print("  "+a);
					if(!( (a>='0' && a<='9') ))
					{
				t_price2.setEditable(true);
              String st="* Enter only numeric digits(0-9) in the Price Field";
              JOptionPane.showMessageDialog(null,st);
              t_price2.setText(null);
              break;
				}}
			}




		if(nam.equals(""))
			{
				throw new BlankException();
			}
		else
			{
				for(int i=0; i<nam.length(); i++)
				{
					boolean check = Character.isLetter(nam.charAt(i));
					char a=nam.charAt(i);
					System.out.print("  "+a);
					if(!((a>=65 && a<=90) || (a>=97 && a<=122) || (a==32) ||(a==46)))
					{
					  throw new NameEx();
					}

				}
			}






		/*
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

		//String stra="house";
		//String strb="jdbc:mysql://172.168.0.254/tybcsdb30","tybcs30","");
		//String strc="root";
		//String strd="root";

		Connection conn=DriverManager.getConnection("jdbc:odbc:house");
*/
Class.forName("com.mysql.jdbc.Driver");
          Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/house","root","root");



		Statement st=conn.createStatement();


		String aea="UPDATE material SET mate_name='"+nam+"', mate_type='"+typ+"', company='"+com+"', mfg_date='"+mfg+"', exp_date='"+exp+"', qty='"+qty+"', price='"+pri+"' where mate_name='"+name56+"'";
		st.executeUpdate(aea);



			t_name2.setText("");
			t_type2.setText("");
			t_comp2.setText("");
			t_mfg2.setText("");
			t_exp2.setText("");
			t_qty2.setText("");
			t_price2.setText("");

		    new SuccessDialog1();



		int sel=JOptionPane.showConfirmDialog(null,"<html><b><font color=black>Do You Want To UPDATE More Material's?","Information",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
			if(sel==JOptionPane.NO_OPTION)
			{
				dispose();
			}
			t_input2.setText("");
			t_input2.requestFocus();
		}
		catch(SQLException sq)
		{


			System.out.println(sq);
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
class searchinfo implements ActionListener
{
	public void actionPerformed(ActionEvent ae)
	{





		String sea=t_input3.getText();




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



		Statement st=conn.createStatement();

		String aaa="select * from material where mate_name='"+sea+"'";
		ResultSet rs=st.executeQuery(aaa);

		while(rs.next())
		{
			String a=rs.getString(1);
			String b=rs.getString(2);
			String c=rs.getString(3);
			String d=rs.getString(4);
			String e=rs.getString(5);
		    String f=rs.getString(6);
		    String g=rs.getString(7);

		     t_name3.setText(a);
			t_type3.setText(b);
			t_comp3.setText(c);
			t_mfg3.setText(d);
			t_exp3.setText(e);
			t_qty3.setText(f);
			t_price3.setText(g);

		}





		}
		catch(Exception sq)
		{


			System.out.println(sq);
		}


	}

	}




class upsearchinfo implements ActionListener
{
	public void actionPerformed(ActionEvent ae)
	{





		String sea=t_input2.getText();




		try{
			/*
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

		//String stra="house";
		//String strb="jdbc:mysql://172.168.0.254/tybcsdb30","tybcs30",""
		//String strc="root";
		//String strd="root";

		Connection conn=DriverManager.getConnection("jdbc:odbc:house");
*/

Class.forName("com.mysql.jdbc.Driver");
          Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/house","root","root");


		Statement st=conn.createStatement();

		String aaa="select * from material where mate_name='"+sea+"'";
		ResultSet rs=st.executeQuery(aaa);

		while(rs.next())
		{
			String a=rs.getString(1);
			String b=rs.getString(2);
			String c=rs.getString(3);
			String d=rs.getString(4);
			String e=rs.getString(5);
		    String f=rs.getString(6);
		    String g=rs.getString(7);

		     t_name2.setText(a);
			t_type2.setText(b);
			t_comp2.setText(c);
			t_mfg2.setText(d);
			t_exp2.setText(e);
			t_qty2.setText(f);
			t_price2.setText(g);

		}





		}
		catch(Exception sq)
		{


			System.out.println(sq);
		}


	}

	}


class delsearchinfo implements ActionListener
{
	public void actionPerformed(ActionEvent ae)
	{





		String sea=t_input4.getText();




		try{
		/*
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

		//String stra="house";
		//String strb="jdbc:mysql://172.168.0.254/tybcsdb30","tybcs30","";
		//String strc="root";
		//String strd="root";

		Connection conn=DriverManager.getConnection("jdbc:odbc:house");
*/

Class.forName("com.mysql.jdbc.Driver");
          Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/house","root","root");


		Statement st=conn.createStatement();

		String aaa="select * from material where mate_name='"+sea+"'";
		ResultSet rs=st.executeQuery(aaa);

		while(rs.next())
		{
			String a=rs.getString(1);
			String b=rs.getString(2);
			String c=rs.getString(3);
			String d=rs.getString(4);
			String e=rs.getString(5);
		    String f=rs.getString(6);
		    String g=rs.getString(7);

		     t_name4.setText(a);
			t_type4.setText(b);
			t_comp4.setText(c);
			t_mfg4.setText(d);
			t_exp4.setText(e);
			t_qty4.setText(f);
			t_price4.setText(g);

		}





		}
		catch(Exception sq)
		{


			System.out.println(sq);
		}


	}

	}












/*
class submit1 implements ActionListener
{


	public void actionPerformed(ActionEvent ae)
	{
		try{


			Class.forName("com.mysql.jdbc.Driver");
          Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/house","root","root");



			String strc="root";
			String strd="root";


			Connection conn=DriverManager.getConnection(strb+stra,strc,strd);

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


			Class.forName("com.mysql.jdbc.Driver");
          Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/house","root","root");




			Connection conn=DriverManager.getConnection(strb+stra,strc,strd);

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

class updateinfo implements ActionListener
{
	public void actionPerformed(ActionEvent ae)
	{
		try{

			String input1=input.getText();





		/*	if(name1.equals(""))
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
         	String spec1=taspecial1.getText();
			String workf1=tfworkf1.getText();
			String workt1=tfworkt1.getText();


				Class.forName("com.mysql.jdbc.Driver");

			String stra="house";
			String strb="jdbc:mysql://localhost:3306/";
			String strc="root";
			String strd="root";


			Connection conn=DriverManager.getConnection(strb+stra,strc,strd);


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

			new SuccessDialog2();


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

*/

	public static void main(String[] args)
	{
		new drug();
	}
}
