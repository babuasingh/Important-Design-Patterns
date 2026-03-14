/*
 * When to use the Adapter Pattern
    You want to use an existing class but its interface is incompatible.
    You want to integrate a third-party library into your system.
    You cannot modify the existing code.
 */

//new feature needed
interface USBCharger {
    void chargeWithUSB();
}


//existing feature
class OldCharger {
    public void chargeWithRoundPin() {
        System.out.println("Charging using Round Pin Charger");
    }
}

//Adaptor class to make the old charger compatible with the new USB charger interface
class ChargerAdapter implements USBCharger {

    private OldCharger oldCharger;

    public ChargerAdapter(OldCharger oldCharger) {
        this.oldCharger = oldCharger;
    }

    @Override
    public void chargeWithUSB() {
        oldCharger.chargeWithRoundPin();
    }
}


public class AdapterDesign {
    public static void main(String[] args) {
        OldCharger oldCharger = new OldCharger(); // existing 
        USBCharger adapter = new ChargerAdapter(oldCharger);
        adapter.chargeWithUSB();
    }
}
