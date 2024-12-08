/**
 * Name: Shaohua Yue
 * Course: CS-665 Software Designs & Patterns
 * Date: 11/10/2024
 * File Name: CustomerDataProxy.java
 * Description: This class is proxy for retrieving data from two different data source.
 */
package edu.bu.met.cs665;

import java.util.HashMap;
import java.util.Map;

public class CustomerDataProxy implements CustomerDataProxyInterface{

    CustomerDataViaHttps customerDataViaHttps;
    HttpsToCustomerDataViaUsbAdapter httpsToCustomerDataViaUsbAdapter;
    Map<Integer, DataType> customerMap;

    private static volatile CustomerDataProxy cdp;

    /**
     * Construction method
     */
    private CustomerDataProxy() {
        customerMap = new HashMap<>();
    }

    /**
     * Get a singleton instance.
     */
    public static CustomerDataProxy getInstance() {
        if(cdp == null) {
            synchronized (CustomerDataProxy.class) {
                if(cdp == null) {
                    cdp = new CustomerDataProxy();
                }
            }
        }
        return cdp;
    }

    /**
     * Put customer Id into the map for searching.
     * @param customerId
     * @param dataType
     */
    public void setCustomerMap(int customerId, DataType dataType) {
        customerMap.put(customerId, dataType);
    }

    /**
     * Set customerDataViaHttps property to CustomerDataProxy.
     * @param customerDataViaHttps
     */
    public void setCustomerDataViaHttps(CustomerDataViaHttps customerDataViaHttps) {
        this.customerDataViaHttps = customerDataViaHttps;
    }

    /**
     * Set httpsToCustomerDataViaUsbAdapter property to CustomerDataProxy.
     * @param httpsToCustomerDataViaUsbAdapter
     */
    public void setHttpsToCustomerDataViaUsbAdapter(HttpsToCustomerDataViaUsbAdapter httpsToCustomerDataViaUsbAdapter) {
        this.httpsToCustomerDataViaUsbAdapter = httpsToCustomerDataViaUsbAdapter;
    }

    /**
     * Print customer information in the terminal.
     * @param customerId
     */
    @Override
    public void printCustomer(int customerId) {
        if(customerMap.get(customerId) == DataType.Disk) {
            httpsToCustomerDataViaUsbAdapter.printCustomer(customerId);
        } else {
            customerDataViaHttps.printCustomer(customerId);
        }
    }

    /**
     * Get customer from the disk or server.
     * @param customerId
     * @return
     */
    @Override
    public Customer getCustomer(int customerId) {
        if(customerMap.get(customerId) == DataType.Disk) {
            return httpsToCustomerDataViaUsbAdapter.getCustomerViaHttps(customerId);
        } else {
            return customerDataViaHttps.getCustomerViaHttps(customerId);
        }
    }
}
