package mini.projeto.gerenciador_tarefas.command;

import mini.projeto.gerenciador_tarefas.model.Book;
import mini.projeto.gerenciador_tarefas.service.LibraryService;

import java.util.List;
import java.util.Scanner;

public class ListReservedBooksCommand implements Command {
    private final LibraryService libraryService;

    public ListReservedBooksCommand() {
        this.libraryService = LibraryService.getInstance(); // Obtém a instância Singleton
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o ID do estudante: ");
        int studentId = scanner.nextInt();

        List<Book> reservedBooks = libraryService.getReservedBooks(studentId);
        for (Book book : reservedBooks) {
            System.out.println(book);
        }

        System.out.println("Operação concluída.");
    }
}
