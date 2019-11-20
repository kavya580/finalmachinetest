package com.faith.dao;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.faith.model.ContactVendor;

public class VendorContactDao implements IVendorContactDao {

	// setting jdbc connection
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	// insert vendor and its contact information

	/* (non-Javadoc)
	 * @see com.faith.dao.IVendorContactDao#insertDetails(com.faith.model.ContactVendor)
	 */
	@Override
	public int insertDetails(ContactVendor contactVendor) {
		String sqlvendor = "insert into t_vendorTable (vName,vAddress,vLocation,vService,pincode,isActive) values('"
				+ contactVendor.getvName()
				+ "','"
				+ contactVendor.getvAddress()
				+ "','"
				+ contactVendor.getvLocation()
				+ "','"
				+ contactVendor.getvService()
				+ "',"
				+ contactVendor.getPincode() + ",'yes')";
		template.update(sqlvendor);

		// get max(vId) from vendor table
		Integer maxVId = getMaxofVId();
	

		// to insert contact details

		String sqlcontact = "insert into f_contactTable(cName,department,email,phone,vId) values('"
				+ contactVendor.getcName()
				+ "','"
				+ contactVendor.getDepartment()
				+ "','"
				+ contactVendor.getEmail()
				+ "','"
				+ contactVendor.getPhone()
				+ "',?)";
		return template.update(sqlcontact, new Object[] { maxVId });

	}

	// to get the maximum value of vId from vendorTable
	private Integer getMaxofVId() {
		String sql = "select MAX(vId) from f_vendorTable";
		Integer seq = template.queryForObject(sql, new Object[] {},
				Integer.class);
		return seq;
	}

	// to get all the details of vendors
	/* (non-Javadoc)
	 * @see com.faith.dao.IVendorContactDao#getAllDetails()
	 */
	@Override
	public List<ContactVendor> getAllDetails() {
		return template
				.query("select v.vId,v.vName,v.vLocation,v.vService,c.cName,"
						+ "c.department,c.phone from f_vendorTable v join f_contactTable c"
						+ " on(v.vId=c.vId) where  isActive='yes'",
						new RowMapper<ContactVendor>() {
							public ContactVendor mapRow(ResultSet rs, int row)
									throws SQLException {
								ContactVendor contactVendor = new ContactVendor();
								contactVendor.setvId(rs.getInt(1));
								contactVendor.setvName(rs.getString(2));
								contactVendor.setvLocation(rs.getString(3));
								contactVendor.setvService(rs.getString(4));
								contactVendor.setcName(rs.getString(5));
								contactVendor.setDepartment(rs.getString(6));
								contactVendor.setPhone(rs.getString(7));

								return contactVendor;
							}
						});
	}

	// to disable vendor
	/* (non-Javadoc)
	 * @see com.faith.dao.IVendorContactDao#disableVendor(int)
	 */
	@Override
	public int disableVendor(int vId) {
		String sql = "update f_vendorTable set isActive='no' where vId=?";
		return template.update(sql, new Object[] { vId });
	}

	// to update vendor and its contact information

	// updation of vendor details
	/* (non-Javadoc)
	 * @see com.faith.dao.IVendorContactDao#updateDetails(com.faith.model.ContactVendor)
	 */
	@Override
	public int updateDetails(ContactVendor contactVendor) {

		String sqlVendor = "update f_vendorTable set vName='"
				+ contactVendor.getvName() + "',vAddress='"
				+ contactVendor.getvAddress() + "',vLocation='"
				+ contactVendor.getvLocation() + "',vService='"
				+ contactVendor.getvService() + "',pincode="
				+ contactVendor.getPincode() + "where vId=?";
		template.update(sqlVendor, new Object[] { contactVendor.getvId() });

		// updation of contact details
		String sqlContact = "update f_contactTable set cName='"
				+ contactVendor.getcName() + "',department='"
				+ contactVendor.getDepartment() + "',email='"
				+ contactVendor.getEmail() + "',phone='"
				+ contactVendor.getPhone() + "'where vId=?";
		return template.update(sqlContact,
				new Object[] { contactVendor.getvId() });
	}

	// to search vendor details
	/* (non-Javadoc)
	 * @see com.faith.dao.IVendorContactDao#getVendorDetails(java.lang.String)
	 */
	@Override
	public List<ContactVendor> searchVendorDetails(String searchString) {
		return template.query("select v.vId,v.vName,v.vLocation,v.vService,c.cName,"
						+ "c.department,c.phone from f_vendorTable v join f_contactTable c"
						+ " on(v.vId=c.vId) where  isActive='yes' and v.vName='"+searchString
						+"' or v.vLocation='"+searchString+"' or v.vService='"+searchString+"'",
						new RowMapper<ContactVendor>() {
							public ContactVendor mapRow(ResultSet rs, int row)
									throws SQLException {
								ContactVendor contactVendor = new ContactVendor();
								contactVendor.setvId(rs.getInt(1));
								contactVendor.setvName(rs.getString(2));
								contactVendor.setvLocation(rs.getString(3));
								contactVendor.setvService(rs.getString(4));
								contactVendor.setcName(rs.getString(5));
								contactVendor.setDepartment(rs.getString(6));
								contactVendor.setPhone(rs.getString(7));
								return contactVendor;
							}
						});
	}

}
