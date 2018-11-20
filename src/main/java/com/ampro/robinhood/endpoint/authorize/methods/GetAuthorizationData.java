package com.ampro.robinhood.endpoint.authorize.methods;

import com.ampro.robinhood.Configuration;
import com.ampro.robinhood.endpoint.authorize.AuthorizationData;
import com.ampro.robinhood.net.request.RequestMethod;
import io.github.openunirest.http.exceptions.UnirestException;

/**
 * An {@link com.ampro.robinhood.net.ApiMethod} to log the user in. This sends
 * the username and password, and returns the token needed to authorize any more
 * account-specific requests.
 *
 * @author Jonathan Augustine
 */
public class GetAuthorizationData extends Authorize {

  
    /**
     * The Constant client_id. Value derived from
     * https://www.reddit.com/r/algotrading/
     * comments/9fatem/robinhood_api_login_issues/
     */
    public static final String CLIENT_ID = "c82SH0WZOsabOXGP2sxqcj34FxkvfnWRZBKlBjFS";


    /**
     * An {@link com.ampro.robinhood.net.ApiMethod} to log the user in. This
     * sends the email and password.
     * <br>
     *     If the account does not have Multifactor/Two-factor authorization
     *     enabled, this ApiMethod will return AuthData containing a token
     *     string. Otherwise, it will return the requirements for logging in
     *     (see {@link AuthorizationData#getMfaType()}.
     *
     * @param email The email used to log into Robinhood
     * @param password The password
     */
    public GetAuthorizationData(String email, String password)
    throws UnirestException {
        super(Configuration.getDefault());
        setUrlBase(RH_URL + "/oauth2/token/");
        //Add the parameters into the request
        this.addFieldParameter("username", email);
        this.addFieldParameter("password", password);
        this.addFieldParameter("client_id", CLIENT_ID);
        this.addFieldParameter("grant_type", "password");
        
        this.addHeaderParameter("Content-Type",
                                "application/x-www-form-urlencoded");

        //This needs to be ran as POST
        this.setMethodType(RequestMethod.POST);
        //Declare what the response should look like
        this.setReturnType(AuthorizationData.class);

    }

}
