package assignments.factory_method.tiles;

import assignments.factory_method.Tile;

public class SwampTile implements Tile {
    @Override
    public char getCharacter() {
        return 'S';
    }

    @Override
    public String getType() {
        return "Swamp";
    }

    @Override
    public void action() {
        System.out.println("You have entered a swamp.");
    }

}
