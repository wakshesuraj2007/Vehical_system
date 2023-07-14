package com.main;
import java.util.Scanner;
import com.bean.Vehicle;
import com.bean.Vehicle_Type;
import com.deo.VehicleServiceManager;

public class ServiceMain {

    public static void main(String[] args) {
        VehicleServiceManager manager = new VehicleServiceManager();
        Scanner scanner = new Scanner(System.in);

       char ch;
       	do {
            System.out.println("==== Vehicle Service Management System ====");
            System.out.println("1. Add a new vehicle");
            System.out.println("2. Remove a vehicle");
            System.out.println("3. Display all vehicles");
            System.out.println("4. Search for a vehicle");
            System.out.println("5. Record service history for a vehicle");
            System.out.println("6. Display service history for a vehicle");
            

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    
                	 Vehicle newVehicle = createVehicleFromUserInput(scanner);
                     manager.addVehicle(newVehicle);
                     System.out.println("Vehicle added successfully!");
                    break;
                case 2:
                
                    System.out.print("Enter the ID of the vehicle to remove: ");
                    int vehicleId = scanner.nextInt();
                    scanner.nextLine(); 
                    Vehicle vehicleToRemove = findVehicleById(manager, vehicleId);
                    if (vehicleToRemove != null) {
                        manager.removeVehicle(vehicleToRemove);
                        System.out.println("Vehicle removed successfully!");
                    } else {
                        System.out.println("Vehicle with ID " + vehicleId + " not found.");
                    }
                    break;
                case 3:
                    manager.displayAllVehicles();
                    break;
                case 4:
                    System.out.print("Enter the make search for: ");
                    String make = scanner.nextLine();
                    manager.searchByMake(make);
                    break;
                case 5:
                	 System.out.print("Enter the model to search for: ");
                     String model = scanner.nextLine();
                     manager.searchByModel(model);
                    break;
                case 6:
                	 System.out.print("Enter the type to search for (CAR, TRUCK, MOTORCYCLE): ");
                     String typeString = scanner.nextLine();
                     Vehicle_Type type = Vehicle_Type.valueOf(typeString.toUpperCase());
                     manager.searchByType(type); 
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            
            }
            System.out.print("Do you want to continue (Y/N): ");
            ch = scanner.next().charAt(0);
    	} while (ch == 'y' || ch == 'Y');
        
    }

	private static Vehicle createVehicleFromUserInput(Scanner scanner) {
		 System.out.print("Enter vehicle make: ");
	        String make = scanner.nextLine();

	        System.out.print("Enter vehicle model: ");
	        String model = scanner.nextLine();

	        System.out.print("Enter vehicle type (CAR, TRUCK, MOTORCYCLE): ");
	        String typeString = scanner.nextLine();
	        Vehicle_Type type = Vehicle_Type.valueOf(typeString.toUpperCase());

	        System.out.print("Enter vehicle year: ");
	        int year = scanner.nextInt();

	        System.out.print("Enter vehicle mileage: ");
	        int mileage = scanner.nextInt();
	        System.out.println("Enter the id: ");
	        int id = scanner.nextInt();

	        return new Vehicle(id, make, model, type, year, mileage);
	    
	
	}
	private static Vehicle findVehicleById(VehicleServiceManager manager, int vehicleId) {
        for (Vehicle vehicle : manager.getVehicles()) {
            if (vehicle.getId() == vehicleId) {
                return vehicle;
            }
        }
        return null;
    }

	
}
