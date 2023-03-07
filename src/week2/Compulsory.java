package week2;

public class Compulsory {
    public static void main(String[] args) {
        Location burla = new Location("Burla", locationType.VILLAGE, 1, 1);
        Location iasi = new Location("Iasi", locationType.CITY, 2.0, 5.1);
        Location gatwick = new Location("Gatwick Airport", locationType.AIRPORT, 6.2, 5.2);
        Road dn1 = new Road(RoadType.HIGHWAY, 220, 180, burla, iasi);
        Road m1 = new Road(RoadType.EXPRESS, 4000, 200, iasi, gatwick);
        Road dn67 = new Road(RoadType.HIGHWAY, 100, 100, gatwick, burla);
        System.out.println(burla);
        System.out.println(iasi);
        System.out.println(gatwick);
        System.out.println(dn1);
        System.out.println(m1);
        System.out.println(dn67);
    }
}
