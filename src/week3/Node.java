package week3;
public interface Node{
    public String getName();
    public String getType();
    public int getImportance();
    public static void Print(Node node) {
        System.out.println(node.getName() + " (" + node.getType() + ")");
    }
}
