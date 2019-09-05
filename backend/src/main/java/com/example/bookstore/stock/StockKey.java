package com.example.bookstore.stock;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class StockKey implements Serializable {

    @Column(name = "store_id")
    private Long storeId;

    @Column(name = "book_id")
    private Long bookId;

    public StockKey() {
    }

    public StockKey(Long storeId, Long bookId) {
        this.storeId = storeId;
        this.bookId = bookId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockKey stockKey = (StockKey) o;
        return Objects.equals(storeId, stockKey.storeId) &&
                Objects.equals(bookId, stockKey.bookId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(storeId, bookId);
    }
}
