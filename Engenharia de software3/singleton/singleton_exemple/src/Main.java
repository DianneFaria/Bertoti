public class Main {
    public static void main(String[] args) {
        // Tenta obter a instância única
        Singleton instancia1 = Singleton.getInstancia();
        instancia1.mostrarMensagem();

        // Obtém a mesma instância
        Singleton instancia2 = Singleton.getInstancia();
        instancia2.mostrarMensagem();

        System.out.println(instancia1 == instancia2);
    }
}
