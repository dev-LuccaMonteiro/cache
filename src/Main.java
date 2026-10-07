import static java.lang.IO.*;
import java.util.ArrayList;
import java.util.List;

void main() {
    List<Pessoa> banco = new ArrayList<>();
    List<Pessoa> cache = new ArrayList<>();

    banco.add(new Pessoa(1, "lucca", 16));
    banco.add(new Pessoa(2, "Bruno", 18));
    banco.add(new Pessoa(3, "Ryan", 18));
    banco.add(new Pessoa(4, "VG", 67));
    banco.add(new Pessoa(5, "Igor", 42));

    boolean ex = true;

    while (ex) {
        println("\n--- MENU ---");
        println("1. Buscar por ID");
        println("2. Ver cache");
        println("3. Sair");

        String op = readln("Escolha uma das três opções: ");

        if (op.equals("1")) {
            int busca = Integer.parseInt(readln("Coloque um ID para pesquisar: "));
            Pessoa pessoaEncontrada = null;

            
            for (Pessoa p : cache) {
                if (p.getid() == busca) {
                    pessoaEncontrada = p;
                    println("Pessoa encontrada NO CACHE: " + p);
                    break;
                }
            }

            
            if (pessoaEncontrada == null) {
                for (Pessoa p : banco) {
                    if (p.getid() == busca) {
                        pessoaEncontrada = p;
                        println("Pessoa achada no BANCO! Adicionando ao cache...");

                        
                        if (cache.size() >= 10) {
                            cache.remove(0); 
                            println("Cache cheio: pessoa mais antiga removida.");
                        }

                        cache.add(pessoaEncontrada);
                        println("Pessoa adicionada ao cache com sucesso.");
                        break;
                    }
                }
            }

            
            if (pessoaEncontrada == null) {
                println("Pessoa não encontrada nem no cache, nem no banco de dados.");
            }

        } else if (op.equals("2")) {
            println("Conteúdo atual do cache:");
            println(cache);

        } else if (op.equals("3")) {
            println("Saindo do sistema...");
            ex = false;

        } else {
            println("Opção inválida! Tente novamente.");
        }
    }
}
