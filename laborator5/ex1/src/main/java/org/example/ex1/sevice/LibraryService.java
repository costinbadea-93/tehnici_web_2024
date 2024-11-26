package org.example.ex1.sevice;

import lombok.AllArgsConstructor;
import org.example.ex1.repository.LibraryRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LibraryService {
    private final LibraryRepository libraryRepository;
}
