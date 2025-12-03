package exam.jspshoppingmall.model.entity;

import exam.jspshoppingmall.model.embedded.Address;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity @Data
@NoArgsConstructor
public class Member extends BaseEntity{

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long memberId;

    @Column(name = "NAME")
    private String name;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "city", column = @Column(name = "MEMBER_CITY")),
            @AttributeOverride(name = "street", column = @Column(name = "MEMBER_STREET")),
            @AttributeOverride(name = "zipcode", column = @Column(name = "MEMBER_ZIPCODE"))
    })
    private Address address;

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();
}
