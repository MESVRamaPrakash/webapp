package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.marksmodel;

public class marksdao {
	private Connection con;

	public marksdao(Connection con) {
		super();
		this.con = con;
	}

	public boolean addMarks(marksmodel marks) {

		boolean f = false;

		try {

			String sql = "insert into student_marks(Rollnumber,Telugu,Hindi,English,Maths,Science,Social) values (?,?,?,?,?,?,?)";

			PreparedStatement pst = con.prepareStatement(sql);

			pst.setInt(1, marks.getRollnumber());
			pst.setInt(2, marks.getTelugu());
			pst.setInt(3, marks.getHindi());
			pst.setInt(4, marks.getEnglish());
			pst.setInt(5, marks.getMaths());
			pst.setInt(6, marks.getScience());
			pst.setInt(7, marks.getSocial());

			int i = pst.executeUpdate();

			if (i == 1) {

				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;

	}

	public List<marksmodel> getAllMarks() {

		List<marksmodel> list = new ArrayList<marksmodel>();

		marksmodel m = null;

		try {

			String sql = "select * from student_marks";

			PreparedStatement pst = con.prepareStatement(sql);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				m = new marksmodel();

				m.setRollnumber(rs.getInt(1));
				m.setTelugu(rs.getInt(2));
				m.setHindi(rs.getInt(3));
				m.setEnglish(rs.getInt(4));
				m.setMaths(rs.getInt(5));
				m.setScience(rs.getInt(6));
				m.setSocial(rs.getInt(7));

				list.add(m);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public marksmodel getByMarksId(int Rollnumber) {

		marksmodel m = null;

		try {

			String sql = "select * from student_marks where Rollnumber = ?";

			PreparedStatement pst = con.prepareStatement(sql);

			pst.setInt(1, Rollnumber);

			ResultSet rs = pst.executeQuery();

			while (rs.next())

			{

				m = new marksmodel();

				m.setRollnumber(rs.getInt(1));
				m.setTelugu(rs.getInt(2));
				m.setHindi(rs.getInt(3));
				m.setEnglish(rs.getInt(4));
				m.setMaths(rs.getInt(5));
				m.setScience(rs.getInt(6));
				m.setSocial(rs.getInt(7));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return m;
	}

	public boolean updateMarks(marksmodel marks) {

		boolean f = false;

		try {

			String sql = "update student_marks set Telugu=?,Hindi=?,English=?,Maths=?,Science=?,Social =? where Rollnumber =?";

			PreparedStatement pst = con.prepareStatement(sql);

			pst.setInt(1, marks.getTelugu());
			pst.setInt(2, marks.getHindi());
			pst.setInt(3, marks.getEnglish());
			pst.setInt(4, marks.getMaths());
			pst.setInt(5, marks.getScience());
			pst.setInt(6, marks.getSocial());
			pst.setInt(7, marks.getRollnumber());

			int i = pst.executeUpdate();

			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public boolean deleteMarks(int Rollnumber) {

		boolean f = false;

		try {

			String sql = "delete from student_marks where Rollnumber = ?";

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
