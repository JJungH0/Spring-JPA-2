package exam.jspshoppingmall.model.entity;

import exam.jspshoppingmall.model.entity.item.Item;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity @Data
public class Category extends BaseEntity{
    @Id
    @GeneratedValue
    @Column(name = "CATEGORY_ID")
    private Long categoryId;

    private String name;

    @ManyToMany
    @JoinTable(name = "CATEGORY_ITEM",
            joinColumns = @JoinColumn(name = "CATEGORY_ID"),
            inverseJoinColumns = @JoinColumn(name = "ITEM_ID"))
    private List<Item> items = new ArrayList<>();

    /**
     * 카테고리 계층 구조를 위한 필드들
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_ID")
    private Category parent;

    @OneToMany(mappedBy = "parent")
    private List<Category> child = new ArrayList<>();

    public void addChildCategory(Category child) {
        this.child.add(child);
        child.setParent(this);

    }

    public void addItem(Item item) {
        items.add(item);
    }
}
