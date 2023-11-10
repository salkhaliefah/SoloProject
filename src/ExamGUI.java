import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ExamGUI implements ActionListener
{
	private static JTextField userText;
	private static JPasswordField passwordText;
	private static JLabel success;

	
	JFrame frame2 = new JFrame();
	JLabel label2 = new JLabel("Start");
	JFrame frame3 = new JFrame();
	JLabel Label2 = new JLabel("Question 3");
	
	
	ExamGUI()
	{
		
		label2.setBounds(0,0,100,50);
		label2.setFont(new Font(null, Font.PLAIN, 25));;
		
		frame2.add(label2);
		frame2.add(Label2);
		 
		   frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   frame2.setSize(420,420);
		   frame2.setLayout(null);
		   frame2.setVisible(true);
	}
	
	int count = 0;
	public static void main(String[] args)
	{
		JPanel panel = new JPanel();
		JFrame frame = new JFrame();
		frame.setSize(600, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(panel);
		
		panel.setLayout(null);
		
		JLabel label = new JLabel("Student");
		label.setBounds(10, 20, 80, 25);
		panel.add(label);
		
		JTextField userText = new JTextField(20);
		userText.setBounds(100, 20, 165, 25);
		panel.add(userText);
		
		JLabel sIDLabel = new JLabel("Student ID");
		sIDLabel.setBounds(10, 50, 80, 35);
		panel.add(sIDLabel);
		
		JPasswordField IDText = new JPasswordField();
		IDText.setBounds(100, 50, 165, 25);
		panel.add(IDText);
		
		
		JButton button =  new JButton("NEXT");
		button.setBounds(10,80, 80, 25);
		button.addActionListener(new ExamGUI());
		panel.add(button);
		
		JLabel success = new JLabel("");
		success.setBounds(10,110,300,25);
		panel.add(success);
		
		
		
		
		
		
		
		
		
		
		
		frame.setVisible(true);
		
		
		
		

	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
        String user = userText.getText();
        String password = passwordText.getText();
        System.out.println(user + ", " + password);
        
        if(user.equals("safa") && password.equals("safa2003"));    
        {
        	success.setText("Start your Exam");
        }
		
		
	}


}
