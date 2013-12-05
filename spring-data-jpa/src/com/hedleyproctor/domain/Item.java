package com.hedleyproctor.domain;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;
import java.math.BigDecimal;

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
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;

import com.google.common.base.Objects;

@Entity(name = "item")
@SecondaryTable(
		name = "inventory",
        pkJoinColumns = @PrimaryKeyJoinColumn(
        		name = "itemid", 
        		referencedColumnName = "itemid"))
@NamedQueries({
        @NamedQuery(
        		name = "Item.getItemListByProduct",
                query = "select i from item i where i.product = :product"),
        @NamedQuery(
        		name = "Item.getInventoryQuantity",
                query = "select i.quantity from item i where i.itemId = :itemId"),
        @NamedQuery(
        		name = "Item.updateInventoryQuantity",
                query = "update item i set i.quantity = i.quantity - :increment where i.itemId = :itemId")
})
public class Item extends BaseDomain implements Serializable {

	private static final long serialVersionUID = -3981484093907996532L;

	@Nonnull @Id @Column(name = "itemid", unique = true, nullable = false, length = 10)
    private String itemId;

    @Nonnull
    @ManyToOne(optional = false, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "productid", referencedColumnName = "productid")
    private Product product;

    @Nullable
    @ManyToOne(optional = true, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "supplierid", referencedColumnName = "suppid")
    private Supplier supplier;

    @Nullable @Column(name = "listprice", nullable = true, precision = 10, scale = 2)
    private BigDecimal listPrice;

    @Nullable @Column(name = "unitcost", nullable = true, precision = 10, scale = 2)
    private BigDecimal unitCost;

    @Nullable @Column(name = "status", nullable = true, length = 2)
    private String status;

    @Nullable @Column(name = "attr1", nullable = true, length = 80)
    private String attribute1;

    @Nullable @Column(name = "attr2", nullable = true, length = 80)
    private String attribute2;

    @Nullable @Column(name = "attr3", nullable = true, length = 80)
    private String attribute3;

    @Nullable @Column(name = "attr4", nullable = true, length = 80)
    private String attribute4;

    @Nullable @Column(name = "attr5", nullable = true, length = 80)
    private String attribute5;

    // inventory table
    @Column(table = "inventory", name = "qty", nullable = false)
    private int quantity = 0;

    protected Item() {}

    public Item(@Nonnull final String itemId, @Nonnull final Product product) {
        this.itemId = itemId;
        this.product = product;
    }


    @Nonnull
    public String getItemId() {
        return itemId;
    }
    // no setter for itemId
    public void setSupplier(@Nullable final Supplier supplier) {
        if (supplier != null) {
            this.supplier = Supplier.copy(supplier);
        }
    }
    @Nonnull
    public Product getProduct() {
        return product;
    }

    public void setProduct(@Nonnull final Product product) {
        checkNotNull(product, "Argument[product] must not be null");
    }

    @Nullable
    public Supplier getSupplier() {
        return supplier;
    }


    @Nullable
    public BigDecimal getListPrice() {
        return listPrice;
    }

    public void setListPrice(@Nullable final BigDecimal listPrice) {
        this.listPrice = listPrice;
    }

    @Nullable
    public BigDecimal getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(@Nullable final BigDecimal unitCost) {
        this.unitCost = unitCost;
    }

    @Nullable
    public String getStatus() {
        return status;
    }

    public void setStatus(@Nullable final String status) {
        this.status = status;
    }

    @Nullable
    public String getAttribute1() {
        return attribute1;
    }

    public void setAttribute1(@Nullable final String attribute1) {
        this.attribute1 = attribute1;
    }

    @Nullable
    public String getAttribute2() {
        return attribute2;
    }

    public void setAttribute2(@Nullable final String attribute2) {
        this.attribute2 = attribute2;
    }

    @Nullable
    public String getAttribute3() {
        return attribute3;
    }

    public void setAttribute3(@Nullable final String attribute3) {
        this.attribute3 = attribute3;
    }

    @Nullable
    public String getAttribute4() {
        return attribute4;
    }

    public void setAttribute4(@Nullable final String attribute4) {
        this.attribute4 = attribute4;
    }

    @Nullable
    public String getAttribute5() {
        return attribute5;
    }

    public void setAttribute5(@Nullable final String attribute5) {
        this.attribute5 = attribute5;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(final int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;

        final Item that = (Item) o;
        return Objects.equal(this.itemId, that.getItemId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(itemId);
    }

}
