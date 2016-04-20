package com.epam.training.sprinkler.domain;

public class Zone {

	private int id;
	private String name;
	private double consumption;

	public Zone() {
    }

	public Zone(int id, String name, double consumption) {
        this.id = id;
        this.name = name;
        this.consumption = consumption;
    }

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getConsumption() {
		return consumption;
	}

	public void setConsumption(double consumption) {
		this.consumption = consumption;
	}

}
