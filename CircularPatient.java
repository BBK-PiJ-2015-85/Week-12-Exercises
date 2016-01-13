public class CircularPatient {
	private String name;
	private int age;
	private CircularPatient nextPatient;
	
	
	public CircularPatient(String name) {
		this.name = name;
		this.nextPatient = this;		
	}
	
	public CircularPatient getNextPatient() {
		return nextPatient;
	}
	
	public void addPatient(CircularPatient newPatient) {
		CircularPatient start = this;
		if (this.nextPatient == this) {
			this.nextPatient = newPatient;
			newPatient.nextPatient = this;
		} else {
			for (CircularPatient p = this.nextPatient; p != start; p = p.nextPatient) {
				if (p.nextPatient == start) {
					p.nextPatient = newPatient;
					newPatient.nextPatient = this;
				}
			}			
		}
	}
	
	public String toString() {
		String str = "";
		CircularPatient start = this;
		if (this == null) {
			str += "Empty List";
		} else {
			str += this.name;
			if (this.nextPatient != start) {
				str += ", ";
			}					
			for (CircularPatient p = this.nextPatient; p != start; p = p.nextPatient) {
				str += p.name;
				if (p.nextPatient != start) {
					str += ", ";
				}
			}
		}		
		return str;
	}
	
	public void deletePatient(String patientName) {
		CircularPatient start = this;
		if (start.nextPatient.name.equals(patientName)) {
			start.nextPatient = start.nextPatient.nextPatient;
			System.out.println("Patient " + patientName + " has been deleted.");
			return;
		} 
		for (CircularPatient p = this.nextPatient; p != start; p = p.nextPatient){
			if (p.nextPatient == start) {
				System.out.println("Patient " + patientName + " not found.");
				return;
			} else if (p.nextPatient.name.equals(patientName)) {
				p.nextPatient = p.nextPatient.nextPatient;
				System.out.println("Patient " + patientName + " has been deleted.");
				return;
			} 
		}
	}
}