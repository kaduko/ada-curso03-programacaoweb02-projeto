package tech.ada.combustivel;

public class App {
    public static void main(String[] args) {

        try(EntradaDeDados leitor = new EntradaDeDados()) {
            new MenuPrincipal(leitor).processar();
        }

    }
}
