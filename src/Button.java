import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Button extends JFrame {
	
	Container c;
	JButton b1,b2;
	int d=0,b=0;
	
		public Button() {
			
			initcomponent();
			
			this.setVisible(true);
			this.setTitle("Frame");
			this.setBounds(50,50,500,500);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		
		
		
		public void initcomponent()
		{
			c=this.getContentPane();
			c.setLayout(null);
			c.setBackground(Color.cyan);
			
			b1=new JButton("Say Hello");
			b1.setBounds(100,20,100,20);
			c.add(b1);
			b1.addActionListener(new ActionListener() {
				
				
				public void actionPerformed(ActionEvent e) {
					System.out.println("Say Hello");
					d++;
					System.out.println("Button Pressed :"+d);
				}
			});
			
			b2=new JButton("Say Hi");
			b2.setBounds(250,20,100,20);
			c.add(b2);
			b2.addActionListener(new ActionListener() {
				
				
				public void actionPerformed(ActionEvent e) {
					System.out.println("Say Hello");
					b++;
					System.out.println("Button Pressed :"+b);
				}
			});
			
		}
			
}
