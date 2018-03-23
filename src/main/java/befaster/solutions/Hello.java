package befaster.solutions;


public class Hello {
    public static String hello(String friendName) {
        if (friendName != null) {
            return "Hello, " + friendName + "!";
        }
        return "Hello, World!";
    }
}
