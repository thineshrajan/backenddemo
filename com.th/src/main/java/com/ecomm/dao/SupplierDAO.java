package com.ecomm.dao;

import java.util.List;
import com.ecomm.model.Supplier;

public interface SupplierDAO {
	
	public List<Supplier> findAllSuppliers();
	public Supplier findSupplierById(int SupplierId);
	public Supplier findSupplierByName(String SupplierName);
	public boolean addSupplier(Supplier supplier);
	public boolean updateSupplier(Supplier supplier);
	public boolean deleteSupplier(int supplierId);


}
