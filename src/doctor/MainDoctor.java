/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doctor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author dell
 */
public class MainDoctor {
    static Scanner sc = new Scanner(System.in);
    
     static ArrayList<Doctor> doctors = new ArrayList<>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        while(true) {
            System.out.println("1. Create Doctor");
            System.out.println("2. Edit Doctor");
            System.out.println("3. Delete Doctor");
            System.out.println("4. Search Doctor by ID");
            System.out.println("5. Sort Doctor by Date of Birth");
            System.out.println("6. Exit");
            
            System.out.print("\nYour choice: ");
            
            switch(sc.nextLine()) {
                case "1":
                    CreateDoctor();
                    break;
                case "2":
                    EditDoctor();
                    break;
                case "3":
                    DeleteDoctor();
                    break;
                case "4":
                    SearchDoctor();
                    break;
                case "5":
                    SortDoctor();
                    break;
                default:
                    
            }
        }
    }

    private static void CreateDoctor() {
        Doctor doctor = new Doctor();
        
        if(doctors.size() == 0) {
            doctor.setId(0);
        } else {
            doctor.setId(doctors.get(doctors.size()-1).getId()+1);
        }
        
        System.out.print("Name: ");
        try {
            doctor.setName(sc.nextLine());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return;
        }        
        
        System.out.print("Date Of Birth: ");
        try {
            doctor.setDateOfBirth(sc.nextLine());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return;
        }      
        
        System.out.print("Specialization: ");
        try {
            doctor.setSpecialization(sc.nextLine());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return;
        }      
        
        System.out.print("Availability: ");
        try {
            doctor.setAvailability(Integer.parseInt(sc.nextLine()));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return;
        }       
        
        System.out.print("Email: ");
        try {
            doctor.setEmail(sc.nextLine());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return;
        }        
        
        System.out.print("Phone: ");
        try {
            doctor.setMobile(sc.nextLine());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return;
        }
        
        doctors.add(doctor);
    }

    private static void EditDoctor() {
        System.out.print("Id: ");
        int id = Integer.parseInt(sc.nextLine());
        
        Doctor newDoctor = new Doctor();
        int i = 0;
        
        for (Doctor doctor : doctors) {
            if (doctor.getId() == id) {
                newDoctor.setId(id);
                
                System.out.print("Name: ");
                try {
                    newDoctor.setName(sc.nextLine());
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                    return;
                }        

                System.out.print("Date Of Birth: ");
                try {
                    newDoctor.setDateOfBirth(sc.nextLine());
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                    return;
                }      

                System.out.print("Specialization: ");
                try {
                    newDoctor.setSpecialization(sc.nextLine());
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                    return;
                }      

                System.out.print("Availability: ");
                try {
                    newDoctor.setAvailability(Integer.parseInt(sc.nextLine()));
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                    return;
                }       

                System.out.print("Email: ");
                try {
                    newDoctor.setEmail(sc.nextLine());
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                    return;
                }        

                System.out.print("Phone: ");
                try {
                    newDoctor.setMobile(sc.nextLine());
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                    return;
                }
                
                break;
            }
            i++;
        }
        
        doctors.set(i, newDoctor);
    }

    private static void DeleteDoctor() {
        System.out.print("Id: ");
        int id = Integer.parseInt(sc.nextLine());
        
        int i = 0;
        for (Doctor doctor : doctors) {
            if (doctor.getId() == id) {
                doctors.remove(i);
                break;
            }
            i++;
        }
    }

    private static void SearchDoctor() {
        System.out.println("1. Search by Id");
        System.out.println("2. Search by Name");
        
        System.out.print("\nYour choice: ");
        switch(sc.nextLine()) {
            case "1":
                System.out.print("Id: ");
                int id = Integer.parseInt(sc.nextLine());

                for (Doctor doctor : doctors) {
                    if (doctor.getId() == id) {
                        System.out.println(doctor);
                        break;
                    }
                }
                break;
            case "2":
                System.out.print("Id: ");
                String name = sc.nextLine();

                for (Doctor doctor : doctors) {
                    if (doctor.getName().equals(name)) {
                        System.out.println(doctor);
                    }
                }
                break;
        }
    }

    private static void SortDoctor() {
        doctors.sort(new Comparator<Doctor>() {
            @Override
            public int compare(Doctor t, Doctor t1) {
                return t.getDateOfBirth().compareTo(t1.getDateOfBirth());
            }
        });
    }
    
}
