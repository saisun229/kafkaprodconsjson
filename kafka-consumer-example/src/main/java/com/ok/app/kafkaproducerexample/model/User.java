package com.ok.app.kafkaproducerexample.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import com.fasterxml.jackson.annotation.JsonProperty;

@EntityScan
	public class User {

	  

		private String name;
	    private String dept;
	    private int salary;
	    
	    

	    public User() {
			super();
			// TODO Auto-generated constructor stub
		}

		public User(
	    		@JsonProperty("name")	String name, 
	    		@JsonProperty("dept")	String dept,
	    		@JsonProperty("salary")	int salary) {
	    	
	        this.name = name;
	        this.dept = dept;
	        this.salary = salary;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getDept() {
	        return dept;
	    }

	    public void setDept(String dept) {
	        this.dept = dept;
	    }

	    public int getSalary() {
	        return salary;
	    }

	    public void setSalary(int salary) {
	        this.salary = salary;
	    }
	    
	
	
	
	
	
	    @Override
	  		public String toString() {
	  			return "User [name=" + name + ", dept=" + dept + ", salary=" + salary + "]";
	  		}
	
	
	
	
	
}
