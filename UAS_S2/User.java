import java.util.ArrayList;

interface Borrowable {
  void receiveMotor(Motor motor);

  void giveMotor(Motor motor);

  Motor getMotorById(String id);
}

class User implements Borrowable {
  String id;
  String name;
  ArrayList<Motor> borrowedMotors;

  public User() {
    this.id = id;
    this.name = name;
    this.borrowedMotors = new ArrayList<Motor>();
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public ArrayList<Motor> getborrowedMotors() {
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