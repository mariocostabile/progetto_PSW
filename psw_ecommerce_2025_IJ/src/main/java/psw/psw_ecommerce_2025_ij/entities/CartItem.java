package psw.psw_ecommerce_2025_ij.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cart_item")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "productName", nullable = false, length = 255)
    private String productName;

    @Column(name = "productPrice", nullable = false, length = 50)
    private double productPrice;

    @ManyToOne(optional = false)
    @JoinColumn(name = "cart_id", nullable = false, unique = true)
    private Cart cart;

}