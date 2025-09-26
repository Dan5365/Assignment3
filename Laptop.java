public class Laptop{
    private final String name;

    public Laptop(String name) {
        this.name = name;
    }

    public void plugIn(UsbCCharger charger) {
        System.out.println(name + " " + "is charging with:" + " " + charger.getChargerType());
    }


}
