package mini.projeto.gerenciador_tarefas.command;

import mini.projeto.gerenciador_tarefas.model.Book;
import mini.projeto.gerenciador_tarefas.service.LibraryService;

public class ListAllBooksCommand implements Command {
    private final LibraryService libraryService;

    public ListAllBooksCommand() {
        this.libraryService = LibraryService.getInstance(); // Obtém a instância Singleton
    }

    @Override
    public void execute() {
        for (Book book : libraryService.getAllBooks()) {
            System.out.println(book);
        }
        System.out.println("Operação concluída.");
    }
}
