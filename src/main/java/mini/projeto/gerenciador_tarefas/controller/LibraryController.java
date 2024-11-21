package mini.projeto.gerenciador_tarefas.controller;

import mini.projeto.gerenciador_tarefas.model.Book;
import mini.projeto.gerenciador_tarefas.service.LibraryService;
import java.util.List;

public class LibraryController {
    private final LibraryService libraryService;

    public LibraryController() {
        this.libraryService = LibraryService.getInstance();
    }

    public void listAllBooks() {
        for (Book book : libraryService.getAllBooks()) {
            System.out.println(book);
        }
    }

    public void reserveBook(int studentId, int bookId) {
        String message = libraryService.reserveBook(studentId, bookId);
        System.out.println(message);
    }

    public void listReservedBooks(int studentId) {
        List<Book> reservedBooks = libraryService.getReservedBooks(studentId);

        if (reservedBooks.isEmpty()) {
            System.out.println("Nenhum livro reservado pelo estudante com ID " + studentId);
        } else {
            for (Book book : reservedBooks) {
                System.out.println(book);
            }
        }
    }

    public void cancelReservation(int studentId, int bookId) {
        String message = libraryService.cancelReservation(studentId, bookId);
        System.out.println(message);
    }
}