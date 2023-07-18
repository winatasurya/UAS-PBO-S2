
// ini adalah commit pertama saya di github
import java.util.InputMismatchException;
import java.util.Scanner;

class Main {

  static Scanner scan = new Scanner(System.in);
  static Rental Rental = new RentalMotor();

  public static void main(String[] args) {
    initLibraryData();

    String isContinue = "y";

    while (isContinue.equals("y")) {
      showMenu();
      int selectedMenu = chooseMenu();

      if (selectedMenu == 1) {
        showMotors();
      } else if (selectedMenu == 2) {
        showUsers();
      } else if (selectedMenu == 3) {
        addUser();
      } else if (selectedMenu == 4) {
        borrowMotor();
      } else if (selectedMenu == 5) {
        returnMotor();
      } else if (selectedMenu == 6) {
        addMotor();
      } else {
        System.out.println("wrong input");
      }

      System.out.print("continue ? (y/n) ");
      while (true) {
        String input = scan.next();
        if (input.equalsIgnoreCase("y") || input.equalsIgnoreCase("n")) {
          isContinue = input;
          break;
        } else {
          System.out.println("Invalid Input. Please enter 'y' or 'n'.");
        }
      }
    }
  }

  public static void showMenu() {
    System.out.println("================================");
    System.out.println("1. show motor list");
    System.out.println("2. show user list");
    System.out.println("3. add user");
    System.out.println("4. borrow motor");
    System.out.println("5. return motor");
    System.out.println("6. add motor");
    System.out.println("================================");
  }

  public static void initLibraryData() {
    Motor motor1 = new Motor();
    motor1.setId("1");
    motor1.setNama("Honda PCX");

    Motor motor2 = new Motor();
    motor2.setId("2");
    motor2.setNama("Yamaha Nmax");

    Motor motor3 = new Motor();
    motor3.setId("3");
    motor3.setNama("Kawasaki H2R");

    User user1 = new User();
    user1.id = "1";
    user1.name = "aka";

    User user2 = new User();
    user2.id = "2";
    user2.name = "budi";

    User user3 = new User();
    user3.id = "3";
    user3.name = "tono";

    Rental.motors.add(motor1);
    Rental.motors.add(motor2);
    Rental.motors.add(motor3);

    Rental.users.add(user1);
    Rental.users.add(user2);
    Rental.users.add(user3);
  }

  public static int chooseMenu() {
    int pilihan = 0;
    try {
      System.out.print("choose menu : ");
      pilihan = scan.nextInt();
    } catch (InputMismatchException e) {
      System.out.println("Invalid Input. Please enter a number.");
      scan.next(); // clear the scanner buffer
    }
    return pilihan;
  }

  public static void showMotors() {
    for (Motor motor : Rental.motors) {
      System.out.println(motor.getId() + " " + motor.getNama());
    }
  }

  public static void showUsers() {
    for (User user : Rental.users) {
      System.out.println(user.id + " " + user.name);
    }
  }

  public static void addUser() {
    User user = new User();

    System.out.print("Masukkan id user: ");
    user.id = scan.next();

    System.out.print("Masukkan name user: ");
    user.name = scan.next();

    Rental.addUser(user);
  }

  public static void addMotor() {
    Motor motor = new Motor();

    System.out.print("Masukkan id motor: ");
    motor.setId(scan.next());

    System.out.print("Masukkan Model motor: ");
    scan.nextLine();
    motor.setNama(scan.nextLine());
  
    Rental.addMotor(motor);
  }

  public static void borrowMotor() {
    System.out.print("Masukkan id user : ");
    String userId = scan.next();

    System.out.print("Masukkan id motor : ");
    String motorId = scan.next();

    Rental.giveMotor(motorId, userId);
  }

  public static void returnMotor() {
    System.out.print("Masukkan id user : ");
    String userId = scan.next();

    System.out.print("Masukkan id motor : ");
    String motorId = scan.next();

    Rental.receiveMotor(motorId, userId);
  }
}