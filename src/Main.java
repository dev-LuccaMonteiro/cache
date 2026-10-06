import static java.lang.IO.*;
void main() {
    Map<Integer, Pessoa> banco = new TreeMap<>();
    List<Pessoa> cache = new ArrayList<>();

    Pessoa a = new Pessoa(1, "lucca", 16);
    Pessoa b = new Pessoa(2, "Bruno", 18);
    Pessoa c = new Pessoa(3, "Ryan", 18);
    Pessoa d = new Pessoa(4, "VG", 67);
    Pessoa e = new Pessoa(5, "Igor", 42);
    cache.add(b);
    banco.put(1, a);
    banco.put(2, b);
    banco.put(3, c);
    banco.put(4, d);
    banco.put(5, e);


    int busca = Integer.parseInt(readln("coloque um id para pesquisar no cache: "));
    boolean encontrado = false;
    if (cache.isEmpty()) {


        for (Pessoa p : cache) {
            if (busca == p.getid()) {
                encontrado = true;
                println("Pessoa encontrada no cache");
                break;
            } else {
                println("id nao achado, buscando no banco");
                //banco.forEach()

                for (Map.Entry<Integer, Pessoa> sei : banco.entrySet()) {
                    Integer id = sei.getKey();
                    Pessoa z = sei.getValue();
                    if (id == busca) {
                        IO.println(id + z.getNome());
                        println("Pessoa encontrada, adicionando ao cache");
                        cache.add(sei.getValue());
                    }
                }

            }

        }


    }
}