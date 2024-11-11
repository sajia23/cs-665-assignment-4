/**
 * Name: Shaohua Yue
 * Course: CS-665 Software Designs & Patterns
 * Date: 11/10/2024
 * File Name: CustomerDataViaHttpsInterface.java
 * Description: This class is interface of CustomerDataViaHttps.
 */
package edu.bu.met.cs665;

public interface CustomerDataViaHttpsInterface {
    void printCustomer(int customerId);
    Customer getCustomerViaHttps(int customerId);
}
