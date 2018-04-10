import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.channels.SelectableChannel;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicTreeUI.TreeCancelEditingAction;

public class customerInfo extends JFrame {
	
	AccessDataBase accessDataBase;
	ResultSet resultSet;
	int quantity;
	private Container c;
	private JLabel cn,cNu,CNP,CAP,CNuP,CAmP,BQ,BQu,img;
	private JTextField cnt,cNut,CNT,CNuT,CAmT,BQT,BQuT;
	private JPanel infot;
	private JButton search1, search2 ,edit,logout,create,delete,clear;
	private JTextArea CAT;
	private ImageIcon imageIcon;
	private Font font;
	private String check1="",check2="";
	
	public customerInfo()
	{
		accessDataBase = new AccessDataBase();
		resultSet = null;
		
		initcomponent();
		
		this.setVisible(true);
		this.setBounds(0,0,1000,700);
		this.setResizable(false);
		this.setLayout(null);
		this.setTitle("Customer Info");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	

	
	
	public void initcomponent() {
		c=this.getContentPane();
		c.setLayout(null);
		c.setBackground(Color.GRAY);
		
		/// Image
				imageIcon =new ImageIcon(getClass().getResource("Bricks (3).jpg"));
				img=new JLabel(imageIcon);
				img.setBounds(300, 10, 400, 120);
				c.add(img);
				
				///Font
				
			 font =new Font("Arial",font.BOLD, 14);
		
		/// Customer Name :
				cn=new JLabel();
				cn.setText("Cust. Name : ");
				cn.setForeground(Color.black);
				cn.setFont(font);
				cn.setBounds(280,145,100,30);
				c.add(cn);
				
				cnt=new JTextField();
				cnt.setText(null);
				cnt.setBackground(Color.white);
				cnt.setFont(font);
				cnt.setToolTipText("Enter Customer Name");
				cnt.setBounds(380,147,200,25);
				c.add(cnt);
				
				cNu=new JLabel();
				cNu.setText("Cust.Number :");
				cNu.setFont(font);
				cNu.setForeground(Color.black);
				cNu.setBounds(270,175,100,30);
				c.add(cNu);
				
				cNut=new JTextField();
				cNut.setBackground(Color.white);
				cNut.setToolTipText("Enter Customer Number");
				cNut.setBounds(380,177,200,25);
				c.add(cNut);
				
		/// Search Button
				search1=new JButton("Search");
				search1.setBounds(590, 177, 100, 25);
				search1.setFont(new Font("ARIAL", Font.PLAIN, 14));
				c.add(search1);
				
				//search2=new JButton("Search");
				//search2.setBounds(590, 177, 100, 25);
				//c.add(search2);
				
		/// Information Panel
				infot=new JPanel();
				infot.setLayout(null);
				infot.setBackground(Color.LIGHT_GRAY);
				infot.setBounds(320, 210, 380, 350);
				c.add(infot);
				
				/// Name 
				
				CNP =new JLabel();
				CNP.setText("Name          : ");
				CNP.setFont(new Font("ARIAL", font.BOLD, 14));
				CNP.setForeground(Color.BLACK);
				CNP.setBounds(5,20,100,20);
				infot.add(CNP);
				
				CNT=new JTextField();
				CNT.setText(null);
				CNT.setFont(new Font("ARIAL", font.BOLD, 14));
				CNT.setForeground(Color.blue);
				CNT.setEnabled(false);
				CNT.setBounds(110,20,200,25);
				infot.add(CNT);
				
				/// QUALITY
				
				BQu=new JLabel("Quality        : ");
				BQu.setForeground(Color.BLACK);
				BQu.setFont(new Font("ARIAL", font.BOLD, 14));
				BQu.setBounds(5,65,100,20);
				infot.add(BQu);
				
				BQuT=new JTextField();
				BQuT.setText(null);
				BQuT.setEnabled(false);
				BQuT.setFont(new Font("ARIAL", font.BOLD, 14));
				BQuT.setBounds(110,65,200,25);
				infot.add(BQuT);
				
		
				/// Quantity
				
				BQ=new JLabel("Quantity      : ");
				BQ.setForeground(Color.BLACK);
				BQ.setFont(new Font("ARIAL", font.BOLD, 14));
				BQ.setBounds(5,110,100,22);
				infot.add(BQ);
				
				BQT=new JTextField();
				BQT.setText(null);
				BQT.setEnabled(false);
				BQT.setFont(new Font("ARIAL", font.BOLD, 14));
				BQT.setBounds(110,110,200,25);
				infot.add(BQT);
				
				
				/// Amount
				
				CAmP=new JLabel("Amount       : ");
				CAmP.setForeground(Color.BLACK);
				CAmP.setFont(new Font("ARIAL", font.BOLD, 14));
				CAmP.setBounds(05,155,100,22);
				infot.add(CAmP);
				
				CAmT=new JTextField();
				CAmT.setText(null);
				CAmT.setEnabled(false);
				CAmT.setFont(new Font("ARIAL", font.BOLD, 14));
				CAmT.setBounds(110,155,200,25);
				infot.add(CAmT);
				
				/// Mobile Number
				
				CNuP =new JLabel("Number      :");
				CNuP.setForeground(Color.BLACK);
				CNuP.setFont(new Font("ARIAL", font.BOLD, 14));
				CNuP.setBounds(05,200,100,22);
				infot.add(CNuP);
				
				CNuT=new JTextField();
				CNuT.setText(null);
				CNuT.setEnabled(false);
				CNuT.setFont(new Font("ARIAL", font.BOLD, 14));
				CNuT.setBounds(110,200,200,25);
				infot.add(CNuT);
				
				/// Address
				
				CAP =new JLabel("Address     :");
				CAP.setForeground(Color.BLACK);
				CAP.setFont(new Font("ARIAL", font.BOLD, 14));
				CAP.setBounds(05,245,100,22);
				infot.add(CAP);
				
				
				CAT=new JTextArea();
				CAT.setText(null);
				CAT.setLayout(null);
				CAT.setEnabled(false);
				CAT.setFont(new Font("ARIAL", font.BOLD, 14));
				CAT.setBounds(110,245,200,50);
				CAT.setLineWrap(true);
				infot.add(CAT);
				
			///Edit Button
				
				edit=new JButton();
				edit.setText("Edit");
				edit.setFont(new Font("ARIAL", Font.PLAIN, 14));
				edit.setBounds(600, 570, 100, 30);
				c.add(edit);
				
				edit.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						String string=edit.getText();
						if (CNT.getText().equals("")) {
							edit.setText("Edit");
						}
						
						else
						{
							CNT.setToolTipText("Edit Customer Name");
							CAT.setToolTipText("Edit Customer Address");
							CNuT.setToolTipText("Edit Customer Number");
							CAmT.setToolTipText("Edit Amount of Tk");
							BQuT.setToolTipText("Edit Bricks Quality");;
							BQT.setToolTipText("Edit Bricks Quantity");
							
							edit.setText("Save");
						}
						if(string.equals("Save"))
						{
							try {
								String searchPhn = cNut.getText();
								String searchName= cnt.getText();
								String name = CNT.getText();
								String phone="";
								String quality = BQuT.getText();
								String quan = BQT.getText();
								double amount = Double.valueOf(CAmT.getText());
								String address = CAT.getText();
								
								/// number Validation
								
								String[] str = CNuT.getText().split("(?!^)");
								String[] str1 = BQuT.getText().split("(?!^)");
								
								
								if (str1.length==1) {
									if (str1[0].equals("A") || str1[0].equals("B") || str1[0].equals("C")) {
										
										quality=BQuT.getText();
								
								
								if (str.length==11) {
									if (str[0].equals("0") && str[1].equals("1")) {
										if(str[2].equals("5") || str[2].equals("6") || str[2].equals("7") || str[2].equals("8") || str[2].equals("9"))
										{
											phone=CNuT.getText();
											
											try {
									quantity = Integer.parseInt(quan);
								} catch (NumberFormatException e) {
									e.printStackTrace();
								}
								
								String sql = "update customer set name='"+name+"', quality='"+quality+"', quantity="+quantity+", phonenumber='"+phone+"', address='"+address+"', amount="+amount+" where phonenumber='"+searchPhn+"' or name='"+searchName+"'";
								
								
								
								accessDataBase.updatetData(sql);
								
								JOptionPane save=new JOptionPane();
								save.setLayout(null);
								save.showMessageDialog(null,"Edit Complete", "Edit Messege", 1);
								c.add(save);
								
								edit.setText("Edit");
											
											
										}
										
									}
									
								}
								else {
									
									JOptionPane phnerror=new JOptionPane();
									phnerror.setLayout(null);
									phnerror.showMessageDialog(null,"Phone Number Is Not Valid", "Error Messege", 2);
									c.add(phnerror);
									
								}
								
								///end Number Validation
								
								
								
									}
									else {
										JOptionPane errquality=new JOptionPane();
										errquality.setLayout(null);
										errquality.showMessageDialog(null,"Invalid Quality.Enter Valid quality", "Error Messege", 2);
										c.add(errquality);
									}
	
								}
								
								else {
									JOptionPane errquality=new JOptionPane();
									errquality.setLayout(null);
									errquality.showMessageDialog(null,"Invalid Quality.Enter Valid quality", "Error Messege", 2);
									c.add(errquality);
								}
								
								
							} catch (Exception e) {
								e.printStackTrace();
							}
							
							
							
							
						}
					}
				});
				
				
				
				/// Create Button
				
				create=new JButton();
				create.setText("Create");
				create.setFont(new Font("ARIAL", Font.PLAIN, 14));
				create.setBounds(460, 570, 100, 30);
				c.add(create);
				
				create.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						String string = create.getText();
						
						if (string.equals("Create")) {	
							CNT.setEnabled(true);
							CAT.setEnabled(true);
							CNuT.setEnabled(true);
							CAmT.setEnabled(true);
							BQuT.setEnabled(true);
							BQT.setEnabled(true);
							create.setText("Save");
						}
						if (string.equals("Save")) {
							
							
							
							try {
								String CustName = CNT.getText();
								String number = CNuT.getText();
								
								String sql1 = "select * from customer where name='"+CustName+"' or phonenumber='"+number+"' ";
								
								resultSet = accessDataBase.searchUsingName(sql1);
								
								
								while(resultSet.next()) {
									
									 check1 = resultSet.getString("name");
									 check2 = resultSet.getString("phonenumber");
									 
									 
							}
								
								accessDataBase.closeConnection();
								
								
							} catch (Exception e2) {
								e2.printStackTrace();
							}
							
							
							
							if(check1.equals(CNT.getText()) || check2.equals(CNuT.getText()))	
							{
								JOptionPane existing =new JOptionPane();
								existing.showMessageDialog(null,"Already Exist","Error",2);
								c.add(existing);
							}
							else {
								
								
								try {
									String name = CNT.getText();
									String phone = "";
									String quality = "";
									String quan = BQT.getText();
									double amount = Double.valueOf(CAmT.getText());
									String address = CAT.getText();
									
									/// number && Quality Validation
									
									String[] str = CNuT.getText().split("(?!^)");
									String[] str1=BQuT.getText().split("(?!^)");
									
									if(str1.length==1)
									{
										if (str1[0].equals("A") || str1[0].equals("B") || str1[0].equals("C")) {
											
											quality=BQuT.getText();
				
									if (str.length==11) {
										if (str[0].equals("0") && str[1].equals("1")) {
											if(str[2].equals("5") || str[2].equals("6") || str[2].equals("7") || str[2].equals("8") || str[2].equals("9"))
											{
												phone= CNuT.getText();
												
												try {
													quantity = Integer.parseInt(quan);
												} catch (NumberFormatException e) {
													e.printStackTrace();
												}
												
												String sql = "Insert into customer(name, phonenumber, quality, quantity, amount, address)" + 
											" Values('"+name+"', '"+phone+"', '"+quality+"', "+quantity+", "+amount+", '"+address+"')";
												
												accessDataBase.insertData(sql);
												
												
												JOptionPane createm=new JOptionPane();
												createm.setLayout(null);
												createm.showMessageDialog(null,"Customer Info Created", "Create Messege", 1);
												c.add(createm);
												
												create.setText("Create");
												CNT.setEnabled(false);
												CAT.setEnabled(false);
												CNuT.setEnabled(false);
												CAmT.setEnabled(false);
												BQuT.setEnabled(false);
												BQT.setEnabled(false);
												
												CNT.setText("");
												CAT.setText("");
												CNuT.setText("");
												CAmT.setText("");
												BQuT.setText("");
												BQT.setText("");
											}
											
										}
										
									}
									else {
										JOptionPane errornumber=new JOptionPane();
										errornumber.setLayout(null);
										errornumber.showMessageDialog(null,"Invalid Phonenumber.Enter Correct Phone Number", "Error Messege", 2);
										c.add(errornumber);
									}
									///end Number Validation
									
										}
										
										else {
											JOptionPane errquality=new JOptionPane();
											errquality.setLayout(null);
											errquality.showMessageDialog(null,"Invalid Quality.Enter Valid quality", "Error Messege", 2);
											c.add(errquality);
										}
									}
									
									else {
										JOptionPane errquality=new JOptionPane();
										errquality.setLayout(null);
										errquality.showMessageDialog(null,"Invalid Quality.Enter Valid quality", "Error Messege", 2);
										c.add(errquality);
									}
									
									/// End Quality Validation
								
									
								
									
								}catch (Exception e) {
									e.printStackTrace();
								}
								
								
							}
	
						}
						
					}
				});
				
				//search using phone number
				//search2.addActionListener(new ActionListener() {
				//	
				//	@Override
				//	public void actionPerformed(ActionEvent e) {
				//		try {
				//			String number = cNut.getText();
				//			
				//			String sql = "select * from customer where phonenumber='"+number+"'";
				//			
				//			resultSet = accessDataBase.searchUsingNumber(sql);
				//			
				//			while(resultSet.next()) {
				//				
				//				String name = resultSet.getString("name");
				//				String quality = resultSet.getString("quality");
				//				String phn = resultSet.getString("phonenumber");
				//				int quantity = resultSet.getInt("quantity");
				//				double amount = resultSet.getDouble("amount");
				//				String address = resultSet.getString("address");
				//				
				//				
				//				CNT.setText(name);
				//				CAT.setText(address);
				//				CNuT.setText(phn);
				//				CAmT.setText(String.valueOf(amount));
				//				BQuT.setText(quality);
				//				BQT.setText(String.valueOf(quantity));
				//			}
				//			
				//			accessDataBase.closeConnection();
				//			
				//			
				//	} catch (Exception e2) {
				//			e2.printStackTrace();
				//		}
				//		
				//	}
				//});
				
				//search using Name
				search1.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							String CustName = cnt.getText();
							String number = cNut.getText();
							
							String sql = "select * from customer where name='"+CustName+"' or phonenumber='"+number+"' ";
							
							resultSet = accessDataBase.searchUsingName(sql);
							
							while(resultSet.next()) {
								
								String name = resultSet.getString("name");
								String quality = resultSet.getString("quality");
								String phn = resultSet.getString("phonenumber");
								int quantity = resultSet.getInt("quantity");
								double amount = resultSet.getDouble("amount");
								String address = resultSet.getString("address");
								
									CNT.setText(name);
									CAT.setText(address);
									CNuT.setText(phn);
									CAmT.setText(String.valueOf(amount));
									BQuT.setText(quality);
									BQT.setText(String.valueOf(quantity));	
									
									CNT.setEnabled(true);
									CAT.setEnabled(true);
									CNuT.setEnabled(true);
									CAmT.setEnabled(true);
									BQuT.setEnabled(true);
									BQT.setEnabled(true);
								}
							
							accessDataBase.closeConnection();
							
							
						} catch (Exception e2) {
							e2.printStackTrace();
						}
						
					}
				});
				
				/// Delete Button
				
				delete=new JButton();
				delete.setText("Delete");
				delete.setFont(new Font("ARIAL", Font.PLAIN, 14));
				delete.setBounds(320, 570, 100, 30);
				c.add(delete);
				
				///CLear Button
				
				clear=new JButton();
				clear.setText("Clear");
				clear.setFont(new Font("ARIAL", Font.PLAIN, 14));
				clear.setBounds(230,630, 100, 30);
				c.add(clear);
				
				/// Clear Button Action Performed
				
				clear.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						
						cnt.setText("");
						cNut.setText("");
						CNT.setText("");
						CAT.setText("");
						CNuT.setText("");
						CAmT.setText("");
						BQuT.setText("");
						BQT.setText("");
						
						CNT.setEnabled(false);
						CAT.setEnabled(false);
						CNuT.setEnabled(false);
						CAmT.setEnabled(false);
						BQuT.setEnabled(false);
						BQT.setEnabled(false);
						
						create.setText("Create");
						delete.setText("Delete");
						edit.setText("Edit");
					}
				});
				
				/// Log Out
				
				logout=new JButton();
				logout.setText("Logout");
				logout.setFont(new Font("ARIAL", Font.PLAIN, 14));
				logout.setBounds(700,630, 100, 30);
				c.add(logout);
				/// Delete Button ActionPerformed
				delete.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						
						if (CNT.getText().equals("") || CNuT.getText().equals("")) {
							JOptionPane deletem=new JOptionPane();
							deletem.setLayout(null);
							deletem.showMessageDialog(null,"Nothing To Deleted", "Delete Messege", 0);
							c.add(deletem);
						} else {
							
							try {
								String phn = cNut.getText();
								String name=CNT.getText();
								String sql = "delete from customer where phonenumber='"+phn+"' or name='"+name+"'";
								
								accessDataBase.deleteData(sql);
							} catch (Exception e) {
								e.printStackTrace();
							}
							
							JOptionPane deletem=new JOptionPane();
							deletem.setLayout(null);
							deletem.showMessageDialog(null,"Customer Info Deleted", "Delete Messege", 0);
							c.add(deletem);
							
							cnt.setText("");
							cNut.setText("");
							CNT.setText("");
							CAT.setText("");
							CNuT.setText("");
							CAmT.setText("");
							BQuT.setText("");
							BQT.setText("");
							
							CNT.setEnabled(false);
							CAT.setEnabled(false);
							CNuT.setEnabled(false);
							CAmT.setEnabled(false);
							BQuT.setEnabled(false);
							BQT.setEnabled(false);
							
						}
						
						
						
					}
				});
				
				logout.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						dispose();
						Authentication logoutb=new Authentication();
						logoutb.setVisible(true);
					}
				});
	}

}
