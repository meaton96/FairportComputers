package com.example.fairportcomputersservice;

public class Customer {

	private String name, phone, email, type, problem;
	private int number;
	public Customer(String n, String p, String e, String t, String pr, int num) {
		name = n;
		phone = p;
		email = e;
		type = t;
		problem = pr;
		number = num;
	}
	public String getName() { return name; }
	public String getPhone() { return phone; }
	public String getEmail() { return email; }
	public String getType() { return type; }
	public String getProblem() { return problem; }
	public int getNumber() { return number; }
	@Override
	public String toString()
	{
		return name + " " + number + phone + " " + email + " " + type + " " + problem;
	
	}
}
