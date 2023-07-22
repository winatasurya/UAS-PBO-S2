import java.util.ArrayList;

interface Borrowable {
  void receiveMotor(Motor motor);

  void giveMotor(Motor motor);

  Motor getMotorById(String id);
}

class User implements Borrowable {
  private String id;
  private String name;
  private ArrayList<Motor> borrowedMotors;

  public User(String id, String name) {
    this.id = id;
    this.name = name;
    this.borrowedMotors = new ArrayList<Motor>();
  }

  public User() {

  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
      this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
      this.name = name;
  }

  public ArrayList<Motor> getBorrowedMotors() {
    return borrowedMotors;
  }

  public void receiveMotor(Motor motor) {
    this.borrowedMotors.add(motor);
  }

  public void giveMotor(Motor motor) {
    this.borrowedMotors.remove(motor);
  }

  public Motor getMotorById(String id) {
    for (Motor motor : this.borrowedMotors) {
      if (motor.getId().equals(id)) {
        return motor;
      }
    }
    return null;
  }
}