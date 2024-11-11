/**
 * Name: Shaohua Yue
 * Course: CS-665 Software Designs & Patterns
 * Date: 11/10/2024
 * File Name: Customer.java
 * Description: This class is the data stored into disk or server.
 */
package edu.bu.met.cs665;

public class Customer {
    Integer customerId;
    String customerName;
    String description;

    /**
     * Construction method
     */
    public Customer(Integer customerId, String customerName, String description) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.description = description;
    }

    /**
     * Get customer Id
     */
    public Integer getCustomerId() {
        return customerId;
    }

    /**
     * Set customer Id
     */
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    /**
     * Get customer Name
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * Set customer Name
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * Get customer description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set customer description
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
