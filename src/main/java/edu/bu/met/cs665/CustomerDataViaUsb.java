/**
 * Name: Shaohua Yue
 * Course: CS-665 Software Designs & Patterns
 * Date: 11/10/2024
 * File Name: CustomerDataViaUsb.java
 * Description: This class is responsible for retrieving data from disk through usb port.
 */
package edu.bu.met.cs665;

public class CustomerDataViaUsb implements CustomerDataViaUsbInterface{

    Disk disk;

    private static volatile CustomerDataViaUsb cdu;

    /**
     * Construction method
     */
    private CustomerDataViaUsb() {
    }

    /**
     * Get a singleton instance.
     */
    public static CustomerDataViaUsb getInstance() {
        if(cdu == null) {
            synchronized (CustomerDataViaUsb.class) {
                if(cdu == null) {
                    cdu = new CustomerDataViaUsb();
                }
            }
        }
        return cdu;
    }

    /**
     * Set disk reference to the instance.
     * @param disk
     */
    public void setDisk(Disk disk) {
        this.disk = disk;
    }

    /**
     * Print customer information in the termianl.
     * @param customerId
     */
    @Override
    public void printCustomer(int customerId) {
        System.out.println(disk.readCustomer(customerId).getCustomerId() + disk.readCustomer(customerId).getCustomerName() + disk.readCustomer(customerId).getDescription());
    }

    /**
     * Get customer information from the disk.
     * @param customerId
     * @return
     */
    @Override
    public Customer getCustomerViaUsb(int customerId) {
        return disk.readCustomer(customerId);
    }
}
