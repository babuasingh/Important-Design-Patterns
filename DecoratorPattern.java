/*When to use the Decorator Pattern
    When you want to add responsibilities/features dynamically to an object.
    To extend functionality without modifying the original class.
    For flexible and reusable wrappers (e.g., UI components, logging). */

    
interface pizza{
    String description();
    double price();
}

class SimplePizza implements pizza{
    @Override
    public String description() {
        return "A Simple Pizza ...........";
    }
    @Override
    public double price() {
        return 100.0;
    }
}

class CheeseBurstPizza implements pizza{
    private pizza pizza;

    public CheeseBurstPizza(pizza pizza){
        this.pizza=pizza;
    }

    @Override
    public String description() {
       return this.pizza.description()+" ,with extra Cheese ......................";
    }

    @Override
    public double price() {
        return this.pizza.price()+170;
    }
}

class OnionPizza implements pizza{
    private pizza pizza;

    public OnionPizza(pizza pizza){
        this.pizza=pizza;
    }

    @Override
    public String description() {
        return this.pizza.description()+", with Onions ........................";
    }

    @Override
    public double price() {
        return this.pizza.price()+80;
    }
}

public class DecoratorPattern {
    public static void main(String[] args) {
        pizza pizza=new SimplePizza();

        pizza=new OnionPizza(pizza);

        pizza=new CheeseBurstPizza(pizza);


        System.out.println(pizza.description()+" has price :- "+pizza.price());


    }
}
