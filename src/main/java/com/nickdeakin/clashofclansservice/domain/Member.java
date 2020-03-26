package com.nickdeakin.clashofclansservice.domain;

import com.nickdeakin.clashofclansservice.domain.dto.MemberDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Builder.Default
    private String id = UUID.randomUUID().toString();

    @NotEmpty
    @NotNull
    private String name;

    public static Member fromDto(MemberDTO memberDTO) {
        return Member.builder()
                .id(memberDTO.getId())
                .name(memberDTO.getName())
                .build();
    }
}
