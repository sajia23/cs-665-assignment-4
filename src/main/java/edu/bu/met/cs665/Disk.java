/**
 * Name: Shaohua Yue
 * Course: CS-665 Software Designs & Patterns
 * Date: 11/10/2024
 * File Name: Disk.java
 * Description: This class is responsible for storing customer data to disk.
 */
package edu.bu.met.cs665;

import java.util.HashMap;
import java.util.Map;

public class Disk {
    Map<Integer, Customer> binaryFiles;

    private static volatile Disk d;

    /**
     * Construction method
     */
    private Disk() {
        this.binaryFiles = new HashMap<>();
    }

    /**
     * Get a singleton instance.
     */
    public static Disk getInstance() {
        if(d == null) {
            synchronized (Disk.class) {
                if(d == null) {
                    d = new Disk();
                }
            }
        }
        return d;
    }

    /**
     * Get customer from disk by customer id.
     * @param customerId
     * @return
     */
    public Customer readCustomer(Integer customerId) {
        return binaryFiles.get(customerId);
    }

    /**
     * Write a customer into the disk.
     * @param customer
     */
    public void writeCustomer(Customer customer) {
        binaryFiles.put(customer.getCustomerId(), customer);
    }
}
