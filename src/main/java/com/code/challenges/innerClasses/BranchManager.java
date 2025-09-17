package com.code.challenges.innerClasses;

import java.util.*;
import java.util.stream.Collectors;

public class BranchManager {

    private static Map<String, List<CustomerNested>> branches = new HashMap<>();

    public static void main(String[] args) {

        String branch1 = "branch1";
        String branch2 = "branch2";

        BranchManager.createBranch(branch1);
        BranchManager.createBranch(branch2);

        // Shipments
        CustomerNested.User.Shipment shipmentA = new CustomerNested.User.Shipment("111", "delivered");
        CustomerNested.User.Shipment shipmentB = new CustomerNested.User.Shipment("111", "delivered");

        // Address
        CustomerNested.User.Address adressA = new CustomerNested.User.Address("Street1", "city1", "zip");
        CustomerNested.User.Address adressB = new CustomerNested.User.Address("Street2", "city2", "zip");

        // Users for customer 1
        CustomerNested.User customer1UserA = new CustomerNested.User("Customer 1 User A", UUID.randomUUID().toString(), "1234", adressA, List.of(shipmentA));
        CustomerNested.User customer1UserB = new CustomerNested.User("Customer 1 User B", UUID.randomUUID().toString(), "5678", adressA, List.of(shipmentA));

        //
        CustomerNested customerNested1 = new CustomerNested(UUID.randomUUID().toString(), "Alice", "alice@email.com", CustomerNested.CustomerType.REGULAR,
                List.of(customer1UserA));
        CustomerNested customerNested2 = new CustomerNested(UUID.randomUUID().toString(), "Alice", "alice@email.com", CustomerNested.CustomerType.REGULAR,
                List.of(customer1UserB));
        CustomerNested customerNested3 = new CustomerNested(UUID.randomUUID().toString(), "Bob", "bob@email.com", CustomerNested.CustomerType.VIP, List.of());

        /*

         */
        createBranch(branch1);
        createBranch(branch2);

        addBranchCustomer(branch1, customerNested1, customerNested3);
        addBranchCustomer(branch2, customerNested2);

        displayBranchesData();
    }

    public static void displayBranchesData() {
        System.out.println();
        for (Map.Entry<String, List<CustomerNested>> branchMap : branches.entrySet()) {
            System.out.println(" - Branch == " + branchMap.getKey() + " ==");

            List<CustomerNested> customers = branchMap.getValue();

            int[] A = new int[]{1,2,3};
            List<Integer> tempList = Arrays.stream(A).boxed().toList();

            for(CustomerNested customer : customers) {
                System.out.println(" -- customer = " + customer.toString());
                System.out.println(" ->> Hashbcode: " + customer.hashCode());

                for (CustomerNested.User user : customer.getUsers()) {
                    System.out.println(" ---- user = " + user.toString());
                }
            }
            System.out.println();
        }
    }

    // Add Branch
    public static void createBranch(String branchName) {
        branches.put(branchName, new ArrayList<>());
    }

    // Add Customer
    public static void addBranchCustomer(String branchName, CustomerNested... customers) {
        //CustomerNested customerNested = new CustomerNested(id, UUID.randomUUID().toString(), email, customerType);

        List<CustomerNested> branchCustomers = branches.get(branchName);
        branchCustomers.addAll(Arrays.asList(customers));
    }


}
