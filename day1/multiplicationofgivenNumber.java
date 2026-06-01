       Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number to find its multiplication table: ");
        int n = sc.nextInt();
        System.out.println("Multiplication table of " + n + ":");
        for (int i = 1; i <= 10; i++) {
            System.out.println(n + " x " + i + " = " + (n * i));
        }
        sc.close();
    }
}
