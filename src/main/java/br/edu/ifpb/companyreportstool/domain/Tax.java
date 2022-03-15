package br.edu.ifpb.companyreportstool.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Tax {
    @Id
    @GeneratedValue
    private Long id;

    private BigDecimal rate;
    private BigDecimal amount;
    private BigDecimal amountExcludingTaxes;
}
