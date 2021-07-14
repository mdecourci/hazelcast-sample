package com.sample.hazelcast.repository.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Table("PRODUCT")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Product {
    private static final long serialVersionUID=1L;
    @Id
    @Column("product_id")
    @GeneratedValue(strategy=AUTO, generator="product_seq")
    @SequenceGenerator(name="product_seq", sequenceName="PRODUCT_ID_SEQ)")
    private Long productId;
    @Column(name="product_name")
    private String productName;
    @Column(name="product_description")
    private String productDescription;

}
