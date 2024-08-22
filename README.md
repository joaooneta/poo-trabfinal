Aplicativo para controle de locação e fluxo de caixa para uma locadora antiga de filmes e jogos, tendo por objetivo ser manuseado por um atendente capacido da empresa, que tem conhecimento prévio sobre o funcionamento da aplicação.

Classes:

- ItemLocadora: Classe abstrata que contem os métodos e atributos em comum a todos os produtos cadastrados no estoque
- Filme: Classe utilizada para criar os objetos que modelam os filmes da aplicação
- Jogo: Classe utilizada para criar os objetos que modelam os jogos da aplicação
- Locadora: Classe responsável por criar o objeto que atua como controlador do fluxo da aplicação, contento todos os comportamentos necessárias para as transações esperadas.

Interfaces:

- Loja: Interface que especifica todos os comportamentos necessários para implementar a classe Locadora corretamente

Especificações Cobradas:

1. Classes e Objetos: A aplicação é composta por 4 classes construidas para a mesma: ItemLocadora, Filme, Jogo e Locadora, criando objetos para armazenar e modelar os dados da mesma.

2. Encapsulamento: Todos os atributos das classes são privados, sendo disponibilizados para o exterior da mesma através de funções que atuam como API's publicas.

3. Herança: A classes ItemLocadora é a superclasse de todos os produtos da aplicação(Filme e Jogo), contendo as informações e comportamentos semelhantes em um só lugar.

4+5. Polimorfismo + Sobrecarga e Sobrescrita de Métodos: O método getDescricao é o método que utiliza tal pilar da POO, servindo como template na Superclasse ItemLocadora, mas sendo sobrescrito nas classes Filme e Jogo para melhor atingir seus potências desejados.

6. Classes Abstratas e Interfaces: A classe abstrata ItemLocadora e a interface Loja atingem a especificação cobrada.

7. Coleções: Os Filmes e Jogos cadastrados são persistidos e modelados em ArrayList's de suas classes respectivamente.

8. Manipulação de arquivos: Escolhido pela implementação de exceções.

EXTRA. Exceções: Exceções implementadas no controle do input do usuário, evitando que a aplicação quebre quando o usuário insere Strings quando o pedido eram numeros.

Classe ItemLocadora:

- Métodos getters e Setters,
- Método String getDescricao(): Retorna informação do produto em uma string

Classe Filme:

- Métodos getters e Setters,
- Método String getDescricao(): Sobrescrito para retornar string adequada a um filme

Classe Jogo:

- Métodos getters e Setters,
- Método String getDescricao(): Sobrescrito para retornar string adequada a um jogo

Classe Locadora:

- Método void init(): Adiciona alguns objetos as ArrayList's jogos e filmes, para facilitar a debugação
- Método void cadastrarFilme(): Faz a inserção de um novo object Filme a sua ArrayList
- Método void cadastrarJogo(): Faz a inserção de um novo object Jogo a sua ArrayList
- Método void exibirCatalogoFilmes(): Faz um loop pela ArrayList filmes exibindo a descrição de todos os filmes
- Método void exibirCatalogoJogos(): Faz um loop pela ArrayList jogos exibindo a descrição de todos os jogos
- Método void locar(): Seta o produto como locado e adiciona o resultado da transação ao caixa
- Método void devolver(): Seta o produto como devolvido, habilitando o produto no catalogo
- Método boolean filmeOuJogo(String tipoProduto): Função auxiliar, validando input do usuario
- Método boolean existeProduto(String tipoProduto, String titulo): Função auxiliar, impedindo inserção de jogos e filmes repetidos
- Método void exibeValorEmCaixa(): Printa valor em caixa em uma string formatada
