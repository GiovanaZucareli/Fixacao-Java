// Classe abstrata base
abstract class Notificacao {
    public abstract void enviar();
}

// Subclasse para email
class NotificacaoEmail extends Notificacao {
    @Override
    public void enviar() {
        System.out.println("Enviando notificação por email...");
    }
}

// Subclasse para SMS
class NotificacaoSMS extends Notificacao {
    @Override
    public void enviar() {
        System.out.println("Enviando notificação por SMS...");
    }
}

// Subclasse para Push
class NotificacaoPush extends Notificacao {
    @Override
    public void enviar() {
        System.out.println("Enviando notificação por Push...");
    }
}


public class sistemaNotificacoes {
    public static void main(String[] args) {

        Notificacao[] notificacoes = new Notificacao[3];

        // Instancias no array

        notificacoes[0] = new NotificacaoEmail();
        notificacoes[1] = new NotificacaoSMS();
        notificacoes[2] = new NotificacaoPush();

        for (Notificacao n : notificacoes) {
            n.enviar();
        }

    }
}
