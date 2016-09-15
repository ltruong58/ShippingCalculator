package com.example.longtruong.ltruong58.shippingcalculator;

/**
 * Represents information for a shipping bill including all calculator.
 * @author Long Truong
 */
public class ShipItem {

    // Define constants
    public static final  double BASE_COST = 3.00;
    public static final  double ADDED_CHARGE = 0.50;
    public static final  int BASE_WEIGHT = 16;

    private int mWeight;
    private double mBaseCost;
    private double mAddedCost;
    private double mTotalCost;

    public ShipItem(){
        mWeight = 0;
        mBaseCost = BASE_COST;
        mAddedCost = 0;
        mTotalCost = BASE_COST;
    }

    public ShipItem(int weight, double addedCost, double totalCost) {
        this.mWeight = weight;
        this.mBaseCost = BASE_COST;
        this.mAddedCost = addedCost;
        this.mTotalCost = totalCost;
    }

    public int getWeight() {
        return mWeight;
    }

    public double getBaseCost() {
        return mBaseCost;
    }

    public double getAddedCost() {
        return mAddedCost;
    }

    public double getTotalCost() {
        return mTotalCost;
    }

    public void setWeight(int mWeight) {
        this.mWeight = mWeight;
        reCalculateCost();
    }

    private void reCalculateCost()
    {
        if(mWeight <= 16){
            mAddedCost = 0;
        }
        else{
            mAddedCost = ADDED_CHARGE * Math.ceil((double)(mWeight - 16) / 4);
        }
        mTotalCost = mBaseCost + mAddedCost;
    }
}
