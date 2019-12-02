package model.DAO;

import java.util.List;

/**
 *Functions of classes that work with product tables
 */
interface WorkListProduct {
    /**
     * get all table items
      * @return List
     */
    List getAllCakes();
    /** get records by one assortment criterion */
    List getCakesAssortmentCriterion(String criterion);

}
