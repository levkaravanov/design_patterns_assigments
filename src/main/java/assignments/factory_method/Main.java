package assignments.factory_method;

import assignments.factory_method.maps.CityMap;
// import assignments.factory_method.maps.WildernessMap;

public class Main {

    public static void main(String[] args) {
        Map map = new CityMap(10, 5);
        // Map map = new WildernessMap(10, 5);

        map.display();
    }
}
