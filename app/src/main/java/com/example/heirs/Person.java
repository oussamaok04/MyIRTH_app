package com.example.heirs;

import com.example.rules.InheritanceException;

public abstract class Person {
	
	private String gender;
	public static final String MALE = "Male";
	public static final String FEMALE = "Female";

	protected Person(String gender) {
		this.gender = gender;
	}
	
	public String getGender()
    {
        return this.gender;
    }

    public void setGender(String gender) throws InheritanceException
    {
        if(gender.equals(MALE) || gender.equals(FEMALE))
            this.gender = gender;
        else
            throw new InheritanceException("Gender must be either 'Male' or 'Female'");
    }
}
