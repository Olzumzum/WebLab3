package model.entities;

public class ItemProduct {
    private String mProductName;
    private String mProductDescription;
    private byte[] mProductImage;
    private int mWeight;
    private int mPrice;

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
