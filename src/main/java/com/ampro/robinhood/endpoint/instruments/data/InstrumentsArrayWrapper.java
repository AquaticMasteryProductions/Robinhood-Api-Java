package com.ampro.robinhood.endpoint.instruments.data;

public class InstrumentsArrayWrapper
{
	private String next;
	private String previous;

	private InstrumentElement[] results;

	/**
	 * Will exist for all, but possibly the final page
	 * 
	 * @return next cursor parameter
	 */
	public String getNext()
	{
		return next;
	}

	/**
	 * Does not exist on the first page
	 * 
	 * @return previous cursor parameter
	 */
	public String getPrevious()
	{
		return previous;
	}

	/**
	 * @return list of instruments from the paginated list
	 */
	public InstrumentElement[] getResults()
	{
		return results;
	}
}
