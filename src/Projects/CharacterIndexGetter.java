package Projects;

public class CharacterIndexGetter {
    public static void show(String s) {
        int count1 = 0 ;
        int count2 = 0;
        while (s.indexOf("a") >= 0)
        {
            int i = s.indexOf("a");
            int record = i + (count1 - count2);
            System.out.println(record);
            count1 = s.length();

            s = s.substring(i+1);
            count2 = s.length();
        }
    }
}
