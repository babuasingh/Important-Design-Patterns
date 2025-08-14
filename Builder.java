/*When to use the Builder Pattern
    When you need to build complex objects with many optional parameters.
    When object creation requires a step-by-step process.
    To avoid constructor overload with many parameters. */

    class User{
    
    private String name;
    private String email;
    private String phone;


    private User(UserBuilder obj){
        this.name=obj.name;
        this.email=obj.email;
        this.phone=obj.phone;
    }

    public static class UserBuilder{
        private  String name;
        private  String email;
        private  String phone;

        public UserBuilder setName(String name){
            this.name=name;
            return this;
        }

        public UserBuilder setMail(String mail){
            this.email=mail;
            return this;
        }

        public UserBuilder setPhone(String phone){
            this.phone=phone;
            return this;
        }

        public User build(){
            return new User(this);
        }
    }

    @Override
    public String toString(){
        return name+" "+email+" "+phone;
    }

}

public class Builder {
    public static void main(String[] args) {
        User one= new User.UserBuilder().setName("Sidd").setMail("temp").build();
        System.out.println(one);
    }    
}
