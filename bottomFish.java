package aquariumToniShabaltiy;

import java.util.ArrayList;

import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class bottomFish extends fish {

	// attributes
	
	// constructor
	
		public bottomFish() {
			super();
			top = false;
			middle = false;
			bottom = true;
		}
	
	// methods
		
//		@Override
//		public void move() {
//			super.move();
//			Location loc = getLocation();
//			Location next = loc.getAdjacentLocation(getDirection());
//			if(this.getLocation().getRow() <= 14 && this.getLocation().getRow() >= 21) {
//				moveTo(next);
//			}
//			else {
//				moveToBottom();
//			}
//		}
		
		public ArrayList<Location> getMoveLocations(){
			ArrayList<Location> locs = new ArrayList<Location>();
			if(this.getLocation().getRow() <= 14 || this.getLocation().getRow() >= 21) {
				int[] vertDown = {Location.SOUTH};
				int[] zontDown = {Location.SOUTH, Location.WEST, Location.EAST, Location.SOUTHEAST, Location.SOUTHWEST};
				for(Location loc : getLocationsInDirections(zontDown)) {
					if(getGrid().get(loc) == null) {
						locs.add(loc);
					}
				}
			}
			else {
				int[] vert = {Location.NORTH, Location.SOUTH};
				int[] zont = {Location.NORTH, Location.SOUTH, Location.WEST, Location.EAST, Location.NORTHEAST, Location.NORTHWEST, Location.SOUTHEAST, Location.SOUTHWEST};
				for(Location loc : getLocationsInDirections(zont)) {
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

//		private void moveToBottom() {
//			setDirection(Location.SOUTH);
//			move();
//		}
	
}
