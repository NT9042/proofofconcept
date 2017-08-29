package designPatterns;

import java.io.Serializable;

public class Person implements Serializable{
	protected Human human;

	public Human getHuman() {
		return human;
	}

	public void setHuman(Human human) {
		this.human = human;
	}
}
