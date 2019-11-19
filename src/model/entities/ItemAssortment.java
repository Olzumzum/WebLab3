package model.entities;

/**
 * класс описывает компонент списка ассортимента продукции
 */
public class ItemAssortment {
    private String nameAssortment;

    public ItemAssortment(String nameAssortment) {
        this.nameAssortment = nameAssortment;
    }

    public String getNameAssortment() {
        return nameAssortment;
    }

    public void setNameAssortment(String nameAssortment) {
        this.nameAssortment = nameAssortment;
    }
}
