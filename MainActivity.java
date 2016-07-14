package ly.moment.sa;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


import com.android.volley.VolleyError;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity {


    EasyHttp a = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void SendHttpGETRequest() {

        // Send Normal http request
        this.a = new EasyHttp("http://192.168.1.18/android/get.php?test=1", MainActivity.this, EasyHttp.GET) {

            /**
             * The response will be handled here
             *
             * @param responseContent The response body
             * @param responseCode    The HTTP response code
             * @param responseHeaders The HTTP response headers
             */
            protected void handleResponse(String responseContent, int responseCode, Map responseHeaders) {

                // Do something

            }

            /**
             * When error happens this will be executed
             *
             * @param error The error information
             */

            protected void handleErrorResponse(VolleyError error) {

                // Do something

            }

        };

        // Set custom request headers ~ "Optional"

        HashMap<String, String> headers = new HashMap<>();
        headers.put("token", "123123123");
        this.a.setRequestHeaders(headers);

        // Send The request to Server;

        this.a.TextRequest();


    }

    public void SendHttpPOSTRequest() {

        // Send Normal http request
        this.a = new EasyHttp("http://192.168.1.18/android/post.php", MainActivity.this, EasyHttp.POST) {

            /**
             * The response will be handled here
             *
             * @param responseContent The response body
             * @param responseCode    The HTTP response code
             * @param responseHeaders The HTTP response headers
             */

            protected void handleResponse(String responseContent, int responseCode, Map responseHeaders) {

                // Do something

            }

            /**
             * When error happens this will be executed
             *
             * @param error The error information
             */


            protected void handleErrorResponse(VolleyError error) {

                // Do something

            }

        };

        // Set Post parameters

        HashMap<String, String> params = new HashMap<>();
        params.put("username","sam");
        params.put("pass","123456");
        this.a.setParams(params);



        // Set custom request headers ~ "Optional"

        HashMap<String, String> headers = new HashMap<>();
        headers.put("token", "123123123");
        this.a.setRequestHeaders(headers);

        // Send The request to Server;

        this.a.TextRequest();


    }


    public void SendHttpGETRequestJsonResponse() {

        // Send Normal http request
        this.a = new EasyHttp("http://192.168.1.18/android/x.json", MainActivity.this, EasyHttp.GET) {

            /**
             * The response will be handled here
             *
             * @param responseContent The response body
             * @param responseCode    The HTTP response code
             * @param responseHeaders The HTTP response headers
             */
            protected void handleResponse(JSONObject responseContent, int responseCode, Map responseHeaders) {

                // Do something

            }

            /**
             * When error happens this will be executed
             *
             * @param error The error information
             */

            protected void handleErrorResponse(VolleyError error) {

                // Do something

            }

        };

        // Set custom request headers ~ "Optional"

        HashMap<String, String> headers = new HashMap<>();
        headers.put("token", "123123123");
        this.a.setRequestHeaders(headers);

        // Send The request to Server;

        this.a.JsonRequest();


    }


    public void SendHttpGETRequestJsonArrayResponse() {

        // Send Normal http request
        this.a = new EasyHttp("http://192.168.1.18/android/x.json", MainActivity.this, EasyHttp.GET) {

            /**
             * The response will be handled here
             *
             * @param responseContent The response body
             * @param responseCode    The HTTP response code
             * @param responseHeaders The HTTP response headers
             */
            protected void handleResponse(JSONArray responseContent, int responseCode, Map responseHeaders) {

                // Do something

            }

            /**
             * When error happens this will be executed
             *
             * @param error The error information
             */

            protected void handleErrorResponse(VolleyError error) {

                // Do something

            }

        };

        // Set custom request headers ~ "Optional"

        HashMap<String, String> headers = new HashMap<>();
        headers.put("token", "123123123");
        this.a.setRequestHeaders(headers);

        // Send The request to Server;

        this.a.JsonArrayRequest();


    }




}
