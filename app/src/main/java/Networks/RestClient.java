package Networks;

/**
 * Created by lenovo on 2018/4/19.
 */

public class RestClient {
    private static RestClient _instance;
    private static final String base_URI = "http://localhost:8080/";

    public static RestClient getInstance() {
        if (_instance == null) {
            _instance = new RestClient();
        }
        return _instance;
    }
}
