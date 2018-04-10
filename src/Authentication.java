import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.im.InputContext;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;



public class Authentication extends JFrame {
	
	
	AccessDataBase accessDataBase;
	ResultSet resultSet;
	Container c;
	JLabel id,pass,img;
	JTextField idt;
	JPasswordField passwordField;
	JButton login,forget;
	ImageIcon imageIcon;
	Font font;
	

	Authentication() {
		
		initComponents();
		
		this.setVisible(true);
		this.setLayout(null);
		this.setBounds(0,0,1000,700);
		this.setResizable(false);
		this.setTitle("Authentication");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	

	
	public void initComponents()
	{
		accessDataBase=new AccessDataBase();
		resultSet=null;
		c= this.getContentPane();
		c.setLayout(null);
		c.setBackground(Color.GRAY);
		
		
		/// Image
		imageIcon =new ImageIcon(getClass().getResource("Bricks (3).jpg"));
		img=new JLabel(imageIcon);
		img.setBounds(300, 80, 400, 120);
		c.add(img);
		
		///Font
		
		font =new Font("Arial",font.BOLD, 14);
		
		
		/// Account Id :
		id=new JLabel();
		id.setText("Account Id : ");
		id.setForeground(Color.black);
		id.setFont(font);
		id.setBounds(350,290,100,30);
		c.add(id);
		
		idt=new JTextField();
		idt.setText(null);
		idt.setFont(font);
		idt.setToolTipText("Enter Your Id");
		idt.setBackground(Color.white);
		idt.setBounds(450,290,200,25);
		c.add(idt);
		
		/// Password Field
		pass=new JLabel();
		pass.setText("Password : ");
		pass.setFont(font);
		pass.setForeground(Color.black);
		pass.setBounds(350,340,100,30);
		c.add(pass);
		
		passwordField=new JPasswordField();
		passwordField.setText(null);
		passwordField.setFont(font);
		passwordField.setToolTipText("Enter Your PassWord ");
		passwordField.setBackground(Color.white);
		passwordField.setBounds(450,340,200,25);
		c.add(passwordField);
		
		/// LogIn Button
		login=new JButton("Login");
		login.setFont(new Font("Arial",font.PLAIN, 14));
		login.setBounds(570,380,80,30);
		c.add(login);
		
		login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					String sql = "select loginid, password from admin where id =1";
					resultSet = accessDataBase.login(sql);
					
					while(resultSet.next()) {
						String id = resultSet.getString("loginid");
						String pass = resultSet.getString("password");
						
						String id1 = idt.getText().trim();
						String pass1 = passwordField.getText().trim();
						
						if (pass.equals(pass1) && id.equals(id1)) {
							dispose();
							customerInfo logincu=new customerInfo();
							logincu.setVisible(true);
						}
						
						else {
							System.out.println(idt.getText());
							
							if(idt.getText().equals("") || passwordField.getText().equals(""))
							{
								JOptionPane empty=new JOptionPane();
								empty.setLayout(null);
								empty.showMessageDialog(null, "Input Your Id or Password","Empty Id or Password Field",2);
								c.add(empty);
							}
							
							else {
								JOptionPane error=new JOptionPane();
								error.setLayout(null);
								error.showMessageDialog(null,"Incorrect Id or Password", "ERROR", 2);
								c.add(error);
							}
							
						}
					}
					
				}catch (Exception g) {
					g.printStackTrace();
				}
			}
		});
		
		///Forget Password Button
		forget=new JButton("Forget");
		forget.setFont(new Font("Arial",font.PLAIN, 14));
		forget.setBounds(450,380,80,30);
		c.add(forget);
		
		forget.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				ForgetPassword forgetP=new ForgetPassword();
				forgetP.setVisible(true);
				
			}
		});
		
		
	}
	

}
