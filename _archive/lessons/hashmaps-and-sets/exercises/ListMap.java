public class ListMap {
    private List<String> keys;
    private List<Integer> values;

    public ListMap(){
        keys = new ArrayList();
        values = new ArrayList();
    }

    /**
     * Adds or replaces an element to the "map" by changing the keys and values columns.
     * @param keys
     *   The array of keys in the "map".
     * @param values
     *   The array of values in the "map".
     * @param key
     *   The key to add or replace in the map.
     * @param value
     *   The value associated with the key.
     */
    public static void put(String key, int value) {
        // FIXME: Write this method!
    }

    /**
     * Gets the value from the "map" associated with a key.
     * @param keys
     *   The array of keys in the "map".
     * @param values
     *   The array of values in the "map".
     * @param key
     *   The key to look up.
     * @return
     *   The value associated with the key, or null if the key is not in the "map".
     */
    public static Integer get(String key) {
        // FIXME: Write this method!
        return null;
    }

    /**
     * Removes a key and value from the "map", if it is present.
     * @param keys
     *   The array of keys in the "map".
     * @param values
     *   The array of values in the "map".
     * @param key
     *   The key to remove.
     * @return
     *   The value that was associated with the key, or null if the key was not in the "map".
     */
    public static Integer remove(String key) {
        // FIXME: Write this method!
        return null;
    }

    public static void main(String[] args) {
        // Create the empty keys and values columns.
        ArrayList<String> keys = new ArrayList<String>();
        ArrayList<Integer> values = new ArrayList<Integer>();
        // Fill in values.
        put("Neptune", 14);
        put("Uranus", 27);
        put("Saturn", 62);
        put("Jupiter", 67);
        put("Mars", 2);
        put("Earth", 14);
        put("Moon", 0);
        put("Venus", 0);
        put("Mercury", 0);
        put("Sun", 8);
        put("Pluto", 5);
        // Oops!  The sun and moon aren't planets.
        remove("Sun");
        remove("Moon");
        // Oops!  Wrong value for Earth; fix it.
        put("Earth", 1);
        // Oops!  Pluto isn't a planet anymore.
        remove("Pluto");

        // Run some tests.  If everything is working, each test should print true.
        Integer num;
        num = get("Sun");
        System.out.println("Sun is missing:       " + (num == null));
        num = get("Mercury");
        System.out.println("Mercury has 0 moons:  " + (num != null && num == 0));
        num = get("Earth");
        System.out.println("Earth has 1 moons:    " + (num != null && num == 1));
        num = get("Moon");
        System.out.println("Moon is missing:      " + (num == null));
        num = get("Saturn");
        System.out.println("Saturn has 62 moons:  " + (num != null && num == 62));
        num = get("Neptune");
        System.out.println("Neptune has 14 moons: " + (num != null && num == 14));
        num = get("Pluto");
        System.out.println("Pluto is missing:     " + (num == null));
    }
}
