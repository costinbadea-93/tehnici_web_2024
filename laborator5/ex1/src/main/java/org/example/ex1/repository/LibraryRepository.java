package org.example.ex1.repository;

import lombok.AllArgsConstructor;
import org.example.ex1.model.Library;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class LibraryRepository {

    private static final Logger log = LoggerFactory.getLogger(LibraryRepository.class);
    private final JdbcTemplate jdbcTemplate;

    public void saveLibrary(Library library) {
        String sql = "INSERT INTO library (name, location) VALUES (?, ?)";
        jdbcTemplate.update(sql, library.getName(), library.getLocation());
        log.info("Library saved: {}", library);
    }
}
