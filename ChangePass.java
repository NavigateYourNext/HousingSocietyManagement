import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

class ChangePass extends JFrame implements ActionListener
{
	private JLabel l1,l2,lpi1,l3,l4,l5;
	private JTextField t1,t2;
	private JButton jb,back;
	
	public ChangePass()
	{
	    
		Container c=this.getContentPane();
		c.setLayout(null);
		
		l5=new JLabel(new ImageIcon("D:/Pro/House/src/sun/back.png"));
		l5.setBounds(0,0,600,400);
	
	lpi1=new JLabel("************************* Forgot Password *************************");
	lpi1.setBounds(90,60,790,25);
	lpi1.setFont(new Font("Dialog",Font.BOLD,16));
		
		l1=new JLabel("Enter User Name:");
		l1.setBounds(100,100,100,100);
	    //l1.setForeground(Color.red);

		
		t1=new JTextField(20);
		t1.setBounds(210,140,90,25);
		
		l2=new JLabel("Security Question:");
		l2.setBounds(100,140,120,120);
		
		l3=new JLabel("Which Is Your Favourite Colour ?");
		l3.setBounds(210,110,200,180);
		
		l4=new JLabel("Answer:");
		l4.setBounds(100,210,50,50);
		
		t2=new JTextField(20);
		t2.setBounds(150,227,90,25);
		
		jb=new JButton("Get Password",new ImageIcon("D:/Pro/House/src/housing/images/Keys.gif"));
		jb.setBounds(120,280,170,40);
		jb.addActionListener(this);
		
		back=new JButton("BACK",new ImageIcon("D:/Pro/House/src/housing/images/1leftarrow_hover.png"));
		back.setBounds(300,280,100,40);
		back.addActionListener(this);

       // c.add(l5);
		c.add(lpi1);
		c.add(l1);
		c.add(t1);
		c.add(l2);
		c.add(l3);
        c.add(l4);
		c.add(t2);
        c.add(jb);
		c.add(back);
		
		setSize(600,400);
		setTitle("Change Password");
		setLocationRelativeTo(null);
		setVisible(true);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						
	
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == jb)
		{
			String s1=t1.getText();
			String s2=t2.getText();
			
			int s=s1.length();
			int ss=s2.length();
			
			if(s==0 || ss==0)
			JOptionPane.showMessageDialog(null,"Fill Blank Entries","Error",JOptionPane.ERROR_MESSAGE);
		    else
			if(s1.equalsIgnoreCase("user") && s2.equals("Greenish"))
		    {
			 JOptionPane.showMessageDialog(null,"Your Password: pass","Your Password",JOptionPane.INFORMATION_MESSAGE);		
            }			 
			else if(!s1.equalsIgnoreCase("user") || !s2.equals("Greenish"))
           JOptionPane.showMessageDialog(null,"Invalid Input","Error",JOptionPane.ERROR_MESSAGE);				
		}
		
		if(ae.getSource()==back)
         new Login();		
	}
	
	
	
	public static void main(String... args)
	{
		
		new ChangePass();
	}
	
}