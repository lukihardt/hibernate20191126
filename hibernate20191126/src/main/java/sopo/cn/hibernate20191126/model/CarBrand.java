package sopo.cn.hibernate20191126.model;

public class CarBrand {
	public CarBrand() {
		super();
	}

	public CarBrand(String brand, int maxSpeed, double speed0100) {
		super();
		this.brand = brand;
		this.maxSpeed = maxSpeed;
		this.speed0100 = speed0100;
	}

	private String id;
	private String brand;
	private int maxSpeed;
	private double speed0100;

	public void setId(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public double getSpeed0100() {
		return speed0100;
	}

	public void setSpeed0100(double speed0100) {
		this.speed0100 = speed0100;
	}
}
