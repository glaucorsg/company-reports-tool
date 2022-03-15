package br.edu.ifpb.companyreportstool.domain;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Entity
public class Expense {

    @Id
    @GeneratedValue
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date day;

    private String description;

    private BigDecimal amount;

    private String location;
}
