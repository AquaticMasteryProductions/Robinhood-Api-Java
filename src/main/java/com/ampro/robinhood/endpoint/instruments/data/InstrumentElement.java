package com.ampro.robinhood.endpoint.instruments.data;

import java.net.URL;

public class InstrumentElement
{
	// Unknow if right type
	private String tradable_chain_id;
	private float min_tick_size;
	private String type;
	private URL splits;
	private float margin_initial_ratio;
	private URL url;
	private URL quote;
	private String tradability;
	private String bloomberg_unique;
	private String list_date;
	private String name;
	private String symbol;
	private URL fundamentals;
	private String state;
	private String country;
	private float day_trade_ratio;
	private boolean tradeable;
	private float maintenance_ratio;
	private String id;
	private URL market;
	// Unknow if right type
	private String simple_name;

	/**
	 * Unknown
	 * 
	 * @return
	 */
	public String getTradable_chain_id()
	{
		return tradable_chain_id;
	}

	/**
	 * 
	 * @return Note: Might be null. See http://www.finra.org/industry/tick-size-pilot-program
	 */
	public float getMin_tick_size()
	{
		return min_tick_size;
	}

	/**
	 * Unknown
	 * 
	 * @return
	 */
	public String getType()
	{
		return type;
	}

	/**
	 * 
	 * @return Link to the split list for this security
	 */
	public URL getSplits()
	{
		return splits;
	}

	/**
	 * Unknown
	 * 
	 * @return
	 */
	public float getMargin_initial_ratio()
	{
		return margin_initial_ratio;
	}

	/**
	 * 
	 * @return Endpoint where more information about this security may be grabbed
	 */
	public URL getUrl()
	{
		return url;
	}

	/**
	 * 
	 * @return Endpoint where quote data about this security may be grabbed
	 */
	public URL getQuote()
	{
		return quote;
	}

	/**
	 * Unknown
	 * 
	 * @return
	 */
	public String getTradability()
	{
		return tradability;
	}

	/**
	 * 
	 * @return Bloomberg Global ID (BBGID) for this security. See http://bsym.bloomberg.com/sym/
	 */
	public String getBloomberg_unique()
	{
		return bloomberg_unique;
	}

	/**
	 * 
	 * @return Date this security was first traded publically on the exchange
	 */
	public String getList_date()
	{
		return list_date;
	}

	/**
	 * 
	 * @return Basic name of the security. Perfect for display
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * 
	 * @return The ticker symbol for this security
	 */
	public String getSymbol()
	{
		return symbol;
	}

	/**
	 * 
	 * @return Link to fundamental data for this security
	 */
	public URL getFundamentals()
	{
		return fundamentals;
	}

	/**
	 * 
	 * @return Indicates whether the security is "active" or not
	 */
	public String getState()
	{
		return state;
	}

	/**
	 * 
	 * @return Two char country code for the security's home office or headquarter
	 */
	public String getCountry()
	{
		return country;
	}

	/**
	 * Unknown
	 * 
	 * @return
	 */
	public float getDay_trade_ratio()
	{
		return day_trade_ratio;
	}

	/**
	 * 
	 * @return Indicates whether the security can be traded on Robinhood
	 */
	public boolean isTradeable()
	{
		return tradeable;
	}

	/**
	 * Unknown
	 * 
	 * @return
	 */
	public float getMaintenance_ratio()
	{
		return maintenance_ratio;
	}

	/**
	 * 
	 * @return The instrument id of this security
	 */
	public String getId()
	{
		return id;
	}

	/**
	 * 
	 * @return Link to the market/exchange this security is traded on
	 */
	public URL getMarket()
	{
		return market;
	}

	/**
	 * Unknown
	 * 
	 * @return
	 */
	public String getSimple_name()
	{
		return simple_name;
	}

}
