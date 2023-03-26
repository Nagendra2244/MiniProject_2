package com.Nagendra.ArogyaHospital;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        int option;
        DaoInterface dao = new DaoImpl();
        Scanner sc = new Scanner(System.in);
        do {
        	System.out.println("--------------------Enter the Required option-----------------------");
            System.out.println("Press [1] Patient Registration");
            System.out.println("Press [2] Show all patients details");
            System.out.println("Press [3] Search by ID");
            System.out.println("Press [4] Search by member a particular age group");
            System.out.println("Press [5] Search by member from a particular city");
            System.out.println("Press [6] Delete data of a member");
            System.out.println("Press [7] Mark recovery of a member");
            System.out.println("Press [8] Enter medicine Supplier");
            System.out.println("Press [9] Enter showallSuppliers");
            System.out.println("Press [10] Enter medicine records");
            System.out.println("Press [11] Enter showallMedicineRecordDetails");
            System.out.println("Press [0] Exit");
            System.out.println("Enter your choice:");
            option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1:
                	System.out.println("--------------------PATIENT REGISTRATION-----------------------");
                    Patient p = new Patient();
                    System.out.println("Enter Patient ID:");
                    p.setId(sc.nextInt());
                    sc.nextLine();
                    System.out.println("Enter Patient Name:");
                    p.setName(sc.nextLine());
                    System.out.println("Enter Patient Gender:");
                    p.setGender(sc.nextLine());
                    System.out.println("Enter Patient Aadhar Number:");
                    p.setAadharNumber(sc.nextLine());
                    System.out.println("Enter Patient Contact Number:");
                    p.setContactNumber(sc.nextLine());
                    System.out.println("Enter Patient City:");
                    p.setCity(sc.nextLine());
                    System.out.println("Enter Patient Address:");
                    p.setAddress(sc.nextLine());
                    System.out.println("Enter Patient Date of Admission (dd/mm/yyyy):");
                    p.setDateOfAdmission(sc.nextLine());
                    System.out.println("Enter Patient Guardian Name:");
                    p.setGuardianName(sc.nextLine());
                    System.out.println("Enter Patient Guardian Address:");
                    p.setGuardianAddress(sc.nextLine());
                    System.out.println("Enter Patient Guardian Contact Number:");
                    p.setGuardianContactNumber(sc.nextLine());
                    System.out.println("Enter Patient Age:");
                    p.setAge(sc.nextInt());
                    sc.nextLine();
                    System.out.println("Patient recovered (yes/no):");
                    p.setRecovered(sc.nextLine());
                    dao.patientRegistartion(p);
                    break;
                case 2:
                	System.out.println("--------------------SHOW ALL PATIENT DETAILS-----------------------");
                	dao.showAllPatients();
                    break;
                case 3:
                	System.out.println("--------------------SEARCH PATIENT BY Id-----------------------");
                    System.out.println("Enter ID to search:");
                    int id = sc.nextInt();
                    sc.nextLine();
                    dao.SearchPatientById(id);
                    break;
                case 4:
                	System.out.println("--------------------SEARCH PATIENT BY AGE-----------------------");
                    System.out.println("Enter age group to search:");
                    int age = sc.nextInt();
                    dao.SearchPatientByage(age);
                     break;
                case 5:
                	System.out.println("-----------------sEARCH PATIENT BY CITY-----------------------");
                    System.out.println("Enter city to search:");
                   String city = sc.nextLine();
                    dao.SearchPatientBycity(city);
                    break;
                case 6:
                	System.out.println("--------------------DELETE PATIENT BY Id-----------------------");
                     System.out.println("Enter ID of patient to be deleted:");
                      id = sc.nextInt();
                    dao.deletePatientById(id);
                    break;
                case 7:
                	System.out.println("-----------------MARK RECOVERY--------------------------");
                	System.out.println("Enter ID of patient to mark recovery:");
                    String recovered=sc.nextLine();
                    dao.markPatientRecovery(recovered);
                    break;
                case 8:    
                    System.out.println("-----------------MEDICINE Supplier--------------------------");
                    Supplier supplier = new Supplier();
                    System.out.println("Enter supplier ID:");
                    supplier.setSupplierID(sc.nextInt());
                    sc.nextLine(); // consume the newline character left in the input buffer
                    System.out.println("Enter supplier Name:");
                    supplier.setSuplierName(sc.nextLine());
                    System.out.println("Enter supply date (YYYY-MM-DD):");
                    supplier.setSupplyDate(sc.nextLine());
                    dao.addSupplier(supplier);
                    break;
                case 9:
                	System.out.println("--------------------SHOW ALL Supplier DETAILS-----------------------");
                	dao.showallSuppliers();
                    break;
                case 10:
                	System.out.println("-----------------MEDICINE RECORDS--------------------------");
                	Patient p1 = new Patient();
                	System.out.println("Enter Patient ID to enter medicine record:");
                    id = sc.nextInt();
                    sc.nextLine();
                    dao.SearchPatientById(id);
                   if(id!=0) {
                        MedicineRecords record = new MedicineRecords();
                        System.out.println("Enter medicine Id:");
                        record.setMedicineID(sc.nextInt());
                        sc.nextLine();
                        System.out.println("Enter supplier ID:");
                        record.setSupplierID(sc.nextLine());
                        System.out.println("Enter medicine name:");
                        record.setMedicineName(sc.nextLine());
                        System.out.println("Enter cost:");
                        record.setUnitPrice(sc.nextDouble());
                        sc.nextLine();
                        System.out.println("Enter Quantity:");
                        record.setQuantity(sc.nextInt());
                        sc.nextLine();
                        System.out.println("Enter manufacture date (yyyy-mm-dd):");
                        record.setManufactureDate(sc.nextLine());
                        System.out.println("Enter expiry date (yyyy-mm-dd):");
                        record.setExpiryDate(sc.nextLine());
                        System.out.println("Enter total price:");
                        record.setTotalPrice(sc.nextDouble());
                        dao.addMedicineRecords(p1 ,record);
                        } else {
                        System.out.println("No patient found with ID " + id);
                    }
                    break;
                case 11:
                	System.out.println("--------------------SHOW ALL MedicineRecord DETAILS-----------------------");
                	dao.showallMedicineRecordDetails();
                    break;
                    

               case 0:
                	System.exit(0);
                default:
                System.out.println("Wrong Choice");
                break;
               
            }
       
        } while(option!=0);
  }
}