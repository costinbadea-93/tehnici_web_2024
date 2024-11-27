package org.example.ex1;

import jakarta.servlet.http.PushBuilder;
import lombok.AllArgsConstructor;
import org.example.ex1.model.Book;
import org.example.ex1.model.Library;
import org.example.ex1.sevice.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Ex1Application implements CommandLineRunner {

    @Autowired
    public LibraryService libraryService;

    public static void main(String[] args) {
        SpringApplication.run(Ex1Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

//        Library library = Library.builder()
//                .name("Library 1")
//                .description("Description 1")
//                .build();

//        libraryService.saveLibrary(library);
//        Library l1 = libraryService.findLibraryByName("Library 1");
//        Book b1 = Book.builder()
//                .author("Author1")
//                .description("Description1")
//                .title("title1")
//                .libraryId(l1.getId())
//                .build();
//        libraryService.addBookToLibrary(b1);
    }

    /**
     * Library
     * Book
     *
     * 1 carte poate sa apartina unei librarii
     * 1 librarie o sa poata sa aiba mai multe carti
     */

}
