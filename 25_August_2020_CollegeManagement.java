import java.util.*;

public class Solution1 {
	public static void main(String[] args) {
		int collegeCode;
		String collegeName;
		String grade;
		String department;
		String company;
		int noOfStudentsGotPlaced;
		College[] college = new College[4];
		Scanner s = new Scanner(System.in);
		for(int i=0;i<college.length;i++) {
			collegeCode = s.nextInt();s.nextLine();
			collegeName = s.nextLine();
			grade = s.nextLine();
			department = s.nextLine();
			company = s.nextLine();
			noOfStudentsGotPlaced = s.nextInt();
			college[i] = new College(collegeCode, collegeName, grade, department, company, noOfStudentsGotPlaced);
		}
		s.nextLine();
		String getDepartment = s.nextLine();
		String getCompany = s.nextLine();
		String getGrade = s.nextLine();
		s.close();
		int sum = findSumOfStudentsPlacedByDepartmentAndCompany(college, getDepartment, getCompany);
		College[] c = searchCollegeByGrade(getGrade, college);
		
		if(sum == 0)
			System.out.println("No students got placed in the given department");
		else
			System.out.println(sum);
		
		if(c == null)
			System.out.println("There are no College with the given grade");
		else {
			for(int i=0;i<c.length;i++) {
				System.out.println(c[i].getCollegeName());
			}
		}
	}
	public static int findSumOfStudentsPlacedByDepartmentAndCompany(College[] college, String department, String company) {
		int sum = 0;
		for(int i=0;i<college.length;i++) {
			if(department.equalsIgnoreCase(college[i].getDepartment()) && company.equalsIgnoreCase(college[i].getCompany())) {
				sum += college[i].getNoOfStudentsGotPlaced();
			}
		}
		return sum;
	}
	public static College[] searchCollegeByGrade(String grade, College[] college) {
		int count = 0;
		for(int i=0;i<college.length;i++) {
			if(grade.equalsIgnoreCase(college[i].getGrade()))
				count++;
		}
		if(count == 0) return null;
		College[] c = new College[count];
		int x = 0;
		for(int i=0;i<college.length;i++) {
			if(grade.equalsIgnoreCase(college[i].getGrade())) {
				c[x++] = college[i];
			}
		}
		for(int i=0;i<c.length;i++) {
			for(int j=i+1;j<c.length;j++) {
				if(c[i].getNoOfStudentsGotPlaced() >= c[j].getNoOfStudentsGotPlaced()) {
					College temp = c[i];
					c[i] = c[j];
					c[j] = temp;
				}
			}
		}
		return c;
	}
}
class College{
	int collegeCode;
	String collegeName;
	String grade;
	String department;
	String company;
	int noOfStudentsGotPlaced;
	College(int collegeCode, String collegeName, String grade, String department, String company, int noOfStudentsGotPlaced){
		this.collegeCode = collegeCode;
		this.collegeName = collegeName;
		this.grade = grade;
		this.department = department;
		this.company = company;
		this.noOfStudentsGotPlaced = noOfStudentsGotPlaced;
	}
	int getCollegeCode() {
		return collegeCode;
	}
	String getCollegeName() {
		return collegeName;
	}
	String getGrade() {
		return grade;
	}
	String getDepartment() {
		return department;
	}
	String getCompany() {
		return company;
	}
	int getNoOfStudentsGotPlaced() {
		return noOfStudentsGotPlaced;
	}
}
