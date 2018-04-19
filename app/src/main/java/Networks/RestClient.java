package Networks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import Entity.LoginAction;
import Entity.UserItem;
import Util.JsonChangeStrUtil;

/**
 * Created by lenovo on 2018/4/19.
 */

public class RestClient {
    private static RestClient _instance;
    private static final String base_URI = "http://10.0.2.2:8080/";

    private String token;
    private String userName;

    public static RestClient getInstance() {
        if (_instance == null) {
            _instance = new RestClient();
        }
        return _instance;
    }
    //登录
    public int login(LoginAction action) throws IOException {
        int result = 0;
        BufferedReader reader = null;

        String uri = base_URI + "login";
        URL url = new URL(uri);
        HttpURLConnection uc = (HttpURLConnection) url.openConnection();
        uc.setDoInput(true);
        uc.setDoOutput(true);
        uc.setRequestProperty("Charset", "UTF-8");
        uc.setRequestProperty("Content-Type", "application/json");
        uc.setRequestProperty("Accept", "application/json");
        uc.setRequestMethod("POST");

        String json = JsonChangeStrUtil.convertJavaBeanToJson(action);
        if (json == null) {
            return -1;
        }

        if (json.length() != 0) {
            byte[] writebytes = json.getBytes();
            //设置文件长度
            uc.setRequestProperty("Content-Length", String.valueOf(writebytes.length));
        }
        OutputStream os = uc.getOutputStream();
        os.write(json.getBytes());
        os.flush();
        os.close();

        //控制台显示，debug或者加日志
        System.out.println("do Json Post(Login in): getResponseCode " + uc.getResponseCode()
                + "getResponseHeader: " + uc.getHeaderField("Authorization"));

        result = uc.getResponseCode();
        //成功返回
        if (uc.getResponseCode() == 200) {
            this.userName = action.getUsername();
            token = uc.getHeaderField("Authorization");
        }
        return result;
    }

    //注册
    public int signUp(UserItem action) {
        int result = 0;
        try {
            String uri = base_URI + "users/sign-up";
            URL url = new URL(uri);
            HttpURLConnection uc = (HttpURLConnection) url.openConnection();
            uc.setDoInput(true);
            uc.setDoOutput(true);
            uc.setRequestProperty("Charset", "UTF-8");
            uc.setRequestProperty("Content-Type", "application/json");
            uc.setRequestProperty("Accept", "application/json");
            uc.setRequestMethod("POST");

            String json = JsonChangeStrUtil.convertJavaBeanToJson(action);

            if (json == null) {
                return -1;
            }

            if (json.length() != 0) {
                byte[] writebytes = json.getBytes();
                //设置文件长度
                uc.setRequestProperty("Content-Length", String.valueOf(writebytes.length));
            }
            OutputStream os = uc.getOutputStream();
            os.write(json.getBytes());
            os.flush();
            os.close();

            //控制台显示，debug或者加日志
            System.out.println("do Json Post(Sign up): getResponseCode " + uc.getResponseCode());

            result = uc.getResponseCode();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
