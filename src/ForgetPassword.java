import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ForgetPassword extends JFrame{
	
	AccessDataBase accessDataBase;
	private Container c;
	private JLabel an,ai,sq,answer,enp,img;
	private JTextField ant,ait,answert;
	private JComboBox jcb;
	private String [] jcbs= {"Select","What Is Your Favorite Color ?","What is your Favourate sports?"};
	private JPasswordField enpf;
	private JButton submit,back;
	private ResultSet resultSet;
	private ImageIcon imageIcon;
	

	public ForgetPassword() {
		
		accessDataBase = new AccessDataBase();
		resultSet = null;
		
		initcomponent();
		
		this.setVisible(true);
		this.setLayout(null);
		this.setBounds(0,0,1000,700);
		this.setResizable(false);
		this.setTitle("Forget Password");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public void initcomponent()
	{
		c=this.getContentPane();
		c.setLayout(null);
		c.setBackground(Color.GRAY);
		
		
		/// Image
				imageIcon =new ImageIcon(getClass().getResource("Bricks (3).jpg"));
				img=new JLabel(imageIcon);
				img.setBounds(300, 80, 400, 120);
				c.add(img);
		
		
		/// Security Question :
			sq=new JLabel();
			sq.setText("Security Que: ");
			sq.setFont(new Font("Arial", Font.BOLD, 14));
			sq.setForeground(Color.black);
			sq.setBounds(340,250,100,25);
			c.add(sq);
			
			
			jcb=new JComboBox(jcbs);
			jcb.setBounds(450,247,230,25);
			jcb.setFont(new Font("Arial", Font.BOLD, 14));
			jcb.setToolTipText("Select Question");
			jcb.setBackground(Color.WHITE);
			c.add(jcb);
			
			
			/// Security Question Answer:
			answer=new JLabel();
			answer.setText("Answer          : ");
			answer.setFont(new Font("Arial", Font.BOLD, 14));
			answer.setForeground(Color.black);
			answer.setBounds(340,300,100,30);
			c.add(answer);
			
			answert=new JTextField();
			answert.setText(null);
			answert.setFont(new Font("Arial", Font.BOLD, 14));
			answert.setToolTipText("Enter Question Answer");
			answert.setBackground(Color.white);
			answert.setBounds(450,297,230,25);
			c.add(answert);
			
			/// Enter new Password :
			enp=new JLabel();
			enp.setText("Password      : ");
			enp.setFont(new Font("Arial", Font.BOLD, 14));
			enp.setForeground(Color.black);
			enp.setBounds(340,350,100,25);
			c.add(enp);
			
			enpf=new JPasswordField();
			enpf.setText(null);
			enpf.setToolTipText("Enter New PassWord");
			enpf.setBackground(Color.WHITE);
			enpf.setBounds(450,347,230,25);
			c.add(enpf);
			
			/// submit && Back Button
			
			submit=new JButton("Submit");
			//submit.setToolTipText("Submit");
			submit.setFont(new Font("Arial", Font.BOLD, 14));
			submit.setBounds(590, 397,100, 30);
			c.add(submit);
			submit.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					try {
						String sql =  "select * from admin where id =1";
						resultSet = accessDataBase.submit(sql);
						while(resultSet.next()) {
							String loginid = resultSet.getString("loginid");
							String password = resultSet.getString("password");
							String ques = resultSet.getString("question");
							String answer = resultSet.getString("answer");
							
							String passF = enpf.getText();
							String quesF = jcb.getSelectedItem().toString();
							String ansF = answert.getText();
							
							if (ques.equals(quesF) && answer.equals(ansF)) {
                               sql = "update admin set password='"+passF+"'";
								accessDataBase.updatetData(sql);
								
								enpf.setText("");
								answert.setText("");
								jcb.setSelectedItem("Select");
								
								JOptionPane save=new JOptionPane();
								save.setLayout(null);
								save.showMessageDialog(null,"Password Successfully Change","Password",1);
								c.add(save);
								
							}else {
								if (enpf.getText().equals("") || answert.getText().equals("") || jcb.getSelectedItem().equals("select")) {
									JOptionPane empty=new JOptionPane();
									empty.setLayout(null);
									empty.showMessageDialog(null,"Must Fill The Requirement","Empty",2);
									c.add(empty);
								} else {
									JOptionPane empty=new JOptionPane();
									empty.setLayout(null);
									empty.showMessageDialog(null,"Question Or Answer is Incorrect","Invalid",2);
									c.add(empty);
								}
							}
						}
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
			});
			
			back=new JButton("Back");
			back.setBounds(450, 397, 100, 30);
			back.setFont(new Font("Arial", Font.BOLD, 14));
			//back.setToolTipText("Back Page");
			c.add(back);
			
			back.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
						dispose();
						Authentication backA=new Authentication();
						backA.setVisible(true);
					
				}
			});
	}
	
}
