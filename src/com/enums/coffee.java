package com.enums;

enum coffeeSize{
    Big(10), Huge(20), Overwhelming(30);
    coffeeSize(int i){
        this.ounces = ounces;
    }
    public int ounces;
    public int getOunces(){
        return this.ounces;
    }
};



public class coffee {
    coffeeSize size;

    public static void main(String[] args) {
        coffee drink1 = new coffee();
        drink1.size = coffeeSize.Big;
        coffee drink2 = new coffee();
        drink2.size = coffeeSize.Huge;
        System.out.println(drink1.size.getOunces());
    }
}
