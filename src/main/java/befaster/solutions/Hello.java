package befaster.solutions;


public class Hello {
    public static String hello(String friendName) {
        final String defaultName = "World";
        if (friendName == null) {
            friendName = defaultName;
        }
        return String.format("Hello, %s!", friendName);
    }
}
