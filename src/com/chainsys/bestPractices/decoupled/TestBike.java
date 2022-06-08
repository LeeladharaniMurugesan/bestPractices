package com.chainsys.bestPractices.decoupled;

public class TestBike {

	public static void main(String[] args) {
		PetrolEngine pe = new PetrolEngine();
		SteelWheel[] sWheels = new SteelWheel[2];
		sWheels[0] = new SteelWheel();
		sWheels[0].location = "front";
		sWheels[1] = new SteelWheel();
		sWheels[1].location = "back";
		
		Bike newBike = new Bike();
		newBike.setEngine(pe);
		newBike.setWheels(sWheels);
		newBike.startBike();
		
		DieselEngine de = new DieselEngine();
		WoodenWheel[] wWheels = new WoodenWheel[2];
		wWheels[0] = new WoodenWheel();
		wWheels[0].location = "front";
		wWheels[1] = new WoodenWheel();
		wWheels[1].location = "back";
		
		Bike secondBike = new Bike();
		secondBike.setEngine(de);
		secondBike.setWheels(wWheels);
		secondBike.startBike();
	}

}
