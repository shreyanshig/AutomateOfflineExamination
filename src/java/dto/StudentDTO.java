/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.InputStream;

/**
 *
 * @author Shreyanshi
 */
public class StudentDTO
{
    private String roll_no;
    private String name;
    private String grade;
    private String board;
    private String center_id;
    private String school;
    private String father_name;
    private String mother_name;
    private InputStream photo;
    public StudentDTO(){
        
    }

    @Override
    public String toString() {
        return "StudentDTO{" + "roll_no=" + roll_no + ", name=" + name + ", grade=" + grade + ", board=" + board + ", center_id=" + center_id + ", school=" + school + ", father_name=" + father_name + ", mother_name=" + mother_name + ", photo=" + photo + '}';
    }

    public StudentDTO(String roll_no, String name, String grade, String board, String center_id, String school, String father_name, String mother_name, InputStream photo) {
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

    public InputStream getPhoto() {
        return photo;
    }

    public void setPhoto(InputStream photo) {
        this.photo = photo;
    }
}
