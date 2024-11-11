/**
 * Name: Shaohua Yue
 * Course: CS-665 Software Designs & Patterns
 * Date: 11/10/2024
 * File Name: CustomerDataViaHttps.java
 * Description: This class is responsible for retrieving data from server.
 */
package edu.bu.met.cs665;

public class CustomerDataViaHttps implements CustomerDataViaHttpsInterface{

    ExternalServer externalServer;

    private static volatile CustomerDataViaHttps cdh;

    /**
     * Construction method
     */
    private CustomerDataViaHttps() {
    }

    /**
     * Get a singleton instance.
     */
    public static CustomerDataViaHttps getInstance() {
        if(cdh == null) {
            synchronized (CustomerDataViaHttps.class) {
                if(cdh == null) {
                    cdh = new CustomerDataViaHttps();
                }
            }
        }
        return cdh;
    }

    /**
     * Set server property to the instance.
     * @param externalServer
     */
    public void setExternalServer(ExternalServer externalServer) {
        this.externalServer = externalServer;
    }

    /**
     * Print customer info in the terminal
      * @param customerId
     */
    @Override
    public void printCustomer(int customerId) {
        System.out.println(externalServer.readCustomer(customerId));
    }

    /**
     * Get customer from server.
     * @param customerId
     * @return
     */
    @Override
    public Customer getCustomerViaHttps(int customerId) {
        return externalServer.readCustomer(customerId);
    }
}
