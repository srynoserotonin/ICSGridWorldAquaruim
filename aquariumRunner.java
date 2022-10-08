package aquariumToniShabaltiy;

import java.util.Random;

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;

public class aquariumRunner {

	public static void main(String[] args) {

		Random rand = new Random();
		ActorWorld world = new ActorWorld(new BoundedGrid(23, 52));	// the bottom two rows need rocks 
		world.add(new Location(rand.nextInt(21), rand.nextInt(52)), new bottomFish());
		world.add(new Location(rand.nextInt(21), rand.nextInt(52)), new middleFish());		
		world.add(new Location(rand.nextInt(21), rand.nextInt(52)), new topFish());
		world.add(new Location(rand.nextInt(21), rand.nextInt(52)), new puffer());
		world.add(new flakes());
		for(int i = 0; i < 52; i++) {
			world.add(new Location(22, i), new Rock());
			world.add(new Location(21, i), new Rock());
		}
		world.show();
		
	}

}
