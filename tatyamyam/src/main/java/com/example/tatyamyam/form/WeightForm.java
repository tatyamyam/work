package com.example.tatyamyam.form;

import com.example.tatyamyam.entity.Health;
import com.example.tatyamyam.entity.Weight;

public class WeightForm {
	
	private Health health;
	private double value;
	
	
	public Health getHealth() {
        return health;
    }

    public void setHealth(Health health) {
        this.health = health;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Weight toWeight() {
        Weight weight = new Weight();
        weight.setValue(this.value);
        weight.setHealth(this.health);
        // 他にも必要なフィールドがあればここで設定する
        return weight;
    }
    
	private int weight;
	
	public int getWeight() {
		return weight;
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
	}

}
