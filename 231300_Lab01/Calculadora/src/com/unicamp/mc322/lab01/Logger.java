package com.unicamp.mc322.lab01;

public class Logger {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_PURPLE = "\u001B[35m";
    private static final String ANSI_YELLOW = "\u001B[33m";

    public static void erro(String msg) {
        imprimir(ANSI_RED + msg + ANSI_RESET, true);
    }

    public static void erro(String msg, boolean pularLinha) {
        imprimir(ANSI_RED + msg + ANSI_RESET, pularLinha);
    }

    public static void info(String msg) {
        imprimir(ANSI_BLUE + msg + ANSI_RESET, true);
    }

    public static void info(String msg, boolean pularLinha) {
        imprimir(ANSI_BLUE + msg + ANSI_RESET, pularLinha);
    }

    public static void elegante(String msg) {
        imprimir(ANSI_PURPLE + msg + ANSI_RESET, true);
    }

    public static void elegante(String msg, boolean pularLinha) {
        imprimir(ANSI_PURPLE + msg + ANSI_RESET, pularLinha);
    }

    public static void chamativo(String msg) {
        imprimir(ANSI_YELLOW + msg + ANSI_RESET, true);
    }

    public static void chamativo(String msg, boolean pularLinha) {
        imprimir(ANSI_YELLOW + msg + ANSI_RESET, pularLinha);
    }

    public static void padrao(String msg) {
        imprimir(msg, true);
    }

    public static void padrao(String msg, boolean pularLinha) {
        imprimir(msg, pularLinha);
    }

    private static void imprimir(Object o, boolean pularLinha) {
        if (pularLinha) {
            System.out.println(o);
        } else {
            System.out.print(o);
        }
    }
}
