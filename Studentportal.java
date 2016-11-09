import java.sql.*;
import java.util.*;
import java.io.*;
public class Studentportal {
	  static String readEntry(String p){
		  try{
			  StringBuffer buffer= new StringBuffer();
			  System.out.print(p);
			  System.out.flush();
			  int c= System.in.read();
			  while(c!='\n' && c!= -1){
				  buffer.append((char)c);
				  c=System.in.read();
			  }
			  return buffer.toString().trim();
		  } catch (IOException e){
			  return " ";
	  }}
	  public static void AddClass(Connection conn,String Studentno,String sem,String year) throws SQLException, IOException{
		  String courseno,sec;
		  String print=" ";
		  boolean p=true;
		  courseno= readEntry( "Course Number: ");
		  sec= readEntry( "Section: ");
		 
		  String q0="SELECT p.prerequisite_number FROM prerequisite p,section s WHERE p.Course_number=s.Course_number AND s.Section_identifier = "+sec;
		  Statement s0=conn.createStatement();
		  ResultSet r0=s0.executeQuery(q0);
		  while(r0.next()){
			  
			  String check0=r0.getString(1);
			  print+=check0+",";
			  
			  String q3="SELECT s.Section_identifier FROM grade_report g,section s WHERE g.Student_number=";
			  q3+=Studentno;
			  q3+=" AND g.Section_identifier=s.Section_identifier AND s.Course_number= '"+check0+"'";
			  Statement s3=conn.createStatement();
			  ResultSet r3=s3.executeQuery(q3);
			  if(!r3.next()){
				  p=false;
			  }
			  
		  }
		  if(p){
		  String q1=" SELECT s.Semester FROM section s WHERE Section_identifier= ";
		  q1+=sec;
		  
		  String q2=" INSERT INTO grade_report(Student_number, Section_identifier ) VALUES ("+Studentno+","+ sec+" )";
		  Statement s1=conn.createStatement();
		  ResultSet r1=s1.executeQuery(q1);
		  String check = null;
		  String spring= new String("Spring");
		  if(r1.next()){
		  check=r1.getString(1);
		  }
		  if(spring.equals(check)){
			  try{
			  Statement s2=conn.createStatement();
			  s2.executeQuery(q2);
			  System.out.println("Class Added");
			  s2.close();}
			  catch(Exception ex){
				  System.out.println("Class has already been added");
			  }
		  }
		  else{
			  System.out.println(" Fall class cannot be added");
		  }
		  s1.close();
		  }
	  
		  else{
			  System.out.println(" Student has not taken the required prerequisites"+print+" for the course.");
		  }
	  }
	  public static void DropClass(Connection conn,String Studentno,String sem,String year) throws SQLException, IOException{
		  String courseno,sec;
		  courseno= readEntry( "Course Number: ");
		  sec= readEntry( "Section: ");
		  String q0=" SELECT s.Semester FROM section s WHERE Section_identifier= ";
		  q0+=sec;
		  Statement s0=conn.createStatement();
		  ResultSet r0=s0.executeQuery(q0);
		  String check = null;
		  String spring= new String("Spring");
		  if(r0.next()){
		  check=r0.getString(1);
		  }
		  if(spring.equals(check)){
		  String q1="SELECT Section_identifier FROM grade_report WHERE Student_number="+Studentno+" AND Section_identifier="+sec;
		  Statement s1=conn.createStatement();
		  ResultSet r1=s1.executeQuery(q1);
		  if(r1.next()){
			  String q2="DELETE FROM grade_report WHERE Section_identifier="+sec;
			  Statement s2=conn.createStatement();
			  s2.executeQuery(q2);
			  System.out.println("Class has been Dropped");
		  }
		  else{
			  System.out.print("Class is not registered for the student");
		  }
		  }
		  else{
			  System.out.println(" Fall class can not be dropped");
		  }
	  }
	  public static void Display(Connection conn, String Studentno,String sem,String year) throws SQLException, IOException {
		  String query= " select s.Course_number,s.Section_identifier,c.Course_name,s.Instructor from section s,grade_report g,Course c where g.Student_number = '";
		  query += Studentno;
		  query +="'";
		  query +="and g.Section_identifier=s.Section_identifier and s.Course_number=c.Course_number ";
		  Statement s=conn.createStatement();
		  ResultSet r=s.executeQuery(query);
		  System.out.println("Your Schedule is :");
		  while(r.next()){
			  System.out.print(r.getString(1));
			  System.out.print(" Section "+r.getString(2)+", ");
			  System.out.print(r.getString(3)+", ");
			  System.out.print("Instructor: "+r.getString(4));
			  System.out.print("\n");
		  }
		  s.close();
	  }
	  public static void main(String[] args) throws SQLException, IOException {
		  try{
			  Class.forName("oracle.jdbc.drive.OracleDriver");
		  }
		  catch(ClassNotFoundException e){
			  System.out.println ("Could not load the driver");
		  }
		  String user,pass;
		  user= readEntry("userid : ");
		  pass= readEntry("password : ");
		  Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@csoracle.utdallas.edu:1521:student",user,pass);
		  String studentno, sem, year,c;
		  studentno= readEntry("Student Number: ");
		  sem= readEntry("Semester: ");
		  year= readEntry("Year: ");
		  String query="SELECT g.Student_number FROM grade_report g,section s WHERE g.Student_number=";
		  query+=studentno+"AND g.Section_identifier=s.Section_identifier AND s.Semester= '"+sem+"' AND s.Year='"+year+"'";
		  Statement s1=conn.createStatement();
		  ResultSet r1=s1.executeQuery(query);
		  boolean t=true;
		  int choice;
		  if(r1.next()){
		  do{
		  System.out.println(" Main Menu :");
		  System.out.println(" (1) Add a class ");
		  System.out.println(" (2) Drop a class ");
		  System.out.println(" (3) See my schedule");
		  System.out.println(" (4) EXIT ");
		  c= readEntry("Enter your choice: ");
		  choice = Integer.parseInt(c);
		  switch(choice)
		  {
		  case 1: AddClass(conn,studentno,sem,year);break;
		  case 2: DropClass(conn,studentno,sem,year);break;
		  case 3: Display(conn,studentno,sem,year);break;
		  case 4: t=false;break;
		  default: System.out.println("Please enter a valid input");break;
		  }
		  }while(t)	;
		  }
		  else{
			  System.out.println("Student does not belong to the University");
		  }
}
}