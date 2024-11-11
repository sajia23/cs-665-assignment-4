/**
 * Name: Shaohua Yue
 * Course: CS-665 Software Designs & Patterns
 * Date: 11/10/2024
 * File Name: CustomerFactory.java
 * Description: This class is responsible for producing customer instance.
 */
package edu.bu.met.cs665;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class CustomerFactory {

    static Disk disk;
    static ExternalServer externalServer;

    private static volatile CustomerFactory cf;

    /**
     * Construction method
     */
    private CustomerFactory() {
    }

    /**
     * Get a singleton instance.
     */
    public static CustomerFactory getInstance() {
        if(cf == null) {
            synchronized (CustomerFactory.class) {
                if(cf == null) {
                    cf = new CustomerFactory();
                }
            }
        }
        return cf;
    }

    /**
     * Set disk reference in the instance.
     * @param disk
     */
    public void setDisk(Disk disk) {
        this.disk = disk;
    }

    /**
     * Set server reference in the instance.
     * @param externalServer
     */
    public void setExternalServer(ExternalServer externalServer) {
        this.externalServer = externalServer;
    }

    /**
     * Create a customer instance and put it into the disk or server.
     * @param dataType
     * @return
     */
    public Customer produceCustomer(DataType dataType) {
        Random random = new Random();

        int randomNumber = 10000 + random.nextInt(90000);

        Customer customer = new Customer(randomNumber, RandomStringUtils.randomAlphanumeric(10), RandomStringUtils.randomAlphanumeric(10));

        if(dataType == DataType.Disk) {
            disk.writeCustomer(customer);
        }
        if(dataType == DataType.Http) {
            externalServer.writeCustomer(customer);
        }
        return customer;
    }
}
