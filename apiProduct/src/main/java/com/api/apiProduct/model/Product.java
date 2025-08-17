package com.api.apiProduct.model;

import com.api.apiProduct.StatusTarefa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Tarefa")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Title")
    private String title;
    @Column(name = "Category")
    private String category;
    @Column(name = "Description")
    private String description;
    @Enumerated(EnumType.STRING)
    @Column(name = "Status")
    private StatusTarefa status;
}
