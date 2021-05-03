/**
 * Program Name:StudentLoapApp.java
 * Purpose:Prototype GUI student loan calculator app to let students 
 * 				see how modifying their repayment schedule would affect the 
 * 				loan cost in terms of the amount of intereste that the student would pay 
 * Coder: Eraj Gillani 0858887
 * Date: Apr. 3, 2020
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.util.ArrayList;


public class StudentLoapApp extends JFrame
{
	ArrayList<Student> studentsArrList = new ArrayList<Student>();
	
	private JPanel inputFormPanel,inputPanel, inputBtnPanel, studentFormPanel, studentDetailsPanel, 
	studentBtnPanel, calcFormPanel, inputCalcPanel, calcDetailsPanel; 
	
	private JComboBox<String> cboOptions;
	private JComboBox<Double> interestDecimal;
	
	JLabel firstLabel, middleLabel, lastLabel, streetNameLabel, streetNumLabel,
	aptLabel, cityLabel, provLabel, postalLabel, cslLabel, oslLabel, titleLabel, idLabel, studentEntry;
	
	JTextField firstText, middleText, lastText, aptText, streetNameText, streetNumText, cityText, 
	postalText, cslText, oslText, idText, repayText, provText;
	
	JLabel objIndex, firstLabel2, middleLabel2, lastLabel2, streetNameLabel2, streetNumLabel2,
	aptLabel2, cityLabel2, provLabel2, postalLabel2, cslLabel2, oslLabel2, titleLabel2, idLabel2;
	
	JButton submitBtn, repaymentFormBtn, prevBtn, nextBtn, removeBtn, calcLoanBtn;
	
	JLabel sliderWholeValue; 
	
	JTextField amortPeriod; 
	JTextArea outputText;
	private boolean btnPressed = false; 
	
	private int numContents = 0, indexNum = 0; 
	
	StudentLoapApp() 
	{
		super("Eraj Gillani 0858887");
		
		//boiler code to set up the JFrame 
		setSize(500, 200); //suggested size
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		this.setLayout(new GridLayout(1,3));
	
		//instantiates the inputForm and calcForm and and all of its associated objects. 
		inputForm();
		studentDetailForm();
		loanForm();
		
		this.add(inputFormPanel);
		this.add(studentFormPanel);
		this.add(calcFormPanel);
		
		
		this.pack(); 
	}

	/*Method Name: inputForm()
	*Purpose: Creates form for the user to enter student data and the amounts of their loans 
	*Accepts: nothing
	*Returns: nothing 
	*/
	public void inputForm()
	{
		inputFormPanel = new JPanel(); 
		inputFormPanel.setLayout(new BorderLayout());
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new FlowLayout());
		topPanel.setBackground(Color.WHITE);
		JLabel heading = new JLabel("This is Eraj Gillani's Student Loan Calculator");
		topPanel.add(heading);
		
		//instantiates the inputPanel and buttonPanel and all of its associated objects. 
		inputTextArea();
		inputButtonArea();
		inputFormPanel.add(topPanel, BorderLayout.NORTH);
		inputFormPanel.add(inputPanel,  BorderLayout.CENTER);
		inputFormPanel.add(inputBtnPanel, BorderLayout.SOUTH); 
		
		inputFormPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
	}
	
	/*Method Name: inputTextArea()
	*Purpose: To create the panel where all the object properties will be inputted by the user. 
	*Accepts: nothing
	*Returns: nothing 
	*/
	public void inputTextArea()
	{
		inputPanel = new JPanel(); 
		inputPanel.setLayout(new GridLayout(11,2));
		
		//all the text field labels
		idLabel =new JLabel("Student ID:");
		firstLabel = new JLabel("First name:");
		middleLabel = new JLabel("Middle name:");
		lastLabel = new JLabel("Surname:");
		aptLabel = new JLabel("Apartment number:");
		streetNameLabel = new JLabel("Street name:");
		streetNumLabel = new JLabel("Street number:");
		cityLabel = new JLabel("City:");
		provLabel = new JLabel("Province:");
		postalLabel = new JLabel("Postal code:");
		cslLabel = new JLabel("CSL loan amount:"); 
		oslLabel = new JLabel("OSL loan amount:");
		
		idText = new JTextField("");
		firstText = new JTextField();
		middleText = new JTextField();
		lastText = new JTextField();
		aptText = new JTextField();
		streetNameText = new JTextField();
		streetNumText = new JTextField();
		cityText= new JTextField();
		postalText = new JTextField();
		cslText = new JTextField("");
		oslText = new JTextField("");
		
		//uncomment to add in text template for testing purposes 
		/*idText = new JTextField("0087901");
		firstText = new JTextField("Billing");
		middleText = new JTextField("John");
		lastText = new JTextField("William");
		aptText = new JTextField(" ");
		streetNameText = new JTextField("130");
		streetNumText = new JTextField("Dundas Street");
		cityText= new JTextField("London");
		postalText = new JTextField("N5Y 5R6");
		cslText = new JTextField("2500.00");
		oslText = new JTextField("1500.00");*/
		
		
		//This array stores the data to be displayed in the comboBox
		String[] provinces = {"Ontario", "Quebec", "Nova Scotia", "New Brunswick", "Manitoba",
				"British Colombia", "Prince Edward Island", "Saskatchewan", "Alberta", "Newfoundland and Labrador"};
		
		//This instantiates the combobox with the options from above
		cboOptions = new JComboBox<String>(provinces);
		
		//This sets the default option to the first one 
		cboOptions.setSelectedIndex(0);
		cboOptions.setBackground(Color.WHITE);
		
		inputPanel.add(idLabel);
		inputPanel.add(idText);
		inputPanel.add(firstLabel);
		inputPanel.add(firstText);
		inputPanel.add(middleLabel);
		inputPanel.add(middleText);
		inputPanel.add(lastLabel);
		inputPanel.add(lastText);
		inputPanel.add(provLabel);
		inputPanel.add(cboOptions);
		inputPanel.add(cityLabel);
		inputPanel.add(cityText);
		inputPanel.add(aptLabel);
		inputPanel.add(aptText);
		inputPanel.add(streetNameLabel);
		inputPanel.add(streetNameText);
		inputPanel.add(streetNumLabel);
		inputPanel.add(streetNumText);
		inputPanel.add(cslLabel);
		inputPanel.add(cslText);
		inputPanel.add(oslLabel);
		inputPanel.add(oslText);
		
		inputPanel.setBackground(Color.WHITE);
		
	}
	
	/*Method Name: inputButtonArea()
	*Purpose: To create the panel where the user can submit the information they typed in into an object 
	*					or select the repayments form 
	*Accepts: nothing
	*Returns: nothing 
	*/
	public void inputButtonArea()
	{
		inputBtnPanel = new JPanel();
		inputBtnPanel.setLayout(new GridLayout(1,3));
		submitBtn = new JButton("Submit"); 
		studentEntry = new JLabel("");

		inputBtnPanel.add(studentEntry);
		studentEntry.setForeground(Color.GREEN);
		inputBtnPanel.add(submitBtn);
		inputBtnPanel.setBackground(Color.WHITE);
		
		
		submitBtn.addActionListener(new createObject());
		
		
	}
	
