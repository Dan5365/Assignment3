public class Main {
    public static void main(String[] args) {
        Phone phone = new Phone("iPhone 15");
        Laptop laptop = new Laptop("MacBook Pro");

        UsbCCharger modernCharger = new ModernCharger();


        OldCharger oldCharger = new OldCharger();
        UsbCCharger adapter = new ChargerAdapter(oldCharger.oldChargerHtml);




        phone.plugIn(modernCharger);
        laptop.plugIn(adapter);


    }

}
