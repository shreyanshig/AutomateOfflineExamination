/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.InputStream;
import java.util.Objects;

/**
 *
 * @author Shreyanshi
 */
public class StudentDetails
{
    private String roll_no;
    private String name;
    private String grade;
    private String board;
    private String center_id;
    private String school;
    private String father_name;
    private String mother_name;
    private String photo;
    public StudentDetails(){
        
    }

    public StudentDetails(String roll_no, String name, String grade, String board, String center_id, String school, String father_name, String mother_name, String photo) {
        this.roll_no = roll_no;
        this.name = name;
        this.grade = grade;
        this.board = board;
        this.center_id = center_id;
        this.school = school;
        this.father_name = father_name;
        this.mother_name = mother_name;
        this.photo = photo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.roll_no);
        hash = 23 * hash + Objects.hashCode(this.name);
        hash = 23 * hash + Objects.hashCode(this.grade);
        hash = 23 * hash + Objects.hashCode(this.board);
        hash = 23 * hash + Objects.hashCode(this.center_id);
        hash = 23 * hash + Objects.hashCode(this.school);
        hash = 23 * hash + Objects.hashCode(this.father_name);
        hash = 23 * hash + Objects.hashCode(this.mother_name);
        hash = 23 * hash + Objects.hashCode(this.photo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final StudentDetails other = (StudentDetails) obj;
        if (!Objects.equals(this.roll_no, other.roll_no)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.grade, other.grade)) {
            return false;
        }
        if (!Objects.equals(this.board, other.board)) {
            return false;
        }
        if (!Objects.equals(this.center_id, other.center_id)) {
            return false;
        }
        if (!Objects.equals(this.school, other.school)) {
            return false;
        }
        if (!Objects.equals(this.father_name, other.father_name)) {
            return false;
        }
        if (!Objects.equals(this.mother_name, other.mother_name)) {
            return false;
        }
        if (!Objects.equals(this.photo, other.photo)) {
            return false;
        }
        return true;
    }

    public String getRoll_no() {
        return roll_no;
    }

    public void setRoll_no(String roll_no) {
        this.roll_no = roll_no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getBoard() {
        return board;
    }

    public void setBoard(String board) {
        this.board = board;
    }

    public String getCenter_id() {
        return center_id;
    }

    public void setCenter_id(String center_id) {
        this.center_id = center_id;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getFather_name() {
        return father_name;
    }

    public void setFather_name(String father_name) {
        this.father_name = father_name;
    }

    public String getMother_name() {
        return mother_name;
    }

    public void setMother_name(String mother_name) {
        this.mother_name = mother_name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "StudentDetails{" + "roll_no=" + roll_no + ", name=" + name + ", grade=" + grade + ", board=" + board + ", center_id=" + center_id + ", school=" + school + ", father_name=" + father_name + ", mother_name=" + mother_name + ", photo=" + photo + '}';
    }
}
