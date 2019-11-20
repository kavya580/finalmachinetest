package com.faith.dao;


import antlr.collections.List;

import com.faith.model.ContactVendor;

public interface IVendorContactDao {

	public abstract int insertDetails(ContactVendor contactVendor);

	// to get all the details of vendors
	public abstract List<ContactVendor> getAllDetails();

	// to disable vendor
	public abstract int disableVendor(int vId);

	// updation of vendor details
	public abstract int updateDetails(ContactVendor contactVendor);

	// to search vendor details
	public abstract List<ContactVendor> searchVendorDetails(String searchString);

}