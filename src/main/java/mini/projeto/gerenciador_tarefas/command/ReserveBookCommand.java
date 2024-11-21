package mini.projeto.gerenciador_tarefas.command;

import mini.projeto.gerenciador_tarefas.service.LibraryService;

import java.util.Scanner;

public class ReserveBookCommand implements Command {
    private final LibraryService libraryService;

    public ReserveBookCommand() {
        this.libraryService = LibraryService.getInstance(); // Obtém a instância Singleton
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o ID do estudante: ");
        int studentId = scanner.nextInt();

        System.out.print("Digite o ID do livro a ser reservado: ");
        int bookId = scanner.nextInt();

        // Usa o serviço para reservar o livro
        String result = libraryService.reserveBook(studentId, bookId);
        System.out.println(result);

        System.out.println("Operação concluída.");
    }
}