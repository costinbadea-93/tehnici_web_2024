package org.example.ex1.repository;

import lombok.AllArgsConstructor;
import org.example.ex1.model.Book;
import org.example.ex1.model.Library;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;

@Repository
@AllArgsConstructor
public class LibraryRepository {

    private static final Logger log = LoggerFactory.getLogger(LibraryRepository.class);
    private final JdbcTemplate jdbcTemplate;

    public void saveLibrary(Library library) {
        String sql = "INSERT INTO library (name, description) VALUES (?, ?)";
//        jdbcTemplate.update(sql, library.getName(), library.getDescription());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, library.getName());
            ps.setString(2, library.getDescription());
            return ps;
        }, keyHolder);

        library.setId(keyHolder.getKey().intValue());
        log.info("Library saved: {}", library);
    }

    public Library getLibraryByName(String name) {
        String sql = "SELECT * FROM library WHERE name = ?";

        log.info("Returning library: {}", name);
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) ->
                 Library.builder()
                         .name(rs.getString("name"))
                         .description(rs.getString("description"))
                         .id(rs.getInt("id"))
                         .build(), name);
    }

    public void addBookToLibrary(Book book) {
       String sql = "INSERT INTO book (title, author, description, libraryId) VALUES (?, ? , ?, ?)";
        jdbcTemplate.update(sql, book.getTitle(), book.getAuthor(), book.getDescription(), book.getLibraryId());
       log.info("Added book: {}", book);
    }
}
