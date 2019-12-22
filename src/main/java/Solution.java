import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* Solution assumes we can't have the symbol "<" as text between tags */
public class Solution{

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while(testCases>0){
            String line = in.nextLine();
//https://www.hackerrank.com/challenges/tag-content-extractor/forum/comments/253626
// Explain the regular expression: <(.+)>([^<]+)</\1>
// <(.+)>  - matches HTML start tags. The parentheses save the contents inside the brackets into Group #1.
//            The dot "." matches any single character (except newline). The "+" matches 1 or more of whatever it comes after. Since it comes after the dot ".", we match 1 or more of any character. These characters are inside the brackets "<" and ">", so we can match any number of characters as long as they're within the brackets. That is exactly what an HTML tag is.
//            Also, the parentheses save the contents inside the brackets into Group #1.
// ([^<]+) - matches all the text in between the HTML start and end tags. We place a special restriction on the text in that it can't have the "<" symbol. The characters inside the parenthesis are saved into Group #2.
// </\\1>  - is to match the HTML end brace that corresponds to our previous start brace. The \1 is here to match all text from Group #1.
            boolean matchFound = false;
            Pattern r = Pattern.compile("<(.+)>([^<]+)</\\1>");
            Matcher m = r.matcher(line);

            while (m.find()) {
                System.out.println(m.group(2));
                matchFound = true;
            }
            if ( ! matchFound) {
                System.out.println("None");
            }


            testCases--;
        }
        in.close();
    }
}



