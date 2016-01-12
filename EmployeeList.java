
public class EmployeeList {
    
	private Employee head;
	private Employee tail;
	

    public EmployeeList() {
		this.head = null;
		this.tail = null;
    }

    //add a Employee to list

    public void addEmployee(Employee newEmployee) {
		
		if (head == null) {
			head = newEmployee;
			tail = newEmployee;
		} else {
			Employee temp = head;
			while (temp.getNextEmployee() != null) {
				temp = temp.getNextEmployee();
			}		
            temp.setNextEmployee(newEmployee);
            newEmployee.setPreviousEmployee(temp);
			tail = newEmployee;
		}
    }

	
	
    //delete a Employee from list

    public boolean deleteEmployee(Employee employee) {
		Employee current = head;
		if (current.getValue().equals(employee.getValue())) {
			if (head.getNextEmployee() != null) {
				head = head.getNextEmployee();
				head.setPreviousEmployee(null);
				return true;
			} else {
				head = null;
				tail = null;
				return true;
			}			
		}
		while (current.getNextEmployee() != null) {
			if (current.getNextEmployee().getValue().equals(employee.getValue())) {
				if (current.getNextEmployee().getNextEmployee() != null) {
					current.setNextEmployee(current.getNextEmployee().getNextEmployee());
					current.getNextEmployee().setPreviousEmployee(current);
					return true;					
				} else {
					current.setNextEmployee(null);
					tail = current;
					return true;
				}				
			}
			current = current.getNextEmployee();
		}
		return false;
    }
	
	
	public String toString() {
		String str = "";
		if (head == null) {
			str += "Empty List";
		} else {
			Employee temp = head;
			do {
				str += temp.getValue();
				if (temp.getNextEmployee() != null) {
					str += ", ";
				}
				temp = temp.getNextEmployee();
			} while (temp != null);
		}		
		return str;
	}
	
	public String toStringBackwards() {
		String str = "";
		if (tail == null) {
			str += "Empty List";
		} else {
			Employee temp = tail;
			do {
				str += temp.getValue();
				if (temp.getPreviousEmployee() != null) {
					str += ", ";
				}
				temp = temp.getPreviousEmployee();
			} while (temp != null);
		}		
		return str;
	}

}