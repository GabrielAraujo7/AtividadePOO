package q1_JoaoGabrielNunes;

abstract class Vehicle {
	private String registrationNumber;
	
	public Vehicle(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

}
