package com.github.kisiel365.day20;

public class Particle {
	private final int id;
	private Vector position;
	private Vector velocity;
	private Vector acceleration;

	public Particle(int id, Vector position, Vector velocity, Vector acceleration) {
		this.id = id;
		this.position = position;
		this.velocity = velocity;
		this.acceleration = acceleration;
	}

	public int getId() {
		return id;
	}

	public Vector getPosition() {
		return position;
	}

	public Vector getVelocity() {
		return velocity;
	}

	public Vector getAcceleration() {
		return acceleration;
	}

	public void tick() {
		velocity.apply(acceleration);
		position.apply(velocity);
	}

}
