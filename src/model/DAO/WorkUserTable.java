package model.DAO;

import model.User;

public interface WorkUserTable {
    /**
     * Search for a record in a database with the same parameters
     * Returns true if such a record exists
     * Returns false if no entry
     * @param user
     * @return
     */
    boolean searchUserInTable(User user);

    /**
     * Adding a record to the user table
     * @param user
     */
    void insetUserRecord(User user);
}
