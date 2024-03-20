Observações: Este projeto foi criado para testar uma ferramente de avalição.

Como base do processo foi utilizado um vídeo do youtube do canal _Automation Step By Step_

## pré requisitos

JDK - 17 (Teste colocando este comando no seu terminal `javac -version`)

Scala - 3.1 (Teste com este comando no CMD `scala -version`)

Maven apache (Teste usando no cmd `mvn -version`)

Pode usar qualquer IDE, porém neste projeto, o que foi utilizado foi o `IntelliJ`

Passo 1 - Veja se existe a JDK e o Scala
Passo 2 - No seu InteliJ, instale o plugin do Scala
Passo 3 - Cria o projeto do gatling:
assim:
Criação do projeto

---

1.  Alguma pasta ＞ Abra o CMD ＞ rode o comando `mvn archetype:generate`
2.  Coloque no archetype como `gatling`
3.  Escolha a última versão(pra mim foi a 42)
4.  Defina o groupID `com.gatling.tests`
5.  Escolha o nome do Projeto `GatlingProject`
6.  Importe seu projeto no Editor de Texto
    Passo 4 - No inteliJ, vá na SRC > Scala e no arquivo de engine aparecerá que o Scale não foi reconhecido, então clique no popin, e depois procure a pasta do Scale que voce instalou ele antes.
    Passo 5 - No intelliJ clique na pasta do Scala com o botão direito > Mark Directory > Test Sources Root até a pasta mudar de cor
    Passo 6 - No intelliJ clique na pasta SRC com o botão direito > Mark Directory > Sources Root até a pasta mudar de cor
    Passo 7 - Abra o arquivo engine e com o botão direito na classe roda a engine
    Verifique na pasta de usuário/simulations

Para fazer os testes, vá o arquivo recording e com o botão direito na classe rode o recording, abrirá o gatling recorder.
Troque de proxy para converter na parte direita do gatling
Encontre o arquivo har seu
Nomeie sua classe
Clique em No Static Resources
Start

Então verifique a pasta target > gatling > sua classe


<b> Aula do professor: Francisco Assis Moreira do Nascimento </b>
