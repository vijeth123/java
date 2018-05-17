package com.vijeth.design.pattern.structural;

interface Internet{
    public void connect(String url);
}

class RealInternet implements Internet{
    @Override
    public void connect(String url) {
        System.out.println("Connecting to internet: "+url);
    }
}

class InternetProxy implements Internet{
    private Internet internet = new RealInternet();
    @Override
    public void connect(String url) {
        switch (url){
            case "facebook.com":
            case "twitter.com" :
                System.out.println("Restricted");
                break;

            default:
                System.out.println("Connecting to internet: "+ url);
        }
    }
}

public class ProxyTest {
    public static void main(String[] args) {
        Internet proxy = new InternetProxy();
        proxy.connect("google.com");
        proxy.connect("facebook.com");
    }
}
