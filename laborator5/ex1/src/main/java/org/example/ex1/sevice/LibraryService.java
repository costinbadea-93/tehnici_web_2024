package org.example.ex1.sevice;

import lombok.AllArgsConstructor;
import org.example.ex1.model.Book;
import org.example.ex1.model.Library;
import org.example.ex1.repository.LibraryRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LibraryService {
    private final LibraryRepository libraryRepository;

    public void saveLibrary(Library library) {
        libraryRepository.saveLibrary(library);
    }

    public Library findLibraryByName(String name) {
        return libraryRepository.getLibraryByName(name);
    }

    public void addBookToLibrary(Book book) {
        libraryRepository.addBookToLibrary(book);
    }
}
