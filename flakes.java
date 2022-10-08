package aquariumToniShabaltiy;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class flakes extends Critter {

	// attribute
	
		public boolean falling;
		public int direction;
		private Random rand;
	
	// constructor
		
		public flakes() {
			rand = new Random();
			falling = true;
			direction = rand.nextInt(1);
			setColor(new Color(119, 72, 9));
		}
	
	// methods
		
		public ArrayList<Location> getMoveLocations(){
			ArrayList<Location> locs = new ArrayList<Location>();
			int[] dirs = {Location.SOUTHWEST, Location.SOUTHEAST};
			for(Location loc : getLocationsInDirections(dirs)) {
				if(getGrid().get(loc) == null) {
					locs.add(loc);
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
	
}
