/*
When to use the Proxy Pattern
    When you want to control access to another object.
    For lazy loading, caching, logging, or security checks.
    When adding a middle layer between client and real object.
 */

import java.util.List;
import java.util.ArrayList;
interface Internet{
    void connectTo(String hostname);
}

class RealInternet implements Internet{
    public void connectTo(String hostname){
        System.out.println("Connectingto host : "+hostname);
    }
}

class ProxyServer implements Internet{
    private static Internet internet;
    private static List<String> banned;

    static{
        internet=new RealInternet();
        banned=new ArrayList<>();
        banned.add("facebook.com");
        banned.add("instagram.com");
    }

    public void connectTo(String host){
        if(banned.contains(host.toLowerCase())){
            System.out.println("Not Allowed to visit the host ,"+host);
            return;
        }
        internet.connectTo(host);
    }

}

public class ProxyDesign {
    public static void main(String[] args) {
        Internet proxy = new ProxyServer();
        proxy.connectTo("google.com");
        proxy.connectTo("facebook.com");
    }
}
