package org.sigmaka.gen20javaspringbootpos.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "transactions_items", schema = "public", catalog = "POS")
public class TransactionsItemsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "selling_price", nullable = false)
    private int sellingPrice;
    @Basic
    @Column(name = "quantity", nullable = false)
    private int quantity;
    @Basic
    @Column(name = "total_price", nullable = false)
    private int totalPrice;
    @Basic
    @Column(name = "created_at", nullable = true)
    private Timestamp createdAt;
    @ManyToOne
    @JoinColumn(name = "tx_id", referencedColumnName = "id")
    private TransactionsEntity transactionsByTxId;
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private ProductsEntity productsByProductId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(int sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
