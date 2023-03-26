package com.Nagendra.ArogyaHospital;

public interface DaoInterface {
   
	   public void patientRegistartion(Patient p);
	   public void showAllPatients();
	   public void SearchPatientById(int id);
	   public void SearchPatientByage(int age);
	   public void SearchPatientBycity(String city);
	   public void deletePatientById(int id);
	   public void markPatientRecovery(String recovered);
	   public void addSupplier(Supplier supplier);
	   public void showallSuppliers();
	   public void addMedicineRecords(Patient p,MedicineRecords record);
	   public void showallMedicineRecordDetails();
	   public void exit();
	
	
}
