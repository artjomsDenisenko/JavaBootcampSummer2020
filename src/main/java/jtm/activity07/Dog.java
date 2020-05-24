package jtm.activity07;

import java.util.regex.*;

public class Dog extends Mammal {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		Pattern pattern = Pattern.compile("[A-Z][a-z]*");
		Matcher matcher = pattern.matcher(name);
		if(matcher.find()) {
			this.name = name;
		}else {
			this.name = "";
		}	

	}
	
}
