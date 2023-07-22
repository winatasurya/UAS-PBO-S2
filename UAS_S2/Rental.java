import java.util.ArrayList;

abstract class Rental {
  public ArrayList<Motor> motors = new ArrayList<Motor>();
  public ArrayList<User> users = new ArrayList<User>();

  public abstract void addUser(User user);

  public abstract Boolean isUserIdExist(String id);

  public abstract void addMotor(Motor motor);

  public abstract Boolean isMotorIdExist(String id);

  public abstract void giveMotor(String motorId, String userId);

  public abstract void receiveMotor(String motorId, String userId);

  protected int getUserIndex(User user) {
    return this.users.indexOf(user);
  }

  protected User getUserById(String id) throws Exception {
    for (User user : this.users) {
      if (user.getId().equals(id)) {
        return user;
      }
    }
    throw new Exception("User dengan id " + id + " tidak ditemukan");
  }

  protected Motor getMotorById(String id) throws Exception {
    for (Motor motor : this.motors) {
      if (motor.getId().equals(id)) {
        return motor;
      }
    }
    throw new Exception("Motor dengan id " + id + " tidak ditemukan");
  }
}

class RentalMotor extends Rental {
  // constructor
  public RentalMotor() {
    super();
  }

  @Override
  public void addUser(User user) {
    if (!isUserIdExist(user.getId())) {
      this.users.add(user);
      System.out.println("User berhasil ditambahkans");
    } else {
      System.out.println("Data User dengan ID " + user.getId() + " Sudah Diisi");
    }
  }

  @Override
  public Boolean isUserIdExist(String id) {
    Boolean isExist = false;
    for (User user : this.users) {
      if (user.getId().equals(id)) {
        isExist = true;
      }
    }
    return isExist;
  }

  // menambahkan Buku
  @Override
  public void addMotor(Motor motor) {
    if (isMotorIdExist(motor.getId())) {
      System.out.println("Data Buku dengan ID " + motor.getId() + " Sudah Ada");
    } else if (isMotorBorrowed(motor.getId())) {
      System.out.println("Motor dengan ID " + motor.getId() + " sudah ada dan Sedang Dipinjam");
    } else {
      this.motors.add(motor);
      System.out.println("Motor Berhasil ditambahkan");
    }
  }

  private boolean isMotorBorrowed(String motorId) {  
    for (User user : this.users) {
      if (user.getMotorById(motorId) != null) {
        return true;
      }
    }
    return false;
  }

  @Override
  public Boolean isMotorIdExist(String id) {
    Boolean isExist = false;
    for (Motor motor : this.motors) {
      if (motor.getId().equals(id)) {
        isExist = true;
      }
    }
    return isExist;
  }

  @Override
  public void giveMotor(String motorId, String userId) {
    try {
      Motor motor = this.getMotorById(motorId);

      User user = this.getUserById(userId);
      int userIndex = this.getUserIndex(user);
      this.motors.remove(motor);
      this.users.get(userIndex).getBorrowedMotors().add(motor);
      System.out
          .println(
              "Motor dengan id " + motor.getId() + " telah berhasil dipinjam oleh user dengan ID " + user.getId());
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public void receiveMotor(String motorId, String userId) {
    try {
      User user = this.getUserById(userId);
      int userIndex = this.getUserIndex(user);

      Motor motor = this.users.get(userIndex).getMotorById(motorId);

      if (motor == null) {
        throw new Exception("Motor dengan id " + motorId + " tidak dipinjam oleh member dengan ID " + user.getId());
      }

      this.motors.add(motor);
      this.users.get(userIndex).getBorrowedMotors().remove(motor);
      System.out.println(
          "Motor dengan id " + motor.getId() + " telah berhasil dikembalikan oleh user dengan ID " + user.getId());
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}