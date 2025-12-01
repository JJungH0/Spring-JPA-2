package exam.jspshoppingmall.model.entity;

import exam.jspshoppingmall.model.entity.item.Item;
import jakarta.persistence.*;
import lombok.Data;

@Entity @Data
@Table(name = "ORDER_ITEM")
public class OrderItem extends BaseEntity{

    @Id
    @GeneratedValue
    @Column(name = "ORDER_ITEAM_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDER_ID")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ITEM_ID")
    private Item item;

    @Column(name = "ORDER_PRICE")
    private int orderPrice;

    @Column(name = "COUNT")
    private int count;
}
