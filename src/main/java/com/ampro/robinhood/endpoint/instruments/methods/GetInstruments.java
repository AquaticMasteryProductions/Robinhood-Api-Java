package com.ampro.robinhood.endpoint.instruments.methods;

import com.ampro.robinhood.endpoint.instruments.Instruments;
import com.ampro.robinhood.endpoint.instruments.data.InstrumentsArrayWrapper;
import com.ampro.robinhood.parameters.HttpHeaderParameter;
import com.ampro.robinhood.request.RequestMethod;

public class GetInstruments extends Instruments
{
	public GetInstruments()
	{
		this("https://api.robinhood.com/instruments/");
	}

	public GetInstruments(String cursorURL)
	{
		this.setUrlBase(cursorURL);

		// Add the headers into the request
		this.addHttpHeaderParameter(new HttpHeaderParameter("Accept", "application/json"));

		// This method is run as GET
		this.setMethod(RequestMethod.GET);

		// Declare what the response should look like
		this.setReturnType(InstrumentsArrayWrapper.class);

	}
}
