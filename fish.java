package aquariumToniShabaltiy;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import info.gridworld.actor.*;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class fish extends Critter {

	// attributes
	
		/*
		 * boolean gender, isAlive, isHungy
		 * int lifeSpan
		 * random
		 */
	
		public boolean gender, isAlive, alive, top, middle, bottom;
		public int lifeSpan, life, hunger;
		private Random rand;
	
	// constructor
		
		public fish() {
			Random rand = new Random();
			isAlive = true;
			hunger = 100;
			alive = true;
			lifeSpan = rand.nextInt(201) + 50;
			life = 0;
			top = false;
			middle = false;
			bottom = false;
		}

	// methods

		public boolean isAlive() {
			return alive;
		}

		public void setAlive(boolean isAlive) {
			this.isAlive = alive;
			for(int i = 0; i < lifeSpan; i++) {
				life++;
				hunger -= rand.nextInt(5);
			}
			if(life >= lifeSpan) {
				this.alive = false;
			}
		}

		public int getHunger() {
			return hunger;
		}

		public void setHunger() {
			this.hunger = hunger;
			if(hunger <= 0) {
				this.alive = false;
			}
			if(hunger <= 25) {
				life -= rand.nextInt(3);
			}
		}

		public int getLifeSpan() {
			return lifeSpan;
		}

		public void setGender(boolean gender) {
			this.gender = gender;
			if(rand.nextInt(1) == 0) {			
				gender = true;	// male
			}
			else if(rand.nextInt(1) == 1) {
				gender = false;		// female
			}
		}
		
		public void creation(fish other) {
			if(this.gender != other.gender && rand.nextInt(3) == 1) {
				//eggs();	// talk to young how to spawn eggs with this method when eggs is its own class
			}
		}
		
		public void assignFish() {
			int prob = rand.nextInt(2);
			if(prob == 0) {
				top = true;
				setColor(Color.green);
				setGender(gender);
			}
			else if(prob == 1) {
				middle = true;
				setColor(Color.red);
				setGender(gender);
			}
			else if(prob == 2) {
				bottom = true;
				setColor(Color.gray);
				setGender(gender);
			}
		}
		
		public void move() {
	        Grid<Actor> gr = getGrid();
	        if (gr == null) {
	            return;
	        }
	        Location loc = getLocation();
	        Location next = loc.getAdjacentLocation(getDirection());
	        if (gr.isValid(next)) {
	            moveTo(next);
	        }
//	        else {
//	            removeSelfFromGrid();
//	        }
	    }
		
		public void eat(ArrayList<Actor> actors) {
			if(this.hunger <= 75){
				for(Actor a : actors) {
					if(a instanceof flakes) {
						a.removeSelfFromGrid();
						this.hunger += rand.nextInt(21) + 5;
					}
				}
			}
		}
		
		@Override
		public void act() {
			super.act();
		}
	
}

















