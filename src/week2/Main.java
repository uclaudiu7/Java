package week2;

public class Main {
    public static void main(String[] args) {
        Location burla = new Location("Burla", locationType.VILLAGE);
        Location iasi = new Location("Iasi", locationType.CITY);
        Location gatwick = new Location("Gatwick Airport", locationType.AIRPORT);
        Road dn1 = new Road(roadType.HIGHWAY, 220, 180);
        Road m1 = new Road(roadType.EXPRESS, 4000, 200);
        System.out.println(burla);
        System.out.println(iasi);
        System.out.println(gatwick);
        System.out.println(dn1);
        System.out.println(m1);
    }
}
