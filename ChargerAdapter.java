public class ChargerAdapter implements UsbCCharger {
    private final String chargerType;

    public ChargerAdapter(String html) {
        int start = html.indexOf(">") + 1;       // после ">"
        int end = html.indexOf("</div>");        // до конца тега
        this.chargerType = html.substring(start, end);
    }

    @Override
    public String getChargerType() {
        return chargerType + " (adapted to USB-C)";
    }
}
