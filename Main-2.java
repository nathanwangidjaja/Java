/******************************************************************************
OOP 
Create examples in Java that demonstrate the principles of 
encapsulation, inheritance, and polymorphism (both compile-time polymorphism and runtime polymorphism), 
abstraction. 

Also, write a small description of each principle and of 
any advantages or disadvantages it may have in a separate text file.

Completion requirements:
Upload your code and the descriptions you created to a Github repository and post the link in a comment.

   [ Employee ]   - name
        |         - address 
        |         - number 
        |  
   [ Salary ]
                  - salary
*******************************************************************************/
import java.util.Scanner;
abstract class Car {  

/* Abstraction
abstraction is a process of hiding the implementation details from the user, 
only the functionality will be provided to the user. 
In other words, the user will have the information on 
what the object does instead of how it does it.
*/
   private String brand;
   private String subBrand; 
   private char color; 
   private int model; 

   public Car (String brand, String subBrand, char color, int model) {
      this.brand    = brand;
      this.subBrand = subBrand;
      this.color = color; 
      this.model = model; 
   }

   public void carCheck() {
      System.out.println("Car Check at " + this.brand + " " + this.subBrand + " " + this.color + " " + this.model);
   }

   public String toString() {
      return brand + " " + subBrand + " " + model;
   }

   public void setBrand (String newBrand) {
      brand = newBrand;
   }

   public String getBrand() {
      return brand;
   }

   public void setSubBrand(String newSubBrand) {
      subBrand = newSubBrand;
   }

   public String getSubBrand() {
      return subBrand;
   }
   
   public void setColor(char newColor) {
       color = newColor;
   }
   public String getColor(){
        String colorName; 
        switch(color) {
          case 'W': 
            colorName = "white";
            break;
          case 'B':
            colorName = "black";
            break;
          case 'M':
            colorName = "maroon";
            break; 
          default:
            colorName = "Unknown";
        }
        return colorName; 
   }

   public void setModel(int newModel) {
      model = newModel;
   }
      public String getModel(){
        String modelName; 
        switch(model) {
          case 1: 
            modelName = "SUV";
            break;
          case 2:
            modelName = "MPV";
            break;
          case 3:
            modelName = "Sedan";
            break; 
          default:
            modelName = "Unknown";
        }
        return modelName; 
   }
      public void ownerProfile() {
   }
}

class Owner extends Car {  
/* inheritance
Inheritance is a process where one class acquires the properties (methods and fields) of another. 
With the use of inheritance the information is made manageable in a hierarchical order.
*/
   private int plateNumber; 
   private double price; 
   private String name; 
         // Owner o1 = new Owner("Toyota", "Fortuner", 'W', 1, 123, 35123.5, "Nathan");
   public Owner (String brand, String subBrand, char color, int model, int plateNumber, double price, String name) {
      super (brand, subBrand, color, model); // call parent's constructor 
      setPrice(price);
      setName(name);
      setPlateNumber(plateNumber);
   }
   
   public void ownerProfile() {
      System.out.println("Owner Profile:");
      System.out.println("Name: " + name);
      System.out.print("Brand: " + getBrand() + " " + getSubBrand() + " - ");
      System.out.println(getColor() + " (" + getModel() + ")");
      System.out.println("Plate Number: " + getPlateNumber()); 
      System.out.println("Price: USD " + getPrice());
      
   }
   
   public double getPrice() {
      return price;
   }
   
   public void setPrice(double newPrice) {
      if(newPrice >= 0.0) {
         price = newPrice;
      }
   }
   
   public String getName() { 
       return name; 
   }
   
   public void setName(String newName) {
       name = newName; 
   }
   
   public int getPlateNumber(){
       return plateNumber; 
   }
   
   public void setPlateNumber(int newPlateNumber){
       plateNumber = newPlateNumber;
   }
   
   static int Overload(int a, int b)  //Overloading - Compile Time Polymorphism
    { 
        return a * b; 
    } 
  
    static int Overload(int a, int b, int c) //Same method with different number of parameters 
    { 
        return a * b * c; 
    } 
}
public class Main
{
	public static void main(String[] args) {
          Car o1 = new Owner("Toyota", "Fortuner", 'W', 1, 123, 35123.5, "Nathan");
          o1.ownerProfile();
          System.out.println("Overload #1:" + Owner.Overload(2, 4)); //Calling #1 - Overloading with different number of parameteres - Compile Time Polymorphism
          System.out.println("Overload #2:" + Owner.Overload(2, 7, 3)); //Calling #2 - Overloading with different number of parameteres - Compile Time Polymorphism
          // object s => call Salary()'s construction
          
          /* encapsulation 
          Encapsulation in Java is a mechanism of wrapping the data (variables) and 
          code acting on the data (methods) together as a single unit. 
          In encapsulation, the variables of a class will be hidden from other classes, 
          and can be accessed only through the methods of their current class.
          */
          // s.address = "Surabaya"; // illegal access
          // s.setAddress("Surabaya"); // encapsulation
          
          //String add = s.address; // illegal

          /* after abstraction, it's prohibited
          Employee e = new Employee ("Surno", "Semarang", 555);  
          System.out.println("\nCall mailCheck() using Employee reference/Employee's constructor--");
          e.mailCheck();  	
          */ 

          /* polymorphism
          Polymorphism is the ability of an object to take on many forms. 
          The most common use of polymorphism in OOP occurs when a parent class reference 
          is used to refer to a child class object.
          */
        Scanner input = new Scanner(System.in); 
		String buyerName;
		double newPrice;
        System.out.println("Transaction: ");
        System.out.println("Buyer Name: ");
        buyerName = input.nextLine();
        System.out.println("Price: ");
        newPrice = input.nextDouble(); 
        
        Car o2 = new Owner("Toyota", "Fortuner", 'W', 1, 123, newPrice, buyerName);
        o2.ownerProfile();
        
        
        
          
	}
}


