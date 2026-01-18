package assignments.factory_method.tiles;

import assignments.factory_method.Tile;

public class BuildingTile implements Tile {
    @Override
    public char getCharacter() {
        return 'B';
    }

    @Override
    public String getType() {
        return "Building";
    }

    @Override
    public void action() {
        System.out.println("You have entered a building.");
    }

}
