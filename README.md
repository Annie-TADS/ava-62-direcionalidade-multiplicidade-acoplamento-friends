# 6.2 // Direcionalidade, Multiplicidade e Acoplamento // Friends

Use este link do GitHub Classroom para ter sua cópia alterável deste repositório: <>

Implementar respeitando os fundamentos de Orientação a Objetos.

**Tópicos desta atividade:** direcionalidade e multiplicidade dos relacionamentos e questões de acoplamento e dependência.

---

Implementar o básico de uma Rede Social: associações bidirecionais! Falando em Orientação a Objetos, associações entre vários objetos formam um Grafo (rede) de Objetos, passível de navegação, ou seja, de um objeto acessar outro, e deste outro acessar outros, e assim por diante. O modelo funcionará com uma classe básica chamada `Pessoa` que terá nome e amigos. Deve ser possível adicionar e remover amigos. A adição de um amigo é bidirecional, ou seja, se `A` adiciona `B` como amigo, então `A` é amigo de `B` e `B` é amigo de `A`, Ver casos de teste:


```java
Pessoa joey     = new Pessoa("Joey");
Pessoa rachel   = new Pessoa("Rachel");
Pessoa monica   = new Pessoa("Monica");
Pessoa chandler = new Pessoa("Chandler");
Pessoa phoebe   = new Pessoa("Phoebe");

System.out.println(joey.getContagemAmigos() == 0);
System.out.println(rachel.getContagemAmigos() == 0);

joey.adicionaAmigo(rachel);

// java.util.List
List<Pessoa> amigosDoJoey = joey.getAmigos();
System.out.println(amigosDoJoey.size() == 1);

System.out.println(joey.getAmigos().size() == 1);
System.out.println(rachel.getAmigos().size() == 1);

monica.adicionaAmigo(joey);
System.out.println(joey.getAmigos().size() == 2);

// o primeiro amigo é `0`
System.out.println(rachel.getAmigo(0).equals(joey));
System.out.println(rachel.getAmigo(1) == null);

System.out.println(joey.getAmigo(0).equals(rachel));
System.out.println(joey.getAmigo(1).equals(monica));

rachel.adicionaAmigo(monica);
monica.adicionaAmigo(chandler);

System.out.println(rachel.getAmigo(1).equals(monica));

System.out.println(monica.getAmigo(0).equals(joey));
System.out.println(monica.getAmigo(1).equals(rachel));
System.out.println(monica.getAmigo(2).equals(chandler));

phoebe.adicionaAmigo(joey);
phoebe.adicionaAmigo(rachel);
phoebe.adicionaAmigo(monica);
phoebe.adicionaAmigo(chandler);

System.out.println(phoebe.getAmigos().size() == 4);

phoebe.removeAmigo(rachel);

System.out.println(phoebe.getAmigos().size() == 3);

System.out.println(phoebe.getAmigo(0).equals(joey));
System.out.println(phoebe.getAmigo(1).equals(monica));
System.out.println(phoebe.getAmigo(2).equals(chandler));

for (int i = 0; i < phoebe.getAmigos().size(); i++) {
  System.out.println(phoebe.getAmigo(i) != null);
}

System.out.println(phoebe.getAmigo(0).getAmigo(0).equals(rachel));
                          // joey     // rachel   // monica   // chandler
System.out.println(phoebe.getAmigo(0).getAmigo(0).getAmigo(1).getAmigo(2).equals(chandler));

System.out.println(joey.getAmigos().size() == 3);

joey.adicionaAmigo(joey);

System.out.println(joey.getAmigos().size() == 3);

joey.removeAmigo(0);
joey.removeAmigo(0);
joey.removeAmigo(0);

System.out.println(joey.getAmigos().size() == 0);
```


