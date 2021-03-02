package me.hwanseok.hwanseok20210225.model.entity;

import lombok.*;
import lombok.experimental.Accessors;
import me.hwanseok.hwanseok20210225.model.enumClass.OrderDetailStatus;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"orderGroup","item"})
@EntityListeners(AuditingEntityListener.class)
@Builder
@Accessors(chain = true)
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE) // user.setId() is not permitted
    private Long id;
    @Enumerated(EnumType.STRING)
    private OrderDetailStatus status;
    private LocalDateTime arrivalDate;
    private Integer quantity;
    private Integer totalPrice;

    @ManyToOne
    private Item item;

    @ManyToOne
    private OrderGroup orderGroup;

    @CreatedDate
    private LocalDateTime createdAt;
    @CreatedBy
    private String createdBy;
    @LastModifiedDate
    private LocalDateTime updatedAt;
    @LastModifiedBy
    private String updatedBy;

}
