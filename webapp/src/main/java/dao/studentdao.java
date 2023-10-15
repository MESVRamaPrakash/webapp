package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.studentmodel;

public class studentdao {
	private Connection con;

	public studentdao(Connection con) {
		super();
		this.con = con;
	}

	public boolean addStudent(studentmodel student) {

		boolean f = false;

		try {

			String sql = "insert into student_details(Rollnumber,Studentname,Section,Clas,Email,Password,Fathername,Mothername) values (?,?,?,?,?,?,?,?)";

			PreparedStatement pst = con.prepareStatement(sql);

			pst.setInt(1, student.getRollnumber());
			pst.setString(2, student.getStudentname());
			pst.setString(3, student.getSection());
			pst.setString(4, student.getClas());
			pst.setString(5, student.getEmail());
			pst.setString(6, student.getPassword());
			pst.setString(7, student.getFathername());
			pst.setString(8, student.getMothername());

			int i = pst.executeUpdate();

			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	public List<studentmodel> getAllStudents() {

		List<studentmodel> list = new ArrayList<studentmodel>();

		studentmodel s = null;

		try {

			String sql = "select * from student_details";

			PreparedStatement pst = con.prepareStatement(sql);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				s = new studentmodel();
				
				s.setRollnumber(rs.getInt(1));
				s.setStudentname(rs.getString(2));
				s.setSection(rs.getString(3));
				s.setClas(rs.getString(4));
				s.setEmail(rs.getString(5));
				s.setPassword(rs.getString(6));
				s.setFathername(rs.getString(7));
				s.setMothername(rs.getString(8));
				

				list.add(s);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public studentmodel getByStudentId(int Rollnumber) {

		studentmodel s = null;

		try {

			String sql = "select * from student_details where Rollnumber = ?";

			PreparedStatement pst = con.prepareStatement(sql);

			pst.setInt(1, Rollnumber);

			ResultSet rs = pst.executeQuery();

			while (rs.next())

			{

				s = new studentmodel();

				s.setRollnumber(rs.getInt(1));
				s.setStudentname(rs.getString(2));
				s.setSection(rs.getString(3));
				s.setClas(rs.getString(4));
				s.setEmail(rs.getString(5));
				s.setPassword(rs.getString(6));
				s.setFathername(rs.getString(7));
				s.setMothername(rs.getString(8));

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return s;
	}

	public boolean updateStudent(studentmodel student) {

		boolean f = false;

		try {

			String sql = "update student_details set Studentname=?,Section=?,Clas=?,Email=?,Password=?,Fathername =?,Mothername =? where Rollnumber =?";

			PreparedStatement pst = con.prepareStatement(sql);

			
			pst.setString(1, student.getStudentname());
			pst.setString(2, student.getSection());
			pst.setString(3, student.getClas());
			pst.setString(4, student.getEmail());
			pst.setString(5, student.getPassword());
			pst.setString(6, student.getFathername());
			pst.setString(7, student.getMothername());
			pst.setInt(8, student.getRollnumber());

			int i = pst.executeUpdate();

			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public boolean deleteStudent(int Rollnumber) {

		boolean f = false;

		try {

			String sql = "delete from student_details where Rollnumber = ?";

			PreparedStatement pst = con.prepareStatement(sql);

			pst.setInt(1, Rollnumber);

			int i = pst.executeUpdate();

			if (i == 1) {

				f = true;

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}
}
