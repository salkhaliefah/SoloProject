
/**
 * ExamSystem class creates a window with buttons options to control exam
 * questions.
 * The user can navigate through questions and choose options for each question.
 * 
 * @author Safa Al Khaliefah
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class Question{
	private String text;
	private String[] options;
	private String correctOption;
	
	public Question(String text, String[] options, String correctOption)
	{
		this.text = text;
		this.options = options;
		this.correctOption = correctOption;
	}
	
	public String getText()
	{
		return text;
	}
	
	public String[] getOptions() 
	{
		return options;
		
	}
	
	public String getCorrectOption()
	{
		return correctOption;
	}
}

/**
 * ExamSystem class represents a GUI application for an axam system.
 */
public class ExamSystem extends JFrame implements ActionListener
{
	// fields for GUI Compoenets and are accessed by multiple methods
	// therefore making them private is best
	private JPanel panel;
	JButton startButton;
	private JTextArea examTextArea;

	private JPanel optionsPanel;
	private int currentQuestion = 1;
	Color textColor = Color.BLACK;
	
	private Question[] questions;

	/**
	 * Constructor for ExamSystem
	 * Initializes the GUI window and components
	 */
	public ExamSystem()
	{
		// window title
		setTitle("Exam System");
		// window size
		setSize(1050, 750);
		// closes window when exit button is clicked
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// calling buildPannel method
		buildPanel();
		// adding panel to window
		add(panel);

		// shows window
		setVisible(true);
		
		initializeQuestions();

	}
	
	private void initializeQuestions() 
	{
		List<Question> questionList = new ArrayList<>(Arrays.asList(
				new Question("LO 1: Which of the following variable names use the correct style?" ,
						new String[] { "TotalAmount" , "totalAmount", "total_Amount", "totalamount"}, "B" ),
	
						new Question("LO 2: Given: int[] a = {1, 2, 3}; What will be after; a[1] = 5?",
								new String[] { "{1, 5, 2, 3}"  , "{5, 2, 3} ", "{1, 5, 3}", "{5, 1, 2, 3} "}, "C" ),
	
						new Question("LO3: Which of the following is correct?\n"
								+ "public class Student\n"
								+ "{ \n"
								+ "String name;\n"
								+ " Address homeAddress;\n"
								+ "}\n"
								+ "public class Address\n"
								+ "{\n"
								+ "  int number;\n"
								+ "  String streetName;\n"
								+ "  String cityName;\n"
								+ "  String stateName;\n"
								+ "  int zipCode;\n"
								+ "}",
								new String[]{ "Student HAS-A Address", "Student IS-A Address","Address HAS-A Student","Address IS-A Student"}, "A" ),
						
						new Question("LO 4:What is a base class in inheritance?",
								new String[] { "Child class"  , "Parents class\n"
										+ " ", "Derived class \n"
												+ "", "Subclass\n"
														+ " "}, "B" ),
				
						new Question("LO 5: What is polymorphism in java? \n",
								new String[] { "Multiple inheritance", "Code duplication ", "Code flexibility", "Data hiding "}, "C" ),
						
			
						new Question("LO6: What is the primary purpose of a stack data structure?",
								new String[] { "To store date in sorted order "  , "To provide quick access to the middle element ", "To manage data in a last-in, frist-out(LIFO)manner.", "To facilitate random access to elements "}, "C" ),
				
						new Question("LO7: What does the term “polymorphism” mean in object-oriented design?",
								new String[] { "The ability of a classroom inherit from multiple classes "  , "The ability to create objects of different types  ", "The ability to write methods with the same name but different implementations.", "The ability to hide the details of an object’s implementation "}, "C" ),
	
						new Question("LO8: What does GUI stand for?",
								new String[] { "A visual component on the screen "  , " An action or occurrence detected by the program  ", " A graphical user interface ", "A type of layout manager\n"}, "C" ),
	
						new Question("LO9: What is an exception in Java?",
								new String[] { "A regular program output "  , "An error that occurs during program execution  ", " A common programming data type", "A standard data type"}, "B" ),
	
						new Question("LO10: Which class in java is used for writing to a file?",
								new String[] { "FileWriter"  , "FileReader ", "BufferedReader",  "PrintWriter"}, "A" ),
	
						new Question("LO11: What is the purpose of the base case in recursion?",
								new String[] { "It’s just a placeholder\n"
										+ ""  , " It helps with iteration ", "Its optional in recursion", "it stops recursion \n"
												+ " "}, "D" )
	));
				
				questions = questionList.toArray(new Question[0]);
	}
				
           
	/**
	 * BuildPanel method initializes arranges GUI components
	 */
	private void buildPanel()
	{
		// creating new Jpanel to add bottonPanel,examTextArea, optionsPanel
		panel = new JPanel(new BorderLayout());
		// changing panel background
		panel.setBackground(Color.LIGHT_GRAY);

		// creating start button
		startButton = new JButton("Start Exam");
		// Registering the event handler for the "Start button"
		startButton.addActionListener(this);

		// creating Jpanel for options A,B,C, and D and setting then in a 4,1
		// gridlayout
		optionsPanel = new JPanel(new GridLayout(4, 1));
		// changing the optionsPanel background to lightGray
		optionsPanel.setBackground(Color.lightGray);

		// creating JTextArea for the questions
		examTextArea = new JTextArea();
		// allows text to be editable in terms of highlighting and copying
		examTextArea.setEditable(false);

		// setting dimensions and font for start button
		startButton.setPreferredSize(new Dimension(0, 30));
		startButton.setFont(new Font("Arial", Font.PLAIN, 20));

		// placement of panel for Option buttons, examTextArea & the start
		// button that give access to the exam
		panel.add(optionsPanel, BorderLayout.EAST);
		panel.add(examTextArea, BorderLayout.CENTER);
		panel.add(startButton, BorderLayout.SOUTH);

		// display of optionsPanel
		optionsPanel.setVisible(false);

	}

