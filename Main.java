public class Main {
    public static void main(String[] args) {
        Phone phone = new Phone("iPhone 15");
        Laptop laptop = new Laptop("MacBook Pro");

        UsbCCharger modernCharger = new ModernCharger();


        String oldChargerHtml = "<div id=\"chargerType\">Old Round Pin Charger</div>";
        UsbCCharger adapterHtml = new ChargerAdapter(oldChargerHtml);




        phone.plugIn(modernCharger);
        laptop.plugIn(adapterHtml);


    }

}