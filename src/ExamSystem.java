
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
	
	/**
	 *  calling initializeQuestion class where all questions are stored using ArrayList 
	 */
	private void initializeQuestions() 
	{
		questions = QuestionInitializer.initializeQuestions();
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
