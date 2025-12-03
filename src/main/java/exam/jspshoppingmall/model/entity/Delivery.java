package exam.jspshoppingmall.model.entity;

import exam.jspshoppingmall.model.embedded.Address;
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



    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "city", column = @Column(name = "DELIVERY_CITY")),
            @AttributeOverride(name = "street", column = @Column(name = "DELIVERY_STREET")),
            @AttributeOverride(name = "zipcode", column = @Column(name = "DELIVERY_ZIPCODE"))
    })
    private Address address;


    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;
}
