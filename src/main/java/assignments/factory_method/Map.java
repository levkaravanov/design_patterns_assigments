package assignments.factory_method;

public abstract class Map {
    protected final int width;
    protected final int height;

    protected Map(int width, int height) {
        this.width = width;
        this.height = height;
    }

    protected abstract Tile createTile();

    public void display() {
        for (int y = 0; y < height; y++) {
            StringBuilder row = new StringBuilder();
            for (int x = 0; x < width; x++) {
                Tile tile = createTile();
                row.append(tile.getCharacter());
            }
            System.out.println(row);
        }
    }
}
