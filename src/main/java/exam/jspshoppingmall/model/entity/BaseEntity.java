package exam.jspshoppingmall.model.entity;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@MappedSuperclass
@Getter @Setter
public class BaseEntity {
    private Date createDate;
    private Date lastModifiedDate;
}
