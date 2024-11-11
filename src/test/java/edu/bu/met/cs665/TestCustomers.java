package edu.bu.met.cs665;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Write some Unit tests for your program like the examples below.
 */

public class TestCustomers {

    @Before
    public void initiation() {
        CustomerDataViaHttps.getInstance().setExternalServer(ExternalServer.getInstance());
        CustomerDataViaUsb.getInstance().setDisk(Disk.getInstance());
        HttpsToCustomerDataViaUsbAdapter.getInstance().setCustomerDataViaUsb(CustomerDataViaUsb.getInstance());
        CustomerDataProxy.getInstance().setCustomerDataViaHttps(CustomerDataViaHttps.getInstance());
        CustomerDataProxy.getInstance().setHttpsToCustomerDataViaUsbAdapter(HttpsToCustomerDataViaUsbAdapter.getInstance());
        CustomerFactory.getInstance().setDisk(Disk.getInstance());
        CustomerFactory.getInstance().setExternalServer(ExternalServer.getInstance());
    }

    @Test
    public void getCustomerFromDisk() {
        Customer customer = CustomerFactory.getInstance().produceCustomer(DataType.Disk);
        CustomerDataProxy.getInstance().setCustomerMap(customer.getCustomerId(), DataType.Disk);
        assertEquals(CustomerDataProxy.getInstance().getCustomer(customer.getCustomerId()), customer);
    }

    @Test
    public void getCustomerFromServer() {
        Customer customer = CustomerFactory.getInstance().produceCustomer(DataType.Http);
        CustomerDataProxy.getInstance().setCustomerMap(customer.getCustomerId(), DataType.Http);
        assertEquals(CustomerDataProxy.getInstance().getCustomer(customer.getCustomerId()), customer);
    }

    @Test
    public void getCustomerFromDiskWithWrongId() {
        Customer customer = CustomerFactory.getInstance().produceCustomer(DataType.Disk);
        CustomerDataProxy.getInstance().setCustomerMap(customer.getCustomerId(), DataType.Disk);
        int wrongId = 123;
        assertEquals(CustomerDataProxy.getInstance().getCustomer(wrongId), null);

    }

    @Test
    public void getWrongCustomerFromServerWithWrongId() {
        Customer customer = CustomerFactory.getInstance().produceCustomer(DataType.Http);
        CustomerDataProxy.getInstance().setCustomerMap(customer.getCustomerId(), DataType.Http);
        int wrongId = 123;
        assertEquals(CustomerDataProxy.getInstance().getCustomer(wrongId), null);
    }

    @Test
    public void getMultiCustomer() {
        Customer customer1 = CustomerFactory.getInstance().produceCustomer(DataType.Http);
        CustomerDataProxy.getInstance().setCustomerMap(customer1.getCustomerId(), DataType.Http);
        Customer customer2 = CustomerFactory.getInstance().produceCustomer(DataType.Disk);
        CustomerDataProxy.getInstance().setCustomerMap(customer2.getCustomerId(), DataType.Disk);
        assertEquals(CustomerDataProxy.getInstance().getCustomer(customer1.getCustomerId()), customer1);
        assertEquals(CustomerDataProxy.getInstance().getCustomer(customer2.getCustomerId()), customer2);
    }

}
