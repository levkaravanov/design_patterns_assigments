package assignments.factory_method.tiles;

import assignments.factory_method.Tile;

public class WaterTile implements Tile {
    @Override
    public char getCharacter() {
        return 'W';
    }

    @Override
    public String getType() {
        return "Water";
    }

    @Override
    public void action() {
        System.out.println("You have entered a water tile.");
    }

}
