/**
 * Name: Shaohua Yue
 * Course: CS-665 Software Designs & Patterns
 * Date: 11/10/2024
 * File Name: CustomerDataProxyInterface.java
 * Description: This class is interface of CustomerDataProxy.
 */
package edu.bu.met.cs665;

public interface CustomerDataProxyInterface {
    void printCustomer(int customerId);
    Customer getCustomer(int customerId);
}
