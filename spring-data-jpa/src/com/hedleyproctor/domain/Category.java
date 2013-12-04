package com.hedleyproctor.domain;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import com.google.common.base.Objects;

@Entity(name = "category")
@NamedQuery(name = "Category.getCategoryList",
        query = "select c from category c")
public class Category implements Serializable {

	private static final long serialVersionUID = -2202411798084220733L;

	@Nonnull
    @Id
    @Column(name = "catid", unique = true, nullable = false, length = 10)
    private String categoryId;

    @Nullable
    @Column(name = "name", nullable = true, length = 80)
    private String name;

    @Nullable
    @Column(name = "descn", nullable = true, length = 255)
    private String description;

    protected Category() {}

    public Category(String categoryId) {
        checkNotNull(categoryId, "Argument[categoryId] must not be null");
        this.categoryId = categoryId.trim();
    }


    @Nonnull
    public String getCategoryId() {
        return categoryId;
    }
    // no setter for categoryId

    @Nullable
    public String getName() {
        return name;
    }

    public void setName(@Nullable String name) {
        this.name = name;
    }

    @Nullable
    public String getDescription() {
        return description;
    }

    public void setDescription(@Nullable String description) {
        this.description = description;
    }

    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (! (o instanceof Category)) {
            return false;
        }
        Category that = (Category) o;
        return Objects.equal(this.getCategoryId(), that.getCategoryId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getCategoryId());
    }

}
