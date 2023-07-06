import java.util.Scanner;

   public class Flight {
    public static void main (String [] args) {
        
        double finalradius = 3963.1676;

        double homelatitude;
        double homelongitude;
        double destlatitude;
        double destlongitude;
        
        char homeNorthSouth;
        char homeEastWest;
        char destNorthSouth;
        char destEastWest;

        homelatitude = Double.parseDouble(args[0]);
        homeNorthSouth = args[1].charAt(0);
        homelongitude =  Double.parseDouble(args[2]);
        homeEastWest = args[3].charAt(0);

        destlatitude = Double.parseDouble(args[4]);
        destNorthSouth = args[5].charAt(0);
        destlongitude = Double.parseDouble(args[6]);
        destEastWest = args[7].charAt(0);

        if (homeNorthSouth == 'S'||homeNorthSouth =='s') {
            homelatitude *= -1;
        }
        if (homeEastWest == 'W'||homeEastWest =='w') {
            homelongitude *= -1;
        }
        if (destNorthSouth == 'S'|| destNorthSouth =='s') {
            destlatitude *= -1;
        }
        if (destEastWest == 'W'||destEastWest =='w'){
            destlongitude *= -1;
        }

        double srfhomelat = homelatitude * Math.PI/180;
        double srfhomelong = homelongitude * Math.PI/180;
        double srfdestlat = destlatitude * Math.PI/180;
        double srfdestlong = destlongitude * Math.PI/180;

        System.out.println("Home coordinates: " + homelatitude+homeNorthSouth + ", " + homelongitude + homeEastWest);
        System.out.println("Destination coordinates: " + destlatitude +destNorthSouth+ ", " + destlongitude + destEastWest);

        double latitudeDiff = srfdestlat - srfhomelat;
        double latitude1 = Math.sin(latitudeDiff/2);
        double latitude2 = Math.pow(latitude1, 2);
        double latitudefinal = latitude2;

        double longitudeDiff = srfdestlong - srfhomelong;
        double longitude1 = Math.sin(longitudeDiff/2);
        double longitude2 = Math.pow(longitude1, 2);
        double longitudefinal = longitude2;

        double v = latitudefinal+longitudefinal * Math.cos(srfhomelat) * Math.cos(srfdestlat);
        double distance = 2 * finalradius * Math.atan2(Math.sqrt(v), Math.sqrt(1-v));
        System.out.println(distance);

        System.out.println("Would you like a map?");
        Scanner scanner = new Scanner (System.in);
        String reader = scanner.nextLine();

        if (reader.equalsIgnoreCase("yes")) {
           String url = "https://www.mapquestapi.com/staticmap/v5/map?"
            + "key=t8xhSEnIxadDAwSL0fSuJer5JAWqGPZ5&size=400,400&type=map&"
            + "locations=" + homelatitude + "," + homelongitude + "|marker-green-A||"
            + destlatitude + "," + destlongitude + "|marker-red-B&shape=color:0xff0000|" + "width:3|"
            + homelatitude + "," + homelongitude + "|" + destlatitude + "," + destlongitude;

            System.out.println(url);
           // StdDraw.picture(0.5, 0.5, url);
            
        }
    }
}