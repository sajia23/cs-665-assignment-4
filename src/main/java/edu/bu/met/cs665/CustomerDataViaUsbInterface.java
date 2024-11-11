/**
 * Name: Shaohua Yue
 * Course: CS-665 Software Designs & Patterns
 * Date: 11/10/2024
 * File Name: CustomerDataViaUsbInterface.java
 * Description: This class is interface for adapter.
 */
package edu.bu.met.cs665;

public interface CustomerDataViaUsbInterface {
    void printCustomer(int customerId);
    Customer getCustomerViaUsb(int customerId);
}
