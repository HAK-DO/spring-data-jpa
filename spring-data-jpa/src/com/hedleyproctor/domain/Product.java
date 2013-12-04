package com.hedleyproctor.domain;

import java.io.Serializable;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import com.google.common.base.Objects;


@Entity(name = "product")
@NamedQueries({
        @NamedQuery(name = "Product.getProductListByCategory",
                query = "select p from product p where p.category = :category"),
        @NamedQuery(name = "Product.searchProductList",
                query = "select p from product p where lower(p.name) like :name")
})
public class Product implements Serializable {

	private static final long serialVersionUID = 5277086297847945141L;

	@Nonnull
    @Id
    @Column(name = "productid", unique = true, nullable = false, length = 10)
    private String productId;

    @Nullable
    @Column(name = "name", nullable = true, length = 80)
    private String name;

    @Nullable
    @Column(name = "descn", nullable = true, length = 255)
    private String description;

    @Nonnull
    @ManyToOne(optional = false, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "categoryid", referencedColumnName = "catid")
    private Category category;

    protected Product() {}

    public Product(@Nonnull final String productId, @Nonnull final Category category) {
    }


    @Nonnull public String getProductId() {
        return productId;
    }
    // no setter for productId

    @Nonnull public String getCategoryId() {
        return category.getCategoryId();
    }

    @Nonnull
    public Category getCategory() {
        return category;
    }

    @Nullable public String getName() {
        return name;
    }

    public void setName(@Nullable final String name) {
        this.name = name;
    }

    @Nullable public String getDescription() {
        return description;
    }

    public void setDescription(@Nullable final String description) {
        this.description = description;
    }

    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (! (o instanceof Product)) {
            return false;
        }
        Product that = (Product) o;
        return Objects.equal(this.getProductId(), that.getProductId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getProductId());
    }

}
