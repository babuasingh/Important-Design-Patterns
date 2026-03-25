/*
What is the State Design Pattern?
The State Pattern allows an object to change its behavior based on its current state. Instead of using large if-else or switch-case blocks to handle different states, the behavior is encapsulated into state classes. The context delegates behavior to the current state object.

Key Concepts of the State Pattern:
State Interface: Defines the common behavior for all states.
Concrete States: Implement the behavior for each state.
Context: Maintains a reference to the current state and delegates requests to the current state object.

When to Use the State Design Pattern:
When an object’s behavior depends on its state.
When you have a lot of if-else or switch statements that change behavior based on state.
When the state-specific behavior changes frequently or needs to be easily extendable.

*/
interface TrafficLightState {
    void handleRequest(TrafficLightContext context);
}

class RedState implements TrafficLightState {
    @Override
    public void handleRequest(TrafficLightContext context) {
        System.out.println("Red Light - Stop");
        context.setState(new GreenState());
    }
}

class GreenState implements TrafficLightState {
    @Override
    public void handleRequest(TrafficLightContext context) {
        System.out.println("Green Light - Go");
        context.setState(new YellowState());
    }
}

class YellowState implements TrafficLightState {
    @Override
    public void handleRequest(TrafficLightContext context) {
        System.out.println("Yellow Light - Caution");
        context.setState(new RedState());
    }
}

class TrafficLightContext {
    private TrafficLightState currentState;

    public TrafficLightContext() {
        currentState = new RedState(); // Initial state
    }

    public void setState(TrafficLightState state) {
        currentState = state;
    }

    public void request() {
        currentState.handleRequest(this);
    }
}


public class StatePattern {
    public static void main(String[] args) {
        TrafficLightContext trafficLight = new TrafficLightContext();

        // Simulate traffic light changes
        for (int i = 0; i < 6; i++) {
            trafficLight.request();
            try {
                Thread.sleep(1000); // Wait for 1 second before changing state
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}