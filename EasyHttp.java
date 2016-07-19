package ly.moment.test;


/*
 * Created by Salem Elmrayed on 7/12/2016.
 * Simple way to send HTTP requests
 * This based on volley
 *
 */

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Map;

public class EasyHttp {


    public final static int GET = 0;
    public final static int POST = 1;
    public final static int PUT = 2;
    public final static int DELETE = 3;
    public final static int HEAD = 4;
    public final static int OPTIONS = 5;
    public final static int TRACE = 6;
    public final static int PATCH = 7;

    private Context con = null;
    private String url = null;
    private StringRequest stringRequest = null;
    private JsonObjectRequest jsonObjReq = null;
    private JsonArrayRequest jsonArryReq = null;
    private boolean flag = false;
    private int method;
    private Map parameters = null;
    private Map Headers = null;
    private int responsecode;
    private Map<String, String> responseheaders = null;


    /**
     * Set up request information.
     *
     * @param url    Target url wich the request will be sent to
     * @param cont   The Activity that dealing with the response
     * @param method The request method
     */

    public EasyHttp(String url, Context cont, int method) {
        this.con = cont;
        this.url = url;
        this.method = method;
    }


    /**
     * Set up POST request parameters.
     *
     * @param parameters HashMap key : parametername , Value : the parameter values
     */

    public void setParams(Map parameters) {

        this.parameters = parameters;

    }

    /**
     * Set up request header.
     *
     * @param header HashMap key : Header name , Value : Header value
     */

    public void setRequestHeaders(Map header) {

        this.Headers = header;

    }

    /**
     * Get HTTP response code.
     */

    private int getResponseCode() {
        return this.responsecode;
    }


    /**
     * Get HTTP response headers.
     */
    private Map<String, String> getResponseHeaders() {
        return this.responseheaders;
    }


    /**
     * Send HTTP request to for expected response : text/html
     */

    public void SendRequest() {


        stringRequest = new StringRequest(this.method, this.url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        // Result handling

                        EasyHttp.this.handleResponse(response, EasyHttp.this.getResponseCode(), EasyHttp.this.getResponseHeaders());


                    }


                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                EasyHttp.this.handleErrorResponse(error);

            }
        }) {

            @Override
            protected Map<String, String> getParams() {

                return EasyHttp.this.parameters;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {

                if (EasyHttp.this.Headers != null) {

                    return EasyHttp.this.Headers;
                }
                return super.getHeaders();
            }

            @Override
            protected Response<String> parseNetworkResponse(NetworkResponse response) {
                EasyHttp.this.responsecode = response.statusCode;
                EasyHttp.this.responseheaders = response.headers;
                return super.parseNetworkResponse(response);

            }


        };
        Volley.newRequestQueue(con).add(stringRequest);


    }




    /**
     * The response will be handled here
     *
     * @param responseContent The response body
     * @param responseCode    The HTTP response code
     * @param responseHeaders The HTTP response headers
     */

    protected void handleResponse(String responseContent, int responseCode, Map responseHeaders) {


    }


    /**
     * When error happens this will be executed
     *
     * @param error The error information
     */

    protected void handleErrorResponse(VolleyError error) {


    }


}
