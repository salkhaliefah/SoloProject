import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;





public class ExamSystem extends JFrame implements ActionListener
{
	
	private JPanel panel;
	JButton startButton;
	private JTextArea examTextArea;
	
	private JPanel optionsPanel;
	private int currentQuestion = 1;
	

	
	public ExamSystem() 
	{
		setTitle("Exam System");
		setSize(900, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		buildPanel();
		add(panel);
		setVisible(true);
		
		
	}
	
	
	private void buildPanel() 
	{
		panel = new JPanel(new BorderLayout());
		startButton = new JButton("Start Exam");
		startButton.addActionListener(this);
		optionsPanel = new JPanel(new GridLayout(4,1)); 
		
		examTextArea = new JTextArea();
		examTextArea.setEditable(false);
		panel.add(examTextArea, BorderLayout.CENTER);
		
		

		panel.add(startButton, BorderLayout.SOUTH);
		startButton.setPreferredSize(new Dimension(120, 40));
		startButton.setFont(new Font("Arial", Font.PLAIN, 16));
		
		optionsPanel = new JPanel(new GridLayout(4,1)); 
		panel.add(optionsPanel, BorderLayout.EAST);
		optionsPanel.setVisible(false);
		
		
		
		
	}
	private void startExam() 
	{
		currentQuestion = 1;
		displayQuestion();
		showOptions();
	}
	
	private void displayQuestion() {
		
		
		if(currentQuestion == 1) {
			examTextArea.setFont(new Font("Arial", Font.ITALIC, 25));
			examTextArea.setText("LO 1: Which of the following variable names use the correct style?\n\n " + "A. TotalAmount\n "+ "B. totalAmount\n" +
				 "C. total_Amount\n"+
				 "D. totalamount\n");
			
			
		}else if (currentQuestion == 2) {
			examTextArea.setText("LO 2: What is the purpose of the base case in recursion?\n\n" + "A. ?????\n" +  "B. ?????\n"+
					 "C. ?????\n"+
					 "D. ?????? \n");
			
			//questions 3,4,5,6,7,8,9,10>>>>>
		}
		
	
	

}
	
	private void showOptions() 
	{
		optionsPanel.removeAll();
		
		JButton OA = new JButton("A");
		OA.addActionListener(this:: checkAnswer);
		JButton OB = new JButton("B");
		OB.addActionListener(this:: checkAnswer);
		JButton OC = new JButton("C");
		OC.addActionListener(this:: checkAnswer);
		JButton OD = new JButton("D");
		OD.addActionListener(this:: checkAnswer);
		
		
		
		optionsPanel.add(OA);
		optionsPanel.add(OB);
		optionsPanel.add(OC);
		optionsPanel.add(OD);
		

		
		
		
		
		optionsPanel.setVisible(true);
		validate();
		
		
	}
	
	private void checkAnswer(ActionEvent e) 
	{
		String selectedOption = ((JButton) e.getSource()).getText();
		String correctOption = getCorrectOption();
		
		if(selectedOption.equals(correctOption)) {
			currentQuestion++;
			
			if(currentQuestion <= 2) 
			{
				displayQuestion();
				showOptions();
				
				
			}else {
				examTextArea.setText("Exam completed, Congratulations!");
				optionsPanel.setVisible(false);
				validate();
				
			}
			
		}else 
		{
			examTextArea.setText("Incorrect answer, Please try again.");
			
		}
	
	}
	
	private String getCorrectOption() 
	{
		if (currentQuestion == 1) {
			return "B" ;
		}else if(currentQuestion == 2){
			return "A";
		}
		return "";
	}

@Override
public void actionPerformed(ActionEvent e) 
{
	if(e.getSource() == startButton)
	{
		startExam();
	}
}

public static void main(String[] args)
{
	SwingUtilities.invokeLater(() -> {
		new ExamSystem();
});
	
	}
}

