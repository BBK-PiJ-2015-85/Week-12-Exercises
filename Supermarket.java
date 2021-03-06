public class Supermarket implements PersonQueue {
	private Person head = null;
	
	public void insert(Person person) {
		if (head == null) {
			head = person;
		} else {
			person.setNext(head);
			head.setPrevious(person);			
			head = person;
		}
	}
	/**
	* Removes a person from the queue.
	*/
	public Person retrieve(){
		if (head == null) {
			return null;
		} else {
			Person current = head;
			while (current.getNext() != null) {
				current = current.getNext();
			}
			if (current.getPrevious() != null) {
				current.getPrevious().setNext(null);
				return current;
			} else {
				head = null;
				return current;
			}
		}
	}
	
	public void addPerson(Person newPerson) {
		insert(newPerson);
	}
	
	public void servePerson() {
		retrieve();
	}
	
	public int queueLength() {
		Person current = head;
		int count = 0;
		while (current != null) {
			count++;
			current = current.getNext();
		}
		return count;
	}
	
	public void launch() {
		Person p1 = new Person("Dave", 54);
		addPerson(p1);
		Person p2 = new Person("Tim", 34);
		addPerson(p2);
		System.out.println(queueLength());
		Person p3 = new Person("Ben", 23);
		addPerson(p3);
		Person p4 = new Person("Sam", 90);
		addPerson(p4);
		servePerson();
		servePerson();
		System.out.println(queueLength());
		Person p5 = new Person("Jim", 55);
		addPerson(p5);
		Person p6 = new Person("Dan", 13);
		addPerson(p6);
		Person p7 = new Person("Will", 87);
		addPerson(p7);
		System.out.println(queueLength());
		servePerson();
		servePerson();
		servePerson();
		servePerson();
		System.out.println(queueLength());	
		servePerson();
		System.out.println(queueLength());		
	}
	public static void main(String[] args) {
		Supermarket mySupermarket = new Supermarket();
		mySupermarket.launch();
	}
}