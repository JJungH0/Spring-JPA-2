package exam.jspshoppingmall.model.entity;

import exam.jspshoppingmall.model.status.DeliveryStatus;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data
@NoArgsConstructor
@Table(name = "DELIVERY")
public class Delivery extends BaseEntity{

    @Id @GeneratedValue
    @Column(name = "DELIVERY_ID")
    private Long deliveryId;

    @OneToOne(mappedBy = "delivery")
    @JoinColumn(name = "ORDER_ID")
    private Order order;

    private String city;

    private String zipcode;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;

}