	/**
	 * StartExam method resets the current question, displays the
	 * first question and shows options what start button is clicked
	 */
	private void startExam()
	{
		currentQuestion = 1;
		displayQuestion();
		showOptions();
	}

	/**
	 * DisplayQuestion method shows questions on window, using if, if
	 * currentQuestion condtion is true the if/ else
	 * block will provide some text.
	 */

	private void displayQuestion() {
		Question currentQuestionObj = questions[currentQuestion - 1];
		examTextArea.setFont(new Font("Arial", Font.ITALIC, 25));
		examTextArea.setBackground(Color.lightGray);
		examTextArea.setText(currentQuestionObj.getText() + "\n\n" +
		"A." + currentQuestionObj.getOptions()[0] + "\n\n"	+
		"B." + currentQuestionObj.getOptions()[1] + "\n\n"	+
		"C." + currentQuestionObj.getOptions()[2] + "\n\n"	+
		"D." + currentQuestionObj.getOptions()[3]);
	}
		
	/**
	 * ShowOptions method sets up option buttons for multiple-choice questions
	 */
	private void checkAnswer(ActionEvent e)
	{
		// Extract the text of the button pressed (the selected option)
		String selectedOption = ((JButton) e.getSource()).getText();
		// Get the correct option
		String correctOption = questions[currentQuestion - 1].getCorrectOption();

		// Check if the selected option is correct
		if (selectedOption.equals(correctOption))
		{
			// Increment the current question counter
			currentQuestion++;

			// check if there are more question to display
			if (currentQuestion <= questions.length)
			{
				// Display the next question
				displayQuestion();
				// calling showOptions method/ shows options for next question
				showOptions();

			}
			else
			{
				// if all questions are answered correct a congratulations
				// message will be displayed
				examTextArea.setText("Exam completed, Congratulations!");
				// hide the options panel
				optionsPanel.setVisible(false);
				// validate changes in layout
				validate();

			}

		}
		else

		{
			// if the selected option is incorrect, display a try again messagen
			examTextArea.setText("Incorrect answer, Please try again.");

		}

	}

	private void showOptions()
	{
		//Clears all components from options panel before applying any new ones
		//ensureing that a new set of button is added each time "showOptions" is clicked
		optionsPanel.removeAll();
        //creating a new JButton "A" and assignes it tovariable OA
		JButton OA = new JButton("A");
		//registers an actions listener for button
		OA.addActionListener(this::checkAnswer);
		//adds OA button to the optionsPanel
		optionsPanel.add(OA);

		JButton OB = new JButton("B");
		OB.addActionListener(this::checkAnswer);
		optionsPanel.add(OB);

		JButton OC = new JButton("C");
		OC.addActionListener(this::checkAnswer);
		optionsPanel.add(OC);

		JButton OD = new JButton("D");
		OD.addActionListener(this::checkAnswer);
		optionsPanel.add(OD);

		// showing panel for multiple-choice options
		optionsPanel.setVisible(true);
		//making sure changes in the GUI take place 
		validate();

	}




	/**
	 * ActionListener implementation for handling button clicks
	 */

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// checks if action was triggered by clicking the startButton
		if (e.getSource() == startButton)
		{
			// startExam method
			startExam();
		}
	}

	/**
	 * Main method to launch the application
	 */

	public static void main(String[] args)
	{
		// Thread that handles GUI events
		SwingUtilities.invokeLater(() -> {
			try {
				new ExamSystem();
			}catch (Exception e) {
				handleException(e);
			}
			
		});
		
		

	}
	
	
	private static void handleException(Exception e) {
		JOptionPane.showMessageDialog(null,  "An error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		e.printStackTrace();
	}
}
