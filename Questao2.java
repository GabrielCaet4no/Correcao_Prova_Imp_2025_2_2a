public static int buscaBinariaCliente(
        Conta[] v, int tam, String x) {

    int inicio = 0;
    int fim = tam - 1;

    while (inicio <= fim) {

        int meio = (inicio + fim) / 2;

        if (v[meio].cliente.equalsIgnoreCase(x)) {
            return meio;
        }

        if (v[meio].cliente.compareToIgnoreCase(x) < 0) {
            inicio = meio + 1;
        } else {
            fim = meio - 1;
        }
    }

    return -1;
}