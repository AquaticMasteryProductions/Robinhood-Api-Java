package com.ampro.robinhood.endpoint.orders.methods;

import com.ampro.robinhood.ConfigurationManager;
import com.ampro.robinhood.endpoint.orders.Orders;
import com.ampro.robinhood.endpoint.orders.enums.OrderTransactionType;
import com.ampro.robinhood.endpoint.orders.enums.TimeInForce;
import com.ampro.robinhood.endpoint.orders.throwables.InvalidTickerException;
import com.ampro.robinhood.parameters.UrlParameter;
import com.ampro.robinhood.throwables.RobinhoodApiException;

public class MakeLimitOrder extends Orders {

	private String ticker = null;
	private TimeInForce time = null;
	private float limitPrice = 0;
	private int quantity = 0;
	private OrderTransactionType orderType = null;

	private String tickerInstrumentUrl = null;

	public MakeLimitOrder(String ticker, TimeInForce time, float limitPrice, int quantity, OrderTransactionType orderType) throws
            RobinhoodApiException, InvalidTickerException {

		this.ticker = ticker;
		this.time = time;
		this.limitPrice = limitPrice;
		this.quantity = quantity;
		this.orderType = orderType;

		//Set the normal parameters for this endpoint
		setEndpointParameters();

		//Set the order parameters
		setOrderParameters();

		try {

			//Verify the ticker, and add the instrument URL to be used for later
			this.tickerInstrumentUrl = verifyTickerData(this.ticker);

		} catch (Exception e) {

			//If there is an invalid ticker, set this order to be unsafe
			this.setOrderSafe(false);
		}


	}


	/**
	 * Method which sets the URLParameters for correctly so the order is ran as a
	 * Limit Buy order, given the settings from the constructor
	 */
	protected void setOrderParameters() {

		//Add the account URL for the currently logged in account
		this.addUrlParameter(new UrlParameter("account", ConfigurationManager.getInstance().getAccountUrl()));
		this.addUrlParameter(new UrlParameter("instrument", this.tickerInstrumentUrl));
		this.addUrlParameter(new UrlParameter("symbol", this.ticker));
		this.addUrlParameter(new UrlParameter("type", "limit"));
		this.addUrlParameter(new UrlParameter("time_in_force", getTimeInForceString(this.time)));
		this.addUrlParameter(new UrlParameter("price", this.limitPrice));
		this.addUrlParameter(new UrlParameter("trigger", "immediate"));
		this.addUrlParameter(new UrlParameter("quantity", String.valueOf(this.quantity)));
		this.addUrlParameter(new UrlParameter("side", getOrderSideString(orderType)));
	}





}
