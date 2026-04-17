import java.util.Random;

public class Luta {
        private Lutador desafiado;
        private Lutador desafiante;
        private boolean aprovada;

        public void marcarLuta(Lutador l1, Lutador l2) {
            if (l1 != l2 && l1.getCategoria() != null && l1.getCategoria().equals(l2.getCategoria())) {
                this.aprovada = true;
                this.desafiado = l1;
                this.desafiante = l2;
            } else {
                this.aprovada = false;
                this.desafiado = null;
                this.desafiante = null;
            }
        }

        public void lutar() {
            if (!this.aprovada) {
                System.out.println("Luta não pode acontecer!");
                return;
            }

            System.out.println(" # LUTAAAAAAR # ");

            System.out.println("### DESAFIADO ###");
            desafiado.apresentar();

            System.out.println("### DESAFIANTE ###");
            desafiante.apresentar();

            Random aleatorio = new Random();
            int resultado = aleatorio.nextInt(3);

            System.out.println("======= RESULTADO =======");

            switch (resultado) {
                case 0:
                    System.out.println("Empate!");
                    desafiado.empatarLuta();
                    desafiante.empatarLuta();
                    break;

                case 1:
                    System.out.println("Vitória do " + desafiado.getNome());
                    desafiado.ganharLuta();
                    desafiante.perderLuta();
                    break;

                case 2:
                    System.out.println("Vitória do " + desafiante.getNome());
                    desafiante.ganharLuta();
                    desafiado.perderLuta();
                    break;
            }
        }

    }
