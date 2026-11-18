public static void extrato(
        Conta[] vContas,
        int tamConta,
        Operacao[] vOp,
        int tamOp) {

    System.out.println("Digite o ID da conta:");
    int id = sc.nextInt();

    int pos = buscaId(vContas, tamConta, id);

    if (pos == -1) {
        System.out.println("Conta não encontrada!");
        return;
    }

    Conta conta = vContas[pos];

    Operacao[] vOpFiltrado = new Operacao[TAM_OP];

    int tamFiltrado =
            filtraOperacoes(vOp, tamOp, vOpFiltrado, id);

    System.out.println();
    System.out.println("----------------------------------------");
    System.out.println("              C O N T A");
    System.out.println("----------------------------------------");

    System.out.println("CLIENTE: " + conta.cliente);
    System.out.println("ID: " + conta.id);

    System.out.println("----------------------------------------");
    System.out.println("ID | OPERAÇÃO | VALOR | SALDO");
    System.out.println("----------------------------------------");

    double saldo = conta.saldo;

    int inicio = tamFiltrado - 5;

    if (inicio < 0) {
        inicio = 0;
    }

    for (int i = 0; i < inicio; i++) {
        saldo -= vOpFiltrado[i].valor;
    }

    System.out.printf(
            "    | Saldo Anterior |        | %.2f%c%n",
            Math.abs(saldo),
            tipoValor(saldo));

    for (int i = inicio; i < tamFiltrado; i++) {

        Operacao op = vOpFiltrado[i];

        saldo = atualizarSaldo(saldo, op);

        System.out.printf(
                "%04d | %-15s | %7.2f%c | %7.2f%c%n",
                op.id,
                nomeOperacao(op.tipo),
                Math.abs(op.valor),
                tipoValor(op.valor),
                Math.abs(saldo),
                tipoValor(saldo));
    }

    System.out.println("----------------------------------------");

    System.out.printf(
            "Saldo Atual: %.2f%c%n",
            Math.abs(saldo),
            tipoValor(saldo));
}