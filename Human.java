package designPatterns;

import java.io.Serializable;

public class Human extends Animal implements Serializable{

	public Human(String nameOfHuman) {
		super();
		this.nameOfHuman = nameOfHuman;
	}

	private String nameOfHuman;

	public String getNameOfHuman() {
		return nameOfHuman;
	}

	public void setNameOfHuman(String nameOfHuman) {
		this.nameOfHuman = nameOfHuman;
	}
}
