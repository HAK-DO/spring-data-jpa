package com.hedleyproctor.domain.builder;

import java.math.BigDecimal;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.hedleyproctor.domain.Item;
import com.hedleyproctor.domain.Product;
import com.hedleyproctor.domain.Supplier;

/**
 * @author Igor Baiborodine
 */
public class ItemBuilder
        implements Builder<Item> {

    // required
    @Nonnull private String itemId;
    @Nonnull private Product product;

    // optional
    @Nullable private Supplier supplier;
    @Nullable private BigDecimal listPrice;
    @Nullable private BigDecimal unitCost;
    @Nullable private String status;
    @Nullable private Integer quantity;
    @Nullable private String attribute1;
    @Nullable private String attribute2;
    @Nullable private String attribute3;
    @Nullable private String attribute4;
    @Nullable private String attribute5;

    public ItemBuilder(@Nonnull final String itemId, @Nonnull final Product product) {
        // non-null validation is done in Item(itemId, product) constructor
        this.itemId = itemId;
        this.product = product;
    }

    public ItemBuilder supplier(@Nullable final Supplier supplier) {
        this.supplier = supplier;
        return this;
    }

    public ItemBuilder listPrice(@Nullable final BigDecimal listPrice) {
        this.listPrice = listPrice;
        return this;
    }

    public ItemBuilder unitCost(@Nullable final BigDecimal unitCost) {
        this.unitCost = unitCost;
        return this;
    }

    public ItemBuilder status(@Nullable final String status) {
        this.status = status;
        return this;
    }

    public ItemBuilder quantity(@Nullable final Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public ItemBuilder attribute1(@Nullable final String attribute1) {
        this.attribute1 = attribute1;
        return this;
    }

    public ItemBuilder attribute2(@Nullable final String attribute2) {
        this.attribute2 = attribute2;
        return this;
    }

    public ItemBuilder attribute3(@Nullable final String attribute3) {
        this.attribute3 = attribute3;
        return this;
    }

    public ItemBuilder attribute4(@Nullable final String attribute4) {
        this.attribute4 = attribute4;
        return this;
    }

    public ItemBuilder attribute5(@Nullable final String attribute5) {
        this.attribute5 = attribute5;
        return this;
    }

    @Override
    @Nonnull public Item build() {
        Item item = new Item(itemId, product);

        item.setSupplier(supplier);
        item.setStatus(status);
        item.setListPrice(listPrice);
        item.setUnitCost(unitCost);
        item.setAttribute1(attribute1);
        item.setAttribute2(attribute2);
        item.setAttribute3(attribute3);
        item.setAttribute4(attribute4);
        item.setAttribute5(attribute5);
        item.setQuantity(quantity);

        return item;
    }
}
