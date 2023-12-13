
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

	/**
	 * Constructor for ExamSystem
	 * Initializes the GUI window and components
	 */
	public ExamSystem()
	{
		// window title
		setTitle("Exam System");
		// window size
		setSize(1000, 700);
		// closes window when exit button is clicked
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// calling buildPannel method
		buildPanel();
		// adding panel to window
		add(panel);

		// shows window
		setVisible(true);

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
		startButton.setPreferredSize(new Dimension(0, 70));
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

	private void displayQuestion()
	{

		// if current question is 1 then program is dealing with first question
		if (currentQuestion == 1)
		{
			examTextArea.setFont(new Font("Arial", Font.ITALIC, 25));
			// Changing color of the window background
			examTextArea.setBackground(Color.lightGray);
			// setting text for question 1
			examTextArea.setText(
					"LO 1: Which of the following variable names use the correct style?\n\n"
							+

							"A. TotalAmount\n " + "B. totalAmount\n"
							+ "C. total_Amount\n" + "D. totalamount\n");

			// block is triggered when currentQuestion is 2 , block contains
			// text for question 2
		}
		else if (currentQuestion == 2)
		{
			examTextArea.setText(
					"LO2: Given: int[] a = {1, 2, 3}; What will be after; a[1] = 5?\n\n"
							+

							"A. {1, 5, 2, 3} \n" + "B. {5, 2, 3} \n"
							+ "C. {1, 5, 3} \n" + "D. {5, 1, 2, 3} \n" + "");

		}
		else if (currentQuestion == 3)
		{
			examTextArea.setText(" LO3: Which of the following is correct?\n\n"
					+ "public class Student\n" + "{ \n" + "String name;\n"
					+ " Address homeAddress;\n" + "}\n\n"
					+ "public class Address\n" + "{\n" + "  int number;\n"
					+ "  String streetName;\n" + "  String cityName;\n"
					+ "  String stateName;\n" + "  int zipCode;\n" + "}\n" +

					"A. Student HAS-A Address \n" + "B. Student IS-A Address \n"
					+ "C. Address HAS-A Student \n"
					+ "D. Address IS-A Student \n" + "");

		}
		else if (currentQuestion == 4)
		{
			examTextArea
					.setText("LO4: What is a base class in inheritance?\n\n" +

							"A. Child class\n" + "B. Parents class\n"
							+ "C. Derived class \n" + "D. Subclass\n" + "");

		}
		else if (currentQuestion == 5)
		{
			examTextArea.setText("LO5: What is polymorphism in java \n\n" +

					"A. Multiple inheritance\n" + "B. Code duplication \n"
					+ "C. Code flexibility\n" + "D. Data hiding \n" + " ");

		}
		else if (currentQuestion == 6)
		{
			examTextArea.setText(
					"LO6: What is the primary purpose of a stack data structure?\n\n"
							+

							"A. To store date in sorted order \n"
							+ "B. To provide quick access to the middle element\n"
							+ "C. To manage data in a last-in, frist-out(LIFO)manner.\n"
							+ "D. To facilitate random access to elements\n"
							+ " ");

		}
		else if (currentQuestion == 7)
		{

			examTextArea.setText(
					"LO7: What does the term “polymorphism” mean in object-oriented design? \n\n"
							+

							"A. The ability of a classroom inherit from multiple classes\n"
							+ "B. The ability to create objects of different types \n"
							+ "C. The ability to write methods with the same name but different implementations. \n"
							+ "D. The ability to hide the details of an object’s implementation\n"
							+ " ");

		}
		else if (currentQuestion == 8)
		{
			examTextArea.setText("LO8: What does GUI stand for?\n\n" +

					"A. A visual component on the screen \n"
					+ "B. An action or occurrence detected by the program \n"
					+ "C. A graphical user interface \n"
					+ "D. A type of layout manager\n" + " ");

		}
		else if (currentQuestion == 9)
		{
			examTextArea.setText("LO9: What is an exception in Java?\n\n" +

					"A. A regular program output \n"
					+ "B. An error that occurs during program execution \n"
					+ "C. A common programming data type \n"
					+ "D. A standard data type \n" + " ");

		}
		else if (currentQuestion == 10)
		{
			examTextArea.setText(
					"LO10: Which class in java is used for writing to a file?\n\n"
							+

							"A. FileWriter\n" + "B. FileReader\n"
							+ "C.BufferedReader\n" + "D. PrintWriter\n" + "");
		}
		else if (currentQuestion == 11)
		{
			examTextArea.setText(
					"LO11: What is the purpose of the base case in recursion?\n\n"
							+ "A. It’s just a placeholder\n"
							+ "B. It helps with iteration\n"
							+ "C. Its optional in recursion\n"
							+ "D. it stops recursion \n" + "");
		}

	}

	/**
	 * ShowOptions method sets up option buttons for multiple-choice questions
	 */

	private void showOptions()
	{
		optionsPanel.removeAll();

		JButton OA = new JButton("A");
		OA.addActionListener(this::checkAnswer);
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
		validate();

	}

	/**
	 * CheckAnswer method if the selected option is correct
	 */

	private void checkAnswer(ActionEvent e)
	{
		// Extract the text of the button pressed (the selected option)
		String selectedOption = ((JButton) e.getSource()).getText();
		// Get the correct option
		String correctOption = getCorrectOption();

		// Check if the selected option is correct
		if (selectedOption.equals(correctOption))
		{
			// Increment the current question counter
			currentQuestion++;

			// check if there are more question to display
			if (currentQuestion <= 11)
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

	/**
	 * GetCorrectOption method returns the correct option for the current
	 * question
	 */

	private String getCorrectOption()
	{
		// if current question is 1, it will return correct option 'B'
		if (currentQuestion == 1)
		{
			return "B";
			// if current question is not 1, it will check it its 2 and returns
			// 'C'
		}
		else if (currentQuestion == 2)
		{
			return "C";
		}
		else if (currentQuestion == 3)
		{
			return "A";
		}
		else if (currentQuestion == 4)
		{
			return "B";
		}
		else if (currentQuestion == 5)
		{
			return "C";
		}
		else if (currentQuestion == 6)
		{
			return "C";
		}
		else if (currentQuestion == 7)
		{
			return "C";
		}
		else if (currentQuestion == 8)
		{
			return "C";
		}
		else if (currentQuestion == 9)
		{
			return "B";
		}
		else if (currentQuestion == 10)
		{
			return "A";
		}
		else if (currentQuestion == 11)
		{
			return "D";
		}
		// if question is not 1-11 it will return an empty string
		return "";
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
			new ExamSystem();
		});

	}
}
