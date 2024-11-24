package mini.projeto.gerenciador_tarefas.view;
import mini.projeto.gerenciador_tarefas.controller.LibraryController;

import java.util.Scanner;

public class LibraryView {
    private final LibraryController libraryController;

    public LibraryView(LibraryController libraryController) {
        this.libraryController = libraryController;
    }

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Gerenciamento da Biblioteca ===");
        System.out.println("1. Listar todos os livros disponíveis");
        System.out.println("2. Reservar um livro");
        System.out.println("3. Listar livros reservados por um estudante");
        System.out.println("4. Cancelar reserva de um livro");
        System.out.print("Escolha uma opção: ");
        int option = scanner.nextInt();
        scanner.nextLine();

        switch (option) {
            case 1:
                libraryController.listAllBooks();
                break;
            case 2:
                System.out.print("Digite o ID do estudante: ");
                int studentIdForBook = scanner.nextInt();
                System.out.print("Digite o ID do livro a ser reservado: ");
                int bookIdToReserve = scanner.nextInt();
                libraryController.reserveBook(studentIdForBook, bookIdToReserve);
                break;
            case 3:
                System.out.print("Digite o ID do estudante: ");
                int studentIdForReservation = scanner.nextInt();
                libraryController.listReservedBooks(studentIdForReservation);
                break;
            case 4:
                System.out.print("Digite o ID do estudante: ");
                int studentIdToCancel = scanner.nextInt();
                System.out.print("Digite o ID do livro a ter a reserva cancelada: ");
                int bookIdToCancel = scanner.nextInt();
                libraryController.cancelReservation(studentIdToCancel, bookIdToCancel);
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }
}