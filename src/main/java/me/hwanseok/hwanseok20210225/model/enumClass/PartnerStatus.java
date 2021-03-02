package me.hwanseok.hwanseok20210225.model.enumClass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PartnerStatus {
    REGISTERED(0, "등록상태", "사용자 등록 상태"),
    UNREGISTERED(1, "해지", "사용자 해지 상태");
    private Integer id;
    private String title;
    private String description;
}
