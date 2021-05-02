package com.unicamp.mc322.lab01;

import java.util.InputMismatchException;
import java.util.Scanner;

import static com.unicamp.mc322.lab01.Operations.EH_PRIMO;
import static com.unicamp.mc322.lab01.Operations.FATORIAL;

public class MinhaCalculadora {
    public static void main(String[] args) {
        int opcaoDesejada;
        boolean continuar;
        double numero1, numero2 = 0;
        Number resultado;
        String operator;
        Scanner input = new Scanner(System.in);
        Calculadora calculadora = new Calculadora();

        imprimirInicio();

        do {
            menu();

            try {
                opcaoDesejada = input.nextInt();
                opcaoDesejada--; // para facilitar no codigo

                if (opcaoDesejada < 0 || opcaoDesejada > calculadora.obterTotalDeOperacoesDisponiveis()) {
                    continuar = false; // sair
                } else {
                    numero1 = obterPrimeiroNumero(input, opcaoDesejada);

                    if (temSegundoNumero(opcaoDesejada)) {
                        numero2 = obterSegundoNumero(input);
                        resultado = calculadora.realizarOperacaoBinaria(opcaoDesejada, numero1, numero2);
                    } else {
                        resultado = calculadora.realizarOperacaoUnaria(opcaoDesejada, numero1);
                    }

                    operator = calculadora.obterSimboloDaOperacao(opcaoDesejada);
                    imprimirResultadoFormatado(numero1, numero2, operator, opcaoDesejada, resultado);
                    continuar = verificaContinuar(input);
                }
            } catch (InputMismatchException ex) {
                continuar = false;
            } catch (Exception e) {
                Logger.erro(e.getMessage());
                continuar = verificaContinuar(input);
            }
        } while (continuar);

        input.close();
    }

    private static void menu() {
        Logger.padrao("");
        Logger.info("O que você deseja fazer?");
        Logger.padrao("(1) - Somar");
        Logger.padrao("(2) - Subtrair");
        Logger.padrao("(3) - Multiplicar");
        Logger.padrao("(4) - Dividir");
        Logger.padrao("(5) - Fatorial");
        Logger.padrao("(6) - Ver se é primo");
        Logger.padrao("Digite qualquer outra tecla para sair");

        Logger.padrao("Opção desejada: ", false);
    }

    private static void imprimirInicio() {
        Logger.elegante("--------------------------------------------");
        Logger.elegante("              MinhaCalculadora              ");
        Logger.elegante("--------------------------------------------");

    }

    private static double obterNumero(Scanner input, String msgDigite) {
        double val = 0;
        boolean numeroInvalido = true;

        while (numeroInvalido) {
            Logger.padrao(msgDigite, false);

            try {
                val = input.nextDouble();
                numeroInvalido = false;
            } catch (InputMismatchException ex) {
                Logger.erro("Valor inválido! Por favor, redigite!");
                input.nextLine();
            }
        }

        return val;
    }

    private static boolean temSegundoNumero(int opcaoDesejada) {
        return opcaoDesejada != FATORIAL.ordinal() && opcaoDesejada != EH_PRIMO.ordinal(); // poderia fazer if < 4, mas preferi != de unarias pensando no caso de futuramente adicionar mais funcoes
    }

    private static double obterPrimeiroNumero(Scanner input, int opcaoDesejada) {
        String primeiro = temSegundoNumero(opcaoDesejada) ? "primeiro " : "";
        return obterNumero(input, "Digite o " + primeiro + "numero: ");
    }

    private static double obterSegundoNumero(Scanner input) {
        return obterNumero(input, "Digite o segundo numero: ");
    }

    private static void imprimirResultadoFormatado(double numero1, double numero2, String operator, int opcaoDesejada, Number resultado) {
        String opcional = temSegundoNumero(opcaoDesejada) ? " " + numero2 : "";
        String result;
        char igualOuInterrogacao = '=';

        if (opcaoDesejada != EH_PRIMO.ordinal()) {
            result = String.valueOf(resultado.doubleValue());
        } else {
            igualOuInterrogacao = '?';
            result = resultado.intValue() == 0 ? "Não" : "Sim";
        }

        String resposta = String.format("%s %s%s %s %s", numero1, operator, opcional, igualOuInterrogacao, result);

        Logger.chamativo("-------------------");
        Logger.chamativo("|", false);
        Logger.chamativo(resposta, false);
        Logger.chamativo("|");
        Logger.chamativo("-------------------");
    }

    private static boolean verificaContinuar(Scanner input) {
        for (; ; ) {
            Logger.info("Deseja fazer outra operação? [S/N]: ", false);
            String valor = input.next();

            if (valor.equalsIgnoreCase("S") || valor.equalsIgnoreCase("N")) {
                return valor.equalsIgnoreCase("S");
            }

            Logger.erro("Opção inválida! Por favor, reinsira...");
        }
    }
}
