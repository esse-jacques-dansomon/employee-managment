package co.essejacques;

import co.essejacques.entities.*;
import co.essejacques.enums.PaymentMethod;
import co.essejacques.services.ServiceService;
import co.essejacques.services.EmployeeService;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        EmployeeService employeeService = new EmployeeService();
        ServiceService serviceService = new ServiceService();
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;
        while (!exit) {
            System.out.println("=== Menu Principal ===");
            System.out.println("1. Enregistrer un Service");
            System.out.println("2. Enregistrer un Employé");
            System.out.println("3. Virer Salaire");
            System.out.println("4. Enregistrer un congé pour un Employé");
            System.out.println("5. Lister les services");
            System.out.println("6. Lister les employés");
            System.out.println("7. Quitter");
            System.out.print("Choix : ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    registerService(serviceService, scanner);
                    break;
                case 2:
                    registerEmployee(employeeService, serviceService, scanner);
                    break;
                case 3:
                    paySalary(employeeService, scanner);
                    break;
                case 4:
                    registerLeave(employeeService, scanner);
                    break;
                case 5:
                    // Logique pour lister les services
                    // Vous pouvez appeler la méthode appropriée de ServiceService
                    serviceService.findAll().forEach(System.out::println);
                    break;
                case 6:
                    // Logique pour lister les employés
                    // Vous pouvez appeler la méthode appropriée de EmployeeService
                    employeeService.findAll().forEach(System.out::println);
                    break;
                case 7:
                    exit = true;
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }

        scanner.close();
    }

    private static void registerService(ServiceService serviceService, Scanner scanner) {
        // Logique pour enregistrer un service
        // Vous pouvez demander à l'utilisateur de saisir les détails du service et appeler la méthode appropriée de ServiceService
        System.out.print("Nom du service : ");
        String name = scanner.nextLine();
        System.out.print("Code du service : ");
        String code = scanner.nextLine();
        Service service = new Service( code, name);
        serviceService.createService(service);
        System.out.println("Service enregistré avec succès");
        System.out.println();
    }

    private static void registerEmployee(EmployeeService employeeService, ServiceService serviceService, Scanner scanner) {
        System.out.println("=== Enregistrer un Employé ===");
        System.out.println("Choisissez le type d'employé :");
        System.out.println("1. Contractuel");
        System.out.println("2. Journalier");
        System.out.println("3. Prestataire");
        System.out.print("Choix : ");

        int employeeTypeChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (employeeTypeChoice) {
            case 1:
                registerContractEmployee(employeeService,serviceService, scanner);
                break;
            case 2:
                registerDailyWageEmployee(employeeService, scanner);
                break;
            case 3:
                registerServiceProvider(employeeService, scanner);
                break;
            default:
                System.out.println("Choix invalide. Retour au menu principal.");
        }
    }

    private static void registerContractEmployee(EmployeeService employeeService, ServiceService serviceService, Scanner scanner) {
        System.out.println("=== Enregistrer un Employé Contractuel ===");


        System.out.print("Entrez le matricule de l'employé : ");
        String matricule = scanner.nextLine();
        System.out.print("Entrez le salaire brut de l'employé : ");
        double salary = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        Service serviceEmployee = null;
        do {
            System.out.println("Liste des services :");
            serviceService.findAll().forEach(System.out::println);
            System.out.print("Entrez le service de l'employé : ");
            String service = scanner.nextLine();
            if (serviceService.findById(Long.valueOf(service)) == null) {
                System.out.println("Service invalide. Veuillez réessayer.");
            } else {
                serviceEmployee = serviceService.findById(Long.valueOf(service));
                break;
            }
        } while (true);


        ContractEmployee contractEmployee = new ContractEmployee(matricule, salary, 0, 0, serviceEmployee);
        employeeService.save(contractEmployee);
        System.out.println("Employé contractuel enregistré avec succès. \n");
    }

    private static void registerDailyWageEmployee(EmployeeService employeeService, Scanner scanner) {
        System.out.println("=== Enregistrer un Employé Journalier ===");

        System.out.print("Entrez le matricule de l'employé : ");
        String matricule = scanner.nextLine();
        System.out.print("Entrez le coût journalier de l'employé : ");
        double dailyCost = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        System.out.print("Entrez le nombre de jours travaillés : ");
        int daysWorked = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        DailyWageEmployee dailyWageEmployee = new DailyWageEmployee(matricule, dailyCost, daysWorked);
        employeeService.save(dailyWageEmployee);
        System.out.println("Employé journalier enregistré avec succès.");
    }

    private static void registerServiceProvider(EmployeeService employeeService, Scanner scanner) {
        System.out.println("=== Enregistrer un Prestataire ===");

        System.out.print("Entrez le matricule de l'employé : ");
        String matricule = scanner.nextLine();
        System.out.print("Entrez le service effectué par le prestataire : ");
        String providedService = scanner.nextLine();
        System.out.print("Entrez la période du service : ");
        double servicePeriod = scanner.nextDouble();
        System.out.print("Entrez le coût du service : ");
        double serviceCost = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        ServiceProviderEmployee serviceProvider = new ServiceProviderEmployee( matricule, providedService, servicePeriod);
        employeeService.save(serviceProvider);
        System.out.println("Prestataire enregistré avec succès.");
    }


    private static void paySalary(EmployeeService employeeService, Scanner scanner) {
        System.out.println("=== Virer Salaire ===");
        System.out.print("Entrez l'ID de l'employé : ");
        int employeeId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Entrez le montant du salaire : ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        System.out.print("Entrez la méthode de paiement (BANK_TRANSFER, MONEY_ORDER, WAVE) : ");
        String paymentMethodStr = scanner.nextLine().toUpperCase();
        PaymentMethod paymentMethod = PaymentMethod.valueOf(paymentMethodStr);

        // Logique pour verser le salaire
        // Par exemple:
//        employeeService.paySalary(employeeId, amount, paymentMethod);
    }

    private static void registerLeave(EmployeeService employeeService, Scanner scanner) {
        System.out.println("=== Enregistrer un congé pour un Employé ===");
        System.out.print("Entrez l'ID de l'employé : ");
        int employeeId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Entrez le type de congé : ");
        String leaveType = scanner.nextLine();
        System.out.print("Entrez le nombre de jours de congé : ");
        int numberOfDays = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Logique pour enregistrer le congé
        // Par exemple:
//        employeeService.takeLeave(employeeId, leaveType, numberOfDays);
    }
}