package com.b.simple.design.business.customer;

import java.math.BigDecimal;
import java.util.List;

import com.b.simple.design.business.exception.DifferentCurrenciesException;
import com.b.simple.design.model.customer.Amount;
import com.b.simple.design.model.customer.AmountImpl;
import com.b.simple.design.model.customer.Currency;
import com.b.simple.design.model.customer.Product;

public class CustomerBOImpl implements CustomerBO {

    @Override
    public Amount getCustomerProductsSum(List<Product> products)
            throws DifferentCurrenciesException {

        if (products.isEmpty()) {
            return new AmountImpl(BigDecimal.ZERO, Currency.EURO);
        }

        if (!doAllProductsHaveSameCurrency(products)) {
            throw new DifferentCurrenciesException();
        }
        return CalculateSumOfProducts(products);
    }

    private Amount CalculateSumOfProducts(List<Product> products) {
        BigDecimal productsSum = BigDecimal.ZERO;
        for (Product product : products) {
            productsSum = productsSum.add(product.getAmount().getValue());

        }
        final Currency firstProductCurrency = products.get(0).getAmount()
                .getCurrency();

        // Create new product
        return new AmountImpl(productsSum, firstProductCurrency);
    }

    private boolean doAllProductsHaveSameCurrency(List<Product> products) throws DifferentCurrenciesException {
        return products.stream().map(product -> product.getAmount()
                .getCurrency().equals(products.get(0).getAmount()
                        .getCurrency())).noneMatch(currencySameAsFirstProduct -> (!currencySameAsFirstProduct));
    }
}
