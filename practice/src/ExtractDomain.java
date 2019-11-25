import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractDomain {
    public static void main(String args[]){
        //String pattern = "^(?:[^/]+://)?([^/:]+)";
        String pattern = "/^(http(s)?(:\\/\\/))?(www\\.)?\\.(\\/.*)?$/";
                  String input = "(http://www.archive.com/web/http://www.mrvc.indianrai.gov.in/overview)";

        Matcher matcher = Pattern.compile(pattern).matcher(input);
        while (matcher.find()) {
            System.out.println(matcher.group());
            int start = matcher.start(1);
            int end = matcher.end(1);
            String result = input.substring(start,end).replaceFirst("www.","");
            if(result.startsWith("www.") ){
                input.substring(start,end).replaceFirst("www.","");
            }else if(result.startsWith("ww2.")){
                input.substring(start,end).replaceFirst("ww2.","");
            }else if(result.startsWith("web.")){
                input.substring(start,end).replaceFirst("web.","");
            }
            System.out.println(result);

        }
    }

    public static String findDomains(String input){
        String pattern = "^(?:[^/]+://)?([^/:]+)";
        Matcher matcher = Pattern.compile(pattern).matcher(input);
        StringBuilder result = new StringBuilder();
        while (matcher.find()) {
            int start = matcher.start(1);
            int end = matcher.end(1);
            String substr =  input.substring(start,end).replaceFirst("www.","");
            if(substr.startsWith("www.") ){
                substr.substring(start,end).replaceFirst("www.","");
            }else if(substr.startsWith("ww2.")){
                substr.substring(start,end).replaceFirst("ww2.","");
            }else if(substr.startsWith("web.")){
                substr.substring(start,end).replaceFirst("web.","");
            }
            result.append(substr).append(";");
        }
        return result.toString();
    }
}
