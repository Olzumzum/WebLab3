package model.entities;

import java.io.Serializable;

/**
 * Класс описывает поля и методы единичного компонента продукции
 */

public class ItemProduct implements Serializable {
    private int mIdProduct;
    private String mProductName;
    private String mProductDescription;
    private byte[] mProductImage;
    private int mWeight;
    private int mPrice;

    public ItemProduct(){

    }

    public ItemProduct(String mProductName, String mProductDescription, byte[] mProductImage, int mWeight, int mPrice) {
        this.mProductName = mProductName;
        this.mProductDescription = mProductDescription;
        this.mProductImage = mProductImage;
        this.mWeight = mWeight;
        this.mPrice = mPrice;
    }


    public int getmIdProduct() {
        return mIdProduct;
    }

    public void setmIdProduct(int mIdProduct) {
        this.mIdProduct = mIdProduct;
    }

    public String getmProductName() {
        return mProductName;
    }

    public void setmProductName(String mProductName) {
        this.mProductName = mProductName;
    }

    public String getmProductDescription() {
        return mProductDescription;
    }

    public void setmProductDescription(String mProductDescription) {
        this.mProductDescription = mProductDescription;
    }

    public byte[] getmProductImage() {
        return mProductImage;
    }

    public void setmProductImage(byte[] mProductImage) {
        this.mProductImage = mProductImage;
    }

    public int getmWeight() {
        return mWeight;
    }

    public void setmWeight(int mWeight) {
        this.mWeight = mWeight;
    }

    public int getmPrice() {
        return mPrice;
    }

    public void setmPrice(int mPrice) {
        this.mPrice = mPrice;
    }
}
