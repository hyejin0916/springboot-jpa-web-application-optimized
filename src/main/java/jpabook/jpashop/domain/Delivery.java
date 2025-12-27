package jpabook.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Delivery {

    @Id @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
    private Order order;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    // EnumType.ORDINAL: 값이 숫자로 들어가서 중간에 데이터가 추가된 경우 장애로 이어질 수 있음
    private DeliveryStatus status; // READY, COMP
}
