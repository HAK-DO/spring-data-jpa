package com.hedleyproctor.domain.builder;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.hedleyproctor.domain.Category;
import com.hedleyproctor.domain.Product;

/**
 * @author Igor Baiborodine
 */
public class ProductBuilder implements Builder<Product> {

    // required
    private String productId;
    private Category category;

    // optional
    private String name;
    private String description;

    public ProductBuilder(@Nonnull final String productId, @Nonnull final Category category) {
        // non null validation is done in Product(productId, category) constructor
        this.productId = productId;
        this.category = category;
    }

    public ProductBuilder name(@Nullable final String name) {
        this.name = name;
        return this;
    }

    public ProductBuilder description(@Nullable final String description) {
        this.description = description;
        return this;
    }

    @Override
    @Nonnull public Product build() {
        Product product = new Product(productId, category);
        product.setName(name);
        product.setDescription(description);
        return product;
    }
}
