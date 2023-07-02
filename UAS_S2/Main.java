class Main {
    public static void main(String[] args) {
        
        String isContinue = "y";

    while (isContinue.equals("y")) {
      showMenu();
      int selectedMenu = chooseMenu();

      if (selectedMenu == 0) {
        break;
      } else if (selectedMenu == 1) {
        showTroops();
      } else if (selectedMenu == 2) {
        addTroop();
      } else if (selectedMenu == 3) {
        toTraining();
      } else if (selectedMenu == 4) {
        showBuilding();
      } else if (selectedMenu == 5) {
        upBuiding();
      } else if (selectedMenu == 6) {
        updateDay();
      } else {
        System.out.println("wrong input");
      }

      System.out.print("continue(y) ? ");
      isContinue = scan.next();
    }
    }
}
