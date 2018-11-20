package com.ampro.robinhood.endpoint.authorize;

import com.ampro.robinhood.endpoint.ApiElement;
import com.ampro.robinhood.endpoint.RobinhoodEnum;

/**
 * A wrapper for both possible API login responses.
 * It holds a token {@link String}, {@link MultifactorType multifactor auth type}
 * and whether multifactor is required for the account.
 * <br>
 *     MultifactorAuthorization (or Two-factor Authorization) is referred to as
 *     {@code mfa} by the Robinhood Api. (Robinhood calls it Two-Factor, but the
 *     Api calls it multifactor...).
 *
 * @author Jonathan Augustine
 * @since 0.8.4
 */
public class AuthorizationData implements ApiElement {

    /** The authorization token used to authorize private ApiMethods */
    private String access_token;
  
    /** The type of multifactor authorization */
    private String mfa_type;
  
    /** Whether multifactor is required to login */
    private boolean mfa_required = false;
  
    /** The multifactor authorization code to enable login */
    private String mfaCode;
  
    /**
     * A wrapper for deserializing token strings from Robinhood
     * @author Conrad Weisse
     */
    public static class Token implements ApiElement {
        /** The actual authorization token string.
         * This name must have an underscore for json unmarshalling. */
        private String access_token;
        /** @return The actual authorization token string */
        public String getToken() { return this.access_token; }
        /** @return The actual authorization token string */
        @Override
        public String toString() { return this.access_token; }
    }

    /**
     * A wrapper for the types of multifactor authorizations.
     * @author Jonathan Augustine
     */
    public enum MultifactorType implements RobinhoodEnum {
        SMS("sms"),
        APP("app");

        private String value;
        MultifactorType(String s) { value = s; }

        /**
         * Parse a {@link MultifactorType} from a string from the Robinhood Api.
         * @param s The string to parse
         * @return The parsed {@link MultifactorType} or null
         */
        public static MultifactorType parse(String s) {
            switch (s) {
                case "sms": return SMS;
                case "app": return APP;
                default: return null;
            }
        }

        @Override
        public String getValue() { return value; }

        @Override
        public String toString() { return value; }
    }


    /** @return The authorization token used to authorize private ApiMethods */
    public String getToken() {
        return access_token;
    }

    /**
     * Set the token used to authorize private ApiMethods.
     * @param newToken The new token
     */
    public void setToken(String newToken) {
        this.access_token = newToken;
    }

    /**
     * Set the token used to authorize private ApiMethods.
     * @param newToken The new token
     */
    public void setToken(Token newToken) {
        this.access_token = newToken.getToken();
    }

    /** @param mfaCode The new multifactor authorization code */
    public void setMfaCode(String mfaCode) {
        this.mfaCode = mfaCode;
    }

    /** @return The code used to login with multifactor authorization */
    public String getMfaCode() {
        return mfaCode;
    }

    /** @return Whether multifactor authorization is required to log in */
    public boolean mfaRequired() {
        return mfa_required;
    }

    /** @return The {@link MultifactorType} needed to login */
    public MultifactorType getMfaType() {
        return MultifactorType.parse(mfa_type);
    }

    /** @return [TOKEN=%s][MFA_CODE=%s][MFA_TYPE=%s][MFA_REQUIRED=%s] */
    @Override
    public String toString() {
        return String.format("[TOKEN=%s][MFA_CODE=%s][MFA_TYPE=%s][MFA_REQUIRED=%s]",
            access_token, mfaCode, mfa_type, mfa_required);
    }
}
