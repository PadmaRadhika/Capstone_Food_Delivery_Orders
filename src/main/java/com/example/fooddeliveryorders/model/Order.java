package com.example.fooddeliveryorders.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "`order`")  // Using backticks to escape the reserved word
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String customerName;
	private String customerEmail;
	private String customerPhone;
	private Double totalAmount;
	private Date orderDate;
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<OrderItem> items = new ArrayList<>();
	// Add methods to add and remove items to manage the bidirectional relationship
    public void addOrderItem(OrderItem orderItem) {
        orderItem.setOrder(this); // Set the parent Order for the item
        items.add(orderItem);
    }

    public void removeOrderItem(OrderItem orderItem) {
        orderItem.setOrder(null); // Remove the parent reference when removing the item
        items.remove(orderItem);
    }
}
