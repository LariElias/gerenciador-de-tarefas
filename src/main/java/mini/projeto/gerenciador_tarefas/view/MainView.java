package mini.projeto.gerenciador_tarefas.view;


import mini.projeto.gerenciador_tarefas.command.*;
import mini.projeto.gerenciador_tarefas.factory.ControllerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainView {
    private final Map<Integer, Command> commands = new HashMap<>();

    public MainView() {
        initializeCommands();
    }

    /**
     * Inicializa os comandos e os mapeia às opções do menu.
     */
    private void initializeCommands() {
        commands.put(1, new ListAllStudentsCommand(ControllerFactory.createStudentController()));
        commands.put(2, new ListActiveStudentsCommand(ControllerFactory.createStudentController()));
        commands.put(3, new ShowStudentDetailsCommand(ControllerFactory.createStudentController()));
        commands.put(4, new ListAllDisciplinesCommand(ControllerFactory.createDisciplineController()));
        commands.put(5, new ListDisciplinesByCourseCommand(ControllerFactory.createDisciplineController()));
        commands.put(6, new ListAllBooksCommand());
        commands.put(7, new ReserveBookCommand());
        commands.put(8, new ListReservedBooksCommand());
        commands.put(9, new CancelReservationCommand());
    }

    /**
     * Exibe o menu principal e gerencia a interação com o usuário.
     */
    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("=== Gerenciador Acadêmico ===");
            System.out.println("1. Listar todos os estudantes");
            System.out.println("2. Listar estudantes ativos de um curso específico");
            System.out.println("3. Ver detalhes de um estudante específico");
            System.out.println("4. Listar todas as disciplinas");
            System.out.println("5. Listar disciplinas de um curso específico");
            System.out.println("6. Listar todos os livros disponíveis");
            System.out.println("7. Reservar um livro");
            System.out.println("8. Listar livros reservados por um estudante");
            System.out.println("9. Cancelar reserva de um livro");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();
            scanner.nextLine();  // Consome o caractere de nova linha

            Command command = commands.get(option);

            if (command != null) {
                command.execute();
            } else if (option == 0) {
                System.out.println("Saindo...");
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }

            System.out.println(); // Linha em branco para separar as interações
        } while (option != 0);

        scanner.close();
    }
}