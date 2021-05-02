package com.unicamp.mc322.lab01;

public class Calculadora {

    interface OperacoesMatematicas {
        Number operacao(double x, double y);
    }

    private final OperacoesMatematicas[] operacoesMatematicas = new OperacoesMatematicas[]{
            this::somar,
            this::subtrair,
            this::multiplicar,
            this::dividir,
            this::fatorialInterno,
            this::ehPrimoInterno,
    };
    private final String[] simbolosOperacoes = new String[]{
            "+",
            "-",
            "*",
            "/",
            "!",
            "é primo",
    };

    public String obterSimboloDaOperacao(int indice) {
        return simbolosOperacoes[indice];
    }

    public int obterTotalDeOperacoesDisponiveis() {
        return this.operacoesMatematicas.length;
    }

    public Number realizarOperacaoUnaria(int indice, double n) {
        return operacoesMatematicas[indice].operacao(n, 0);
    }

    public Number realizarOperacaoBinaria(int indice, double n1, double n2) {
        return operacoesMatematicas[indice].operacao(n1, n2);
    }

    private double somar(double n1, double n2) {
        return n1 + n2;
    }

    private double subtrair(double n1, double n2) {
        return n1 - n2;
    }

    private double multiplicar(double n1, double n2) {
        return n1 * n2;
    }

    private double dividir(double n1, double n2) throws ArithmeticException {
        if (n2 == 0) {
            throw new ArithmeticException("Erro: Divisão por 0!");
        }

        return n1 / n2;
    }

    private double fatorialInterno(double n, double nada) {
        if (ehInt(n)) {
            return fatorial((int) n);
        } else {
            throw new NumberFormatException("Erro: Fatorial tem domínio apenas nos números naturais!");
        }
    }

    private double fatorial(int n) {
        if(n < 0) {
            throw new ArithmeticException("Erro: Fatorial de negativo");
        }

        if (n == 1 || n == 0) {
            return 1;
        }

        double ret = n;
        for (int i = n - 1; i > 1; i--) {
            ret *= i;
        }

        return ret;
    }

    private int ehPrimoInterno(double n, double nada) {
        return ehPrimo(n);
    }

    private int ehPrimo(double n) {
        if (n == 0 || n == 1) {
            return 0;
        }

        if (n < 0) {
            n = -n; // se n eh primo, -n também é.
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return 0;
            }
        }

        return 1;
    }

    private boolean ehInt(double n) {
        return n == (int) n;
    }
}
