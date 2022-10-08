package aquariumToniShabaltiy;

import java.util.Random;

import info.gridworld.actor.*;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class eggs extends Flower {

	// attributes
	
		/*
		 *  location 
		 *  spawn 
		 *  random
		 *  
		 */
	
		private Random rand;
		public int spawn;
	
	// constructor
	
		public eggs() {
			Random rand = new Random();
			spawn = rand.nextInt(6);
		}
		
	// methods
		
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
	        for(int i = 0; i < 25; i++) {
	        	if(i == 25) {
	        		hatch();
	        	}
	        }
	    }

		public void hatch() {
			for(int i = 0; i <= rand.nextInt(5); i++) {
				fish guppy = new fish();
			}
		}
	
}
