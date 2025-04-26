# 🎓 Interface Didática  – Explicação mostrando o funcionamento metodo de ordenação QUICKSORT

Este projeto Java com interface gráfica (Swing) foi criado com fins **educacionais**, para **ensinar e visualizar a geração e ordenação de vetores aleatórios** de maneira clara, intuitiva e animada.
A apresentação faz parte de um trabalho que foi pedido em sala de aula, a parte visual do java (swing) pesquisei por conta própria e incrementei no codigo, pois como era uma apresentação didatica eu achei que fosse melhor algo mais intuitivo utilizando algo visual.

## 🎯 Objetivo

A aplicação tem como propósito **aprimorar a compreensão de algoritmos** relacionados à manipulação de vetores, utilizando uma abordagem **visual e interativa**. Ela permite observar:

- A geração de vetores aleatórios
- A coleta de valores em posições específicas
- A ordenação dos valores coletados
- Tudo isso com **feedback visual estilo terminal**, **controle de velocidade**, **barra de progresso** e uma **interface amigável**

## ⚡ Como Funciona o Algoritmo QuickSort

O **QuickSort** é um algoritmo de ordenação muito eficiente que segue o princípio da **divisão e conquista**. Ele funciona dividindo o problema em partes menores, ordenando cada uma delas separadamente.

### 🧠 Passo a Passo do QuickSort:

1. **Escolha de um Pivô**
   - O algoritmo escolhe um elemento do vetor, chamado de **pivô**, ele pode ser aleátorio, valor a esquerda ou valor a direita, nesse exemplo eu optei por sempre escolher o ultimo valor (no caso a direita) para uma ordenação mais eficiente.
   - Esse pivô será usado como referência para reorganizar os elementos.

2. **Particionamento**
   - Todos os elementos **menores que o pivô** são colocados à sua esquerda.
   - Todos os elementos **maiores que o pivô** são colocados à sua direita.
   - Agora o pivô está **na posição correta** em relação aos demais.

3. **Recursão**
   - O algoritmo é chamado **recursivamente** para ordenar a parte da esquerda e a parte da direita do pivô.
   - Esse processo se repete até que todas as partes estejam ordenadas.
   - 
## 🖥️ Funcionalidades

- Geração automática de múltiplos vetores aleatórios
- Destaque visual para os valores coletados em cada vetor
- Exibição dos valores coletados e ordenados
- Barra de progresso animada indicando cada etapa
- Controles intuitivos para:
  - Quantidade de vetores
  - Tamanho dos vetores
  - Velocidade da animação (em ms)
- Design estilizado com fonte de terminal (verde em fundo preto)
- Botão animado "🎬 Iniciar Animação"

## 🧪 Exemplo de Funcionamento

1. O usuário escolhe o número de vetores e o tamanho de cada vetor.
2. O programa gera os vetores com números aleatórios de 1 a 100.
3. De cada vetor, é **coletado um valor de uma posição específica** (calculada com base no índice).
4. Os valores coletados são exibidos.
5. Os valores são ordenados e mostrados ao final.
6. A barra de progresso acompanha cada etapa da execução.

## 📦 Tecnologias Utilizadas

- **Java** (JDK 8 ou superior)
- **Swing** para a construção da interface gráfica

## 🚀 Como Executar

1. Compile o arquivo:
   ```bash
   javac InterfaceDidaticaMelhorada.java
   ```

2. Execute o programa:
   ```bash
   java InterfaceDidaticaMelhorada
   ```

> Obs.: É necessário ter o Java instalado na máquina.



> 💡 Projeto desenvolvido com foco em **clareza didática, interatividade e usabilidade visual**.
