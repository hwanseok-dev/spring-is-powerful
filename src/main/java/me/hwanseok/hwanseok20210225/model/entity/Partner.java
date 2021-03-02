package me.hwanseok.hwanseok20210225.model.entity;

import lombok.*;
import lombok.experimental.Accessors;
import me.hwanseok.hwanseok20210225.model.enumClass.PartnerStatus;
import org.hibernate.annotations.Fetch;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"category", "itemList"})
@EntityListeners(AuditingEntityListener.class)
@Builder
@Accessors(chain = true)
public class Partner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE) // user.setId() is not permitted
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private PartnerStatus status;
    private String address;
    private String callCenter;
    private String partnerNumber;
    private String businessNumber;
    private String ceoName;

    @ManyToOne
    private Category category;

    private LocalDateTime registeredAt;
    private LocalDateTime unregisteredAt;
    @CreatedDate
    private LocalDateTime createdAt;
    @CreatedBy
    private String createdBy;
    @LastModifiedDate
    private LocalDateTime updatedAt;
    @LastModifiedBy
    private String updatedBy;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "partner")
    private List<Item> itemList;
}
