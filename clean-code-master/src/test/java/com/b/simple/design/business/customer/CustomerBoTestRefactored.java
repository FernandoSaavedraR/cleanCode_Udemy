/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.b.simple.design.business.customer;

import com.b.simple.design.business.exception.DifferentCurrenciesException;
import com.b.simple.design.model.customer.Amount;
import com.b.simple.design.model.customer.AmountImpl;
import com.b.simple.design.model.customer.Currency;
import com.b.simple.design.model.customer.Product;
import com.b.simple.design.model.customer.ProductImpl;
import com.b.simple.design.model.customer.ProductType;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Fernando
 */
public class CustomerBoTestRefactored {

    private final CustomerBO customerBO = new CustomerBOImpl();

    @Test
    public void testCustomerProductSum_TwoProductsSameCurrencies()
            throws DifferentCurrenciesException {
        Amount[] ammounts = {
            new AmountImpl(new BigDecimal("5.0"), Currency.EURO),
            new AmountImpl(new BigDecimal("6.0"), Currency.EURO)};
        List<Product> products = FillArrayWithAmmounts(ammounts);

        Amount actual = customerBO.getCustomerProductsSum(products);

        Amount expected = new AmountImpl(new BigDecimal("11.0"), Currency.EURO);
        assertAmmount(expected, actual);
    }

    private void assertAmmount(Amount expected, Amount actual) {
        assertEquals(expected.getCurrency(), actual.getCurrency());
        assertEquals(expected.getValue(), actual.getValue());
    }

    @Test
    public void testCustomerProductSum2_EmptyProducts() throws DifferentCurrenciesException {

        List<Product> products = new ArrayList<>();

        Amount actual = customerBO.getCustomerProductsSum(products);
        Amount expected = new AmountImpl(BigDecimal.ZERO,Currency.EURO);
        assertAmmount(expected, actual);
    }

    private List<Product> FillArrayWithAmmounts(Amount[] ammounts) {
        List<Product> products = new ArrayList<>();
        for (Amount ammount : ammounts) {
            products.add(new ProductImpl(100, "Product 15", ProductType.BANK_GUARANTEE, ammount));
        }
        return products;
    }
}
