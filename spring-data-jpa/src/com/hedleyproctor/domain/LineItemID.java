package com.hedleyproctor.domain;

import java.io.Serializable;

import javax.annotation.Nonnull;

import com.google.common.base.Objects;

/**
 * @author Igor Baiborodine
 */
public class LineItemID
        implements Serializable {
	private static final long serialVersionUID = -7279625626129791932L;
	@Nonnull
    private Integer orderId;
    @Nonnull
    private Integer lineNumber;

    protected LineItemID() {}

    public LineItemID(@Nonnull final Integer orderId, @Nonnull final Integer lineNumber) {
        this.orderId = orderId;
        this.lineNumber = lineNumber;
    }

    @Nonnull
    public Integer getOrderId() {
        return orderId;
    }

    @Nonnull
    public Integer getLineNumber() {
        return lineNumber;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof LineItemID)) return false;

        final LineItemID that = (LineItemID) o;
        return Objects.equal(this.orderId, that.orderId)
                && Objects.equal(this.orderId, that.orderId);
    }

    @Override
    public int hashCode() {
        int result = orderId != null ? Objects.hashCode(orderId) : 0;
        result = result + (lineNumber != null ? Objects.hashCode(lineNumber) : 0);
        return result;
    }

}
