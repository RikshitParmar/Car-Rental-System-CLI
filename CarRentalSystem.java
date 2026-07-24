// Car rental System.
import java.util.Scanner;


public class Main2{
    public static void main(String[] args) {
        RentalSystem r = new RentalSystem();

        r.addCar();
        r.showCar();
        r.rentCar();
        r.returnCar();
    }
}


class Car{
    Scanner input = new Scanner(System.in);
    private int carId;
    private String brand;
    private String model;
    private int pricePerDay;
    private boolean available = true;

    public Car(int carId,String brand,String model,int pricePerDay){
        this.carId = carId;
        this.brand = brand;
        this.model = model;
        this.pricePerDay = pricePerDay;
    }

    public boolean getcaravailable(){
        return available;
    }
    public void setCarAvailable(){
        this.available = true;
    }

    public int getCarId(){
        return carId;
    }

    public int getPricePerDay(){
        return pricePerDay;
    }

    public void displayCar(){
        System.out.println("\nCAR ID: " + this.carId);
        System.out.println("CAR BRAND: " + this.brand);
        System.out.println("CAR MODEL: " + this.model);
        System.out.println("PRICE OF CAR PER DAY: " + this.pricePerDay);
    }

    public void rentCar() {
        if (available) {
            available = false;
            System.out.println("Car Rented Successfully");
        } else {
            System.out.println("Car is Not Available For Rent :(");
        }
    }

    public void returnCar() {
        if (!available) {
            available = true;
            System.out.println("Thanks For Using Our Services :)");
        } else {
            System.out.println("This car was not rented.");
        }
}
}

class Customer{
    Scanner input = new Scanner(System.in);
    private int customerId;
    private String name;
    private int phone;

    public Customer(int customerId,String name){
        this.customerId = customerId;
        this.name = name;
        this.phone = setPhone();
    }

    public int setPhone(){
        System.out.print("Enter Phone Number: ");
        String pnUser = input.nextLine();
        if(pnUser.length() == 10){
            return Integer.parseInt(pnUser);
        }
        return 0000000000;
    }

    public void displayCustomer(){
        System.out.println("USER ID: " + this.customerId);
        System.out.println("USER NAME: " + this.name);
        System.out.println("USER PHONE NUMBER: " + this.phone);
    }
}

class RentalSystem{
    Scanner input = new Scanner(System.in);
    private Car[] cars = new Car[300];
    private Customer[] customers = new Customer[300];
    static int storage = 0;

    public void addCar(){
        if(storage == 300){
            System.out.println("Storage Full !!");
            return;
        }

        System.out.print("How Many Car You Added: ");
        int carAdd = input.nextInt();

        for(int i = 0; i < carAdd; i++){

            System.out.print("ENTER CAR ID: ");
            int carId = input.nextInt();
            input.nextLine();

            System.out.print("ENTER CAR BRAND: ");
            String carBrand = input.nextLine();

            System.out.print("ENTER CAR MODEL: ");
            String carModel = input.nextLine();

            System.out.print("ENTER PRICE OF CAR PER DAY: ");
            int carPrice = input.nextInt();
            System.out.println();

            cars[storage] = new Car(carId,carBrand,carModel,carPrice);
            storage++;
        }
    }

    public void showCar(){
        if(storage == 0){
            System.out.println("Storage Area is Empty !!");
        }

        for(int i = 0; i < storage; i++){
            System.out.println("============== CAR DETAILS ================");
            cars[i].displayCar();
            System.out.println("============================================");
            System.out.println();
        }
    }

    public void rentCar(){
        while(true){
            System.out.print("Enter ID of Car You Rent: ");
            int CarID = input.nextInt();

            System.out.print("How Many Days: ");
            int d = input.nextInt();

            for(int i = 0; i < storage; i++){
                if(CarID == cars[i].getCarId()){
                    input.nextLine();
                    cars[i].rentCar();
                    cars[i].displayCar();
                    System.out.println();
                    System.out.println("Total Price of Car: " + (cars[i].getPricePerDay() * d));
                    break;
                }else{
                    System.out.println("ID Not Found!!.");
                }
            }
            break;
        }
    }

    public void returnCar(){
        while(true){
            System.out.print("\nEnter ID of Car: ");
            int carId = input.nextInt();

            for(int i = 0; i < storage; i++){
                if(carId == cars[i].getCarId() && cars[i].getcaravailable() == false){
                    cars[i].returnCar();
                    input.nextLine();
                    cars[i].displayCar();
                    cars[i].setCarAvailable();
                    break;
                }else{
                    System.out.println("ID Not Found!!");
                }
            }
            break;
        }
    }
}
