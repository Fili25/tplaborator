import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.*;


public class Lab3 {



    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.printf("URL-");
        UrlCont urlCont = new UrlCont(scan.nextLine());
        System.out.printf("Глубина сканера-");
        int glubina = scan.nextInt();
        System.out.printf("Количество потоков-");
        int countthr = scan.nextInt();


        ArrayList<NetScaner> webScans = new ArrayList<>(countthr);


        for (int i = 0; i < countthr; i++) {
            NetScaner webScanner = new NetScaner(urlCont, glubina);
            webScanner.start();
            webScans.add(webScanner);
        }

        boolean proc = true;
        while (proc == true) {
            proc = false;
            for (NetScaner webScanner : webScans) {
                if (webScanner.getState() != Thread.State.WAITING) {
                    proc = true;
                    break;
                }
            }
        }

        Hashtable<String, UrlInfo> visitedUrl = urlCont.getVisitedUrl();
        Enumeration<UrlInfo> val = visitedUrl.elements();
        while (val.hasMoreElements()) {
            UrlInfo urlInfo = val.nextElement();
            System.out.println(urlInfo.getUrl());
        }
        System.out.println("Naideno URL: " + Integer.toString(visitedUrl.size()));
        scan.close();
    }
}
