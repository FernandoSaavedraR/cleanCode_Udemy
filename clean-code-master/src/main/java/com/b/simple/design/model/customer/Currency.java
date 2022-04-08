package com.b.simple.design.model.customer;

import java.util.stream.Stream;

public enum Currency {

	EURO("EUR"), UNITED_STATES_DOLLAR("USD"), INDIAN_RUPEE("INR");

	private final String textValue;

	Currency(final String textValue) {
		this.textValue = textValue;
	}

	@Override
	public String toString() {
		return textValue;
	}

    public Stream<Object> equals() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
