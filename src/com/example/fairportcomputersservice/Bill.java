package com.example.fairportcomputersservice;

import java.util.ArrayList;

public class Bill {

	private int hours;
	private ArrayList<Part> parts;
	private static final int HOURLY_RATE = 60;
	
	public Bill(int hours, ArrayList<Part> parts)
	{
		this.hours = hours;
		this.parts = parts;
	}
	public double getCost()
	{
		double partCost = 0;
		for (Part p : parts) { partCost +=  p.getCost(); }
		return hours * HOURLY_RATE + partCost; 
	}
}
