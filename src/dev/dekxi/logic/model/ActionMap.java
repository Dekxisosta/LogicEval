package dev.dekxi.logic.model;

import java.util.HashMap;
import java.util.Map;

/*===============================
 * ACTION MAP MODEL / OBJECT
 *===============================*/
/**
 * A map that uses integers as indices and {@link Action} objects
 * as program operations
 *
 * <p><b>DEPENDENCIES</b></p>
 * <ul>
 *     <li> {@link java.util.HashMap} used for easier navigation by
 *         assigning key-value pairs </li>
 *     <li> {@link java.util.Map} to access subtype Hashmap </li>
 * </ul>
 */
public final class ActionMap {
    /*===============================
     * INSTANCE FIELDS
     *===============================*/
    /** Map used to store indexed actions for easier navigation*/
    private final Map<Integer, Action> actionMap = new HashMap<>();

    /** Public constructor for instantiation */
    public ActionMap() {}

    /*===============================
     * EXPOSED API / PUBLIC METHODS
     *===============================*/
    /**
     * Stores an action in actionMap together with its index serving as the key.
     * If the num parameter is already contained within the actionMap, it does
     * not perform put
     *
     * @param num the index used for navigating
     * @param action the action performed {@link Action}
     */
    public void put(int num, Action action) {
        if(!actionMap.containsKey(num))
            actionMap.put(num, action);
    }

    /**
     * Returns the held action of the given key <p></p>
     * @param num the index used for navigating
     * @return {@link Action} the action performed
     */
    public Action get(int num) {return actionMap.get(num);}

    /**
     * Returns all the available action names in actionMap <p></p>
     * @return names
     */
    public String[] getActionNames() {
        int size = actionMap.size();
        String[] names = new String[size];

        for(int i=0; i<size;i++)
            names[i] = get(i).getName();

        return names;
    }

    /**
     * Runs the Runnable method of the action inside actionMap <p></p>
     * @param choice the index of the action to be performed
     */
    public void perform(int choice) {get(choice).run();}
}