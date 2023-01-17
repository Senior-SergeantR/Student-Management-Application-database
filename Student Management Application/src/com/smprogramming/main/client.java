package com.smprogramming.main;

import com.smprogramming.dao.StudentDao;
import com.smprogramming.dao.StudentDaoInterface;
import com.smprogramming.model.Student;

import java.util.Scanner;

public class client {
    public static void main(String[] args) {

        StudentDaoInterface dao = new StudentDao();

        Scanner sc =new Scanner(System.in);

        System.out.println("Welcome to student database application");

        while(true){
            System.out.println("\n1.Add Student" +
                    "\n2.show all Students" +
                    "\n3.Get student based on roll number" +
                    "\n4.Delete Student" +
                    "\n5.Update Student" +
                    "\n6.Exit");

            System.out.println("Enter Choice: ");
            int choice= sc.nextInt();

            switch (choice){
                case 1:
                    System.out.println("Add student");
                    System.out.println("Enter Student Name: ");
                    String name = sc.next();
                    System.out.println("Enter Student college Name: ");
                    String collegeName = sc.next();
                    System.out.println("Enter Home city: ");
                    String city= sc.next();
                    System.out.println("Enter percentage: ");
                    double percentage=sc.nextDouble();

                    Student student = new Student(name,collegeName,city,percentage);
                    boolean answer = dao.insertStudent(student);
                        if (answer){
                            System.out.println("Record inserted successfully");
                        }else {
                            System.out.println("something went wrong");
                        }
                    System.out.println();

                    break;
                case 2:
                    System.out.println("Show all Students");
                    dao.showAllStudent();
                    break;
                case 3:
                    System.out.println("Get student based on roll number");
                    System.out.println("Enter roll number");
                    int roll = sc.nextInt();

                    boolean f = dao.showStudentById(roll);
                    if (!f){
                        System.out.println("Student with this id is not available in our system!!!");
                    }
                    break;
                case 4:
                    System.out.println("Delete student");
                    System.out.println("Enter the roll number to delete: ");
                    int rollNum = sc.nextInt();
                    boolean ff = dao.delete(rollNum);
                    if(ff){
                        System.out.println("Record deleted successfully!!!");
                    }else{
                        System.out.println("Something went wrong!!!");
                    }
                    break;
                case 5:
                    System.out.println("Update student");
                    System.out.println("\n1.Update name" +
                            "\n2.Update College Name");
                    System.out.println("Enter your choice: ");

                    int ch = sc.nextInt();
                            if (ch==1){
                                System.out.println("Enter roll Number: ");
                                int rnum = sc.nextInt();
                                System.out.println("Enter new name: ");
                                String sname = sc.next();

                                Student std = new Student();

                                std.setName(sname);
                                boolean flag = dao.update(rnum,sname,ch,std);

                                if (flag){
                                    System.out.println("Updated Successfully!!");
                                }else{
                                    System.out.println("Something went wrong");
                                }
                            }

                    break;
                case 6:
                    System.out.println("Thank you for using Student management application");
                    System.exit(0);
                default:
                    System.out.println("Please enter a valid choice");
            }
        }
    }
}
