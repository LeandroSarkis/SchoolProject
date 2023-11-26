package entities;

public class Director extends Employee {

	public Director(String name, int identificationNumber, String hiringDate) {
		this.name = name;
		this.identificationNumber = identificationNumber;
		this.hiringDate = hiringDate;
	}
	
	public Director(String name) {
		this.name = name;

	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	@Override
	public String toString() {
		return name;
	}
}
