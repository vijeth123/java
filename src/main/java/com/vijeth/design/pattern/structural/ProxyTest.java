package com.vijeth.design.pattern.structural;

import java.util.ArrayList;
import java.util.List;

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

    private List<String> restrictedSites;

    public InternetProxy() {
        restrictedSites = new ArrayList<>();
        restrictedSites.add("facebook.com");
        restrictedSites.add("youtube.com");
        restrictedSites.add("orkut.com");
        restrictedSites.add("twitter.com");
    }

    @Override
    public void connect(String url) {
        if(restrictedSites.contains(url)) {
            System.out.println("Restricted site... Cannot connect to: "+url);
        }else{
            internet.connect(url);
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
