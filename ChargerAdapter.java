public class ChargerAdapter implements UsbCCharger {
    private final String chargerType;

    public ChargerAdapter(String html) {
        int start = html.indexOf(">") + 1;    
        int end = html.indexOf("</div>");       
        this.chargerType = html.substring(start, end);
    }

    @Override
    public String getChargerType() {
        return chargerType + " (adapted to USB-C)";
    }
}

