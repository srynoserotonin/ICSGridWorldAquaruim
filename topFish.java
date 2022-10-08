package aquariumToniShabaltiy;

import java.util.ArrayList;

import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class topFish extends bottomFish {

	// attributes
	
		
	
	// constructor
	
		public topFish() {
			super();
			top = true;
			middle = false;
			bottom = false;
		}
	
	// methods
	
//		@Override
//		public void move() {
//			super.move();
//			Location loc = getLocation();
//			Location next = loc.getAdjacentLocation(getDirection());
//			if(this.getLocation().getRow() >= 0 && this.getLocation().getRow() <= 7) {
//				moveTo(next);
//			}
//			else {
//				moveToTop();
//			}
//		}
		
		public ArrayList<Location> getMoveLocations(){
			ArrayList<Location> locs = new ArrayList<Location>();
			if(this.getLocation().getRow() >= 7) {
				int[] vertDown = {Location.NORTH};
				int[] zontDown = {Location.NORTH, Location.WEST, Location.EAST, Location.NORTHEAST, Location.NORTHWEST};
				for(Location loc : getLocationsInDirections(zontDown)) {
					if(getGrid().get(loc) == null) {
						locs.add(loc);
					}
				}
			}
			else {
				int[] vert = {Location.NORTH, Location.SOUTH};
				int[] zont = {Location.NORTH, Location.SOUTH, Location.WEST, Location.EAST, Location.NORTHEAST, Location.NORTHWEST, Location.SOUTHEAST, Location.SOUTHWEST};
				for(Location loc : getLocationsInDirections(vert)) {
					if(getGrid().get(loc) == null) {
						locs.add(loc);
					}
				}
			}
			return locs;
		}
		
		public ArrayList<Location> getLocationsInDirections(int[] directions){
			ArrayList<Location> locs = new ArrayList<Location>();
			Grid gr = getGrid();
			Location loc = getLocation();
			for(int d : directions) {
				Location neighborLoc = loc.getAdjacentLocation(getDirection() + d);
				if(gr.isValid(neighborLoc)) {
					 locs.add(neighborLoc);
				}
			}
			return locs;
		}

		private void moveToTop() {
			setDirection(Location.NORTH);
			move();
		}
	
}
