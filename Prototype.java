/*When to use the Prototype Pattern
    When object creation is expensive or time-consuming.
    When you need to create many copies of similar objects.
    To clone existing objects instead of building new ones from scratch. */
class UserProto implements Cloneable {
    private String name;
    private String email;

    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public UserProto clone(){
        try {
            return (UserProto) super.clone();
        } catch (CloneNotSupportedException e) {
           return null;
        }
    }

    @Override
    public String toString() {
        return "User [name=" + name + ", email=" + email + "]";
    }

    
}

public class Prototype {
    public static void main(String[] args) {
        UserProto one=new UserProto();
        one.setName("sidd");
        System.out.println(one);

        UserProto two= one.clone();
        two.setEmail("siddemail.com");
        System.out.println(two);
    }
}
