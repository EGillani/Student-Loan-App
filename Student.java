/**
 * Program Name:Student.java
 * Purpose: Instructions how to create an object to store the students information and their loan 
 * Coder: Eraj Gillani 0858887
 * Date: Apr. 3, 2020
 */

public class Student
{
	private String studentID;
	private String surname;
	private String middleName;
	private String firstName;
	private String aptNumber;
	private String streetNumber;
	private String streetName;
	private String city;
	private String province;
	private String postalCode;
	private double cslLoanAmount;
	private double oslLoanAmount;
	
	public Student(String studentId, String surname, String middlename, String firstName, String aptNumber, 
									String streetNumber, String streetName, String city, String province, String postalCode, 
									double cslLoanAmount, double oslLoanAmount)
	{
		this.studentID = studentId;
		this.surname = surname;
		this.middleName = middlename;
		this.firstName = firstName;
		this.aptNumber = aptNumber;
		this.streetNumber = streetNumber;
		this.streetName = streetName;
		this.city = city;
		this.province = province;
		this.postalCode = postalCode;
		this.cslLoanAmount = cslLoanAmount;
		this.oslLoanAmount = oslLoanAmount; 
		
	}

	public String getStudentID()
	{
		return studentID;
	}

	public String getSurname()
	{
		return surname;
	}

	public void setSurname(String surname)
	{
		this.surname = surname;
	}

	public String getMiddleName()
	{
		return middleName;
	}

	public void setMiddleName(String middleName)
	{
		this.middleName = middleName;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getAptNumber()
	{
		return aptNumber;
	}

	public void setAptNumber(String aptNumber)
	{
		this.aptNumber = aptNumber;
	}

	public String getStreetNumber()
	{
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber)
	{
		this.streetNumber = streetNumber;
	}

	public String getStreetName()
	{
		return streetName;
	}

	public void setStreetName(String streetName)
	{
		this.streetName = streetName;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public String getProvince()
	{
		return province;
	}

	public void setProvince(String province)
	{
		this.province = province;
	}

	public String getPostalCode()
	{
		return postalCode;
	}

	public void setPostalCode(String postalCode)
	{
		this.postalCode = postalCode;
	}

	public double getCslLoanAmount()
	{
		return cslLoanAmount;
	}

	public void setCslLoanAmount(double cslLoanAmount)
	{
		this.cslLoanAmount = cslLoanAmount;
	}

	public double getOslLoanAmount()
	{
		return oslLoanAmount;
	}

	public void setOslLoanAmount(double oslLoanAmount)
	{
		this.oslLoanAmount = oslLoanAmount;
	}

	/*public String toString()
	{
		String accNum = String.format("\nAccount Number:\t\t%s", accountNumber);
		String numWithdraw = String.format("\nNumber of Withdrawals:\t%d", numberWithdrawals);
		String numDeposit = String.format("\nNumber of Deposits:\t%d", numberDeposits);
		String strBalance = String.format("\nBalance:\t\t$%.2f", balance);
		String strAccountActive = String.format("\nAccount Active:\t\t%b", accountActive);
		String strInterestRate = String.format("\nAnnual Interest Rate:\t%.1g%c", (getIntRate()*100.00),'%');
		return super.toString() + accNum + numWithdraw + numDeposit + strBalance + strAccountActive + strInterestRate ;
	}*/
	
	public String toString() 
	{
		String name = "Student Name: "+ surname +", "+ firstName +" "+ middleName +"\n";
		String number = "Student Number: "+ studentID +"\n";
		String cslAmount = "CSL Amount is $"+ cslLoanAmount +"\n";
		String oslAmount = "OSL Amount is $"+ oslLoanAmount +"\n";
		
		String rString = name + number + cslAmount + oslAmount;
		return rString; 		
	}
}
//end class