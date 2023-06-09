package com.example.demo.library.books;

import java.util.List;

import org.hibernate.validator.constraints.Length;

import com.example.demo.library.lends.LendEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor 
@AllArgsConstructor
@Table(name = "books")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Column(unique = true, nullable = false, length = 14, columnDefinition = "VARCHAR(14)", updatable = false, name = "myisbn")
    private String isbn;

    @NotBlank
    @Length(min = 1, max = 100)
    private String title;

    @NotBlank
    private String author;

    @Column(columnDefinition="TEXT")
    private String description;

    @OneToMany(mappedBy = "book")
    private List<LendEntity> lends;


}
