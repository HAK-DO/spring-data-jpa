package com.hedleyproctor.domain.builder;

import javax.annotation.Nonnull;

import com.hedleyproctor.domain.CartItem;
import com.hedleyproctor.domain.LineItem;

/**
 * @author Igor Baiborodine
 */
public class LineItemBuilder
        implements Builder<LineItem> {
    @Nonnull
    private Integer orderId;
    @Nonnull
    private Integer lineNumber;
    @Nonnull
    private CartItem cartItem;

    public LineItemBuilder(@Nonnull final Integer lineNumber, @Nonnull final CartItem cartItem) {
        // non-null validation is done in LineItem(lineNumber, cartItem) constructor
        this.lineNumber = lineNumber;
        this.cartItem = cartItem;
    }

    @Nonnull
    public LineItemBuilder orderId(@Nonnull final Integer orderId) {
        this.orderId = orderId;
        return this;
    }

    @Override @Nonnull
    public LineItem build() {
        LineItem lineItem = new LineItem(lineNumber, cartItem);
        lineItem.setOrderId(orderId);
        return lineItem;
    }
}
