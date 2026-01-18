package assignments.factory_method.maps;

import assignments.factory_method.Map;
import assignments.factory_method.Tile;
import assignments.factory_method.tiles.BuildingTile;
import assignments.factory_method.tiles.ForestTile;
import assignments.factory_method.tiles.RoadTile;

import java.util.Random;

public class CityMap extends Map {
    private final Random random = new Random();

    public CityMap(int width, int height) {
        super(width, height);
    }

    @Override
    protected Tile createTile() {
        int pick = random.nextInt(3);
        switch (pick) {
            case 0:
                return new RoadTile();
            case 1:
                return new ForestTile();
            default:
                return new BuildingTile();
        }
    }
}
