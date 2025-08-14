/*
 * When to use the Adapter Pattern
    When two classes don’t match interfaces but need to work together.
    When integrating with legacy code or third-party libraries.
    To make existing classes compatible with new code.
 */

//new feature needed
interface RoundBox {
    void fitRoundBoxInSquareHole();
}

//existing feature
class SquareBox{
    public void fitInSquareHole(){
        System.out.println("Square Box fits in Square Hole");
    }
}

//Adapting the new feature
class SquareHoleAdapter implements RoundBox{
    private SquareBox squareHole;
    
    public SquareHoleAdapter(){
        squareHole=new SquareBox();
    }

    @Override
    public void fitRoundBoxInSquareHole(){
        System.out.println("Fitting the Round Box in the square hole");
        squareHole.fitInSquareHole();
    }
}


class FittingTheBoxInHole{
    public void fitTheBox(String type){
        if(type.equalsIgnoreCase("square")){
            SquareBox square = new SquareBox();
            square.fitInSquareHole();
        }else if(type.equalsIgnoreCase("round")){
            RoundBox round=new SquareHoleAdapter();
            round.fitRoundBoxInSquareHole();
        }else{
            System.out.println("Feature not supported yet");
        }
    }
}

public class AdapterDesign {
    public static void main(String[] args) {
        FittingTheBoxInHole obj=new FittingTheBoxInHole();
        obj.fitTheBox("square");
        obj.fitTheBox("round");
        obj.fitTheBox("pantagon");
    }
}
