package com.ampro.robinhood.endpoint.account;

import com.ampro.robinhood.ApiMethod;

public class Account extends ApiMethod {

	protected Account() {

		super("account");

		//We do require a token for these methods. Thus we require it for all methods using this service
		this.requireToken();
	}

}