/*
	 * Class Name: CreateObject (private class) 
	 * Purpose: stores all the information from the text fields into a new object 
	 * Coder:	Eraj Gillani
	 * Date:	April 8th 2020
*/
	private class createObject implements ActionListener 
	{
		/*Method Name: actionPerformed(ActionEvent e)
		*Purpose: when submit button is clicked, retrieves the information to store into an object
		*				 throws data validation exceptions if the user inputs incorrect information in the text fields 
		*Accepts: ActionEvent e 
		*Returns: nothing
		*/
		public void actionPerformed(ActionEvent e)
		{
			String id;
			String first;
			String middle ;
			String last;
			String apt;
			String sName;
			String sNum ;
			String city ;
			String post;
			String prov ;
			String cslStr ;
			String oslStr;
			double csl =  0;
			double osl = 0;
			
			try
			{
				 id = idText.getText();
					validateStudentID(id);
				 first = firstText.getText();
				 middle = middleText.getText();
				 last = lastText.getText();
				 apt = aptText.getText();
				 sName = streetNameText.getText();
				 sNum = streetNumText.getText();
				 city = cityText.getText();
				 post = postalText.getText();
				 prov = (String)cboOptions.getSelectedItem();
				 cslStr = cslText.getText();
				 oslStr = oslText.getText();
				 csl = Double.parseDouble(cslStr);
				 osl = Double.parseDouble(oslStr);
				 try
				 {
						convertLoanValues(csl, osl);
				 }
				 catch( EG_NegativeValueException e1)
					{
						JOptionPane.showMessageDialog(null, e1.getMessage()+"\nYou cannot enter negative values. It's okay though,\n"
								+ "converting negative number to positive");
						//convert to positive values 
						csl = Math.abs(csl);
						osl = Math.abs(osl);
					}

				studentsArrList.add(new Student(id, last, middle, first, apt, sNum, sName, city, prov, post, csl, osl));
				numContents++; 
				
				studentEntry.setText("Successful Student Entry: " + numContents);
				
				if(btnPressed == true)
				{
					indexNum++; 
					loadCurrentText();
				}
			} 
			catch (InvalidIDException e2)
			{
				JOptionPane.showMessageDialog(null, e2.getMessage());
			}

			catch(Exception allE)
			{
				JOptionPane.showMessageDialog(null, "Something went wrong, did you fill in all the necessary values(student id, csl, osl)?");
			}
			
		}//end method 
	
	}//end class
	
	/*
	 * Class Name:  InvalidIDException 
	 * Purpose: create an exception that is thrown when the user does not input a correct student id format 
	 * Coder:	Eraj Gillani
	 * Date:	April 8th 2020
*/
	public class InvalidIDException extends Exception
	{
		InvalidIDException()
		{
			super("Invalid Student ID Input: must consist of seven numeric characters and have a leading zero\n"
					+ "Example: 0123456");
		}
	}
	
	/*Method Name: convertLoanValues()
	*Purpose: throws exception if csl and osl loan amount are below zero 
	*Accepts: two double values 
	*Returns: nothing
	*/
	public void convertLoanValues(double csl, double osl) throws EG_NegativeValueException
	{
		
		if(csl < 0 || osl < 0 )
		{
			throw new EG_NegativeValueException();
		}
	}//end method 

	/*Method Name:validateStudentID()
	*Purpose: validates that the correct student id format has been entered! 
	*Accepts: String value  
	*Returns: nothing
	*/
	public void validateStudentID(String studentID) throws InvalidIDException
	{
		
		int length = studentID.length(); 
		if (studentID.isBlank() || !studentID.matches("[0-9]+") || length != 7 || !studentID.startsWith("0",0))
		{
				throw new InvalidIDException();
		}

	}//end method 
	
	/*Method Name: studentDetailForm()
	*Purpose: Creates a panel and formats where user can print and choose the desired user details to calculate loan 
	*Accepts: nothing
	*Returns: nothing 
	*/
	public void studentDetailForm()
	{
		studentFormPanel = new JPanel(); 
		studentFormPanel.setLayout(new BorderLayout());
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new FlowLayout());
		topPanel.setBackground(Color.WHITE);
		repaymentFormBtn = new JButton("Load Student Details"); 
		topPanel.add(repaymentFormBtn);
		repaymentFormBtn.addActionListener(new loadStudentDetails());
		studentDetailsPanel = new JPanel();	
		studentDetailsPanel.setBackground(Color.WHITE);
		
		studentFormPanel.add(topPanel, BorderLayout.NORTH);
		studentFormPanel.add(studentDetailsPanel, BorderLayout.CENTER);
		
		studentBtnPanel = new JPanel();
		studentBtnPanel.setLayout(new FlowLayout());
		studentBtnPanel.setBackground(Color.WHITE);
		studentFormPanel.add(studentBtnPanel, BorderLayout.SOUTH);
		prevBtn = new JButton("Previous");
		prevBtn.addActionListener(new previousStd());
		nextBtn = new JButton("Next");
		nextBtn.addActionListener(new nextStd());
		removeBtn = new JButton("Remove");
		removeBtn.addActionListener(new removeObject());
		
		studentBtnPanel.add(removeBtn);
		studentBtnPanel.add(prevBtn);
		studentBtnPanel.add(nextBtn);
		
		studentFormPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
	}
	
	/*Method Name: createStudentInfoPanel()
	*Purpose: Creates and formats area where the student details are printed! 
	*Accepts: nothing
	*Returns: nothing 
	*/
	public void createStudentInfoPanel()
	{	
			studentDetailsPanel.setLayout(new GridLayout(12,1));		

			objIndex = new JLabel("Your looking at Student: ");
			idLabel2 = new JLabel("Student ID: ");
			firstLabel2 = new JLabel("First name: ");
			middleLabel2 = new JLabel("Middle name: " );
			lastLabel2 = new JLabel("Surname: ");
			aptLabel2 = new JLabel("Apartment number: ");
			streetNameLabel2 = new JLabel("Street name: ");
			streetNumLabel2 = new JLabel("Street number: ");
			cityLabel2 = new JLabel("City: ");
			provLabel2 = new JLabel("Province: ");
			postalLabel2 = new JLabel("Postal code: ");
			cslLabel2 = new JLabel("CSL loan amount: "); 
			oslLabel2 = new JLabel("OSL loan amount: "); 
			
			studentDetailsPanel.add(objIndex);
			studentDetailsPanel.add(idLabel2);
			studentDetailsPanel.add(firstLabel2);
			studentDetailsPanel.add(middleLabel2);
			studentDetailsPanel.add(lastLabel2);
			studentDetailsPanel.add(provLabel2);
			studentDetailsPanel.add(cityLabel2);
			studentDetailsPanel.add(aptLabel2);
			studentDetailsPanel.add(streetNameLabel2);
			studentDetailsPanel.add(streetNumLabel2);
			studentDetailsPanel.add(cslLabel2);
			studentDetailsPanel.add(oslLabel2);
			btnPressed = true; 
	
	}
	
	/*Method Name:loadCurrentText()
	*Purpose: looks the details of the current student based on index number (position of the student in the arraylist) 
	*				 throws an exception to make sure there are students in the database before clicking the button 
	*Accepts: nothing 
	*Returns: nothing
	*/
	public void loadCurrentText()
	{
		try
		{
			objIndex.setText("Your looking at Student: " + (indexNum + 1));
			idLabel2.setText("Student ID: " + studentsArrList.get(indexNum).getStudentID());
			firstLabel2.setText("First name: " + studentsArrList.get(indexNum).getFirstName());
			middleLabel2.setText("Middle name: " + studentsArrList.get(indexNum).getMiddleName());
			lastLabel2.setText("Surname: " + studentsArrList.get(indexNum).getSurname());
			aptLabel2.setText("Apartment number: " + studentsArrList.get(indexNum).getAptNumber());
			streetNameLabel2.setText("Street name: " + studentsArrList.get(indexNum).getStreetName());
			streetNumLabel2.setText("Street number: " + studentsArrList.get(indexNum).getStreetNumber());
			cityLabel2.setText("City: " + studentsArrList.get(indexNum).getCity());
			provLabel2.setText("Province: " + (String)studentsArrList.get(indexNum).getProvince());
			postalLabel2.setText("Postal code: " + studentsArrList.get(indexNum).getPostalCode());
			cslLabel2.setText("CSL loan amount: " + String.valueOf(studentsArrList.get(indexNum).getCslLoanAmount())); 
			oslLabel2.setText("OSL loan amount: " + String.valueOf(studentsArrList.get(indexNum).getOslLoanAmount())); 

		}
		catch(IndexOutOfBoundsException | NullPointerException i)
		{
			JOptionPane.showMessageDialog(null,"Make sure you submit a student to the database first"
					+ " before trying to output their details");
		}
		catch(Exception e1)
		{
			JOptionPane.showMessageDialog(null,"Something went wrong sorry!");
		}

		
		
	}
	
	/*
	* Class Name: loadStudentDetails (private class) 
	* Purpose: when the load button is clicked, it prints the students details to the screen 
	 Coder:	Eraj Gillani
	* Date:	April 8th 2020
	*/
	private class loadStudentDetails implements ActionListener
	{
		/*Method Name: actionPerformed
		*Purpose: prints students details to the screen and throws exception if failed 
		*Accepts: ActionEvent e
		*Returns: nothing
		*/
		public void actionPerformed(ActionEvent e)
		{
			if(numContents != 0 && btnPressed == false)
			{
				createStudentInfoPanel();
			}

			try 
			{
				 loadCurrentText();
			}
			catch(Exception e2)
			{
				JOptionPane.showMessageDialog(null,"Something went wrong sorry!");
			}
			SwingUtilities.updateComponentTreeUI(studentDetailsPanel);
		}//end method

		
	}//end class 
	
	/*
	* Class Name: previousStd  (private class) 
	* Purpose: iterates to the previous student in the arraylist and loads their details 
	 Coder:	Eraj Gillani
	* Date:	April 8th 2020
	*/
	private class previousStd implements ActionListener{
	
		/*Method Name:actionPerformed()
		*Purpose: iterates to the previous student, and if reaches the end, goes to the other end of the list 
		*Accepts: ActionEvent 
		*Returns: nothing
		*/
		public void actionPerformed(ActionEvent e) 
		{
			indexNum--;
			if (indexNum < 0) {
				indexNum = studentsArrList.size() - 1;
			}
		
			loadCurrentText();
		
			SwingUtilities.updateComponentTreeUI(studentDetailsPanel);
		}//end method 
		
	}//end class
	
	/*
	* Class Name: nextStd  (private class) 
	* Purpose: iterates to the next student in the arraylist and loads their details 
	 Coder:	Eraj Gillani
	* Date:	April 8th 2020
	*/
	private class nextStd implements ActionListener
	{
		
		/*Method Name:actionPerformed()
		*Purpose: iterates to the previous student, and if reaches the end, goes to the other end of the list 
		*Accepts: ActionEvent 
		*Returns: nothing
		*/
		public void actionPerformed(ActionEvent e) 
		{
			// cycle through all the options available 
			indexNum++;
			if (indexNum >= studentsArrList.size()) 
			{
				indexNum = 0;
			}
			
			loadCurrentText();
			SwingUtilities.updateComponentTreeUI(studentDetailsPanel);
		}//end method 
		
	}//end class
	
	/*
	* Class Name:  removeObject(private class) 
	* Purpose: deletes an object from arraylist
	 Coder:	Eraj Gillani
	* Date:	April 8th 2020
	*/
	private class removeObject implements ActionListener
	{

		/*Method Name:actionPerformed()
		*Purpose: deletes an object from the array list and sets the displayed information to empty strings 
		*Accepts: ActionEvent e 
		*Returns: nothing
		*/
		public void actionPerformed(ActionEvent e) 
		{

			studentsArrList.remove(indexNum);
			numContents--; 
			
			if(indexNum > 0)
			{
				indexNum--;
			}
			
			objIndex.setText("Your looking at Student: ");
			idLabel2.setText("Student ID: ");
			firstLabel2.setText("First name: ");
			middleLabel2.setText("Middle name: " );
			lastLabel2.setText("Surname: ");
			aptLabel2.setText("Apartment number: ");
			streetNameLabel2.setText("Street name: ");
			streetNumLabel2.setText("Street number: ");
			cityLabel2.setText("City: ");
			provLabel2.setText("Province: ");
			postalLabel2.setText("Postal code: ");
			cslLabel2.setText("CSL loan amount: "); 
			oslLabel2.setText("OSL loan amount: "); 
			
			JOptionPane.showMessageDialog(null, "Student Removed From Database!");
		}
		
	}//end method 
	
	/*Method Name:  loanForm()
	*Purpose:creates the part of the form that will allow the user to calculate their loan in terms of interest and amortization period they select
	*Accepts: nothing 
	*Returns: nothing
	*/
	public void loanForm()
	{
		calcFormPanel = new JPanel(); 
		calcFormPanel.setLayout(new BorderLayout());
		
		JPanel calcBtnPanel = new JPanel();
		calcBtnPanel.setLayout(new FlowLayout());
		calcBtnPanel.setBackground(Color.WHITE);
		calcLoanBtn = new JButton("Calculate Loan"); 
		calcLoanBtn.addActionListener(new calcLoanDetails());
		calcBtnPanel.add(calcLoanBtn);

		calcLoanInputPanel();

		calcDetailsPanel = new JPanel(); 
		calcDetailsPanel.setLayout(new FlowLayout());
		calcDetailsPanel.setBackground(Color.WHITE);
		outputText = new JTextArea();
		calcDetailsPanel.add(outputText);
		
		calcFormPanel.add(inputCalcPanel, BorderLayout.NORTH); 
		calcFormPanel.add(calcBtnPanel, BorderLayout.CENTER); 
		calcFormPanel.add(calcDetailsPanel, BorderLayout.SOUTH); 
		
		calcFormPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
	}

	/*Method Name: calcLoanInputPanel()
	*Purpose: sets up the panel that will hold the input loan details and the output details with the necessary calculations 
	*Accepts: nothing 
	*Returns: nothing
	*/
	public void calcLoanInputPanel()
	{
		inputCalcPanel = new JPanel(); 
		inputCalcPanel.setLayout(new GridLayout(3,1));
		
		JPanel sliderPanel = new JPanel();
		sliderPanel.setLayout(new FlowLayout());
		sliderPanel.setBackground(Color.WHITE);
		JLabel interestTitle = new JLabel("Annual Interest Rate (%): ");
		sliderPanel.add(interestTitle);
		JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
		slider.setBackground(Color.WHITE);
		slider.setMajorTickSpacing(1);
		sliderPanel.add(slider);
		
		sliderWholeValue = new JLabel("50"); 
		sliderWholeValue.setBackground(Color.WHITE);
		sliderPanel.add(sliderWholeValue);

		inputCalcPanel.add(sliderPanel);
		slider.addChangeListener(new sliderHandler());
		
		JPanel percentPanel = new JPanel(); 
		percentPanel.setLayout(new FlowLayout());
		percentPanel.setBackground(Color.WHITE);
		JLabel percent = new JLabel("Plus Quarter (%): ");
		percentPanel.add(percent);

		Double[] options = {0.00, 0.25, 0.50, 0.75};
		interestDecimal = new JComboBox<Double>(options);
		interestDecimal.setBackground(Color.WHITE);
		percentPanel.add(interestDecimal);
		inputCalcPanel.add(percentPanel);
		
		JPanel amortPanel = new JPanel(); 
		amortPanel.setLayout(new FlowLayout());
		amortPanel.setBackground(Color.WHITE);
		JLabel amortTitle = new JLabel("Amortization period (months):");
		amortPeriod = new JTextField("",2);
		amortPanel.add(amortTitle);
		amortPanel.add(amortPeriod);		
		inputCalcPanel.add(amortPanel);
	}
	
	/*
	* Class Name:  sliderHandler (private class) 
	* Purpose: creates the slide and updates the interest WHOLE value based on the user selection 
	 Coder:	Eraj Gillani
	* Date:	April 8th 2020
	*/
	private class sliderHandler implements ChangeListener
	{
		
		/*Method Name:stateChanged()
		*Purpose:This method gets executed every time the slider is moved
		*Accepts: ChangeEvent 
		*Returns: nothing
		*/
		public void stateChanged(ChangeEvent e) {
			
			JSlider source = (JSlider)e.getSource();

			if (!source.getValueIsAdjusting())
			{
				int fps = (int)source.getValue();
				String out = Integer.toString(fps);
				sliderWholeValue.setText(out);
				
			}
		}//end method 
		
	}//end class
	
	/*
	* Class Name: calcLoanDetails (private class) 
	* Purpose: calculate loan details depending on the user selection on interest rate and amortization period 
	 Coder:	Eraj Gillani
	* Date:	April 8th 2020
	*/
	private class calcLoanDetails implements ActionListener, EG_LoanPayable
	{

		/*Method Name: calculateLoanPayment()
		*Purpose:
		*Accepts: two double values and an int value
		*Returns: double 
		*/
		public double calculateLoanPayment(double loan, double primeIntRate, int months) 
		{
			// TODO Auto-generated method stub
			//P  = A * i * (1 + i)^N /( (1 + i)^N – 1)
			double num = (loan)*(primeIntRate)*Math.pow((1+primeIntRate),months)/(Math.pow(1+primeIntRate, months)-1);
			return num;
		}


		/*Method Name: actionPerformed()
		*Purpose: calculate the loan details and throw an exception if there is no student selected or something just went wrong 
		*Accepts: ActionEvent 
		*Returns: nothing
		*/
		public void actionPerformed(ActionEvent e) 
		{
			try
			{
				double oslValue = studentsArrList.get(indexNum).getOslLoanAmount();
				double cslValue = studentsArrList.get(indexNum).getCslLoanAmount();
				double wholeNum = Double.parseDouble(sliderWholeValue.getText());
				double fracNum = (double)interestDecimal.getSelectedItem();
				double intRate = wholeNum + fracNum;
				
				double monthlyOsl = (intRate + 1)*ANNUAL_RATE_TO_MONTHLY_RATE ;
				double monthlyCsl = (intRate + 2.5)*ANNUAL_RATE_TO_MONTHLY_RATE;
				int amortMonths = Integer.parseInt(amortPeriod.getText());
				

				double monthlyOslPay = (double)Math.round(calculateLoanPayment(oslValue, monthlyOsl, amortMonths)* 100) / 100;
				double monthlyCslPay = (double)Math.round(calculateLoanPayment(cslValue, monthlyCsl, amortMonths)* 100) / 100;
				double total = (double)Math.round(monthlyOslPay+monthlyCslPay);
				double totalPlusInt = (double)Math.round(amortMonths * total)*100/100;
				int studentNum = indexNum + 1; 
			

				outputText.setText(String.format("Student: %d\n", studentNum) + studentsArrList.get(indexNum).toString()+"Monthly csl payment: $"+String.format("%.2f", monthlyCslPay)+"\nMonthly osl payment: $"+String.format("%.2f", monthlyOslPay)+
						"\nTotal monthly payment: $"+String.format("%.2f", total)+
						" over "+amortMonths+" months."+
						"\nTotal amount that will be repaid: $"+
						String.format("%.2f", totalPlusInt)+
						"\nOriginal amount borrowed: $"+String.format("%.2f", (oslValue+cslValue))+
						"\nTotal amount of interest paid: $"+String.format("%.2f", (totalPlusInt-(oslValue+cslValue))));
			}
			catch(NumberFormatException n)
			{
				JOptionPane.showMessageDialog(null, "Please input a whole integer value (in months) for amortization period");
			}
			catch(Exception a)
			{
				JOptionPane.showMessageDialog(null, "Oops! We were unable to calculate your loan, did you submit the student details first?");
			}

			SwingUtilities.updateComponentTreeUI(calcDetailsPanel);
		}//end method 

		
		
	}// end class 
	
	
	public static void main(String[] args)
	{ 
		//create new object to start app 
		new StudentLoapApp(); 

	}
	
}
//end class