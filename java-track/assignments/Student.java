public class Student {

	private String first;
	private String last;
	private int id;
	private int credits;
	private double gpatotal;
	private double gpa;
	
	//constructor
	public Student(String first, String last, int id){
		this.first=first;
		this.last=last;
		this.id=id;
		this.credits=0;
		this.gpatotal=0;
		this.gpa=0;
	}
	
	public String getName(){
		return (this.first+" "+this.last);
	}
	
	public int getStudentID(){
		return this.id;
	}
	
	public String getClassStanding(){
		if (this.credits<30){
			return "Freshman";
		}else if(this.credits>=30 && this.credits<60){
			return "Sophomore";
		}else if (this.credits>=60 && this.credits<90){
			return "Junior";
		}else if (this.credits>=90){
			return "Senior";
		}else{
			return "Error: class standing undefined";
		}
	}
	
	public int getCredits(){
		return this.credits;
	}
	
	public void submitGrade(double g, int c){
		this.gpatotal=this.gpatotal+g*c;
		this.credits=this.credits+c;
		this.gpa=((double)Math.round((this.gpatotal/this.credits)*1000d)/1000d);
	}
	
	public double getGPA(){
		return gpa;
	}
	
	public double computeTuition(){
		int t=((((this.credits-1)-((this.credits-1)%15))/15)+1);
		return 20000.0*t;
	}
	
	public Student createLegacy(Student ss){
		Student bb = new Student(this.getName(),ss.getName(),this.getStudentID()+ss.getStudentID());
		bb.credits=Math.max(this.getCredits(),ss.getCredits());
		bb.gpa=((this.gpa+ss.gpa)/2);
		return bb;
	}
	
	public String toString(){
		return this.first+" "+this.last+" "+this.id;
	}
}
