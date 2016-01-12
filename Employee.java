public class Employee<T> {
	private T value;
    private Employee nextEmployee;
    private Employee previousEmployee;
	
	public Employee(T value) {
		this. value = value;
		this.nextEmployee = null;
		this.previousEmployee = null;
	}
	
	public T getValue() {
        return value;
    }

    public Employee getNextEmployee() {
        return nextEmployee;
    }
	
	public void setNextEmployee(Employee nextEmployee) {
		this.nextEmployee = nextEmployee;
	}

    public Employee getPreviousEmployee() {
        return previousEmployee;
    }

    public void setPreviousEmployee(Employee previousEmployee) {
        this.previousEmployee = previousEmployee;
    }

}