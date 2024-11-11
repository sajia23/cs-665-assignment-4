/**
 * Name: Shaohua Yue
 * Course: CS-665 Software Designs & Patterns
 * Date: 11/10/2024
 * File Name: ExternalServer.java
 * Description: This class is responsible for storing customer data to server.
 */
package edu.bu.met.cs665;

import java.util.HashMap;
import java.util.Map;

public class ExternalServer {
    Map<Integer, Customer> database;

    private static volatile ExternalServer e;

    /**
     * Construction method
     */
    private ExternalServer() {
        this.database = new HashMap<>();
    }

    /**
     * Get a singleton instance.
     */
    public static ExternalServer getInstance() {
        if(e == null) {
            synchronized (ExternalServer.class) {
                if(e == null) {
                    e = new ExternalServer();
                }
            }
        }
        return e;
    }

    /**
     * Get a customer from the server.
     * @param customerId
     * @return
     */
    public Customer readCustomer(Integer customerId) {
        return database.get(customerId);
    }

    /**
     * Write a customer into the database.
     * @param customer
     */
    public void writeCustomer(Customer customer) {
        database.put(customer.getCustomerId(), customer);
    }
}
