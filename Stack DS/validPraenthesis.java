import java.util.Stack;

public class validPraenthesis {

    public static boolean isValid(String str)
    {
        Stack<Character> s = new Stack<>();
        for(int i=0; i<str.length(); i++)
        {
            char ch = str.charAt(i);

            if(ch =='(' || ch == '{' || ch == '[')    //opeaning
            {
                s.push(ch);
            }
            else            //closind
            {
                if(s.isEmpty())
                {
                    return false;
                }

                if((s.peek() == '(' && ch == ')')
                    ||(s.peek() == '{' && ch == '}')
                    || (s.peek() == '[' && ch == ']'))
                {
                    s.pop();
                }
                else
                {
                    return false;
                }
            }
        }

        if(s.isEmpty())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public static void main(String[] args) {
        String str = "({[]})";
        System.out.println(isValid(str));
    }
}
