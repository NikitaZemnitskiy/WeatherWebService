import java.net.URI;
import java.net.URISyntaxException;

public class TestURI {
    public static void main() throws URISyntaxException {
        URI url = new URI("smtp://fake_mail:25");
        System.out.println(url.getHost());
    }
}
