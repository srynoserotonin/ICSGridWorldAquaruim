package aquariumToniShabaltiy;

import java.util.ArrayList;

import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class middleFish extends bottomFish {

	// attributes
	
	// constructor
	
		public middleFish() {
			super();
			top = false;
			middle = true;
			bottom = false;
		}
	
	// methods 
	
//		@Override
//		public void move() {
//			super.move();
//			Location loc = getLocation();
//			Location next = loc.getAdjacentLocation(getDirection());
//			if(this.getLocation().getRow() >= 7 && this.getLocation().getRow() < 14) {
//				moveTo(next);
//			}
//			else if(this.getLocation().getRow() < 7){
//				moveDownToMiddle();
//			}
//			else if(this.getLocation().getRow() >= 14) {
//				moveUpToMiddle();
//			}
//		}
//
//		private void moveUpToMiddle() {
//			setDirection(Location.NORTH);
//			move();
//		}
//
//		private void moveDownToMiddle() {
//			setDirection(Location.SOUTH);
//			move();
//		}
		
		public ArrayList<Location> getLocationsInDirections(int[] directions) {
	        ArrayList<Location> locs = new ArrayList<Location>();
	        Grid<Actor> gr = getGrid();
	        Location loc = getLocation();
	        for (int d : directions) {
	            Location neighborLoc = loc.getAdjacentLocation(getDirection() + d);
	            if (gr.isValid(neighborLoc))
	                locs.add(neighborLoc);
	        }
	        return locs;
	    }
		
		@Override
		public ArrayList<Location> getMoveLocations() {
			ArrayList<Location> locs = new ArrayList<Location>();
			if(this.getLocation().getRow() <= 7) {
				int[] vertDown = {Location.SOUTH};
				int[]zontDown = {Location.SOUTH,Location.WEST, Location.EAST,  Location.SOUTHEAST, Location.SOUTHWEST};
				for (Location loc : getLocationsInDirections(zontDown)) {
					if (getGrid().get(loc) == null) {
						locs.add(loc);
			        }
				}
			}
			else if(this.getLocation().getRow() >= 14 ) {
				int[] vertUp = {Location.NORTH};
		        int[] zontUp = {Location.NORTH, Location.WEST, Location.EAST, Location.NORTHEAST, Location.NORTHWEST};
		        for(Location loc : getLocationsInDirections(zontUp)) {
		        	if(getGrid().get(loc) == null) {
		        		locs.add(loc);
			        }
		        }
			}
			else {
				int[] vert = {Location.NORTH, Location.SOUTH};
				int[] zont = {Location.NORTH, Location.SOUTH, Location.WEST, Location.EAST, Location.NORTHEAST, Location.NORTHWEST, Location.SOUTHEAST, Location.SOUTHWEST};
				for (Location loc : getLocationsInDirections(zont)) {
					if (getGrid().get(loc) == null) {
						locs.add(loc);
		            }
		        }
			}
			
			return locs;
		           
			}

		
		

		
}
