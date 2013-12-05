package com.hedleyproctor.domain.builder;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.hedleyproctor.domain.Category;

/**
 * @author Igor Baiborodine
 */
public class CategoryBuilder
        implements Builder<Category> {
    // required
    @Nonnull private String categoryId;
    // optional
    @Nullable private String name;
    @Nullable private String description;

    public CategoryBuilder(@Nonnull String categoryId) {
        checkNotNull(categoryId, "Argument[categoryId] must not be null");
        this.categoryId = categoryId;
    }

    public CategoryBuilder name(@Nullable final String name) {
        this.name = name;
        return this;
    }

    public CategoryBuilder description(@Nullable final String description) {
        this.description = description;
        return this;
    }

    @Override
    @Nonnull public Category build() {
        Category category = new Category(categoryId);
        category.setName(name);
        category.setDescription(description);
        return category;
    }
}
