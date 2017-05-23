package regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by mvl on 23.05.2017.
 */
public class UrlValidator {
    private Pattern pattern;
    private Matcher matcher;

    private static final String URL_PATERN =
            "^((https?|ftp)\\:\\/\\/)?([a-z0-9]{1})((\\.[a-z0-9-])|([a-z0-9-]))*\\.([a-z]{2,4})$";

    public UrlValidator() {
        this.pattern = Pattern.compile(URL_PATERN);
    }

    public boolean validate(final String hex) {
        matcher = pattern.matcher(hex);

        return matcher.matches();
    }

    public static void main(String[] args) {
        UrlValidator urlValidator = new UrlValidator();

        System.out.println(urlValidator.validate("http://alpha-hydro.com"));
        System.out.println(urlValidator.validate("https://www.alpha-hydro.com"));
        System.out.println(urlValidator.validate("ftp://alpha-hydro.ru"));
        System.out.println(urlValidator.validate("http://alpha-hydro."));
    }

}
