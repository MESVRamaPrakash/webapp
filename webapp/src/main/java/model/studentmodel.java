package model;

public class studentmodel {

	private int Rollnumber;
	
	private String Studentname;

	private String Section;

	private String Clas;

	private String Email;

	private String Password;

	private String Fathername;

	private String Mothername;

	public int getRollnumber() {
		return Rollnumber;
	}

	public void setRollnumber(int rollnumber) {
		Rollnumber = rollnumber;
	}
	
	public String getStudentname() {
		return Studentname;
	}

	public void setStudentname(String studentname) {
		Studentname = studentname;
	}

	public String getSection() {
		return Section;
	}

	public void setSection(String section) {
		Section = section;
	}

	public String getClas() {
		return Clas;
	}

	public void setClas(String clas) {
		Clas = clas;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getFathername() {
		return Fathername;
	}

	public void setFathername(String fathername) {
		Fathername = fathername;
	}

	public String getMothername() {
		return Mothername;
	}

	public void setMothername(String mothername) {
		Mothername = mothername;
	}

	public studentmodel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public studentmodel(int rollnumber, String studentname, String section, String clas, String email, String password,
			String fathername, String mothername) {
		super();
		Rollnumber = rollnumber;
		Studentname = studentname;
		Section = section;
		Clas = clas;
		Email = email;
		Password = password;
		Fathername = fathername;
		Mothername = mothername;
	}

}
