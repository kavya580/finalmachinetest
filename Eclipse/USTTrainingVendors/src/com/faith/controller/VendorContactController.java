package com.faith.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.faith.dao.IVendorContactDao;
import com.faith.model.ContactVendor;

@RestController
public class VendorContactController {

	@Autowired
	IVendorContactDao dao;

	// for inserting and updating vendor contact details
	@RequestMapping(value = "/api/vendordetail", method = { RequestMethod.POST,
			RequestMethod.PUT })
	public void insertDetails(@RequestBody ContactVendor contactVendor) {
		if (contactVendor.getvId() == 0) {
			dao.insertDetails(contactVendor);
		} else {
			dao.updateDetails(contactVendor);
		}
	}

	// for disabling a vendor
	@RequestMapping(value = "/api/disablevendor/{vId}", method = RequestMethod.PUT)
	public void disableVendor(@PathVariable("vId") int vId) {
		dao.disableVendor(vId);
	}

	// to get and search all vendor details
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/api/vendordetail/{searchString}", method = RequestMethod.GET)
	public List getVendorDetails(Model m,
			@PathVariable("searchString") String searchString) {
		List list;
		if (searchString.equals("null")) {
			list = dao.getAllDetails();
		} else {
			list = dao.searchVendorDetails(searchString);
		}
		return list;
	}

}
