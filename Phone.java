public class Phone {
   private final String name;

   public Phone(String name) {
      this.name = name;
   }

   public void plugIn(UsbCCharger charger){
      System.out.println(name + " " + "is charging with" + " " + charger.getChargerType());
   }


}
