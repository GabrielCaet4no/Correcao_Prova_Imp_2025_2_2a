public static int cadastrarConta(Conta[] v, int tam) {

    if (tam == TAM_CONTAS) {
        System.out.println("Vetor cheio!");
        return tam;
    }

    Conta c = new Conta();

    System.out.println("Digite o ID:");
    c.id = sc.nextInt();

    if (buscaId(v, tam, c.id) != -1) {
        System.out.println("ID já cadastrado!");
        return tam;
    }

    System.out.println("Digite o cliente:");
    sc.nextLine();
    c.cliente = sc.nextLine();

    System.out.println("Digite o saldo:");
    c.saldo = sc.nextDouble();

    if (c.saldo < 0) {
        System.out.println("Saldo não pode ser negativo!");
        return tam;
    }

    System.out.println("Digite o limite:");
    c.limite = sc.nextDouble();

    if (c.limite < 0) {
        System.out.println("Limite não pode ser negativo!");
        return tam;
    }

    v[tam] = c;

    return tam + 1;
}