package aquariumToniShabaltiy;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class puffer extends fish {

	// attributes
	
		public boolean puffed;
		private Random rand;
	
	// constructor
	
		public puffer() {
			super();
			puffed = false;
			setColor(new Color(255, 255, 204));
			rand = new Random();
		}
	
	// methods
		
		@Override
		public void processActors(ArrayList<Actor> actors) {
			for(Actor a : actors) {
				if(!(a instanceof puffer) && !(a instanceof Rock)) {
					// puff();
					// System.out.println("they close");
				}
			}
		}
		
//		public void puff() {
//			for(Location innerLoc : getGrid().getEmptyAdjacentLocations(getLocation())) {
//				new Rock().putSelfInGrid(getGrid(), innerLoc);
//				for(int i = 0; i < 4; i++) {
//					new Rock().removeSelfFromGrid();
//				}
//			}
//		}
		
		public boolean canMove() {
	        Grid<Actor> gr = getGrid();
	        if (gr == null) {
	            return false;
	        }
	        Location loc = getLocation();
	        Location next = loc.getAdjacentLocation(getDirection());
	        if (!gr.isValid(next)) {
	            return false;
	        }
	        Actor neighbor = gr.get(next);
	        return (neighbor == null) || (neighbor instanceof Flower);
	    }
		
		@Override
		public void move() {
			if(canMove()) {
				if(rand.nextInt(1) == 0) {
					setDirection(Location.EAST);
				}
				else if(rand.nextInt(1) == 1){
					setDirection(Location.WEST);
				}
			}
			dontMove();
			super.move();
		}
		
		public void dontMove() {
			if(rand.nextInt(3) == 1) {
				moveTo(getLocation());
			}
		}
	
}

















