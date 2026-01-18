package assignments.factory_method.tiles;

import assignments.factory_method.Tile;

public class ForestTile implements Tile {
    @Override
    public char getCharacter() {
        return 'F';
    }

    @Override
    public String getType() {
        return "Forest";
    }

    @Override
    public void action() {
        System.out.println("You have entered a forest.");
    }

}
