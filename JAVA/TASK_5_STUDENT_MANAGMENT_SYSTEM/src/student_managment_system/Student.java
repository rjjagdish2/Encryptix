/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package student_managment_system;


import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Jagdish
 */
public class Student {

    Connection cn;
    Statement smt;

    String rollno, name, grade;

    public Student() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/mca", "root", "jagdish");
            smt = cn.createStatement();
            //Create Table
//            String str = "create table student_management(rollno varchar(10) primary key,name varchar(25),grade varchar(5))";
//            smt.execute(str);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void setRollno(String rollno) {
        this.rollno = rollno;
    }

    private String getRollno() {
        return rollno;
    }

    private String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    private String getGrade() {
        return grade;
    }

    private void setGrade(String grade) {
        this.grade = grade;
    }

    public boolean addData(String rollno, String sname, String grade) {
        setRollno(rollno);
        setName(sname);
        setGrade(grade);

        String searchQuery = "select * from student_management where rollno='" + getRollno() + "'";

        String insertQuery = "insert into student_management values('" + getRollno() + "','" + getName() + "','" + getGrade() + "')";
        try {

            ResultSet rs = smt.executeQuery(searchQuery);
            if (rs.next()) {
                return false;
            } else {
                if (!smt.execute(insertQuery)) {
                    return true;

                } else {
                    return false;
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public boolean deleteData(String rollno) {

        setRollno(rollno);
        String searchQuery = "select * from student_management where rollno='" + getRollno() + "'";

        try {
            ResultSet rs = smt.executeQuery(searchQuery);
            if (rs.next()) {
                String deleteQuery = "delete from student_management where rollno='" + getRollno() + "'";
                boolean output = smt.execute(deleteQuery);
                System.out.println(output);
                if (!smt.execute(deleteQuery)) {

                    return true;
                } else {

                    return false;
                }

            } else {
                System.out.println("Student Classs else");
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    public ResultSet searchData(String rollno) {
        setRollno(rollno);
        ResultSet rs = null;
        String searchQuery = "select * from student_management where rollno='" + getRollno() + "'";
        try {
            rs = smt.executeQuery(searchQuery);
            if (rs.next()) {
                return rs;
            }

        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
            return rs;
        }
        rs = null;
        return rs;
    }

    public boolean updateData(String rollno, String sname, String grade) {
        setRollno(rollno);
        setName(sname);
        setGrade(grade);
        String searchQuery = "select * from student_management where rollno='" + getRollno() + "'";

        try {
            ResultSet rs = smt.executeQuery(searchQuery);
            if (rs.next()) {
                String updateQuery = "update student_management set name='" + getName() + "',grade='" + getGrade() + "' where rollno='" + getRollno() + "'";

                if (!smt.execute(updateQuery)) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    public ResultSet showData() {
        String showQuery = "select * from student_management";
        ResultSet rs = null;
        try {
            rs = smt.executeQuery(showQuery);
            if (rs.next()) {
                return rs;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rs;
    }
}
