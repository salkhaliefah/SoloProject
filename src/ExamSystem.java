import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;





public class ExamSystem extends JFrame implements ActionListener
{
	//JPanel for elements 
	private JPanel panel;
	JButton startButton;
	private JTextArea examTextArea;
	
	private JPanel optionsPanel;
	private int currentQuestion = 1;
	Color textColor = Color.BLACK;
	

	
	public ExamSystem() 
	{
		setTitle("Exam System");
		setSize(1000,700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		buildPanel();
		
		add(panel);
		
		setVisible(true);
		
		
	}
	
	
	private void buildPanel() 
	{
		panel = new JPanel(new BorderLayout());
		startButton = new JButton("Start Exam");
		//Registering the event handler for the "Start button" 
		startButton.addActionListener(this);
		
		optionsPanel = new JPanel(new GridLayout(4,1)); 
		optionsPanel.setBackground(Color.lightGray);
		
		examTextArea = new JTextArea();
		examTextArea.setEditable(false);
		examTextArea.setForeground(textColor);
		
		
		startButton.setPreferredSize(new Dimension(120, 40));
		startButton.setFont(new Font("Arial", Font.PLAIN, 16));
		//chnaging widget color 
		panel.setBackground(Color.LIGHT_GRAY);
		
		//placement of panel for Option buttons, Written Questions(TextArea) & the start button that give access to the exam
		panel.add(optionsPanel, BorderLayout.EAST);
       panel.add(examTextArea, BorderLayout.CENTER);
		panel.add(startButton, BorderLayout.SOUTH);
		
		optionsPanel.setVisible(false);
		
		
		
		
	}
	private void startExam() 
	{
		currentQuestion = 1;
		displayQuestion();
		showOptions();
	}
	
	//displaying question on window, using if, if question is answered correct 
	//the next question will apear if question is answered wrong it will give a statment that tells the user to try again
	private void displayQuestion() {
		
		
		if(currentQuestion == 1) {
			examTextArea.setFont(new Font("Arial", Font.ITALIC, 25));
			//Changing color of the window background 
			examTextArea.setBackground(Color.lightGray);
			examTextArea.setText("LO 1: Which of the following variable names use the correct style?\n\n" + 
			     
					
				 
				 
				 "A. TotalAmount\n "+
				 "B. totalAmount\n" +
				 "C. total_Amount\n"+
				 "D. totalamount\n");
			
			
		}else if (currentQuestion == 2) {
			examTextArea.setText("LO2: Given: int[] a = {1, 2, 3}; What will be after; a[1] = 5?\n\n"    +
					
					
			         
					
					
			         "A. {1, 5, 2, 3} \n"+
					 "B. {5, 2, 3} \n" +
					 "C. {1, 5, 3} \n" +
					 "D. {5, 1, 2, 3} \n" +
					 "");
			
	
		}else if (currentQuestion == 3) {
			examTextArea.setText("\n LO3: Which of the following is correct?\n\n" + "public class Student\n" +
					 "{ \n" +
					 "String name;\n" +
					 " Address homeAddress;\n" +
					 "}\n\n" +
					 "public class Address\n" +
					 "{\n" +
					 "  int number;\n" +
					 "  String streetName;\n" +
					 "  String cityName;\n" +
					 "  String stateName;\n" +
					 "  int zipCode;\n" +
					 "}\n" +
					 
					 
					 "A. Student HAS-A Address \n" +
					 "B. Student IS-A Address \n" +
					 "C. Address HAS-A Student \n" +
					 "D. Address IS-A Student \n" +
					 "");
			
			
			
		}else if(currentQuestion == 4) {
			examTextArea.setText("LO4: What is a base class in inheritance?\n\n" +
					
					
					 "A. Child class\n"+
					 "B. Parents class\n"+
					 "C. Derived class \n"+
					 "D. Subclass\n"+
					 "");
			
			
		}else if (currentQuestion == 5) {
			examTextArea.setText("LO5: What is polymorphism in java \n\n" +
					
					
					 "A. Multiple inheritance\n"+
					 "B. Code duplication \n"+
					 "C. Code flexibility\n"+
					 "D. Data hiding \n"+
					 " ");
			
			
			
		}else if (currentQuestion == 6) {
			examTextArea.setText("LO6: What is the primary purpose of a stack data structure?\n\n" +
					
					
					 "A. To store date in sorted order \n"+
					 "B. To provide quick access to the middle element\n"+
					 "C. To manage data in a last-in, frist-out(LIFO)manner.\n"+
					 "D. To facilitate random access to elements\n"+
					 " ");
			
			
			
		}else if (currentQuestion == 7) {
			
			examTextArea.setText("LO7: What does the term “polymorphism” mean in object-oriented design? \n\n" +
					
					
					 "A. The ability of a classroom inherit from multiple classes\n"+
					 "B. The ability to create objects of different types \n"+
					 "C. The ability to write methods with the same name but different implementations. \n"+
					 "D. The ability to hide the details of an object’s implementation\n"+
					 " ");
			
			
		}else if (currentQuestion == 8) {
			examTextArea.setText("LO8: What does GUI stand for?\n\n" +
					
					
					 "A. A visual component on the screen \n"+
					 "B. An action or occurrence detected by the program \n"+
					 "C. A graphical user interface \n"+
					 "D. A type of layout manager\n"+
					 " ");
			
			
		}else if (currentQuestion == 9) {
			examTextArea.setText("LO9: What is an exception in Java?\n\n" +
					
					
					 "A. A regular program output \n"+
					 "B. An error that occurs during program execution \n"+
					 "C. A common programming data type \n"+
					 "D. A standard data type \n"+
					 " ");
			
			
		}else if (currentQuestion == 10) {
			examTextArea.setText("LO10: Which class in java is used for writing to a file?\n\n" +
					
					
					 "A. FileWriter\n"+
					 "B. FileReader\n"+
					 "C.BufferedReader\n"+
					 "D. PrintWriter\n"+
					 "");
		}else if (currentQuestion == 11) {
			examTextArea.setText("LO11: What is the purpose of the base case in recursion?\n\n" +
					 "A. It’s just a placeholder\n" +
					 "B. It helps with iteration\n"+
					 "C. Its optional in recursion\n"+
					 "D. it stops recursion \n"+
					 "");
		}
		
		
	
	

}
	
	private void showOptions() 
	{
		optionsPanel.removeAll();
		
		JButton OA = new JButton("A");
		OA.addActionListener(this:: checkAnswer);
		optionsPanel.add(OA);
		
		JButton OB = new JButton("B");
		OB.addActionListener(this:: checkAnswer);
		optionsPanel.add(OB);
		
		JButton OC = new JButton("C");
		OC.addActionListener(this:: checkAnswer);
		optionsPanel.add(OC);
		
		JButton OD = new JButton("D");
		OD.addActionListener(this:: checkAnswer);
		optionsPanel.add(OD);
		
		
		

		
		
		
		//showing panel for multiple-choice options 
		optionsPanel.setVisible(true);
		validate();
		
		
	}
	
	private void checkAnswer(ActionEvent e) 
	{
		String selectedOption = ((JButton) e.getSource()).getText();
		String correctOption = getCorrectOption();
		
		if(selectedOption.equals(correctOption)) {
			currentQuestion++;
			
			if(currentQuestion <= 11) 
			{
				displayQuestion();
				showOptions();
				
				
			} else {
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
			return "C";
		}else if(currentQuestion == 3) {
			return "A";
		}else if(currentQuestion == 4) {
			return "B";
		}else if(currentQuestion == 5) {
			return "C";
		}else if(currentQuestion == 6) {
			return "C";
		}else if(currentQuestion == 7) {
			return "C";
		}else if(currentQuestion == 8) {
			return "C";
		}else if(currentQuestion == 9) {
			return "B";
		}else if(currentQuestion == 10) {
			return "A";
		}else if(currentQuestion == 11) {
			return "D";
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

