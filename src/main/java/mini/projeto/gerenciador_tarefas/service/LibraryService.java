package mini.projeto.gerenciador_tarefas.service;

import mini.projeto.gerenciador_tarefas.model.Book;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;

public class LibraryService {
    private static final String LIBRARY_API_URL = "https://qiiw8bgxka.execute-api.us-east-2.amazonaws.com/acervo/biblioteca";
    private final Gson gson = new Gson();

    private final Map<Integer, List<Book>> studentReservations = new HashMap<>();
    private final Map<Integer, String> bookStatus = new HashMap<>();
    
//    um campo estático instance para armazenar a única instância do LibraryService.
    private static LibraryService instance;

    private LibraryService() {
    }

    public static LibraryService getInstance() {
        if (instance == null) {
            instance = new LibraryService();
        }
        return instance;
    }

    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        try {
            String response = HttpClientService.get(LIBRARY_API_URL);
            Type bookListType = new TypeToken<ArrayList<Book>>() {}.getType();
            books = gson.fromJson(response, bookListType);

            for (Book book : books) {
                if (bookStatus.containsKey(book.getId())) {
                    book.setStatus(bookStatus.get(book.getId()));
                } else {
                    book.setStatus("disponível"); // Valor padrão para livros disponíveis
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            System.out.println("Erro ao buscar os dados dos livros.");
        }
        return books;
    }

    public String reserveBook(int studentId, int bookId) {
        List<Book> books = getAllBooks();
        for (Book book : books) {
            if (book.getId() == bookId) {
                if ("indisponível".equalsIgnoreCase(book.getStatus())) {
                    return "Livro já está reservado.";
                }

                studentReservations.putIfAbsent(studentId, new ArrayList<Book>());
                studentReservations.get(studentId).add(book);

                bookStatus.put(bookId, "indisponível");

                return "Livro reservado com sucesso!";
            }
        }
        return "Livro não encontrado para reserva.";
    }

    public List<Book> getReservedBooks(int studentId) {
        return studentReservations.getOrDefault(studentId, new ArrayList<Book>());
    }

    public String cancelReservation(int studentId, int bookId) {
        List<Book> reservedBooks = studentReservations.get(studentId);
        if (reservedBooks != null) {
            for (Book book : reservedBooks) {
                if (book.getId() == bookId) {
                    reservedBooks.remove(book);
                    bookStatus.put(bookId, "disponível");
                    return "Reserva do livro cancelada com sucesso!";
                }
            }
        }
        return "Reserva não encontrada para cancelamento.";
    }
}
