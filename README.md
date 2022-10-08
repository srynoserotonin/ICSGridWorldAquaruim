# ICSGridWorldAquaruim

Use these files to be the updated codex

for TAZ

TAZ Fish Tank- Difficulty Rating: 10 stars
For this project, you need to create six kinds of GridWorld actors. All actors must have graphics 
specific to their type:

    Flakes and Algae
        A Flake will randomly spawn in the top row of the grid. The flake always
        moves down either southwest or southeast in direction. If the space below the flake is occupied,
        or would be off of the grid, the Flake will turn into an Algae (a green Flower). Algae will have a
        one in fifteen chance of spreading to an unoccupied adjacent location.
        
    Puffer
        The puffer needs to only face East and West but can move in all directions. The puffer
        has a 25% chance of not moving each turn. If the puffer has an actor directly in front of the
        direction it is facing, it will puff up (fill all adjacent locations with puffed actors, any actor in
        those locations are pushed 3-5 spaces away). After five steps the puffed actors are removed and
        the Puffer returns to normal. Puffers will eat Flakes, Algae, or Eggs and try to swim toward them
        if they are within a distance of 5. Puffers are always the color yellow.
        
    Snail
        The snail moves by placing a front segment in the space it is facing. On the next step it
        moves on top of the front segment and waits a step before it places another front segment.
        Snails move straight if they can expect for a one in fifteen chance that they turn. Snails eat Algae
        and will move generally toward Algae if it is present. If a Snail eats ten Algae it will have a 50%
        chance of laying three eggs. The eggs will wait 25 steps and then release three snails each
        before removing themselves from the grid. Snails only live for 75-100 steps before they remove
        themselves from the gid.
        
    Fish
        The fish is spawned as either a top, middle, or bottom fish. The fish will move only within
        the zone of the tank that they are spawned as, so a top fish can only move in the top third of the
        grid (find the number of rows in the grid). Top fish will be color green, middle will be color red,
        and bottom will be color brown. Fish will also be assigned a random boolean at birth. If a true
        finds a false of the same type, the false will go to the edge of the grid and lay three eggs. The
        eggs will wait 25 steps and then release three fish each before removing themselves from the
        grid. Fish will eat Flakes and try to swim toward them if they are in the same zone. Fish only live
        for 100-150 steps before they remove themselves from the gid.
        
        
(for typos blame doc copied from doc written by RDY)
