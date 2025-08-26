package com.api.apiProduct.model;

import com.api.apiProduct.StatusFilme;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Filme")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Filme {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)

    private Long id;
    @Column(name = "Title")
    private String title;
    @Column(name = "Category")
    private String category;
    @Column(name = "Description")
    private String description;
    @Enumerated(EnumType.STRING)
    @Column(name = "Status")
    private StatusFilme status;
}
