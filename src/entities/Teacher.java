package entities;

public class Teacher extends Employee {

	private String subject;

	public Teacher(String name, int identificationNumber, String hiringDate, String subject) {
		this.name = name;
		this.identificationNumber = identificationNumber;
		this.hiringDate = hiringDate;
		this.subject = subject;
	}

	public String getName() {
		return this.name;
	}

	public int getIdentificationNumber() {
		return identificationNumber;
	}

	public void setIdentificationNumber(int identificationNumber) {
		this.identificationNumber = identificationNumber;
	}

	public String getHiringDate() {
		return hiringDate;
	}

	public void setHiringDate(String hiringDate) {
		this.hiringDate = hiringDate;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "Teacher [subject=" + subject + ", identificationNumber=" + identificationNumber + ", hiringDate="
				+ hiringDate + ", name=" + name + ", getIdentificationNumber()=" + getIdentificationNumber()
				+ ", getHiringDate()=" + getHiringDate() + ", getSubject()=" + getSubject() + "]";
	}

}
