/**
 * Name: Shaohua Yue
 * Course: CS-665 Software Designs & Patterns
 * Date: 11/10/2024
 * File Name: HttpsToCustomerDataViaUsbAdapter.java
 * Description: This class is the adapter for retrieving data from usb.
 */
package edu.bu.met.cs665;

public class HttpsToCustomerDataViaUsbAdapter implements CustomerDataViaHttpsInterface{

    CustomerDataViaUsb customerDataViaUsb;

    private static volatile HttpsToCustomerDataViaUsbAdapter hcdu;

    /**
     * Construction method
     */
    private HttpsToCustomerDataViaUsbAdapter() {
    }

    /**
     * Get a singleton instance.
     */
    public static HttpsToCustomerDataViaUsbAdapter getInstance() {
        if(hcdu == null) {
            synchronized (HttpsToCustomerDataViaUsbAdapter.class) {
                if(hcdu == null) {
                    hcdu = new HttpsToCustomerDataViaUsbAdapter();
                }
            }
        }
        return hcdu;
    }

    /**
     * Set customerDataViaUsb reference to the instance.
     * @param customerDataViaUsb
     */
    public void setCustomerDataViaUsb(CustomerDataViaUsb customerDataViaUsb) {
        this.customerDataViaUsb = customerDataViaUsb;
    }

    /**
     * Print the customer by customer id.
     * @param customerId
     */
    @Override
    public void printCustomer(int customerId) {
        System.out.println(customerDataViaUsb.getCustomerViaUsb(customerId));
    }

    /**
     * Get a customer from disk.
     * @param customerId
     * @return
     */
    @Override
    public Customer getCustomerViaHttps(int customerId) {
        return customerDataViaUsb.getCustomerViaUsb(customerId);
    }
}
