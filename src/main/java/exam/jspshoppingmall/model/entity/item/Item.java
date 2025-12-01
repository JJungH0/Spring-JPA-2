package exam.jspshoppingmall.model.entity.item;

import exam.jspshoppingmall.model.entity.BaseEntity;
import exam.jspshoppingmall.model.entity.Category;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity @Getter @Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // 상속 관계 매핑 단일 테이블 전략
@DiscriminatorColumn(name = "DTYPE") // 단일 테이블 전략에 필요한 구분 컬럼
public abstract class Item extends BaseEntity {

    @Id @GeneratedValue
    @Column(name = "ITEM_ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PRICE")
    private int price;

    @Column(name = "STOCK_QUANTITY")
    private int stockQuantity;

    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<>();
}
