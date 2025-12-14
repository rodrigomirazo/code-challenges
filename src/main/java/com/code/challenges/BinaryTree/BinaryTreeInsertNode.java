package com.code.challenges.BinaryTree;

public class BinaryTreeInsertNode {

    static void main() {

        BinaryTreeInsertNode bin = new BinaryTreeInsertNode();
        bin.new Item("1", 1.0, 2);

        Offer50Percent offer50 = new Offer50Percent();
        offer50.getOffer(bin.new Item("1", 1.0, 2));
    }

    class Item {

        String sku;
        double price;
        int quantity;

        public Item(String sku, double price, int quantity) {
            this.sku = sku;
            this.price = price;
            this.quantity = quantity;
        }
    }

    static public abstract class GenericOffer {

        public void getOffer(Item item) {
            System.out.println("hi");
        }
    }

    static class Offer50Percent extends GenericOffer {

        @Override
        public void getOffer(Item item) {
            System.out.println("50 percent offer");
        }
    }
}
