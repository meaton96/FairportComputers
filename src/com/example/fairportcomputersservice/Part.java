package com.example.fairportcomputersservice;

public class Part {

	private String name;
	private double cost;
	private int number;
	
	public Part(String name, double cost, int number)
	{
		this.name = name;
		this.cost = cost;
		this.number = number;
	}
	public String getName() { return name; }
	public double getCost() { return cost; }
	public int getNumber() { return number; }
}
