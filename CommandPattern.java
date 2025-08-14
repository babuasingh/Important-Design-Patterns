/*
When to use the Command Pattern
    When you need to encapsulate actions/operations as objects.
    For undo/redo, task queues, or remote execution.
    When you want to decouple the sender and receiver of a request.
 */
//command to execute
interface command{
    void execute();
}

//receiver -> Receiver - the real worker
class Light{
    public void LightOn(){
        System.out.println("Light ON");
    }
    public void LightOff(){
        System.out.println("Light OFF");
    }
}

// Concrete Commands
class LightONCommand implements command{
    private Light light;
    LightONCommand(Light light){
        this.light=light;
    }
    public void execute(){
        light.LightOn();
    }
}

// Concrete Commands
class LightOFFCommand implements command{
    private Light light;
    LightOFFCommand(Light light){
        this.light=light;
    }
    public void execute(){
        light.LightOff();
    }
}

// Invoker - remote control
class Remote{
    private command command;
    
    Remote(command command){
        this.command=command;
    }

    void pressButton(){
        command.execute();
    }

}


//client
public class CommandPattern {
    public static void main(String[] args) {
        Light light=new Light();
        LightONCommand lightON=new LightONCommand(light);
        LightOFFCommand lightOFF=new LightOFFCommand(light);

        Remote remote=new Remote(lightON);
        remote.pressButton();

        remote=new Remote(lightOFF);
        remote.pressButton();
    }
}
