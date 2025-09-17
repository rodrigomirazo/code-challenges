package com.code.challenges.innerClasses;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

/*
Design and implement a system that calculates the final cart price after applying different promotions.

You are given:

A list of items (skuId, price, quantity).

A list of promotions (various types).

Types of promotions:

PercentageOffPromotion – e.g., “10% off SKU A”.

BuyXGetYPromotion – e.g., “Buy 2 of SKU A, get 1 SKU B free”.

SpendAndSavePromotion – e.g., “Spend $100, save $20”.

Implement a method:
double calculateFinalPrice(List<Item> items, List<Promotion> promotions);

that returns the total cart value after applying promotions.

You don’t have to cover every edge case, but your solution should be extensible for future promotion types.
*/

import java.util.ArrayList;
import java.util.List;

class Promotions {
    public static void main(String[] args) {

        List<Item> items = new ArrayList<>();
        items.add(new Item ("1", 100, 1));
        items.add(new Item ("2", 200, 2));
        items.add(new Item ("3", 300, 3));

        List<Promotion> promotions = new ArrayList<>();
        promotions.add(new PercentageOffPromotion());
        promotions.add(new PercentageOffPromotion());
        promotions.add(new PercentageOffPromotion());
    }

    public static class Item {
        public String skuId;
        public int price;
        public int quantity;

        public Item(String skuId, int price, int quantity) {
            this.skuId = skuId;
            this.price = price;
            this.quantity = quantity;
        }
    }
    //skuId, price, quantity

    interface Promotion {
        public int applyPromotion(Item item);
    }

    public static class PercentageOffPromotion implements Promotion {

        public int percentage = 10;

        // PercentageOffPromotion – e.g., “10% off SKU A”.
        public int applyPromotion(Item item) {

            return (item.price  * item.quantity) * (100 - percentage);
        }
    }

    //BuyXGetYPromotion – e.g., “Buy 2 of SKU A, get 1 SKU B free”.
    public class BuyXGetYPromotion implements Promotion {

        //PercentageOffPromotion – e.g., “10% off SKU A”.
        public int applyPromotion(Item item) {
          if(item.quantity > 2) {
            return item.price;
          }
          return item.price;
        }
    }

    //SpendAndSavePromotion – e.g., “Spend $100, save $20”.

    public class SpendAndSavePromotion implements Promotion {

        private int promotionApplyQuantity = 100;
        public int percentage = 10;

        public int applyPromotion(Item item, int promotionApplyQuantity) {

            int payment = item.price  * item.quantity;
            if(payment >= promotionApplyQuantity) {

                return payment * (100 - percentage);
            }

            return (item.price  * item.quantity);
        }

        @Override
        public int applyPromotion(Item item) {
            return 0;
        }
    }
}
