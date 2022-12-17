public class reomveDuplicates {

    public static void removeduplicates(String str, int index, StringBuilder newstr, boolean map[])
    {
        //base case
        if(index == str.length())
        {
            System.out.println(newstr);
            return;
        }

        //kaam
        char currChar = str.charAt(index);
        if(map[currChar - 'a'] == true)
        {
            //duplicate character
            removeduplicates(str, index+1, newstr, map);
        }
        else
        {
            //new character
            map[currChar - 'a'] = true;
            removeduplicates(str, index+1, newstr.append(currChar), map);
        }

    }

    public static void main(String[] args) {
        String str = "ayushkumargupta";
        int index = 0;
        StringBuilder newstr = new StringBuilder("");
        boolean map[] = new boolean[26];
        removeduplicates(str, index, newstr, map);
    }
}
