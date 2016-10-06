public class Course {

	private String name;
	private int credits;
	private int seats;
	private int open;
	private Student[] roster;
	
	//constructor
	public Course(String name, int credits, int seats){
		this.name=name;
		this.credits=credits;
		this.seats=seats;
		this.open=this.seats;
		this.roster=new Student[this.seats];
	}
	
	public String getName(){
		return this.name;
	}
	
	public int getCredits(){
		return this.credits;
	}
	
	public int getRemainingSeats(){
		return this.open;
	}
	
	public boolean addStudent(Student s2){
		boolean added = true;
		if (this.open>0){										//if there are open seats
			if ((this.seats-this.open)>0){						//if there is at least one student already enrolled
				for (int i=0; i<(this.seats-this.open); i++){
					if (this.roster[i].getName()==s2.getName()){//check for duplicate students
						added=false;
						return added;
					}
				}
			}
			this.roster[this.seats-this.open]=s2;				//add new student
			
			this.open=this.open-1;								//reduce number of open seats
		}else{
			added = false;
			return added;
		}
		return added;
	}
	
	public double averageGPA(){
		double a=0;
		for(int i=0; i<(this.seats-this.open); i++){
			a=a+roster[i].getGPA();
		}
		double avg=a/(this.seats-this.open);
		return avg;
	}
	
	public String toString(){
		return this.name + " " + this.credits;
	}
}
